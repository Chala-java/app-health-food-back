package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Direccion;
import com.example.PedidosApp.servicios.DireccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/direccion")
public class ControladorDireccion {

    @Autowired
    DireccionServicio direccionServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Direccion datosDireccion) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.direccionServicio.guardarDireccion(datosDireccion));
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Buscar
    @GetMapping
    public ResponseEntity<?>buscarTodos(){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.direccionServicio.buscarTodasDirecciones());
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage()); 
        }
    }

    //Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
           .status(HttpStatus.OK)
           .body(this.direccionServicio.buscarDireccionPorId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Direccion datosDireccion){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.direccionServicio.modificarDireccion(id, datosDireccion));
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Integer id){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.direccionServicio.eliminarDireccion(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }


}
