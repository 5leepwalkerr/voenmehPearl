package com.voenmeh.voenmehpearl.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voenmehUser",schema = "public",uniqueConstraints = {@UniqueConstraint(columnNames = {"userName","email"})})
@Getter
@Setter
@Builder
public class VoenmehUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId",nullable = false)
    private Long userId;
    @Column(name = "userName",nullable = false,unique = true)
    private String userName;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "craetionDateTime")
    private Date creationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "userRole",nullable = false)
    private VoenmehRole userRole;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
