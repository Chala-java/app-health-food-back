package com.example.PedidosApp.repositorios;

import com.example.PedidosApp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{

    //Dentro del repo van las consultas personalizadas

}
