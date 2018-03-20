package tilma.rabbitmq.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@RabbitListener(queues = "the-queue")
public class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);


    @RabbitHandler
    public void bar(ServerBar clientBar) {
        LOGGER.info("Bar: {}", clientBar.getName());
    }

    @RabbitHandler
    public void foo(ServerFoo clientFoo) {
        LOGGER.info("Foo: {}", clientFoo.getName());
    }


}
