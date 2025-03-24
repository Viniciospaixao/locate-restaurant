package com.lr.LocateRestaurant.domain.repositories;

import com.lr.LocateRestaurant.domain.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByTipoCozinha(String tipoCozinha);

    List<Restaurante> findByLocalizacao(String localizacao);
}
