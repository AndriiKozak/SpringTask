package com.mycompany.springtask;

import java.util.Objects;
import java.util.UUID;

public class MyEntity {

    private UUID id;
    private String key;
    private Integer value;

    public MyEntity() {
    }

    public MyEntity(UUID id, String key, Integer value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyEntity{" + "id=" + id + ", key=" + key + ", value=" + value + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.key);
        hash = 17 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

}
