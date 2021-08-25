package com.atlantico.user.gateway.database.entity;

import com.atlantico.user.commons.util.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -114252909735297767L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
