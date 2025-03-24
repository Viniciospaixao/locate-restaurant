package com.lr.LocateRestaurant.domain.repositories;

import com.lr.LocateRestaurant.domain.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByDataHora(LocalDateTime dataHora);
    List<Reserva> findByRestauranteId(Long restauranteId);
    List<Reserva> findByUsuarioId(Long usuarioId);
}