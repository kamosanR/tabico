package com.snackboy.tabico.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Member> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Member save(Member member) {
        if (repository.existsByEmail(member.getEmail())) {
            throw new RuntimeException("Email already exists: " + member.getEmail());
        }
        return repository.save(member);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
