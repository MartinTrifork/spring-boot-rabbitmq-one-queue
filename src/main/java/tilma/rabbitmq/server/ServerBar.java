package tilma.rabbitmq.server;

/**
 *  Bar server side
 */
@SuppressWarnings("unused") // JSON
public class ServerBar {

    private String name;

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
