package com.voenmeh.voenmehpearl.repository;

import com.voenmeh.voenmehpearl.model.VoenmehFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoenmehFileRepository extends JpaRepository<VoenmehFile, Long> {
}
