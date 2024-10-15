package com.fitperformsync.fitperformsync.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;

    @NotNull
    private String name;

    private String password;

    @NotNull
    private String email;

    @NotNull()
    private LocalDate dateOfBirth;
}
