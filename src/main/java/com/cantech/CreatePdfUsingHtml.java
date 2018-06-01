/**
 * 
 */
package com.cantech;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author shahzad
 *
 */
public class CreatePdfUsingHtml {
	public static void main(String[] args) {

		createPdfUsingHtmlPage();

	}

	private static void createPdfUsingHtmlPage() {
		try {
			String k = "<html><body> <h1>This is my Project</h1>"
					+ "First Name: <br><br>"
					+ "<h2><font color='red'>This is sample to creating pdf by using java</font></h2></body></html>";
			OutputStream file = new FileOutputStream(new File("/home/shahzad/pdf/Test.pdf"));
			
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			htmlWorker.parse(new StringReader(k));
			document.close();
			file.close();
			System.out.println("Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
