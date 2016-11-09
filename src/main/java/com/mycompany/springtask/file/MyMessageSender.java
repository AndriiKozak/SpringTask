package com.mycompany.springtask.file;

import org.springframework.web.multipart.MultipartFile;
@FunctionalInterface
public interface MyMessageSender {

    void sendMessage(final MultipartFile file);

}
