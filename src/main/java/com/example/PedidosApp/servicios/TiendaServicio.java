package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Producto;
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

    public Tienda guardarTiendas(Tienda datosTiendas) throws Exception  {
        try {
            // Seteamos la tienda en cada producto para que tenga relación
            if (datosTiendas.getProductos() != null && !datosTiendas.getProductos().isEmpty()) {
                for (Producto producto : datosTiendas.getProductos()) {
                    producto.setTienda(datosTiendas);
                }
            }

            // Guardamos la tienda y los productos en cascada
            return this.repositorio.save(datosTiendas);
        } catch (Exception error){
            throw new Exception("Error guardando tienda con productos: " + error.getMessage());
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

