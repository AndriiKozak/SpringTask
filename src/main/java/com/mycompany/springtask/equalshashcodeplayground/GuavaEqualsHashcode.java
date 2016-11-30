package com.mycompany.springtask.equalshashcodeplayground;

import com.google.common.base.Objects;

public class GuavaEqualsHashcode {
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
        return Objects.hashCode(key, value);
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
        final GuavaEqualsHashcode other = (GuavaEqualsHashcode) obj;
        if (!Objects.equal(this.key, other.key)) {
            return false;
        }
        return Objects.equal(this.value, other.value);
    }
    
    
}
