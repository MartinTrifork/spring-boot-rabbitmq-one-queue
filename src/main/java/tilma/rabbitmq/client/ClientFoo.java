package tilma.rabbitmq.client;

import java.io.Serializable;

/**
 *
 */
public class ClientFoo implements Serializable {

    private String name;

    public ClientFoo() {
    }

    public ClientFoo(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
