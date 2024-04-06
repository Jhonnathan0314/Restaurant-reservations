package com.restaurant.reservation.context.reservation.infrastructure.mappers;

import com.restaurant.reservation.context.reservation.application.dto.ReservationCreateDTO;
import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.infrastructure.persistence.ReservationEntity;
import com.restaurant.reservation.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationCreateMapper implements Mapper<ReservationEntity, Reservation, ReservationCreateDTO> {
    @Override
    public Reservation entityToModel(ReservationEntity entity) {
        return Reservation.builder()
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .name(entity.getName())
                .dinersNumber(entity.getDinersNumber())
                .notes(entity.getNotes())
                .reservationDate(entity.getReservationDate())
                .build();
    }

    @Override
    public ReservationEntity modelToEntity(Reservation model) {
        return ReservationEntity.builder()
                .documentType(model.getDocumentType())
                .documentNumber(model.getDocumentNumber())
                .name(model.getName())
                .dinersNumber(model.getDinersNumber())
                .notes(model.getNotes())
                .reservationDate(model.getReservationDate())
                .build();
    }

    @Override
    public ReservationCreateDTO modelToDto(Reservation model) {
        return ReservationCreateDTO.builder()
                .documentType(model.getDocumentType())
                .documentNumber(model.getDocumentNumber())
                .name(model.getName())
                .dinersNumber(model.getDinersNumber())
                .notes(model.getNotes())
                .reservationDate(model.getReservationDate())
                .build();
    }

    @Override
    public Reservation dtoToModel(ReservationCreateDTO dto) {
        return Reservation.builder()
                .documentType(dto.getDocumentType())
                .documentNumber(dto.getDocumentNumber())
                .name(dto.getName())
                .dinersNumber(dto.getDinersNumber())
                .notes(dto.getNotes())
                .reservationDate(dto.getReservationDate())
                .build();
    }

    @Override
    public List<Reservation> entitiesToModels(List<ReservationEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationEntity> modelsToEntities(List<Reservation> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationCreateDTO> modelsToDtos(List<Reservation> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> dtosToModels(List<ReservationCreateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
