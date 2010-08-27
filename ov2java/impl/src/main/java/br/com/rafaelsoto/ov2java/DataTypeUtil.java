package br.com.rafaelsoto.ov2java;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataTypeUtil {

	 public static void writeInt(int v, OutputStream out) throws IOException {
	        out.write((v >>>  0) & 0xFF);
	        out.write((v >>>  8) & 0xFF);
	        out.write((v >>> 16) & 0xFF);
	        out.write((v >>> 24) & 0xFF);
	    }
	    
	    public static long readLong(InputStream is) throws IOException{
	        long res = 0;
	       
	            res = is.read();
	            res += is.read() <<8;
	            res += is.read() <<16;
	            res += is.read() <<24;
	        return res;
	    }
}
