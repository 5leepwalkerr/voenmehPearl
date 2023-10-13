package com.voenmeh.voenmehpearl.repository;

import com.voenmeh.voenmehpearl.model.VoenmehUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoenmehUserRepository extends JpaRepository<Long, VoenmehUser> {
}
