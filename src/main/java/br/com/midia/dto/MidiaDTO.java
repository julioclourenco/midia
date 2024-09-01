package br.com.midia.dto;

import br.com.midia.enums.Origem;
import br.com.midia.enums.Tipo;
import br.com.midia.enums.Plataforma;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.Date;

public record MidiaDTO(
        @NotNull
        Plataforma plataforma,
        @NotNull
        Tipo tipo,
        @NotNull
        Origem origem,
        @NotBlank
        String titulo,
        @NotBlank
        String estilo,
        @NotNull
        BigInteger nota,
        Date registro) {
}
