/**
 * 
 */
package com.cantech;

/**
 * @author shahzad
 *
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

	public static void main(String[] args) {

		try {

			OutputStream file = new FileOutputStream(new File("/home/shahzad/pdf/samplepdf.pdf"));
			Document document = new Document();
			PdfWriter.getInstance(document, file);

			// Inserting Image in PDF
			Image image = Image.getInstance("https://infodetails.s3.ap-south-1.amazonaws.com/salman-Khan.jpeg");
			image.scaleAbsolute(120f, 60f);// image width,height
			
			
			Image image1 = Image.getInstance("https://infodetails.s3.ap-south-1.amazonaws.com/nture.jpeg");
			image1.scaleAbsolute(400f, 450f);

			// Inserting Table in PDF
			PdfPTable table = new PdfPTable(3);

			PdfPCell cell = new PdfPCell(new Paragraph("Shahzad"));

			cell.setColspan(5);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPadding(10.0f);
			cell.setBackgroundColor(new BaseColor(140, 221, 8));

			table.addCell(cell);

			table.addCell("Name");
			table.addCell("Address");
			table.addCell("Country");
			table.addCell("Java4s");
			table.addCell("NC");
			table.addCell("United States");
			table.setSpacingBefore(30.0f); // Space Before table starts, like
											// margin-top in CSS
			table.setSpacingAfter(30.0f); // Space After table starts, like
											// margin-Bottom in CSS

			// Inserting List in PDF
			List list = new List(true, 30);
			list.add(new ListItem("Java4s"));
			list.add(new ListItem("Php4s"));
			list.add(new ListItem("Some Thing..."));

			// Text formating in PDF
			Chunk chunk = new Chunk("Welecome To Programming");
			chunk.setUnderline(+1f, -2f);// 1st co-ordinate is for line
											// width,2nd is space between
			Chunk chunk1 = new Chunk("java.com");
			chunk1.setUnderline(+4f, -8f);
			chunk1.setBackground(new BaseColor(17, 46, 193));

			// Now Insert Every Thing Into PDF Document
			document.open();// PDF document opened........

			document.add(image);

			document.add(Chunk.NEWLINE); // Something like in HTML :-)

			document.add(new Paragraph("Dear Shahzad"));
			document.add(new Paragraph("Document Generated On - " + new Date().toString()));

			document.add(table);

			document.add(chunk);
			document.add(chunk1);

			document.add(Chunk.NEWLINE); // Something like in HTML :-)
			document.add(image1);
			document.newPage(); // Opened new page
			document.add(list); // In the new page we are going to add list

			document.close();

			file.close();

			System.out.println("Pdf created successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}