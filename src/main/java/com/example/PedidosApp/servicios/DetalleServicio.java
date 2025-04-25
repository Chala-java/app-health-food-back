package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Detalle;
import com.example.PedidosApp.repositorios.IDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServicio {

    @Autowired
    IDetalleRepositorio repositorio;

    // Metodo Guardar
    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception {
        try {
            return this.repositorio.save(datosDetalle);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para buscar todos los registros
    public List<Detalle> buscarTodosLosDetalles() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para buscar por ID
    public Detalle buscarDetallePorId(Integer idDetalle) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(idDetalle);
            if (detalleBuscado.isPresent()) {
                return detalleBuscado.get();
            } else {
                throw new Exception("No se encontro el detalle");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para modificar por id
    public Detalle modificarDetalle(Integer id, Detalle datosDetalle) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(id);
            if (detalleBuscado.isPresent()) {
                detalleBuscado.get().setDetalle_pedido(detalleBuscado.get().getDetalle_pedido());
                detalleBuscado.get().setCantidad(detalleBuscado.get().getCantidad());
                detalleBuscado.get().setSubtotal(detalleBuscado.get().getSubtotal());
                return this.repositorio.save(detalleBuscado.get());
            } else {
                throw new Exception("No se encontro el detalle");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para eliminar por id
    public Boolean eliminarDetalle(Integer id) throws Exception {
        try {
            Optional<Detalle> detalleBuscado = this.repositorio.findById(id);
            if (detalleBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("No se encontro el detalle");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
