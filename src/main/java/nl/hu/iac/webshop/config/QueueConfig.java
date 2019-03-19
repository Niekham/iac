package nl.hu.iac.webshop.config;

import nl.hu.iac.webshop.QueueConsumers.BankConsumer;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Exchange eventExchange() {
        return new TopicExchange("bankConfirmation");
    }

    @Bean
    public Queue queue() {
        return new Queue("acknowledgeToBank");
    }

    @Bean
    public Binding binding(Queue queue, Exchange eventExchange) {
        return BindingBuilder
                .bind(queue)
                .to(eventExchange)
                .with("bank.request")
                .noargs();
    }

    @Bean
    public BankConsumer eventReceiver() {
        return new BankConsumer();
    }
}
