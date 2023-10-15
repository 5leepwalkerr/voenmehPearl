package com.voenmeh.voenmehpearl.repository;

import com.voenmeh.voenmehpearl.model.VoenmehUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoenmehUserRepository extends JpaRepository<VoenmehUser, Long> {
}
