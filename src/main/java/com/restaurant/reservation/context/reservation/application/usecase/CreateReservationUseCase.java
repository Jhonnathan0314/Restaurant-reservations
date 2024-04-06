package com.restaurant.reservation.context.reservation.application.usecase;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.utils.constants.ErrorMessages;
import com.restaurant.reservation.utils.exceptions.InvalidBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateReservationUseCase {

    private final ReservationRepository repository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public Reservation create(Reservation reservation) throws InvalidBodyException {

        if(!reservation.isValid()) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        return repository.create(reservation);
    }

}
