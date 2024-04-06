package com.restaurant.reservation.context.reservation.infrastructure.mappers;

import com.restaurant.reservation.context.reservation.application.dto.ReservationResponseDTO;
import com.restaurant.reservation.context.reservation.domain.model.Reservation;
import com.restaurant.reservation.context.reservation.infrastructure.persistence.ReservationEntity;
import com.restaurant.reservation.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationResponseMapper implements Mapper<ReservationEntity, Reservation, ReservationResponseDTO> {
    @Override
    public Reservation entityToModel(ReservationEntity entity) {
        return Reservation.builder()
                .id(entity.getId())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .name(entity.getName())
                .dinersNumber(entity.getDinersNumber())
                .notes(entity.getNotes())
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
                .build();
    }

    @Override
    public ReservationResponseDTO modelToDto(Reservation model) {
        return ReservationResponseDTO.builder()
                .id(model.getId())
                .documentType(model.getDocumentType())
                .documentNumber(model.getDocumentNumber())
                .name(model.getName())
                .dinersNumber(model.getDinersNumber())
                .notes(model.getNotes())
                .build();
    }

    @Override
    public Reservation dtoToModel(ReservationResponseDTO dto) {
        return Reservation.builder()
                .id(dto.getId())
                .documentType(dto.getDocumentType())
                .documentNumber(dto.getDocumentNumber())
                .name(dto.getName())
                .dinersNumber(dto.getDinersNumber())
                .notes(dto.getNotes())
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
    public List<ReservationResponseDTO> modelsToDtos(List<Reservation> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> dtosToModels(List<ReservationResponseDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
