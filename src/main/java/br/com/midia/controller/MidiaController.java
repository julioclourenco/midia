package br.com.midia.controller;

import br.com.midia.dto.MidiaAlterarDTO;
import br.com.midia.dto.MidiaDTO;
import br.com.midia.dto.MidiasDTO;
import br.com.midia.entity.Midia;
import br.com.midia.repository.MidiaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/midia")
public class MidiaController {

    @Autowired
    private MidiaRepository repository;
    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid MidiaDTO midia){
        Midia entity = new Midia(midia);
        entity.setRegistro(new Date());
        repository.save(entity);
        return "create sucess";
    }

    @GetMapping
    public Page<MidiasDTO> listar(@PageableDefault(size = 3, sort = {"titulo"}) Pageable page){
        return repository.findAll(page).map(MidiasDTO::new);
    }

    @PutMapping
    @Transactional
    public String alterar(@RequestBody @Valid MidiaAlterarDTO dto){
        var midia = repository.getReferenceById(dto.id());
        midia.atualizarDados(dto);
        return "update success";
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        repository.deleteById(id);
        return "delete success";
    }
}
