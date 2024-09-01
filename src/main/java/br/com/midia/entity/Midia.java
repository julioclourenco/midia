package br.com.midia.entity;

import br.com.midia.dto.MidiaAlterarDTO;
import br.com.midia.dto.MidiaDTO;
import br.com.midia.enums.Origem;
import br.com.midia.enums.Plataforma;
import br.com.midia.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;

@Table(name= "midia")
@Entity(name= "midia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Midia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Plataforma plataforma;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Origem origem;
    private String titulo;
    private String estilo;
    private BigInteger nota;
    private Date registro;
    public Midia(MidiaDTO dto){
        this.plataforma = dto.plataforma();
        this.tipo = dto.tipo();
        this.origem = dto.origem();
        this.titulo = dto.titulo().toUpperCase();
        this.estilo = dto.estilo().toUpperCase();
        this.nota = dto.nota();
        this.registro = dto.registro();
    }

    public void atualizarDados(MidiaAlterarDTO dto) {
        if(dto != null && dto.titulo() != null) {
            this.titulo =  dto.titulo();
        }
        if(dto != null && dto.estilo() != null) {
            this.estilo = dto.estilo() ;
        }
        if(dto != null && dto.nota() != null){
            this.nota   = dto.nota();
        }
    }
}
