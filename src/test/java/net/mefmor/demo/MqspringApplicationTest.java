package net.mefmor.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class MqspringApplicationTest {
    private static final String DESTINATION_NAME = "DEV.QUEUE.1";

    @Autowired
    private JmsTemplate jmsTemplate;

    @BeforeEach
    void setReceiveTimeout() {
        this.jmsTemplate.setReceiveTimeout(1_000);
    }

    @Test
    void byDefaultQueueIsEmpty() {
        assertThat(jmsTemplate.receive(DESTINATION_NAME), nullValue());
    }

    @Test
    void ifWePutMessageInQueueWeCanGetIt() {
        jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello, world!");

        assertThat(jmsTemplate.receiveAndConvert("DEV.QUEUE.1"), equalTo("Hello, world!"));
    }
}