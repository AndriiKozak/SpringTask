package com.mycompany.springtask.file;

import javax.jms.Message;
import javax.jms.MessageListener;

public class FakeBloater implements MessageListener {

    @Override
    public void onMessage(Message m) {
        System.out.println("got message");
    }
}
