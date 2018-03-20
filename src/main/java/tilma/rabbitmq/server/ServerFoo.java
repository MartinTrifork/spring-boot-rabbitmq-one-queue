package tilma.rabbitmq.server;

/**
 *  Foo server side
 */
@SuppressWarnings("unused") // JSON
public class ServerFoo {

    private String name;

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
