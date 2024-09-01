package br.com.midia.controller;

import br.com.midia.dto.MidiasDTO;
import br.com.midia.entity.Midia;
import br.com.midia.repository.MidiaRepository;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rabbit")
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MidiaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<String> teste(@PathVariable Long id){
        System.out.println("\n\n\n Cheguei Jota manézão......");

        System.out.println("\n\n\n Enviando msg para RabbitMQ......");

        Optional<Midia> m = repository.findById(id);

 /*       String json = "{\n" +
                "    \"id\":" +m.get().getId()+",\n" +
                "    \"plataforma\":\""+m.get().getPlataforma()+"\",\n" +
                "    \"titulo\":\""+m.get().getTitulo()+"\",\n" +
                "    \"estilo\":\""+m.get().getEstilo()+"\",\n" +
                "    \"nota\":"+m.get().getNota()+",\n" +
                "    \"registro\":\""+m.get().getRegistro()+"\",\n" +
                "    \"tipo\":\""+m.get().getTipo()+"\",\n" +
                "    \"origem\":\""+m.get().getOrigem()+"\"\n" +
                "}\n" +
                "\n";
*/


        //Message message = new Message( ("Criei uma msg no RabbitMQ codigo : " + m.get().getId()).getBytes());

        //Message message = new Message( (json).getBytes());
        //rabbitTemplate.send("midia.teste", message);
        //rabbitTemplate.convertAndSend("teste.ex","", m.get());


        rabbitTemplate.convertAndSend("exchange.midia","", m.get());
        //rabbitTemplate.convertAndSend("exchange.midia.teste","", m.get());

        return ResponseEntity.ok("success !!!!!");
    }

}
