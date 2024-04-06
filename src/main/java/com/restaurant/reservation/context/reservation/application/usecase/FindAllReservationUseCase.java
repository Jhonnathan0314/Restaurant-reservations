package com.restaurant.reservation.context.reservation.application.usecase;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.utils.constants.ErrorMessages;
import com.restaurant.reservation.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllReservationUseCase {

    private final ReservationRepository repository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<Reservation> findAll() throws NoResultsException {

        List<Reservation> reservations = repository.findAll();
        if(reservations.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        return reservations;

    }

}
