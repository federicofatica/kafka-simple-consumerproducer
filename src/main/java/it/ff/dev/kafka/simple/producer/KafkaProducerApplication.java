package it.ff.dev.kafka.simple.producer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner{
	
	
	private static Logger logger = LoggerFactory.getLogger(KafkaProducerApplication.class);

	@Value("${kp.app.id}")
	private String appId;
	
	@Value("${kp.app.topic}")
	private String topic;
	
	@Value("${kp.app.interval}")
	private int interval;
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Starting producer with id [{}]", appId);
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new KafkaSimpleProducer(kafkaTemplate,appId, topic), 0, interval, TimeUnit.SECONDS);
		
		logger.info("Stopping producer with id [{}]", appId);
	}
	
	
	

}
