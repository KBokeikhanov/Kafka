import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kz-dmptestkafka01.kar-tel.local:9092");
        props.put("group.id", "group1");
        props.put("enable.auto.commit", "true");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        org.apache.kafka.clients.consumer.KafkaConsumer<String,String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("Smartnps"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}

