package com.mycompany.springtask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepositoryImpl implements MyRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MyEntity> findAll() {
        return jdbcTemplate.query("select Id, Kkey, Value from My_Entity", new EntityMapper());
    }

    @Override
    public MyEntity findByStringId(String uuidString) {
        return jdbcTemplate.queryForObject("select Id, Kkey, Value from My_Entity where id=?", new Object[]{uuidString}, new EntityMapper());
    }

    @Override
    public MyEntity save(MyEntity entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
            jdbcTemplate.update("insert into My_Entity (Id ,Kkey, Value) values (? ,?, ?)", entity.getId().toString(), entity.getKey(), entity.getValue());
        } else {
            jdbcTemplate.update("update My_Entity set Kkey=?, Value=? where id=?", entity.getKey(), entity.getValue(), entity.getId().toString());
        }
        return entity;
    }

    @Override
    public boolean delete(MyEntity entity) {
        return 0 != jdbcTemplate.update("delete from My_Entity where id=?", entity.getId().toString());
    }

    private static class EntityMapper implements RowMapper<MyEntity> {

        @Override
        public MyEntity mapRow(ResultSet rs, int i) throws SQLException {
            return new MyEntity(UUID.fromString(rs.getString("Id")), rs.getString("Kkey"), rs.getInt("Value"));
        }

    }
}
