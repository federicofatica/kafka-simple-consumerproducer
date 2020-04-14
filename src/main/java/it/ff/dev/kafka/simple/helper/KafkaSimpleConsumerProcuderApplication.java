package it.ff.dev.kafka.simple.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.ff.dev.kafka.simple.consumer.KafkaConsumerApplication;
import it.ff.dev.kafka.simple.producer.KafkaProducerApplication;

@SpringBootApplication
public class KafkaSimpleConsumerProcuderApplication implements CommandLineRunner{
	
	
	private static Logger logger = LoggerFactory.getLogger(KafkaSimpleConsumerProcuderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaSimpleConsumerProcuderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Test KafkaSimple by using {} for the Consumer sample or {} for the Producer Sample", KafkaConsumerApplication.class, KafkaProducerApplication.class);

		logger.info("--- Producer Configuration ---");
		
		logger.info("spring.kafka.bootstrap-servers=192.168.1.211:9072,192.168.1.211:9073,192.168.1.211:9074");
		logger.info("kp.app.id=KP1");
		logger.info("kp.app.topic=K3T01_P6_R3");
		logger.info("kp.app.interval=10");


		logger.info("--- Consumer Configuration ---");			
		logger.info("spring.kafka.bootstrap-servers=192.168.1.211:9082,192.168.1.211:9083,192.168.1.211:9084");
		logger.info("spring.kafka.consumer.group-id=K02_T02_GID01");
		logger.info("spring.kafka.consumer.auto-offset-reset=earliest");
		logger.info("kc.app.topics=K2T01,K2T02");
	}

}
