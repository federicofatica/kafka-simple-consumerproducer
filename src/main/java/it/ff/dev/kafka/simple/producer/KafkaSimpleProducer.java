package it.ff.dev.kafka.simple.producer;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class KafkaSimpleProducer implements Runnable{
	

	private static Logger logger = LoggerFactory.getLogger(KafkaSimpleProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private String topicName;
	private String appId;
	private String runId;
	
	private static int COUNTER = 0;

	public KafkaSimpleProducer(KafkaTemplate<String, String> kafkaTemplate, String appId, String topicName) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topicName = topicName;
		this.appId = appId;
		this.runId = Instant.now().toString();
	}
	
	
	
	private void simpleSendMessage(String message) {
		
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("App [{}], Sent message=[{}] to topic=[{}] with offset=[{}]", appId, message, topicName, result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("App [{}], Unable to send message=[{}] to topic=[{}] due to: [{}]", appId, message, topicName, ex.getMessage());
			}
		});
	}



	@Override
	public void run() {
		simpleSendMessage(appId + "|" + runId + "|" + topicName + "|"+ COUNTER++);
		
	}
	
}
