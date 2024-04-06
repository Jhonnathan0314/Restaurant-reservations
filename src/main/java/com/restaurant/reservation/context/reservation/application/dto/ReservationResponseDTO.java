package com.restaurant.reservation.context.reservation.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {

    private Long id;
    private String documentType;
    private Long documentNumber;
    private String name;
    private int dinersNumber;
    private String notes;
    private Timestamp reservationDate;

}
