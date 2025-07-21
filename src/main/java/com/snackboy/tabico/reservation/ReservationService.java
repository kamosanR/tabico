package com.snackboy.tabico.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }
}
