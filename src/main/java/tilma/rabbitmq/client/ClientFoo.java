package tilma.rabbitmq.client;

import java.io.Serializable;

/**
 * Foo client side
 */
@SuppressWarnings("unused") // JSON
public class ClientFoo implements Serializable {

    private String name;

    public ClientFoo() {
    }

    ClientFoo(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
