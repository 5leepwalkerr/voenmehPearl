package com.voenmeh.voenmehpearl.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.data.annotation.CreatedDate;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "voenmehFile")
public class VoenmehFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId",nullable = false)
    private Long fileId;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "contentType")
    private String contentType;

    @Lob
    @Column(name = "fileData")
    private byte[] fileData;

    @CreatedDate
    @Column(name = "fileCreationTime",nullable = false)
    private Date fileCreationTime;

}
