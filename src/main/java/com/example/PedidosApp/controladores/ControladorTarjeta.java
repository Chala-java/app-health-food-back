package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Tarjeta;
import com.example.PedidosApp.servicios.TarjetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarjeta")
public class ControladorTarjeta {

    @Autowired
    TarjetaServicio tarjetaServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tarjeta datosPeticion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.tarjetaServicio.guardarTarjeta(datosPeticion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodas() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tarjetaServicio.buscarTodasTarjetas());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tarjetaServicio.buscarTarjetaPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Tarjeta datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tarjetaServicio.modificarTarjeta(id, datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tarjetaServicio.eliminarTarjeta(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
