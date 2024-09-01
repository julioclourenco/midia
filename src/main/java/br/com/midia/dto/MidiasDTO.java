package br.com.midia.dto;

import br.com.midia.entity.Midia;
import br.com.midia.enums.Plataforma;
import br.com.midia.enums.Tipo;

import java.math.BigInteger;

public record MidiasDTO(Long id, Plataforma plataforma, String titulo, BigInteger nota, String estilo, Tipo tipo) {
    public MidiasDTO(Midia midia){
        this(midia.getId(), midia.getPlataforma(), midia.getTitulo(), midia.getNota(), midia.getEstilo(), midia.getTipo());
    }
}
