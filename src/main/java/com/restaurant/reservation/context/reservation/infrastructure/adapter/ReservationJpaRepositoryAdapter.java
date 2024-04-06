package com.restaurant.reservation.context.reservation.infrastructure.adapter;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.context.reservation.infrastructure.mappers.ReservationResponseMapper;
import com.restaurant.reservation.context.reservation.infrastructure.persistence.ReservationEntity;
import com.restaurant.reservation.context.reservation.infrastructure.persistence.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationJpaRepositoryAdapter implements ReservationRepository {

    private final ReservationJpaRepository jpaRepository;

    private final ReservationResponseMapper mapper = new ReservationResponseMapper();

    @Override
    public List<Reservation> findAll() {
        List<ReservationEntity> reservations = jpaRepository.findAll();
        return mapper.entitiesToModels(reservations);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        Optional<ReservationEntity> reservation = jpaRepository.findById(id);
        return reservation.map(mapper::entityToModel);
    }

    @Override
    public Reservation create(Reservation reservation) {
        ReservationEntity reservationEntity = jpaRepository.save(mapper.modelToEntity(reservation));
        return mapper.entityToModel(reservationEntity);
    }

    @Override
    public Reservation update(Reservation reservation) {
        ReservationEntity reservationEntity = jpaRepository.save(mapper.modelToEntity(reservation));
        return mapper.entityToModel(reservationEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
