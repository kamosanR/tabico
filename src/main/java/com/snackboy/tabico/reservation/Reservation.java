package com.snackboy.tabico.reservation;

import com.snackboy.tabico.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String guestName;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder.Default
    private String status = "CONFIRMED"; // CONFIRMED, CANCELLED

    private String roomType;

    private Integer numberOfGuests;
}
