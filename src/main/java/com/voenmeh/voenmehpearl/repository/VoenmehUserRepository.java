package com.voenmeh.voenmehpearl.repository;

import com.voenmeh.voenmehpearl.model.VoenmehUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoenmehUserRepository extends JpaRepository<VoenmehUser, Long> {
    Optional<VoenmehUser> findByUsername(String username);
}
