package org.api.test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.api.test.model.Specification;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VelocityWriter2 {
	static String modelName = "User";
    static String packageName = "com.companyname.projectname";
 
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
        
    	Specification specsObj = objectMapper
    			.readValue(new File("src/main/resources/vtemplates/Info.json"), Specification.class);
    	
    	System.out.println(specsObj);
    	
    	 VelocityEngine velocityEngine = new VelocityEngine();
         velocityEngine.init();
       
         Template t = velocityEngine.getTemplate("/src/main/resources/vtemplates/SampleTest.vm");
        
         VelocityContext context = new VelocityContext();
   
         if(packageName != null) {
             context.put("packagename", packageName);
         
         }
         context.put("className", "APITest");
         
         context.put("specs", specsObj);
         
         StringWriter writer = new StringWriter();
         t.merge( context, writer );
   
         System.out.println(writer.toString());
         
    	
    	
        
    }

}
