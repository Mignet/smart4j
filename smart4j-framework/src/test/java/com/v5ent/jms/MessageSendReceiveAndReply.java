package com.v5ent.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
/**
 * 首先创建两个Queue，发送者给一个Queue发送，接收者接收到消息之后给另一个Queue回复一个Message，然后再创建一个消费者来接受所回复的消息。
 * 示例:首先消息生产者发送一个消息，内容为"Mignet"
 * 然后消费者收到这个消息之后根据消息的JMSReplyTo，回复一个消息，内容为"Hello Mignet"
 * 最后在回复的Queue上创建一个接收回复消息的消费者，它输出所回复的内容。
 * @author Mignet
 *
 */
public class MessageSendReceiveAndReply {
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
   
        Connection connection = factory.createConnection();
        connection.start();
       
        //消息发送到这个Queue
        Queue queue = new ActiveMQQueue("testQueue");
        //消息回复到这个Queue
        Queue replyQueue = new ActiveMQQueue("replyQueue");
       
        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个消息，并设置它的JMSReplyTo为replyQueue。
        Message message = session.createTextMessage("Mignet");
        message.setJMSReplyTo(replyQueue);
       
        MessageProducer producer = session.createProducer(queue);
        producer.send(message);
           
        //消息的接收者
        MessageConsumer comsumer = session.createConsumer(queue);
        comsumer.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    //创建一个新的MessageProducer来发送一个回复消息。
                    MessageProducer producer = session.createProducer(m.getJMSReplyTo());
                    producer.send(session.createTextMessage("Hello," + ((TextMessage) m).getText()));
                } catch (JMSException e1) {
                    e1.printStackTrace();
                }
            }
           
        });
       
        //这个接收者用来接收回复的消息
        MessageConsumer comsumer2 = session.createConsumer(replyQueue);
        comsumer2.setMessageListener(new MessageListener(){
            public void onMessage(Message m) {
                try {
                    System.out.println("recevied:"+((TextMessage) m).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
