package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Pedido;
import com.example.PedidosApp.repositorios.IPedidoRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    IPedidoRepositorio repositorio;

    //Metodo Guardar
    public Pedido guardarPedido(Pedido datosPedido) throws Exception {
        try{
            return this.repositorio.save(datosPedido);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Pedido> buscarTodosPedidos() throws Exception {
        try{
            return this.repositorio.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Pedido buscarPedidoPorId(Integer idPedido) throws Exception {
        try{
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(idPedido);
            if (pedidoBuscado.isPresent()) {
                return pedidoBuscado.get();
            }else{
                throw new Exception("No se encontro el pedido con el ID: " + idPedido);
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar por ID
    public Pedido modificarPedido(Integer id, Pedido datosPedido) throws Exception {
       try{
        Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
        if (pedidoBuscado.isPresent()) {
            pedidoBuscado.get().setId_pedido(datosPedido.getId_pedido());
            pedidoBuscado.get().setEstado_pedido(datosPedido.getEstado_pedido());
            pedidoBuscado.get().setFecha_pedido(datosPedido.getFecha_pedido());
            pedidoBuscado.get().setTotal_pedido(datosPedido.getTotal_pedido());
            return this.repositorio.save(pedidoBuscado.get());
        }else{
            throw new Exception("No se encontro el pedido con el ID: " + id);
        }
       }catch(Exception error){
        throw new Exception(error.getMessage());
       } 
    }

    //Metodo para eliminar por ID
    public boolean eliminarPedido(Integer id) throws Exception {
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
