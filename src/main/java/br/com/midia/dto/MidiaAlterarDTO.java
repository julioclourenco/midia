package br.com.midia.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record MidiaAlterarDTO(
        @NotNull
        Long id,
        String titulo,
        String estilo,
        BigInteger nota) {

}
