package pojo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RUnnerfile {
	
	@Test
	public void pojo2(){
		
		Items it1 = new Items("P1001", "Laptop", "1");
		Items it2 = new Items("P1002", "Laptop", "2");
		List<Items>item=Arrays.asList(it1,it2);

		Customer cs=new Customer("ishu", "illinois");
		ProductOrderpayload data = new ProductOrderpayload("356",cs,item);

		try {
	        ObjectMapper mapper = new ObjectMapper();
	        String jsonPayload = mapper.writeValueAsString(data);

	        System.out.println("JSON Payload:");
	        System.out.println(jsonPayload);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  
		
		
	}

}
