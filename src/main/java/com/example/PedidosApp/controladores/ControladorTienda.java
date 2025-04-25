package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Tienda;
import com.example.PedidosApp.servicios.TiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tienda")
public class ControladorTienda {

    @Autowired
    TiendaServicio tiendaServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tienda datosTienda) {
        try {
           return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(this.tiendaServicio.guardarTienda(datosTienda));
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
            .body(this.tiendaServicio.buscarTodosTiendas());
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
           .body(this.tiendaServicio.buscarTiendaPorId(id));
        }catch(Exception error){
            return ResponseEntity
           .status(HttpStatus.BAD_REQUEST)
           .body(error.getMessage());
        }
    }

    //Moificar
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Tienda datosTienda){
        try{
            return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tiendaServicio.modificarTienda(id, datosTienda));
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
            .body(this.tiendaServicio.eliminarTienda(id)); 
        }catch(Exception error){
            return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(error.getMessage());
        }
    }
}
