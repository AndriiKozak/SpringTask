package com.mycompany.springtask.file;

import org.springframework.web.multipart.MultipartFile;

public interface MyMessageSender {

    void sendMessage(final MultipartFile file);

}
