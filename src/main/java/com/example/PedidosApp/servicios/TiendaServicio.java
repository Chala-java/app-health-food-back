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

    // Método principal para guardar tienda con productos
    public Tienda guardarTiendaConProductos(Tienda datosTienda) throws Exception {
        try {
            // Establecer la relación bidireccional
            if (datosTienda.getProductos() != null && !datosTienda.getProductos().isEmpty()) {
                for (Producto producto : datosTienda.getProductos()) {
                    producto.setTienda(datosTienda);
                }
            }

            return this.repositorio.save(datosTienda);
        } catch (Exception error) {
            throw new Exception("Error al guardar tienda con productos: " + error.getMessage());
        }
    }

    // Método para guardar tienda sin productos (para compatibilidad)
    public Tienda guardarTienda(Tienda datosTienda) throws Exception {
        try {
            return this.repositorio.save(datosTienda);
        } catch (Exception error) {
            throw new Exception("Error al guardar tienda: " + error.getMessage());
        }
    }

    // Método unificado que funciona con o sin productos
    public Tienda guardarTiendas(Tienda datosTienda) throws Exception {
        return guardarTiendaConProductos(datosTienda);
    }

    // Método para agregar productos a una tienda existente
    public Tienda agregarProductosATienda(Integer idTienda, List<Producto> productos) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(idTienda);
            if (tiendaBuscada.isPresent()) {
                Tienda tienda = tiendaBuscada.get();

                // Agregar los nuevos productos
                for (Producto producto : productos) {
                    producto.setTienda(tienda);
                    tienda.getProductos().add(producto);
                }

                return this.repositorio.save(tienda);
            } else {
                throw new Exception("La tienda no existe");
            }
        } catch (Exception error) {
            throw new Exception("Error al agregar productos a la tienda: " + error.getMessage());
        }
    }

    // Metodo para buscar todos los registros
    public List<Tienda> buscarTodosTiendas() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para buscar por ID
    public Tienda buscarTiendaPorId(Integer idTienda) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(idTienda);
            if (tiendaBuscada.isPresent()) {
                return tiendaBuscada.get();
            } else {
                throw new Exception("La tienda consultada no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para modificar por ID
    public Tienda modificarTienda(Integer id, Tienda datosTienda) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()) {
                Tienda tiendaExistente = tiendaBuscada.get();

                // Actualizar campos básicos
                tiendaExistente.setNombre(datosTienda.getNombre());
                tiendaExistente.setDireccion(datosTienda.getDireccion());
                tiendaExistente.setTelefono(datosTienda.getTelefono());
                tiendaExistente.setCategoria(datosTienda.getCategoria());
                tiendaExistente.setLogoUrl(datosTienda.getLogoUrl());
                tiendaExistente.setPortadaUrl(datosTienda.getPortadaUrl());
                tiendaExistente.setCategorias(datosTienda.getCategorias());

                // Actualizar productos si se proporcionan
                if (datosTienda.getProductos() != null) {
                    // Limpiar productos existentes
                    tiendaExistente.getProductos().clear();

                    // Agregar nuevos productos
                    for (Producto producto : datosTienda.getProductos()) {
                        producto.setTienda(tiendaExistente);
                        tiendaExistente.getProductos().add(producto);
                    }
                }

                return this.repositorio.save(tiendaExistente);
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Metodo para eliminar por ID
    public boolean eliminarTienda(Integer id) throws Exception {
        try {
            Optional<Tienda> tiendaBuscada = this.repositorio.findById(id);
            if (tiendaBuscada.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception("Tienda no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
