package com.example.studentlist;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "surname", length = 200)
    private String surname;
    @Column(name = "exam")
    private int exam;
    @Column(name = "mark", length = 200)
    private String mark;
}
