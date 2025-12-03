package org.example.onetoone.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.onetoone.Model.Teacher;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "teacherId must be not null")
    private Integer teacherId;

    @NotEmpty(message = "area must be not empty")
    private String area;

    @NotEmpty(message = "street must be not empty")
    private String street;

    @NotEmpty(message = "BuildingNumber must be not empty")
    private String BuildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
