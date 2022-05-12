import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kz-dmptestkafka01.kar-tel.local:9092");
        props.put("acks", "all");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);

        for (int i=1; i<=100; i++) {
            String key = Integer.toString(i);
            String val = "Message: " + Integer.toString(i);
            producer.send(new ProducerRecord<String, String>("Smartnps", key, val));
        }

        producer.close();

    }
}
