package com.mycompany.springtask;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public interface MyRepository {

    boolean delete(MyEntity entity);

    List<MyEntity> findAll();

    MyEntity findByStringId(String uuidString);

    MyEntity save(MyEntity entity);

    @Autowired
    void setDataSource(DataSource dataSource);

}
