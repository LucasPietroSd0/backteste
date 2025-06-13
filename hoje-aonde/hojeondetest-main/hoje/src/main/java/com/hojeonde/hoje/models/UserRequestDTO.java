package com.hojeonde.hoje.models;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;
public record UserRequestDTO(

                             @NotBlank
                             @Email
                             String email,

                             @NotBlank
                             @NumberFormat
                             String telefone,

                             @NotBlank
                             String senha

                             ) {

}
