package com.example.PedidosApp.modelos;

import com.example.PedidosApp.ayudas.enums.PagoEstado;
import com.example.PedidosApp.ayudas.enums.PagoMetodos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pago")
    private Integer id_pago;
    @Column(name="metodo_pago", nullable = false)
    @Enumerated(EnumType.STRING)
    private PagoMetodos metodo_pago;
    @Column(name="estado_pedido", columnDefinition = "VARCHAR(10) DEFAULT 'PENDIENTE'")
    @Enumerated(EnumType.STRING)
    private PagoEstado estado_pago;
    @Column(name="fecha_pedido", columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime  fecha_pago;

    @OneToMany(mappedBy = "pago")
    @JsonManagedReference(value = "pago-pedido")
    private List<Pedido> pedidos;

    public Pago() {
    }

    public Pago(Integer id_pago, PagoMetodos metodo_pago, PagoEstado estado_pago, LocalDateTime fecha_pago) {
        this.id_pago = id_pago;
        this.metodo_pago = metodo_pago;
        this.estado_pago = estado_pago;
        this.fecha_pago = fecha_pago;
    }

    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public PagoMetodos getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(PagoMetodos metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public PagoEstado getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(PagoEstado estado_pago) {
        this.estado_pago = estado_pago;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
