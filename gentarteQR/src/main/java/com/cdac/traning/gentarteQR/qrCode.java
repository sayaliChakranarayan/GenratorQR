package com.cdac.traning.gentarteQR;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import ch.qos.logback.core.filter.Filter;

public class qrCode {
	public static void main(String[] args)  {
    	try {
		String qrCodeData="www.linkedin.com/in/sayali-chakranarayan-2157b5235";
        Path filepath=Paths.get("\\Users\\SHILPA\\Desktop\\sayali.png");
        String format = "\\Users\\SHILPA\\Desktop\\sayali.png";
        String charset = "UTF-8";
        Map <EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        
        BitMatrix matrix=new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE,200,200, hintMap);

		MatrixToImageWriter.writeToPath(matrix, format.substring(format.lastIndexOf(".")+1), filepath);
        
        System.out.println("QR succesfully created");
	} catch(Exception e) {
		System.err.println(e);
	}
	}

}
