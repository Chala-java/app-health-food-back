package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Repartidor;
import com.example.PedidosApp.servicios.RepartidorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repartidor")
public class ControladorRepartidor {

    @Autowired
    RepartidorServicio repartidorServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Repartidor datosRepartidor) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.repartidorServicio.guardarRepartidor(datosRepartidor));
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
            .body(this.repartidorServicio.buscarTodosRepartidores());
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
           .body(this.repartidorServicio.buscarRepartidorPorId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Repartidor datosRepartidor){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.repartidorServicio.modificarRepartidor(id, datosRepartidor));
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
            .body(this.repartidorServicio.eliminarRepartidor(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }
}
