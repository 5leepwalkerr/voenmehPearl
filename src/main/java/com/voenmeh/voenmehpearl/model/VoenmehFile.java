package com.voenmeh.voenmehpearl.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "voenmehFile")
public class VoenmehFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId",nullable = false)
    private Long fileId;

    @Column(name = "voenmehFile",nullable = true)
    private File voenmehFile;

}
