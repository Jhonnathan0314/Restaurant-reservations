package com.restaurant.reservation.context.reservation.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Reservation {

    private Long id;
    private String documentType;
    private Long documentNumber;
    private String name;
    private Integer dinersNumber;
    private String notes;
    private Timestamp reservationDate;
    private Timestamp updateDate;

    public boolean isValid() {
        return documentType != null && !documentType.isEmpty() &&
                documentNumber != null &&
                name != null && !name.isEmpty() &&
                dinersNumber != null && dinersNumber > 0 && dinersNumber < 5 &&
                notes != null && !notes.isEmpty();
    }

    public boolean areEquals(Reservation reservation) {
        return Objects.equals(this.documentType, reservation.getDocumentType()) &&
                Objects.equals(this.documentNumber, reservation.getDocumentNumber()) &&
                Objects.equals(this.name, reservation.getDocumentType()) &&
                Objects.equals(this.dinersNumber, reservation.getDinersNumber()) &&
                Objects.equals(this.notes, reservation.getDocumentType()) &&
                this.reservationDate == reservation.getReservationDate();

    }

}
