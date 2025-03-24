package com.lr.LocateRestaurant.domain.repositories;

import com.lr.LocateRestaurant.domain.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findByRestauranteId(Long restauranteId);

    List<Avaliacao> findByUsuarioId(Long usuarioId);
}

