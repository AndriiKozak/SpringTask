package com.mycompany.springtask.equalshashcodeplayground;

import java.util.Objects;

public class JDK7EqualsHashcode {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.key);
        hash = 11 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JDK7EqualsHashcode other = (JDK7EqualsHashcode) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return Objects.equals(this.value, other.value);
    }
    
    
}
