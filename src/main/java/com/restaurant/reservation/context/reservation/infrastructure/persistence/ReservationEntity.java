package com.restaurant.reservation.context.reservation.infrastructure.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant_reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_type", length = 20)
    private String documentType;

    @Column(name = "document_number")
    private Long documentNumber;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "diners_number")
    private Integer dinersNumber;

    @Column(name = "notes", length = 150)
    private String notes;

    @Column(name = "reservation_date")
    @CreationTimestamp
    @JsonFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private Timestamp reservationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    @JsonFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private Timestamp updateDate;

}
