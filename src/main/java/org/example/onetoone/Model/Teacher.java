package org.example.onetoone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must be not empty")
    @Column(nullable = false )
    private String name;

    @NotNull(message = "age must be not null")
    @Column(nullable = false)
    private Integer age;

    @NotEmpty(message = "email must be not empty")
    @Column(nullable = false , unique = true)
    private String email;

    @NotNull(message = "salary must be not null")
    @Column(nullable = false)
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courseSet;
}
