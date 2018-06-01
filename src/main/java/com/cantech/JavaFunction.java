///**
// * 
// */
//package com.cantech;
//
//import java.util.function.Function;
//
//import org.springframework.http.HttpStatus;
//
//import com.jugo.api.constants.JugoResponseCode;
//import com.jugo.api.exception.JugoApiException;
//import com.jugo.api.models.Vendor;
//
///**
// * @author shahzad
// *
// */
//public class JavaFunction {
//
//	public static void main(String[] args) {
//
//		String email  = "shahzad.hussain@gmail.com";
//		validateIsNull(value -> vendorDao.getVendorByEmail(value), email);
//		validateIsNull(value -> vendorDao.getVendorByUsername(value), username);
//		validateIsNull(value -> vendorDao.getVedorByContactNumber(value), contactNumber);
//	}
//
//	private void checkExistanceVendor(String email, String username, String contactNumber) {
//		Vendor vendor = vendorDao.getVendorByEmail(email);
//		if (vendor != null)
//			throw new JugoApiException(JugoResponseCode.EXIST_EMAIL, HttpStatus.BAD_REQUEST);
//		vendor = vendorDao.getVendorByUsername(username);
//		if (vendor != null)
//			throw new JugoApiException(JugoResponseCode.EXIST_USERNAME, HttpStatus.BAD_REQUEST);
//		vendor = vendorDao.getVedorByContactNumber(contactNumber);
//		if (vendor != null)
//			throw new JugoApiException(JugoResponseCode.EXIST_CONTACT, HttpStatus.BAD_REQUEST);
//
//		
//
//	}
//
//	private void validateIsNull(Function<String, Vendor> func, String value) throws JugoApiException {
//		Vendor vendor = func.apply(value);
//		if (vendor != null)
//			throw new JugoApiException(JugoResponseCode.VENDOR_EXIST, HttpStatus.BAD_REQUEST);
//	}
//
//}
