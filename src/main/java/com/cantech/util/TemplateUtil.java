/**
 * 
 */
package com.cantech.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Image;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shahzad
 *
 */
@Slf4j
public class TemplateUtil {

	@SuppressWarnings("unchecked")
	public static <T> Map<String, String> toMap(T object) {
		if (object != null) {
			ObjectMapper oMapper = new ObjectMapper();
			Map<String, String> map = oMapper.convertValue(object, Map.class);
			return map;
		}
		return null;
	}

	public static void createPdf(String templateName, Map<String, String> map, String outputFileName) {
		try {
			ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
			templateResolver.setPrefix("templates/");
			templateResolver.setTemplateMode("HTML5");
			templateResolver.setSuffix(".html");
			templateResolver.setTemplateMode("XHTML");
			templateResolver.setCharacterEncoding("UTF-8");
			templateResolver.setOrder(1);

			TemplateEngine templateEngine = new TemplateEngine();
			templateEngine.setTemplateResolver(templateResolver);

			Context context = new Context();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				log.info("\nKey = " + entry.getKey() + ", \nValue = " + entry.getValue());
				context.setVariable(entry.getKey(), entry.getValue());
			}
			// Get the plain HTML with the resolved ${name} variable!
			String html = templateEngine.process(templateName, context);
			OutputStream outputStream = new FileOutputStream(outputFileName);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(outputStream);
			outputStream.close();
			log.info("\nPdf Createf Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static InputStream getInputStream(Image image) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(image);
			oos.flush();
			oos.close();
			return new ByteArrayInputStream(baos.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
