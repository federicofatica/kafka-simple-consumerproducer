# KAFKA SIMPLE

## Code

### Producer
The procucer with id ${kp.app.id} sends event to topic ${kp.app.topic} every ${kp.app.interval} seconds

The main class is `it.ff.dev.kafka.simple.producer.KafkaProducerApplication` 

The required properties are:

``` 
spring.kafka.bootstrap-servers=192.168.1.211:9072,192.168.1.211:9073,192.168.1.211:9074
kp.app.id=KP1
kp.app.topic=K3T01_P6_R3
kp.app.interval=10
```

### Consumer

The consumer part of the group ${kp.app.id} receive events from the topics ${kc.app.topics} (a comma separated list)

The main class is: `it.ff.dev.kafka.simple.consumer.KafkaConsumerApplication` 

The required properties are:

```
spring.kafka.bootstrap-servers=192.168.1.211:9082,192.168.1.211:9083,192.168.1.211:9084
spring.kafka.consumer.group-id=K02_T02_GID01
spring.kafka.consumer.auto-offset-reset=earliest
kc.app.topics=K2T01,K2T02
```


## Docker

Build simple image with docker build. 

```
$ docker build -t ff/kafkasimpleconsumerprocducer  .
```

Run docker container by specifying application.properties and main class, one between `it.ff.dev.kafka.simple.consumer.KafkaConsumerApplication` for the Consumer sample and `it.ff.dev.kafka.simple.producer.KafkaProducerApplication` for the Producer Sample

```
$ docker run  -v $(pwd)/myapplication.properties:/app/application.properties -e KSMAIN=... ff/kafkasimpleconsumerprocducer
```