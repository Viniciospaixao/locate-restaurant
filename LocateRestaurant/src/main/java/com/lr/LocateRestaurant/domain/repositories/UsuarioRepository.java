package com.lr.LocateRestaurant.domain.repositories;

import com.lr.LocateRestaurant.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos personalizados podem ser adicionados aqui
    // Exemplo: Buscar usuário por e-mail
    Optional<Usuario> findByEmail(String email);
}
