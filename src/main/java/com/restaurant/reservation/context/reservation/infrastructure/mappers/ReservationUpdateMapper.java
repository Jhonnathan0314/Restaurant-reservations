package com.restaurant.reservation.context.reservation.infrastructure.mappers;

import com.restaurant.reservation.context.reservation.application.dto.ReservationUpdateDTO;
import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.infrastructure.persistence.ReservationEntity;
import com.restaurant.reservation.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationUpdateMapper implements Mapper<ReservationEntity, Reservation, ReservationUpdateDTO> {
    @Override
    public Reservation entityToModel(ReservationEntity entity) {
        return Reservation.builder()
                .id(entity.getId())
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
                .id(model.getId())
                .documentType(model.getDocumentType())
                .documentNumber(model.getDocumentNumber())
                .name(model.getName())
                .dinersNumber(model.getDinersNumber())
                .notes(model.getNotes())
                .reservationDate(model.getReservationDate())
                .build();
    }

    @Override
    public ReservationUpdateDTO modelToDto(Reservation model) {
        return ReservationUpdateDTO.builder()
                .id(model.getId())
                .documentType(model.getDocumentType())
                .documentNumber(model.getDocumentNumber())
                .name(model.getName())
                .dinersNumber(model.getDinersNumber())
                .notes(model.getNotes())
                .reservationDate(model.getReservationDate())
                .build();
    }

    @Override
    public Reservation dtoToModel(ReservationUpdateDTO dto) {
        return Reservation.builder()
                .id(dto.getId())
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
    public List<ReservationUpdateDTO> modelsToDtos(List<Reservation> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> dtosToModels(List<ReservationUpdateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
