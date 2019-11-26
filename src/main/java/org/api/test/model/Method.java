
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
"name",
"operation",
"pathParm",
"status",
"validate",
"url",
"pathparams",
"body"
})
public class Method {

@JsonProperty("name")
private String name;
@JsonProperty("operation")
private String operation;
@JsonProperty("pathParm")
private Boolean pathParm;
@JsonProperty("status")
private Integer status;
@JsonProperty("validate")
private List<Validate> validate = null;
@JsonProperty("url")
private String url;
@JsonProperty("pathparams")
private List<Pathparam> pathparams = null;
@JsonProperty("body")
private Body body;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("operation")
public String getOperation() {
return operation;
}

@JsonProperty("operation")
public void setOperation(String operation) {
this.operation = operation;
}

@JsonProperty("pathParm")
public Boolean getPathParm() {
return pathParm;
}

@JsonProperty("pathParm")
public void setPathParm(Boolean pathParm) {
this.pathParm = pathParm;
}

@JsonProperty("status")
public Integer getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(Integer status) {
this.status = status;
}

@JsonProperty("validate")
public List<Validate> getValidate() {
return validate;
}

@JsonProperty("validate")
public void setValidate(List<Validate> validate) {
this.validate = validate;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("pathparams")
public List<Pathparam> getPathparams() {
return pathparams;
}

@JsonProperty("pathparams")
public void setPathparams(List<Pathparam> pathparams) {
this.pathparams = pathparams;
}

@JsonProperty("body")
public Body getBody() {
return body;
}

@JsonProperty("body")
public void setBody(Body body) {
this.body = body;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("name", name).append("operation", operation).append("pathParm", pathParm).append("status", status).append("validate", validate).append("url", url).append("pathparams", pathparams).append("body", body).append("additionalProperties", additionalProperties).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(pathParm).append(pathparams).append(name).append(additionalProperties).append(body).append(operation).append(url).append(status).append(validate).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Method) == false) {
return false;
}
Method rhs = ((Method) other);
return new EqualsBuilder().append(pathParm, rhs.pathParm).append(pathparams, rhs.pathparams).append(name, rhs.name).append(additionalProperties, rhs.additionalProperties).append(body, rhs.body).append(operation, rhs.operation).append(url, rhs.url).append(status, rhs.status).append(validate, rhs.validate).isEquals();
}

}