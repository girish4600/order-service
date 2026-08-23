package com.gsk.ecom.kafka;


import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    /*@Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;


    *//**
     * This will automatically create new topic in the kafka
    **//*
    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name("order-topic").build();
    }

    @Bean
    public ProducerFactory<String, OrderNotificationRequest> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        //need to add alias(orderConfirmation) here
        config.put(JsonSerializer.TYPE_MAPPINGS, "orderConfirmation:com.gsk.ecom.kafka.model.OrderNotificationRequest");

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, OrderNotificationRequest> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }*/
}
