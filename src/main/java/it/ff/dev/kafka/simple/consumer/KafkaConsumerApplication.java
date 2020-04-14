package it.ff.dev.kafka.simple.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerApplication implements CommandLineRunner{
	
	
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			
		}
		
	}
	
	@KafkaListener(topics = "#{'${kc.app.topics}'.split(',')}")
	public void listen(ConsumerRecord<?, ?> cr) {
		logger.info("Consumed record [{}]", cr);
	}
	

}
