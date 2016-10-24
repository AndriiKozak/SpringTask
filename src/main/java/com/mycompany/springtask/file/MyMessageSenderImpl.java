package com.mycompany.springtask.file;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("messageSender")
public class MyMessageSenderImpl implements MyMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(final MultipartFile file) {
        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                BytesMessage msg = session.createBytesMessage();
                try {
                    msg.writeBytes(file.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(MyMessageSender.class.getName()).log(Level.SEVERE, null, ex);
                }
                return msg;
            }
        });
    }
}
