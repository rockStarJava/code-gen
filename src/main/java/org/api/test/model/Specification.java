
package org.api.test.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "methods"
})
public class Specification {

    @JsonProperty("url")
    private String url;
    @JsonProperty("methods")
    private List<Method> methods = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Specification() {
    }

    /**
     * 
     * @param methods
     * @param url
     */
    public Specification(String url, List<Method> methods) {
        super();
        this.url = url;
        this.methods = methods;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Specification withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("methods")
    public List<Method> getMethods() {
        return methods;
    }

    @JsonProperty("methods")
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public Specification withMethods(List<Method> methods) {
        this.methods = methods;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Specification withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("url", url).append("methods", methods).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(url).append(methods).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Specification) == false) {
            return false;
        }
        Specification rhs = ((Specification) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(url, rhs.url).append(methods, rhs.methods).isEquals();
    }

}
