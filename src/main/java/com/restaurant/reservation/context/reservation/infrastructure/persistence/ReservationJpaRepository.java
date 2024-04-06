package com.restaurant.reservation.context.reservation.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {

}
