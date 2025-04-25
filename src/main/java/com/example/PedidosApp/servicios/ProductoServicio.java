package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Producto;
import com.example.PedidosApp.repositorios.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    IProductoRepositorio repositorio;

    // Metodo Guardar
    public Producto guardarProducto(Producto datosProducto) throws Exception {
        try {
            return this.repositorio.save(datosProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo buscar todos los registros
    public List<Producto> buscarTodosProductos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo buscar por id
    public Producto buscarProductoPorId(Integer idProducto) throws Exception {
        try {
            Optional<Producto> productobuscado = this.repositorio.findById(idProducto);
            if (productobuscado.isPresent()) {
                return productobuscado.get();
            } else {
                throw new Exception("El Producto consultado no esta en la BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para modificar por ID
    public Producto modificarProducto(Integer id, Producto datosProducto) throws Exception {
        try {
            Optional<Producto> productoBuscado = this.repositorio.findById(id);
            if (productoBuscado.isPresent()) {
                productoBuscado.get().setId_producto(datosProducto.getId_producto());
                productoBuscado.get().setNombre(datosProducto.getNombre());
                productoBuscado.get().setPrecio(datosProducto.getPrecio());
                productoBuscado.get().setDescripcion(datosProducto.getDescripcion());
                return this.repositorio.save(productoBuscado.get());
            } else {
                throw new Exception("El Producto consultado no esta en la BD");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    // Metodo para eliminar por ID
    public boolean eliminarProducto(Integer id) throws Exception {
        try{
            Optional<Producto> productoBuscado = this.repositorio.findById(id);
            if (productoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("El Producto consultado no esta en la BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
