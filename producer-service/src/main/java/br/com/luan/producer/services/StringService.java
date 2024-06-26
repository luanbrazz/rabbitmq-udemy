package br.com.luan.producer.services;

import br.com.luan.producer.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, message);
    }
}
