package tilma.rabbitmq.client;

import java.io.Serializable;

/**
 *  Bar client side
 */
@SuppressWarnings({"unused", "FieldCanBeLocal"}) // JSON
public class ClientBar implements Serializable {

    private String name;

    private String extra = "a";  // will be ignored

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

    public String getExtra() {
        return extra;
    }
}
