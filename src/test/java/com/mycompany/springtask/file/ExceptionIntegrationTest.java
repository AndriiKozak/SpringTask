package com.mycompany.springtask.file;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class ExceptionIntegrationTest {
    @Autowired
    private ExceptionControllerAdvice advice;
    @Autowired
    private FakeBloater receiver;
    
    private Logger logger;    
    private FileService service;
    private MultipartFile file;
    
    @Before 
    public void setUp() throws Exception{
       logger = mock(Logger.class);
       service = mock(FileService.class);
       file = mock(MultipartFile.class);
       when(file.getBytes()).thenReturn(new byte[0]);
       
       receiver.logger = logger;
       advice.fileService = service;
    }
    @Test
    public void malformedCsvTest() throws Exception{
        MalformedCsvException exception = new MalformedCsvException();  
        exception.setFlie(file);
        advice.malformedCsv(exception);
        Thread.sleep(10000);
       // verify(logger).info(any());
        verify(service).saveCopy(any(), any());        
    }
}
