package com.mycompany.springtask.file;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class FakeBloater implements MessageListener {

    public void onMessage(Message m) {
        BytesMessage message = (BytesMessage) m;
        System.out.println("got message");
    }
}
