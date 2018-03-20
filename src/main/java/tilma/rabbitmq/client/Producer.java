package tilma.rabbitmq.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static tilma.rabbitmq.RabbitmqApplication.THE_EXCHANGE;

/**
 * producer of messages
 */
@RestController
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping("sendBar")
    public String sendBar() {
        rabbitTemplate.convertAndSend(THE_EXCHANGE, "*", new ClientBar("name"));
        LOGGER.info("send Bar");
        return "ok";
    }

    @RequestMapping("sendFoo")
    public String sendFoo() {
        rabbitTemplate.convertAndSend(THE_EXCHANGE, "*", new ClientFoo("name"));
        LOGGER.info("send Foo");
        return "ok";
    }
}
