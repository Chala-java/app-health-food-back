package com.example.PedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productos")
    private Integer id_producto;
    @Column(name="nombre_productos", length = 100, nullable = false)
    private String nombre;
    @Column(name="precio", nullable = false)
    private BigDecimal precio;
    @Column(name="descripcion",nullable = true)
    private String descripcion;

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

    public Producto(Integer id_producto, String nombre, BigDecimal precio, String descripcion) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
