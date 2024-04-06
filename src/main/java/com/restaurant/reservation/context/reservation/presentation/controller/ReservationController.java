package com.restaurant.reservation.context.reservation.presentation.controller;

import com.restaurant.reservation.context.reservation.application.dto.ReservationCreateDTO;
import com.restaurant.reservation.context.reservation.application.dto.ReservationResponseDTO;
import com.restaurant.reservation.context.reservation.application.dto.ReservationUpdateDTO;
import com.restaurant.reservation.context.reservation.application.usecase.*;
import com.restaurant.reservation.context.reservation.infrastructure.mappers.ReservationCreateMapper;
import com.restaurant.reservation.context.reservation.infrastructure.mappers.ReservationResponseMapper;
import com.restaurant.reservation.context.reservation.infrastructure.mappers.ReservationUpdateMapper;
import com.restaurant.reservation.utils.exceptions.InvalidBodyException;
import com.restaurant.reservation.utils.exceptions.NoChangesException;
import com.restaurant.reservation.utils.exceptions.NoResultsException;
import com.restaurant.reservation.utils.exceptions.NonExistenceException;
import com.restaurant.reservation.utils.http.HttpUtils;
import com.restaurant.reservation.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReservationController {

    private final FindAllReservationUseCase findAllUseCase;
    private final FindByIdReservationUseCase findByIdUseCase;
    private final CreateReservationUseCase createUseCase;
    private final UpdateReservationUseCase updateUseCase;
    private final DeleteByIdReservationUseCase deleteByIdUseCase;

    private final ReservationCreateMapper createMapper = new ReservationCreateMapper();
    private final ReservationUpdateMapper updateMapper = new ReservationUpdateMapper();
    private final ReservationResponseMapper responseMapper = new ReservationResponseMapper();

    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReservationResponseDTO>>> findAll() {
        ApiResponse<List<ReservationResponseDTO>> response = new ApiResponse<>();
        try {
            List<ReservationResponseDTO> reservations = responseMapper.modelsToDtos(findAllUseCase.findAll());
            response.setData(reservations);
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setStatus(httpUtils.determineHttpErrorCode(e));
            response.setMessage(httpUtils.determineHttpErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> findAll(@PathVariable(name = "id") Long id) {
        ApiResponse<ReservationResponseDTO> response = new ApiResponse<>();
        try {
            ReservationResponseDTO reservation = responseMapper.modelToDto(findByIdUseCase.findById(id));
            response.setData(reservation);
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setStatus(httpUtils.determineHttpErrorCode(e));
            response.setMessage(httpUtils.determineHttpErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> create(@RequestBody ReservationCreateDTO reservationDTO) {
        ApiResponse<ReservationResponseDTO> response = new ApiResponse<>();
        try {
            ReservationResponseDTO reservation = responseMapper.modelToDto(createUseCase.create(createMapper.dtoToModel(reservationDTO)));
            response.setData(reservation);
            response.setStatus(HttpStatus.CREATED.value());
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException e) {
            response.setStatus(httpUtils.determineHttpErrorCode(e));
            response.setMessage(httpUtils.determineHttpErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationResponseDTO>> update(@PathVariable(name = "id") Long id, @RequestBody ReservationUpdateDTO reservationDTO) {
        ApiResponse<ReservationResponseDTO> response = new ApiResponse<>();
        try {
            ReservationResponseDTO reservation = responseMapper.modelToDto(updateUseCase.update(updateMapper.dtoToModel(reservationDTO)));
            response.setData(reservation);
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | NoChangesException | NonExistenceException e) {
            response.setStatus(httpUtils.determineHttpErrorCode(e));
            response.setMessage(httpUtils.determineHttpErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable(name = "id") Long id) {
        ApiResponse<Object> response = new ApiResponse<>();
        try {
            deleteByIdUseCase.deleteById(id);
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (NonExistenceException e) {
            response.setStatus(httpUtils.determineHttpErrorCode(e));
            response.setMessage(httpUtils.determineHttpErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
