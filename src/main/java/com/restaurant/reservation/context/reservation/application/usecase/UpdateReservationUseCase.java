package com.restaurant.reservation.context.reservation.application.usecase;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.utils.constants.ErrorMessages;
import com.restaurant.reservation.utils.exceptions.InvalidBodyException;
import com.restaurant.reservation.utils.exceptions.NoChangesException;
import com.restaurant.reservation.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateReservationUseCase {

    private final ReservationRepository repository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public Reservation update(Reservation reservation) throws InvalidBodyException, NonExistenceException, NoChangesException {

        Optional<Reservation> reservationDb = repository.findById(reservation.getId());
        if(reservationDb.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);
        if(!reservation.isValid()) throw new InvalidBodyException(errorMessages.INVALID_BODY);
        if(reservation.areEquals(reservationDb.get())) throw new NoChangesException(errorMessages.NO_CHANGES);

        return repository.update(reservation);
    }
}
