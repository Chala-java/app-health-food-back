package com.example.PedidosApp.modelos;

import com.example.PedidosApp.ayudas.enums.EntregaEstado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.time.LocalDateTime;

@Entity
@Table(name="Entregas")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_entrega")
    private Integer id_entrega;
    @Column(name="fecha_entrega", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha_de_entrega;
    @Column(name="estado_entrega", columnDefinition = "VARCHAR(10) DEFAULT 'ASIGANDO' ")
    private EntregaEstado estado_entrega;

    @ManyToOne
    @JoinColumn(name = "fk_repartiodor", referencedColumnName = "id_repartidor")
    @JsonBackReference(value = "entrega-repartidor")
    private Repartidor repartidor;

    public Entrega() {
    }

    public Entrega(Integer id_entrega, LocalDateTime fecha_de_entrega, EntregaEstado estado_entrega) {
        this.id_entrega = id_entrega;
        this.fecha_de_entrega = fecha_de_entrega;
        this.estado_entrega = estado_entrega;
    }

    public Integer getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(Integer id_entrega) {
        this.id_entrega = id_entrega;
    }

    public LocalDateTime getFecha_de_entrega() {
        return fecha_de_entrega;
    }

    public void setFecha_de_entrega(LocalDateTime fecha_de_entrega) {
        this.fecha_de_entrega = fecha_de_entrega;
    }

    public EntregaEstado getEstado_entrega() {
        return estado_entrega;
    }

    public void setEstado_entrega(EntregaEstado estado_entrega) {
        this.estado_entrega = estado_entrega;
    }
}
