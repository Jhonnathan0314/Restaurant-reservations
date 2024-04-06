package com.restaurant.reservation.context.reservation.application.usecase;

import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.domain.port.ReservationRepository;
import com.restaurant.reservation.utils.constants.ErrorMessages;
import com.restaurant.reservation.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdReservationUseCase {

    private final ReservationRepository repository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public Reservation findById(Long id) throws NoResultsException {

        Optional<Reservation> reservation = repository.findById(id);
        if(reservation.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        return reservation.get();

    }
}
