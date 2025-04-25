package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Pago;
import com.example.PedidosApp.repositorios.IPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServicio {

    @Autowired
    IPagoRepositorio repositorio;

    //Metodo Guardar
    public Pago guardarPago(Pago datosPago) throws Exception {
        try{
            return this.repositorio.save(datosPago);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Pago> buscarTodosLosPagos() throws Exception{
        try{
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage()); 
        }
    }

    //Metodo para buscar por ID
    public Pago buscarPagoPorId(Integer idPago) throws Exception{
        try{
            Optional<Pago> pagoBuscado = this.repositorio.findById(idPago);
            if(pagoBuscado.isPresent()){
                return pagoBuscado.get();
            }else{
                throw new Exception("No se encontro el pago");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage()); 
        }
    }

    //Metodo para modificar por id
    public Pago modificarPago(Integer id, Pago datosPago) throws Exception{
       try{
        Optional<Pago> pagoBuscado = this.repositorio.findById(id);
        if(pagoBuscado.isPresent()){
            pagoBuscado.get().setId_pago(datosPago.getId_pago());
            pagoBuscado.get().setMetodo_pago(datosPago.getMetodo_pago());
            pagoBuscado.get().setEstado_pago(datosPago.getEstado_pago());
            pagoBuscado.get().setFecha_pago(datosPago.getFecha_pago());
            return this.repositorio.save(pagoBuscado.get());
        }else{
            throw new Exception("No se encontro el pago");
        }
       }catch (Exception error){
        throw new Exception(error.getMessage());
       }
    }

    //Metodo para eliminar por id
    public Boolean eliminarPago(Integer id) throws Exception{
        try{
            Optional<Pago> pagoBuscado = this.repositorio.findById(id);
            if(pagoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;  
            }else{
                throw new Exception("No se encontro el pago");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
        
}
