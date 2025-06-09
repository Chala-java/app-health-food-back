package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Tarjeta;
import com.example.PedidosApp.repositorios.IDTarjetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServicio {

    @Autowired
    IDTarjetaRepositorio repositorio;

    // Guardar tarjeta
    public Tarjeta guardarTarjeta(Tarjeta tarjeta) throws Exception {
        try {
            return this.repositorio.save(tarjeta);
        } catch (Exception error) {
            throw new Exception("Error al guardar tarjeta: " + error.getMessage());
        }
    }

    // Buscar todas
    public List<Tarjeta> buscarTodasTarjetas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception("Error al buscar tarjetas: " + error.getMessage());
        }
    }

    // Buscar por ID
    public Tarjeta buscarTarjetaPorId(Integer id) throws Exception {
        try {
            Optional<Tarjeta> tarjetaBuscada = this.repositorio.findById(id);
            if (tarjetaBuscada.isPresent()) {
                return tarjetaBuscada.get();
            } else {
                throw new Exception("Tarjeta no encontrada");
            }
        } catch (Exception error) {
            throw new Exception("Error al buscar tarjeta: " + error.getMessage());
        }
    }

    // Modificar
    public Tarjeta modificarTarjeta(Integer id, Tarjeta datosTarjeta) throws Exception {
        try {
            Optional<Tarjeta> tarjetaBuscada = this.repositorio.findById(id);
            if (tarjetaBuscada.isPresent()) {
                Tarjeta tarjetaExistente = tarjetaBuscada.get();

                tarjetaExistente.setNumero_tarjeta(datosTarjeta.getNumero_tarjeta());
                tarjetaExistente.setTitular(datosTarjeta.getTitular());
                tarjetaExistente.setFecha_vencimiento(datosTarjeta.getFecha_vencimiento());
                tarjetaExistente.setUsuario(datosTarjeta.getUsuario());

                return this.repositorio.save(tarjetaExistente);
            } else {
                throw new Exception("Tarjeta no encontrada");
            }
        } catch (Exception error) {
            throw new Exception("Error al modificar tarjeta: " + error.getMessage());
        }
    }

    // Eliminar
    public boolean eliminarTarjeta(Integer id) throws Exception {
        try {
            Optional<Tarjeta> tarjetaBuscada = this.repositorio.findById(id);
            if (tarjetaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Tarjeta no encontrada");
            }
        } catch (Exception error) {
            throw new Exception("Error al eliminar tarjeta: " + error.getMessage());
        }
    }
}
