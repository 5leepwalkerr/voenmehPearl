package com.voenmeh.voenmehpearl.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voenmehUser",schema = "public")
@Getter
@Setter
public class VoenmehUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId",nullable = false)
    private Long userId;

    @Column(name = "userName",nullable = false)
    private String userName;

    @Column(name = "userPassword",nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "usersFiles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "fileId")
    )
    private Set<VoenmehFile> usersFiles = new HashSet<>();

    @CreatedDate
    @Column(name = "craetionDateTime",nullable = false)
    private Date creationDateTime;
}
