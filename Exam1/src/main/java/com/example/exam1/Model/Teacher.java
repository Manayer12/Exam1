package com.example.exam1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "should not be null")
    private Integer id;
    @NotEmpty(message = "should not be null")

    private String name;
    @NotNull(message = "should not be null")
    private Integer salary;
}
