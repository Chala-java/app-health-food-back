package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Repartidor;
import com.example.PedidosApp.repositorios.IRepartidorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class RepartidorServicio {

    @Autowired
    IRepartidorRepositorio repositorio;

    //Metodo Guardar
    public Repartidor guardarRepartidor(Repartidor datosRepartidor) throws Exception {
        try {
            return this.repositorio.save(datosRepartidor);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Repartidor> buscarTodosRepartidores() throws Exception {
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Repartidor buscarRepartidorPorId(Integer idRepartidor) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(idRepartidor);
            if (repartidorBuscado.isPresent()){
                return repartidorBuscado.get();
            }else {
                throw new Exception("El repartidor consultado no esta en BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar por ID
    public Repartidor modificarRepartidor(Integer id, Repartidor datosRepartidor) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()){
                repartidorBuscado.get().setId_repartidor(datosRepartidor.getId_repartidor());
                repartidorBuscado.get().setNombre(datosRepartidor.getNombre());
                repartidorBuscado.get().setTelefono(datosRepartidor.getTelefono());
                repartidorBuscado.get().setCorreoElectronico(datosRepartidor.getCorreoElectronico());
                repartidorBuscado.get().setTipoVehiculo(datosRepartidor.getTipoVehiculo());
                return this.repositorio.save(repartidorBuscado.get());
            }else {
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar por ID
    public boolean eliminarRepartidor(Integer id) throws Exception {
        try {
            Optional<Repartidor> repartidorBuscado = this.repositorio.findById(id);
            if (repartidorBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Repartidor no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
