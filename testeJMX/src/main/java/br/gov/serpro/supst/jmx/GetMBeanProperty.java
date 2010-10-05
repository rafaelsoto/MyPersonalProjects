package br.gov.serpro.supst.jmx;

import java.lang.management.ManagementFactory;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

public class GetMBeanProperty {

	public static void main(String[] args) throws AttributeNotFoundException, InstanceNotFoundException, MBeanException, ReflectionException, MalformedObjectNameException, NullPointerException {
		
		  MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		  
		  ObjectName name = new ObjectName("Catalina:type=Server"); 
		  
		  Object obj = mbs.getAttribute(name, "port");
		  
		  System.out.println("");
		  
	}
	
}
