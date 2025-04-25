package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Pedido;
import com.example.PedidosApp.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ControladorPedido {

    @Autowired
    PedidoServicio pedidoServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Pedido datosPedido) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.pedidoServicio.guardarPedido(datosPedido));
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
            .body(this.pedidoServicio.buscarTodosPedidos());
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
           .body(this.pedidoServicio.buscarPedidoPorId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Pedido datosPedido){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.pedidoServicio.modificarPedido(id, datosPedido));
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
            .body(this.pedidoServicio.eliminarPedido(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }
}
