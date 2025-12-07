package org.example.onetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must be not empty")
    private String name;

    @NotEmpty(message = "major must be not empty")
    private String major;

    @NotNull(message = "age must be not null")
    private Integer age;

    @ManyToMany
    @JsonIgnore
    private Set<Course> courses;
}
