package br.com.midia.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
/*    @Bean
    public Queue criarFila(){
        System.out.println("01 RabbitMQConfiguration -> criarFila");
        return QueueBuilder.nonDurable("midia.teste" ).build();
    }*/

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory conn){
        System.out.println("01 RabbitMQConfiguration -> criarRabbitAdmin");
        return new RabbitAdmin(conn);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializar(RabbitAdmin rabbitAdmin){
        System.out.println("02 RabbitMQConfiguration -> inicializar");
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        FanoutExchange fanoutExchange = new FanoutExchange("exchange.midia");
        System.out.println("03 RabbitMQConfiguration -> criar FanoutExchange : " + fanoutExchange.getName());
       // return new FanoutExchange("teste.ex");
        return fanoutExchange;
    }

/*    @Bean
    public FanoutExchange fanoutExchangeBuild(){
        return ExchangeBuilder.fanoutExchange("teste.ex").;
    }*/

    @Bean
    public Queue criarFila() {
        System.out.println("04 RabbitMQConfiguration -> criarFila 01");
        return QueueBuilder.nonDurable("midia.01").build();
    }
    @Bean
    public Queue criarFila2() {
        System.out.println("05 RabbitMQConfiguration -> criarFila 02");
        return QueueBuilder.nonDurable("midia.02").build();
    }



    @Bean
    public Binding bindMidias(FanoutExchange fanoutExchange){
        System.out.println("06 RabbitMQConfiguration -> atribui a criarFila 01");
        return BindingBuilder.bind(criarFila()).to(fanoutExchange);
    }

    @Bean
    public Binding bindMidias2(FanoutExchange fanoutExchange){
        System.out.println("07 RabbitMQConfiguration -> atribui a criarFila 02");
        return BindingBuilder.bind(criarFila2()).to(fanoutExchange);
    }



}
