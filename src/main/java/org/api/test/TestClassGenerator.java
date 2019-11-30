package org.api.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.api.test.model.Specification;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

public class TestClassGenerator {
	static String modelName = "User";
	private static final String PATH_DELIMITER = "/";
	private static final String PACKAGE_SEPERATOR = ".";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		Specification specsObj = objectMapper.readValue(new File("src/main/resources/vtemplates/Info.json"),
				Specification.class);

		System.out.println("here is the specs object " + specsObj);

		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();

		/**
		 * load template
		 */
		Template t = velocityEngine.getTemplate("/src/main/resources/vtemplates/SampleTest.vm");

		VelocityContext context = new VelocityContext();

		if (specsObj.getPackageName() != null) {
			context.put("packagename", specsObj.getPackageName());

		}

		context.put("className", specsObj.getName());

		context.put("specs", specsObj);

		String fileName = "src/test/java/" + specsObj.getPackageName().replace(PACKAGE_SEPERATOR, PATH_DELIMITER)
				+ PATH_DELIMITER + specsObj.getName() + ".java";

		final File file = new File(fileName);

		final File parentDirectory = file.getParentFile();

		if (null != parentDirectory) {
			parentDirectory.mkdirs();
		}

		/**
		 * generate the class file.
		 */

		StringWriter sw = new StringWriter();
		t.merge(context, sw);
		String formattedContent = sw.toString();
		/** format the file **/
		try {
			formattedContent = new Formatter().formatSource(sw.toString());
		} catch (FormatterException e) {
			System.err.println("Some error happened while formatting" + e.getMessage());
		}

		Writer writer = new FileWriter(file);

		writer.write(formattedContent);
		writer.flush();
		writer.close();
		System.out.println("generated class at path :" + parentDirectory);

	}
}
