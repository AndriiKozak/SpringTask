
package com.mycompany.springtask;

import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class CrudIntegrationTest {
    private MyEntity createdEntity;
    private MyEntity readEntity;
    private MyEntity editEntity;
    private MyEntity deleteEntity;
    @Autowired
    private MyController controller;
    @Autowired 
    private MyRepository repository;
     
    @Before
    public void setUp(){
       createdEntity = new MyEntity(); 
       createdEntity.setKey("CreatedEntity");
       createdEntity.setValue(42);
       readEntity = new MyEntity();
       readEntity.setKey("readEntity");
       readEntity.setValue(13);
       repository.save(readEntity);
       editEntity = new MyEntity();
       editEntity.setKey("Not editet yet");
       editEntity.setValue(0);
       repository.save(editEntity);
       deleteEntity = new MyEntity();
       deleteEntity.setKey("entity to delete");
       deleteEntity.setValue(-1);
       repository.save(deleteEntity);       
    }
    @Test
    public void createTest(){
        controller.edit(createdEntity);
        MyEntity expected = repository.findByStringId(createdEntity.getId().toString());
        assertEquals(createdEntity, expected);
    }
    
    @Test
    public void readTest(){
       Model model = new ExtendedModelMap(); 
       controller.list(model);
       assertTrue(((List<MyEntity>) model.asMap().get("entities")).contains(readEntity));
    }
    
    @Test
    public void updateTest(){
       editEntity.setKey("already edited");
       editEntity.setValue(1);
       controller.edit(editEntity);
       MyEntity expected = repository.findByStringId(editEntity.getId().toString());
       assertEquals(editEntity, expected);
    }
    
    @Test
    public void deleteTest(){
        assertNotNull(repository.findByStringId(deleteEntity.getId().toString()));
        controller.delete(deleteEntity);
        assertFalse(repository.findAll().contains(deleteEntity));
    }
    
    
    @After
    public void tearDown(){
        if (createdEntity.getId()!=null) repository.delete(createdEntity);
        repository.delete(readEntity);
        repository.delete(editEntity);
        repository.delete(deleteEntity);
    }
}
