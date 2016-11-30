package com.mycompany.springtask.file;

import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.log4j.Logger;

public class FakeBloater implements MessageListener {
    protected Logger logger = Logger.getLogger(FakeBloater.class);
    @Override
    public void onMessage(Message m) {
        logger.info(m);
    }
}
