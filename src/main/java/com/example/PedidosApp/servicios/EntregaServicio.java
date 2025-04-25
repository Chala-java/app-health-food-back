package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Entrega;
import com.example.PedidosApp.repositorios.IEntregaRepositoro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaServicio {

    @Autowired
    IEntregaRepositoro repositorio;

    //Metodo Guardar
    public Entrega guardarEntrega(Entrega datosEntrega) throws Exception {
        try{
            return this.repositorio.save(datosEntrega);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Entrega> buscarTodos() throws Exception {
        try{
            return this.repositorio.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Entrega buscarEntregaporId(Integer idEntrega) throws Exception {
        try{
            Optional<Entrega> entregaBuscada = this.repositorio.findById(idEntrega);
            if (entregaBuscada.isPresent()) {
                return entregaBuscada.get();
            }else{
                throw new Exception("No se encontro el registro de la entrega");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar por ID
    public Entrega modificarEntrega(Integer id, Entrega datosEntrega) throws Exception {
        try{
            Optional<Entrega> entregaBuscada = this.repositorio.findById(id);
            if (entregaBuscada.isPresent()) {
                entregaBuscada.get().setId_entrega(datosEntrega.getId_entrega());
                entregaBuscada.get().setFecha_de_entrega(datosEntrega.getFecha_de_entrega());
                entregaBuscada.get().setEstado_entrega(datosEntrega.getEstado_entrega());
                return this.repositorio.save(entregaBuscada.get());
            }else{
                throw new Exception("No se encontro el registro de la entrega");
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar por ID
    public boolean eliminarEntrega(Integer id) throws Exception {
        try{
            Optional<Entrega> entregaBuscada = this.repositorio.findById(id);
            if (entregaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;  
            }else{
                throw new Exception("No se encontro el registro de la entrega"); 
            }
        }catch(Exception error){
            throw new Exception(error.getMessage()); 
        }
    }

}
