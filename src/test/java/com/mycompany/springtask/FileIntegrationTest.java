package com.mycompany.springtask;

import com.mycompany.springtask.file.FileController;
import com.mycompany.springtask.file.MalformedCsvException;
import java.util.Optional;
import java.util.Random;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class FileIntegrationTest {

    @Autowired
    private FileController controller;
    @Autowired
    private MyRepository repository;
    Model model;
    private String content;
    private final String key = "Test entity";
    private Integer value;
    private Optional<MyEntity> addedEntity = Optional.empty();

    @Before
    public void setUp() {
        model = new ExtendedModelMap();
        value = (new Random()).nextInt();
        content = key + "," + value;
    }

    @Test
    public void uploadFileTest() throws Exception {
        assertFalse(repository.findAll().stream().anyMatch((e) -> key.equals(e.getKey()) && value.equals(e.getValue())));
        MultipartFile file = new MockMultipartFile("test.csv", content.getBytes());
        controller.upploadFile(file, model);
        assertTrue(repository.findAll().stream().anyMatch((e) -> {
            if (key.equals(e.getKey()) && value.equals(e.getValue())) {
                addedEntity = Optional.of(e);
                return true;
            } else {
                return false;
            }
        }));
    }

    @Test(expected = MalformedCsvException.class)
    public void uploadFileThrowMalformedCSVException() throws Exception {
        content = key + ";" + value;
        MultipartFile file = new MockMultipartFile("malformedTest.csv", content.getBytes());
        controller.upploadFile(file, model);
    }
    
    @After
    public void tearDown(){
        addedEntity.ifPresent((e)->repository.delete(e));
    }
}
