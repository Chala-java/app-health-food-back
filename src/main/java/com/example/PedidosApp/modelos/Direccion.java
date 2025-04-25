package com.example.PedidosApp.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.lang.model.util.AbstractElementVisitor14;
import java.util.List;

@Entity
@Table(name="Direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_direccion")
    private Integer id_direccion;
    @Column(name="calle", length=255, nullable = false)
    private String calle;
    @Column(name="ciudad", length=100, nullable = false)
    private String ciudad;
    @Column(name="codigo_postal", length=20, nullable = false)
    private String codigo_postal;
    @Column(name="pais", length=50, nullable = false)
    private String pais;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @JsonBackReference(value = "direccionesusuario")
    private Usuario usuario;

    public Direccion() {
    }

    public Direccion(Integer id_direccion, String calle, String ciudad, String codigo_postal, String pais) {
        this.id_direccion = id_direccion;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigo_postal = codigo_postal;
        this.pais = pais;
    }

    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
