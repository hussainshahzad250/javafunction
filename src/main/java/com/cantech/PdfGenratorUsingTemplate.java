package com.cantech;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cantech.model.PdfRequest;
import com.cantech.model.Student;
import com.cantech.util.TemplateUtil;
import com.lowagie.text.DocumentException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PdfGenratorUsingTemplate {

	public static void main(String[] args) throws DocumentException, IOException {
		// createPdf1();
		// createPdf2();
		createPdf3();
	}

	private static void createPdf3() {
		PdfRequest request = new PdfRequest("Laxmi Nagar New Delhi 110092","Lalita Park New Delhi 110056","3647267466", "https://infodetails.s3.ap-south-1.amazonaws.com/barcode-1524813201666.jpg", "https://infodetails.s3.ap-south-1.amazonaws.com/barcode-1524813201666.jpg", "eWayBillNumber", "15", "boxnumber",
				"awbNumber", "transporterName", "serviceName");
		Map<String, String> map = TemplateUtil.toMap(request);
		TemplateUtil.createPdf("createpdf", map, "order.pdf");

	}

	private static void createPdf1() {
		String templateName = "template";
		String outputFileName = "output.pdf";
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Shahzad");
		map.put("email", "shahzad@canbrand.in");
		map.put("mobile", "7828588330");
		TemplateUtil.createPdf(templateName, map, outputFileName);
		log.info("\n PDF Successfully Created");
	}

	private static void createPdf2() {
		Student person = new Student("Shahzad", "Hussain", "shahzad@canbrand.in", "7828588330");
		Map<String, String> map = TemplateUtil.toMap(person);
		String outputFile = "student.pdf";
		TemplateUtil.createPdf("person", map, outputFile);
		log.info("\nPDF Successfully Created");
	}
}
