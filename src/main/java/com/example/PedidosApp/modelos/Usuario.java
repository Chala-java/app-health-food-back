package com.example.PedidosApp.modelos;

import com.example.PedidosApp.ayudas.enums.UsuarioEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario_tabla")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    @Column(name = "nombre_usuario", length = 100, unique = true, nullable = false)
    private String nombre;
    @Column(name = "correo_usuario", length = 150, unique = true, nullable = false)
    private String correoElectronico;
    @Column(name = "contrasena_usuario", length = 260, nullable = false)
    private String contrasena;
    @Column(name = "telefono_usuario", length = 260, nullable = true)
    private String telefono;
    @Column(name = "tipo_usuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioEnum tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "direccionesusuario")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "pedidos-usuario")
    private List<Pedido> pedidos;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contrasena, String telefono, UsuarioEnum tipoUsuario, List<Direccion> direcciones, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.direcciones = direcciones;
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public UsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}