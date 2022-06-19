package com.howtodoinjava.hibernate.test.dto;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table (name = "Concursuri")
public class Concursuri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int IdConcurs;
    @Column (name = "denumireConcurs")
    private String denumireConcurs;
    @Column (name = "Premiu")
    private int Premiu;




}
