package com.example.PedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productos")
    private Integer id_producto;
    @Column(name = "nombre_productos", length = 100, nullable = false)
    private String nombre;
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    @Column(name = "precio_descuento", nullable = false)
    private BigDecimal precioDescuento;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @Column(name = "ubicacion", length = 200, nullable = false)
    private String ubicacion;
    @Column(name = "imagen_url", length = 500)
    private String imagenUrl;


    @ManyToOne
    @JoinColumn(name = "fk_tienda", referencedColumnName = "id_restaurante")
    @JsonBackReference(value = "productos-tienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "fk_detalle", referencedColumnName = "detalle_pedido")
    @JsonBackReference(value = "detalle-producto")
    private Detalle detalle;

    public Producto() {
    }

    public Producto(Integer id_producto, String nombre, BigDecimal precio, BigDecimal precioDescuento, String descripcion, String ubicacion, String imagenUrl, Tienda tienda, Detalle detalle) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.precioDescuento = precioDescuento;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.imagenUrl = imagenUrl;
        this.tienda = tienda;
        this.detalle = detalle;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioDescuento() {
        return precioDescuento;
    }

    public void setPrecioDescuento(BigDecimal precioDescuento) {
        this.precioDescuento = precioDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }
}