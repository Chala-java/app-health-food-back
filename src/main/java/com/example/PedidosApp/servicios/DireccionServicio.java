package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Direccion;
import com.example.PedidosApp.repositorios.IDireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio {

    @Autowired
    IDireccionRepositorio repositorio;

    //Metodo Guardar
    public Direccion guardarDireccion(Direccion datosDireccion) throws Exception {
        try{
            return this.repositorio.save(datosDireccion);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para buscar todos los registros
    public List<Direccion> buscarTodasDirecciones() throws Exception {
        try{
            return this.repositorio.findAll(); 
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para buscar por id
    public Direccion buscarDireccionPorId(Integer idDireccion) throws Exception {
        try{
            Optional<Direccion> direccionBuscada = this.repositorio.findById(idDireccion);
            if (direccionBuscada.isPresent()) {
                return direccionBuscada.get();
            } else {
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para modificar por id
    public Direccion modificarDireccion(Integer id, Direccion datosDireccion) throws Exception {
        try{
            Optional<Direccion> direccionBuscada = this. repositorio.findById(id);
            if (direccionBuscada.isPresent()) {
              direccionBuscada.get().setId_direccion(datosDireccion.getId_direccion());
              direccionBuscada.get().setCalle(direccionBuscada.get().getCalle());
              direccionBuscada.get().setCiudad(direccionBuscada.get().getCiudad());
              direccionBuscada.get().setCodigo_postal(direccionBuscada.get().getCodigo_postal());
              direccionBuscada.get().setPais(direccionBuscada.get().getPais());
              return this.repositorio.save(direccionBuscada.get());
            } else {
                throw new Exception("Direccion no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para eliminar por id
    public Boolean eliminarDireccion(Integer id) throws Exception {
        try{
            Optional<Direccion> direccionBuscada = this.repositorio.findById(id);
            if (direccionBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true; 
            } else {
                throw new Exception("Direccion no encontrada"); 
            }
        }catch (Exception error){
            throw new Exception(error.getMessage()); 
        }
    }
}
