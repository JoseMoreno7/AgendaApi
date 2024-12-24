 package com.examenfinal.listacontactosapi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter //lombot
@Setter //lombot
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id //Notacion que viene de jakarta ar ano tener problemas
    @GeneratedValue(strategy = GenerationType.AUTO)
    // autoincremetar el id con auto por la base de datos h2
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private LocalDateTime createdAt;
}
