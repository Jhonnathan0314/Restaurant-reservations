package com.restaurant.reservation.context.reservation.application.usecase;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.utils.constants.ErrorMessages;
import com.restaurant.reservation.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteByIdReservationUseCase {

    private final ReservationRepository repository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public void deleteById(Long id) throws NonExistenceException {

        Optional<Reservation> reservationDb = repository.findById(id);
        if(reservationDb.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);

        repository.deleteById(id);
    }

}
