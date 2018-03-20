package tilma.rabbitmq.client;

import java.io.Serializable;

/**
 *
 */
public class ClientBar implements Serializable {

    private String name;

    public ClientBar() {
    }

    public ClientBar(String name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
