package tilma.rabbitmq.client;

import java.io.Serializable;

/**
 *  Bar client side
 */
@SuppressWarnings("unused") // JSON
public class ClientBar implements Serializable {

    private String name;

    public ClientBar() {
    }

    ClientBar(String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
