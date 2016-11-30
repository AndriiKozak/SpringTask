package com.mycompany.springtask.equalshashcodeplayground;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class LombokEqualsHashcode {
    private String key;
    private Integer value;

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
}
