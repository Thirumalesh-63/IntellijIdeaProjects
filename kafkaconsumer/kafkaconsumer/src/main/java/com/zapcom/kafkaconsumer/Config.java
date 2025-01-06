package com.zapcom.kafkaconsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG;
import static org.apache.kafka.common.config.SaslConfigs.SASL_JAAS_CONFIG;

public class Config {

    public Map<String, Object> bulkEntitlementstKafkaConsumerConfig() {

        Map<String, Object> props = new HashMap<>(alertKafkaBasicConfigMap);

        props.put(SASL_JAAS_CONFIG, this.jaasConfig);

        props.put(ENABLE_AUTO_COMMIT_CONFIG, this.enableAutoCommit);

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,

                StringDeser

                props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDes

        return props;

    }

    @Bean
    public ConsumerFactory<String, String> bulkEntitlementsConsumerFactory()
    {
return new DefaultKafkaConsumerFactory<>(bulkEntitlementstKafkaConsumerConfig());
}


@Bean
public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> bulkEntitlementsKafkaListenerContainerFactory() {

    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

    factory.setConsumerFactory(bulkEntitlementsConsumerFactory());

    factory.getContainerProperties().setAckMode(ContainerProperties. AckMode.RECORD);

    return factory;


}
}
