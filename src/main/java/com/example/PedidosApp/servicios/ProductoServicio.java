package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Producto;
import com.example.PedidosApp.modelos.Tienda;
import com.example.PedidosApp.repositorios.IProductoRepositorio;
import com.example.PedidosApp.repositorios.ITiendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    IProductoRepositorio repositorio;

    @Autowired
    ITiendaRepositorio tiendaRepositorio;

    // Metodo Guardar Producto con validación de tienda
    public Producto guardarProducto(Producto datosProducto) throws Exception {
        try {
            // Validar que la tienda existe si se proporciona un ID
            if (datosProducto.getTienda() != null &&
                    datosProducto.getTienda().getId_restaurante() != null) {

                Optional<Tienda> tiendaExiste = tiendaRepositorio
                        .findById(datosProducto.getTienda().getId_restaurante());

                if (!tiendaExiste.isPresent()) {
                    throw new Exception("La tienda especificada no existe");
                }

                // Establecer la tienda completa
                datosProducto.setTienda(tiendaExiste.get());
            }

            return this.repositorio.save(datosProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para guardar producto directamente a una tienda
    public Producto guardarProductoEnTienda(Integer idTienda, Producto datosProducto) throws Exception {
        try {
            Optional<Tienda> tienda = tiendaRepositorio.findById(idTienda);
            if (!tienda.isPresent()) {
                throw new Exception("La tienda especificada no existe");
            }

            datosProducto.setTienda(tienda.get());
            return this.repositorio.save(datosProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para obtener productos por tienda
    public List<Producto> buscarProductosPorTienda(Integer idTienda) throws Exception {
        try {
            Optional<Tienda> tienda = tiendaRepositorio.findById(idTienda);
            if (!tienda.isPresent()) {
                throw new Exception("La tienda especificada no existe");
            }

            return tienda.get().getProductos();
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
                Producto productoExistente = productoBuscado.get();

                productoExistente.setNombre(datosProducto.getNombre());
                productoExistente.setPrecio(datosProducto.getPrecio());
                productoExistente.setDescripcion(datosProducto.getDescripcion());
                productoExistente.setPrecioDescuento(datosProducto.getPrecioDescuento());
                productoExistente.setUbicacion(datosProducto.getUbicacion());
                productoExistente.setImagenUrl(datosProducto.getImagenUrl());

                // Actualizar tienda si se proporciona
                if (datosProducto.getTienda() != null &&
                        datosProducto.getTienda().getId_restaurante() != null) {

                    Optional<Tienda> tienda = tiendaRepositorio
                            .findById(datosProducto.getTienda().getId_restaurante());

                    if (tienda.isPresent()) {
                        productoExistente.setTienda(tienda.get());
                    } else {
                        throw new Exception("La tienda especificada no existe");
                    }
                }

                return this.repositorio.save(productoExistente);
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
