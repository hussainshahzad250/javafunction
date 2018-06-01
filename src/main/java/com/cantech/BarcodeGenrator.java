package com.cantech;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.code128.Code128;
import org.krysalis.barcode4j.impl.code39.Code39;
import org.krysalis.barcode4j.impl.pdf417.PDF417;

import com.cantech.util.TemplateUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfWriter;

public class BarcodeGenrator {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		// createBarcode();
		// createBarCode();
		// createBarCodePng();
		// barcodeImage();
		barcodewithBackground();
	}

	private static void barcodewithBackground() {

	}

	private static void createBarcode() throws DocumentException, MalformedURLException, IOException {
		Document document = new Document(new Rectangle(PageSize.A4));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/home/shahzad/pdf/testsample.pdf"));
		document.open();
		document.add(new Paragraph("Code_128 Format"));

		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		code128.setAltText("Order Number");
		code128.setBarHeight(15f);
		code128.setCode("ORD#1005");
		code128.setCodeType(code128.CODE128);

		
		Image image = code128.createImageWithBarcode(writer.getDirectContent(), null, BaseColor.BLUE);

		// Create BARCODE
		document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, BaseColor.BLUE));

		// Create PDF
		document.add(new Paragraph("Sample 1: This is simple image demo."));
		document.add(image);
		document.close();

		System.out.println("Document Generated...!!!!!!");
	}

	private static void barcodeImage() throws FileNotFoundException, DocumentException {
		Document doc = new Document();
		PdfWriter writer1 = PdfWriter.getInstance(doc, new FileOutputStream("/home/shahzad/pdf/testsample.jpg"));
		doc.open();
		doc.add(new Paragraph("Test"));
		Barcode128 code128 = new Barcode128();
		code128.setGenerateChecksum(true);
		code128.setAltText("jhsdkj");
		code128.setBarHeight(10f);
		code128.setCode("1234554321");

		Image imageEAN = code128.createImageWithBarcode(writer1.getDirectContent(), BaseColor.BLACK, BaseColor.GREEN);
		imageEAN.scaleToFit(200, 200);
		doc.add(imageEAN);
		doc.close();
		System.out.println("Image created successfully");
	}

	private static void createBarCodePng() {
		try {
			Barcode128 code128 = new Barcode128();
			code128.setGenerateChecksum(true);
			code128.setAltText("jhsdkj");
			code128.setBarHeight(10f);
			code128.setCode("1234554321");
			java.awt.Image awtImage = Toolkit.getDefaultToolkit()
					.createImage(new File("/home/shahzad/pdf/img.jpg").getAbsolutePath());
			Image instance = com.itextpdf.text.Image.getInstance(awtImage, null);
			Document document = new Document();
			document.open();
			document.add(new Paragraph(
					String.format("%s is an image of type %s", "java.awt.Image", instance.getClass().getName())));
			document.add(instance);
			System.out.println("cerate");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createBarCode() {
		BarcodeEAN codeEAN = new BarcodeEAN();
		codeEAN.setCodeType(codeEAN.EAN13);
		codeEAN.setGenerateChecksum(true);
		codeEAN.setCode("9780201615883");
		System.out.println(codeEAN.getCode());
		Image imageEAN = codeEAN.createImageWithBarcode(null, null, null);

	}
}
