/**
 * 
 */
package com.cantech.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shahzad
 *
 */
@Data
@NoArgsConstructor
public class PdfRequest {
//	public AddressRequest sourceAddress;
//	public AddressRequest recepientAddress;
	
	private String from;
	private String to;
	private String invoicenumber;
	private String orderNumber;
	private String boxId;
	private String eWayBillNumber;
	private String numberOfBoxes;
	private String boxnumber;
	private String awbNumber;
	private String transporterName;
	private String serviceName;
	
	
	public PdfRequest(String from, String to,String invoicenumber, String orderNumber, String boxId, String eWayBillNumber,
			String numberOfBoxes, String boxnumber, String awbNumber, String transporterName, String serviceName) {
		this.from=from;
		this.to=to;
		this.invoicenumber = invoicenumber;
		this.orderNumber = orderNumber;
		this.boxId = boxId;
		this.eWayBillNumber = eWayBillNumber;
		this.numberOfBoxes = numberOfBoxes;
		this.boxnumber = boxnumber;
		this.awbNumber = awbNumber;
		this.transporterName = transporterName;
		this.serviceName = serviceName;
	}
	
	
	
}
