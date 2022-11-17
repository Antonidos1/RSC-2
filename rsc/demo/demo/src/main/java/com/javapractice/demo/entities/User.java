package com.javapractice.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(nullable = false, length = 25,name = "first_name")
    private String firstname;
    @Column(nullable = false, length = 25, name = "last_name")
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}


