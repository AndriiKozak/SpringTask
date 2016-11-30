package com.mycompany.springtask.equalshashcodeplayground;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EqualsHashcodeBuilder {
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
        return new HashCodeBuilder()
        .append(key)
        .append(value)
        .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }    
        if(EqualsHashcodeBuilder.class.equals(obj.getClass())){
        final EqualsHashcodeBuilder other = (EqualsHashcodeBuilder) obj;
        return new EqualsBuilder()
            .append(key, other.key)
            .append(value, other.value)            
            .isEquals();
        } else{
            return false;
        }
    }
    
    
}
