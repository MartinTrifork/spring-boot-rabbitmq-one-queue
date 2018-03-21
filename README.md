# Send multiple message over one exchange and queue

This is a spring boot project showing how to send mulitple message over one exchange and queue and use the spring 
annotations / configuration to handle them.

One todo item:
- how to handle unconfigured messages?

## Run RabbitMQ
```Shell
docker run -d -p 5671:5671 -p 15672:15672 --name some-rabbit rabbitmq:3-management
```
