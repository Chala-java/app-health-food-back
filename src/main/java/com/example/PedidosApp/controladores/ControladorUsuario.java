package com.example.PedidosApp.controladores;

import com.example.PedidosApp.modelos.Usuario;
import com.example.PedidosApp.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    UsuarioServicio usuarioServicio;

    // Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosPeticion) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.guardarUsuario(datosPeticion));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Método para logear usuario
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario login) {
        try {
            Optional<Usuario> usuarioEncontrado = this.usuarioServicio
                    .buscarPorCorreoElectronico(login.getCorreoElectronico());

            if (usuarioEncontrado.isPresent()) {
                Usuario usuario = usuarioEncontrado.get();

                if (usuario.getContrasena().equals(login.getContrasena())) {
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(usuario);
                } else {
                    return ResponseEntity
                            .status(HttpStatus.UNAUTHORIZED)
                            .body("Contraseña incorrecta");
                }
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Correo electrónico no registrado");
            }

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    // Buscar Todos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarTodosUsuarios());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Buscar ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.buscarUsuarioPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }

    // Modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modifcar(@PathVariable Integer id, @RequestBody Usuario datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.modificarUsuario(id, datos));

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
                    .body(this.usuarioServicio.eliminarUsuario(id));

        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
