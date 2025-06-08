package com.example.PedidosApp.modelos;

import com.example.PedidosApp.ayudas.enums.RestauranteEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Reaturante")
public class Tienda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private Integer id_restaurante;
    @Column(name="nombre_restaurante", length=100, unique=true, nullable = false )
    private String nombre;
    @Column(name="direccion_restaurante", length = 255, nullable = false)
    private String direccion;
    @Column(name="telefono_restaurante", length = 20, nullable = false)
    private String telefono;
    @Column(name="categoria", length = 100, nullable = false)
    private String categoria;
    @Column(name="logo_url", length = 500, nullable = false)
    private String logoUrl;
    @Column(name="portada_url", length = 500, nullable = false)
    private String portadaUrl;

    @Column(name="categorias",length=50, nullable = true)
    @Enumerated(EnumType.STRING)
    private RestauranteEnum Categorias;

    @OneToMany(mappedBy = "tienda")
    @JsonManagedReference(value = "pedidos-tienda")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "tienda")
   @JsonManagedReference(value = "productos-tienda")
    private List<Producto> productos;

    public Tienda() {
    }

    public Tienda(Integer id_restaurante, String nombre, String direccion, String telefono, String categoria, String logoUrl, String portadaUrl, RestauranteEnum categorias, List<Pedido> pedidos, List<Producto> productos) {
        this.id_restaurante = id_restaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
        this.logoUrl = logoUrl;
        this.portadaUrl = portadaUrl;
        Categorias = categorias;
        this.pedidos = pedidos;
        this.productos = productos;
    }

    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }

    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    public RestauranteEnum getCategorias() {
        return Categorias;
    }

    public void setCategorias(RestauranteEnum categorias) {
        Categorias = categorias;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
