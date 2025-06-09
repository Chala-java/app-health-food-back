package com.example.PedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Integer id_tarjeta;

    @Column(name = "titular", nullable = false)
    private String titular;

    @Column(name = "numero_tarjeta", nullable = false, length = 20)
    private String numero_tarjeta;

    @Column(name = "cvv", nullable = false, length = 5)
    private String cvv;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fecha_vencimiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference(value = "tarjetas-usuario")
    private Usuario usuario;

    public Tarjeta() {}

    public Tarjeta(String titular, String numero_tarjeta, String cvv, LocalDate fecha_vencimiento, Usuario usuario) {
        this.titular = titular;
        this.numero_tarjeta = numero_tarjeta;
        this.cvv = cvv;
        this.fecha_vencimiento = fecha_vencimiento;
        this.usuario = usuario;
    }

    // Getters y Setters

    public Integer getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Integer id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
