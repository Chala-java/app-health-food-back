package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Producto;
import com.example.PedidosApp.modelos.Tienda;
import com.example.PedidosApp.servicios.TiendaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tienda")
@CrossOrigin(origins = "*")
public class ControladorTienda {

    @Autowired
    TiendaServicio tiendaServicio;

    // Guardar tienda (con o sin productos)
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Tienda datosTienda) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.tiendaServicio.guardarTiendas(datosTienda));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Agregar productos a tienda existente
    @PostMapping("/{id}/productos")
    public ResponseEntity<?> agregarProductos(@PathVariable Integer id, @RequestBody List<Producto> productos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.tiendaServicio.agregarProductosATienda(id, productos));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Buscar todas las tiendas
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

    //Buscar tienda por id
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

    // Buscar productos de una tienda específica
    @GetMapping("/{id}/productos")
    public ResponseEntity<?> buscarProductosDeTienda(@PathVariable Integer id){
        try{
            Tienda tienda = this.tiendaServicio.buscarTiendaPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tienda.getProductos());
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Modificar tienda
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

    //Eliminar tienda
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

    @PostMapping("/login-tienda")
    public ResponseEntity<?> loginTienda(@RequestBody Tienda login) {
        try {
            Optional<Tienda> tiendaEncontrada = this.tiendaServicio
                    .buscarPorCorreo(login.getCorreoElectronico());

            if (tiendaEncontrada.isPresent()) {
                Tienda tienda = tiendaEncontrada.get();

                if (tienda.getContrasena().equals(login.getContrasena())) {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(tienda); // Devuelve toda la info del restaurante
                } else {
                    return ResponseEntity
                            .status(HttpStatus.UNAUTHORIZED)
                            .body("Contraseña incorrecta");
                }
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Correo no registrado");
            }

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}