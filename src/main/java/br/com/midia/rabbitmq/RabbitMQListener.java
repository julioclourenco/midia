package br.com.midia.rabbitmq;

import br.com.midia.entity.Midia;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "midia.01")
    public void receberMensagem(Midia msg){
        System.out.println("Recebi a mensagem midia.01 !!!!!! -> " + msg.getTitulo());
        //System.out.println("Recebi a mensagem midia.01 !!!!!! ID -> " + msg.getId());
        //System.out.println("Recebi a mensagem midia.01 !!!!!! Plataforma -> " + msg.getPlataforma());
        if(msg.getId() == 1){
            throw new RuntimeException("Deu ruim!!!");
        }
    }

    @RabbitListener(queues = "midia.02")
    public void receberMensagem2(Midia msg){
        System.out.println("Recebi a mensagem midia.02 !!!!!! -> " + msg.getTitulo());
        //System.out.println("Recebi a mensagem midia.02 !!!!!! ID -> " + msg.getId());
        //System.out.println("Recebi a mensagem midia.02 !!!!!! Plataforma -> " + msg.getPlataforma());
    }

    /**
     * Criado por fora
     * Criei no sistma o listen
     * Criei a fila direto no RabbitMq
     * @param msg
     */
    //@RabbitListener(queues = "midia.teste")
    public void receberMensagem3(Midia msg){
        System.out.println("Recebi a mensagem midia.teste !!!!!! -> " + msg.getTitulo().concat(" / ").concat(String.valueOf(msg.getId())).concat(" / ").concat(msg.getPlataforma().toString()) );
    }

}
