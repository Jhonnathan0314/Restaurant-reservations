package com.restaurant.reservation.context.reservation.domain.port;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Reservation create(Reservation reservation);
    Reservation update(Reservation reservation);
    void deleteById(Long id);

}
