package lombok;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner2 {
	
	@Test
	public void lombok() {
	
	
	Items1 it= new Items1("10","15","20");
	Items1 it1= new Items1("10","15","20");
	List<Items1>its=Arrays.asList(it,it1);
	Category cg = new Category("idly","dosa");
	Employee em = new Employee("ishu","111",its,cg);
	
	try {
        ObjectMapper mapper = new ObjectMapper();
        String jsonPayload = mapper.writeValueAsString(em);

        System.out.println("JSON Payload:");
        System.out.println(jsonPayload);
    } catch (Exception e) {
        e.printStackTrace();
    }
	}

}
