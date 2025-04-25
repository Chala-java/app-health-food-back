package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Tienda;
import com.example.PedidosApp.repositorios.ITiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TiendaServicio {

    @Autowired
    ITiendaRepositorio repositorio;

    //Metodo Guardar
    public Tienda guardarTienda(Tienda datosTienda) throws Exception  {
        try {
            return this.repositorio.save(datosTienda);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Tienda> buscarTodosTiendas() throws Exception {
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Tienda buscarTiendaPorId(Integer idTienda) throws Exception {
        try {
           Optional<Tienda> tiendaBuscada = this.repositorio.findById(idTienda);
           if (tiendaBuscada.isPresent()){
               return tiendaBuscada.get();  
           } else{
               throw new Exception("La tienda consultada no esta en BD");
           }
        } catch (Exception error){
            throw new Exception(error.getMessage()); 
        }
    }

    //Metodo para modificar por ID
    public Tienda modificarTienda(Integer id, Tienda datosTienda) throws Exception{
        try {
            Optional<Tienda> tiendaBuscada=this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()){
                tiendaBuscada.get().setId_restaurante(datosTienda.getId_restaurante());
                tiendaBuscada.get().setNombre(datosTienda.getNombre());
                tiendaBuscada.get().setDireccion(datosTienda.getDireccion());
                tiendaBuscada.get().setTelefono(datosTienda.getTelefono());
                tiendaBuscada.get().setCategorias(datosTienda.getCategorias());
                return this.repositorio.save(tiendaBuscada.get());
            }else {
                throw new Exception("Tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar por ID
    public boolean eliminarTienda(Integer id) throws Exception{
        try{
            Optional<Tienda> tiendaBuscada=this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Tienda no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}

