package tilma.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tilma.rabbitmq.client.Producer;
import tilma.rabbitmq.server.ServerBar;
import tilma.rabbitmq.server.ServerFoo;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RabbitmqApplication {

    public static final String THE_EXCHANGE = "the-exchange";

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue("the-queue");
    }

    @Bean
    Exchange exchange() {
        return ExchangeBuilder.fanoutExchange(THE_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    Binding bindingFoo(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("*").noargs();
    }

    @Bean
    CommandLineRunner demo(Producer producer) {
        return args -> {
            producer.sendBar();
            producer.sendFoo();
            producer.sendBar();
            producer.sendFoo();
        };
    }


    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter();
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("tilma.rabbitmq.client.ClientFoo", ServerFoo.class);
        idClassMapping.put("tilma.rabbitmq.client.ClientBar", ServerBar.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }



}
