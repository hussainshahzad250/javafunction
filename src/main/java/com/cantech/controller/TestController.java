/**
 * 
 */
package com.cantech.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cantech.model.Student;
import com.cantech.util.TemplateUtil;

/**
 * @author shahzad
 *
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getData() throws Exception {
		Student person = new Student("Shahzad","Hussain","shahzad@canbrand.in","7828588330");
		Map<String, String> map = TemplateUtil.toMap(person);
		String outputFile = "student.pdf";
		String templateName = "person";
		TemplateUtil.createPdf(templateName, map,outputFile);
		return new ResponseEntity<Object>("Success", HttpStatus.OK);
	}

}
