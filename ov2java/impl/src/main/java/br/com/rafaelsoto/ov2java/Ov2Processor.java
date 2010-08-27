package br.com.rafaelsoto.ov2java;

import static br.com.rafaelsoto.ov2java.DataTypeUtil.readLong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Ov2Processor {

	
	public OV2Record[] read(File file) throws FileNotFoundException
	{
		return read(new FileInputStream(file));
	}
	
	public OV2Record[] read(InputStream input)
	{
		
		List<OV2Record> retorno = new ArrayList<OV2Record>();
		OV2Record record = null;
		
		

        int b = -1;
        try{
            while ((b = input.read()) != -1) {
            	

                if (b == Status.SIMPLE.status()) {
                    
                	record = new OV2Record();
                	
                	long total = readLong(input);

                    double longitude = (double) readLong(input) / 100000.0;
                    double latitude = (double) readLong(input) / 100000.0;

                    byte[] r = new byte[(int) total - 13];
                    input.read(r);

                    record.setNome(new String(r));
                    record.setLatitudeY(latitude);
                    record.setLongitudeX(longitude);
                    
                    retorno.add(record);
                    
                   
                }

                else if(b == Status.DELETED.status()){
                    byte[] r = new byte[9];
                    input.read(r);
                }

                else if(b == Status.SKIPPER.status()){
                    byte[] r = new byte[20];
                    input.read(r);
                }
                else{
                    throw new IOException("tipo desconhecido de dado");
                }
                
                
            }
            
            
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return (OV2Record[]) retorno.toArray();
	}
	
		
	
}
