package com.mycompany.springtask.file;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class ExceptionControllerAdvice {

    static final private String ERROR_DESTINATION = "/erorrs/";
    @Autowired
    MyMessageSender messageSender;
    @Autowired
    FileService fileService;

    @ExceptionHandler(MalformedCsvException.class)
    public String malformedCsv(MalformedCsvException e) throws IOException {
        MultipartFile file = e.getFlie();
        fileService.saveCopy(ERROR_DESTINATION, file);
        messageSender.sendMessage(file);
        return "malformedCsv";
    }
}
