package com.hojeonde.hoje.models;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;
public record UserRequestDTO(@NotBlank
                             String nome,
                             @NotBlank
                             String email,
                             @NumberFormat
                             String telefone,

                             String cpf
                             ) {
}
