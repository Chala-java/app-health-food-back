package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Producto;
import com.example.PedidosApp.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ControladorProducto {

    @Autowired
    ProductoServicio productoServicio;

    // Guardar producto
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

    // Guardar producto directamente en una tienda
    @PostMapping("/tienda/{idTienda}")
    public ResponseEntity<?> guardarEnTienda(@PathVariable Integer idTienda, @RequestBody Producto datosProducto) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.productoServicio.guardarProductoEnTienda(idTienda, datosProducto));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar todos los productos
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

    // Buscar productos por tienda
    @GetMapping("/tienda/{idTienda}")
    public ResponseEntity<?> buscarPorTienda(@PathVariable Integer idTienda){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.productoServicio.buscarProductosPorTienda(idTienda));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar producto por id
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

    //Modificar producto
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

    //Eliminar producto
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