package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Entrega;
import com.example.PedidosApp.servicios.EntregaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class ControladorEntrega {

    @Autowired
    EntregaServicio entregaServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Entrega datosEntrega) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.entregaServicio.guardarEntrega(datosEntrega));
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
            .body(this.entregaServicio.buscarTodos());
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
           .body(this.entregaServicio.buscarEntregaporId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Entrega datosEntrega){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.entregaServicio.modificarEntrega(id, datosEntrega));
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
            .body(this.entregaServicio.eliminarEntrega(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }
}
