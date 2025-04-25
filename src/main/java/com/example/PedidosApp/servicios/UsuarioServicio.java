package com.example.PedidosApp.servicios;

import com.example.PedidosApp.modelos.Usuario;
import com.example.PedidosApp.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositorio repositorio;

    //Listar los metodos que activaran
    //Las consultas en la base de datos

    //Metodo Guardar
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try {
            //Validar los datos entrada
            return this.repositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        try {

            return this.repositorio.findAll();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(idUsuario);
            if (usuarioBuscado.isPresent()){
                return usuarioBuscado.get();
            }else {
                throw  new Exception("El usuario consultado no esta en BD");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    //Metodo para modificar por ID
    public Usuario modificarUsuario(Integer id, Usuario datosUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                return this.repositorio.save(usuarioBuscado.get());

            }else {
                throw new Exception("usuaro no encntrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar por ID
    public boolean eliminarUsuario(Integer id) throws Exception{
        try{
            Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()){
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception("Usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }
}
