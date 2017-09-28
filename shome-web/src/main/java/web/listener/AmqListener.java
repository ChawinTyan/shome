package web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class AmqListener implements MessageListener {

    @Value("mq.queue.history")
    private String MQ_QUEUE_HISTORY;

    @Autowired
    private JmsTemplate jmsTemplate;

    private Logger LOG = LoggerFactory.getLogger(AmqListener.class);

    public void onMessage(Message message) {
        try {
            final String content = ((TextMessage) message).getText();
            LOG.info("【MQ监听到信息.{}】", content);
            jmsTemplate.send(MQ_QUEUE_HISTORY, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(content);
                }
            });
        } catch (JMSException e) {
            LOG.info("【MQ处理信息异常】", e);
        }
    }
}
