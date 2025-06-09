package com.example.PedidosApp.repositorios;
import com.example.PedidosApp.modelos.Tarjeta;
import com.example.PedidosApp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IDTarjetaRepositorio extends JpaRepository<Tarjeta, Integer>  {
    List<Tarjeta> findByUsuario(Usuario usuario);
}
