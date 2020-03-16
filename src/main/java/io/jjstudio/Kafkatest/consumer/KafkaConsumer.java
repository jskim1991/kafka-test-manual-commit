package io.jjstudio.Kafkatest.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@EnableBinding(SinkBinding.class)
public class KafkaConsumer {

    @StreamListener(value = SinkBinding.INPUT)
    public void listen(Message<String> message) throws InterruptedException {
        System.out.println("log this message");
        Thread.sleep(6000l);
        // TODO : let us assume I was debugging with a breakpoint for this long.
        // This sleep will result in CommitFailedException

        sendAck(message);
    }

    public void sendAck(Message<String> message) {
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            try {
                acknowledgment.acknowledge();
                System.out.println("manual commit complete");
                // put in cache to store my last processed record
            }
            catch (Exception e) {
                throw e; // retry
            }
        }
    }
}
