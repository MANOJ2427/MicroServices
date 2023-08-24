package com.learn.microservices.userServices.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Users {
    @Id
    @Column(name ="id")
    @Nonnull
    private String userID;

    @Column(name ="name")
    @Nonnull
    private String name;

    @Column(name ="email")
    @Nonnull
    private String email;

    @Column(name ="about")
    @Nonnull
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();


}
