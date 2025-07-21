package com.snackboy.tabico.config;

import com.snackboy.tabico.member.Member;
import com.snackboy.tabico.member.MemberRepository;
import com.snackboy.tabico.reservation.Reservation;
import com.snackboy.tabico.reservation.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        // テストデータが存在しない場合のみ追加
        if (memberRepository.count() == 0) {
            // テスト用会員データ
            Member member1 = memberRepository.save(Member.builder()
                    .name("田中太郎")
                    .email("tanaka@example.com")
                    .phone("090-1234-5678")
                    .address("東京都渋谷区")
                    .build());

            Member member2 = memberRepository.save(Member.builder()
                    .name("佐藤花子")
                    .email("sato@example.com")
                    .phone("090-9876-5432")
                    .address("大阪府大阪市")
                    .build());

            // 会員の予約データ
            reservationRepository.save(Reservation.builder()
                    .guestName("田中太郎")
                    .checkIn(LocalDate.of(2025, 7, 25))
                    .checkOut(LocalDate.of(2025, 7, 27))
                    .roomType("デラックス")
                    .numberOfGuests(2)
                    .member(member1)
                    .status("CONFIRMED")
                    .build());

            reservationRepository.save(Reservation.builder()
                    .guestName("佐藤花子")
                    .checkIn(LocalDate.of(2025, 8, 1))
                    .checkOut(LocalDate.of(2025, 8, 3))
                    .roomType("スイート")
                    .numberOfGuests(1)
                    .member(member2)
                    .status("CONFIRMED")
                    .build());

            // 一般予約（会員以外）
            reservationRepository.save(Reservation.builder()
                    .guestName("山田次郎")
                    .checkIn(LocalDate.of(2025, 8, 10))
                    .checkOut(LocalDate.of(2025, 8, 12))
                    .roomType("スタンダード")
                    .numberOfGuests(3)
                    .status("CONFIRMED")
                    .build());
        }
    }
}
