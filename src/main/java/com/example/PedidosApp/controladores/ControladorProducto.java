package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Producto;
import com.example.PedidosApp.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    @Autowired
    ProductoServicio productoServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Producto datosProducto) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.productoServicio.guardarProducto(datosProducto));
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
            .body(this.productoServicio.buscarTodosProductos());
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
           .body(this.productoServicio.buscarProductoPorId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Producto datosProducto){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.productoServicio.modificarProducto(id, datosProducto));
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
            .body(this.productoServicio.eliminarProducto(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }
}
