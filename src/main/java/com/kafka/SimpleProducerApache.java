package com.kafka;

//import util.properties packages
import java.util.Properties;

//import simple producer packages
import org.apache.kafka.clients.producer.Producer;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;

//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

//Create java class named "SimpleProducer"
public class SimpleProducerApache {
    public static String topicName = "test";
    public static void main(String[] args) throws Exception{
        // Check arguments length value
        // TODO Auto-generated method stub
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                StringSerializer.class.getName());
        props.put("value.serializer",
                StringSerializer.class.getName());

        Producer<String, String> producer = new KafkaProducer(props);
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                    topicName, Integer.toString(i), "Bosh");
            System.out.println(producerRecord);
            producer.send(producerRecord);
        }

        producer.close();
    }

}
