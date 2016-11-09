package com.mycompany.springtask.file;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.apache.log4j.Logger;

@EnableWebMvc
@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
    private static final String ERROR_DESTINATION = "/erorrs/";
    @Autowired
    MyMessageSender messageSender;
    @Autowired
    FileService fileService;

    @ExceptionHandler(MalformedCsvException.class)
    public String malformedCsv(MalformedCsvException e) throws IOException {
        logger.error(e);
        MultipartFile file = e.getFlie();
        fileService.saveCopy(ERROR_DESTINATION, file);
        messageSender.sendMessage(file);
        return "malformedCsv";
    }
}
