
package org.api.test.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Body {

     private Map<String, Object> properties = new HashMap<>();

   
    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    @JsonAnySetter
    public void setProperty(String name, Object value) {
        this.properties.put(name, value);
    }

    public Body withProperty(String name, Object value) {
        this.properties.put(name, value);
        return this;
    }


	@Override
	public String toString() {
		return "Body [properties=" + properties + "]";
	}

   

}
