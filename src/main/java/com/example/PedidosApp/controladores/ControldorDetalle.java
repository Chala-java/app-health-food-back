package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Detalle;
import com.example.PedidosApp.servicios.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle")
public class ControldorDetalle {

    @Autowired
    DetalleServicio detalleServicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?>guardar(@RequestBody Detalle datosDetalle){
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.detalleServicio.guardarDetalle(datosDetalle)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Buscar Todos
    @GetMapping
    public ResponseEntity<?>buscarTodos(){
        try {
           return ResponseEntity
           .status(HttpStatus.OK)
           .body(this.detalleServicio.buscarTodosLosDetalles());
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try {
           return ResponseEntity
           .status(HttpStatus.OK).body(this.detalleServicio
           .buscarDetallePorId(id));
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Editar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Detalle datosetalle){
        try {
           return ResponseEntity
           .status(HttpStatus.OK)
           .body(this.detalleServicio.modificarDetalle(id, datosetalle));
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Integer id){
        try {
           return ResponseEntity
           .status(HttpStatus.OK)
           .body(this.detalleServicio.eliminarDetalle(id));
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }


}
