package lombok;

import java.util.List;

import pojo2.Items;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
	
	private String employeename;
	private String id;
	private List<Items1> items1;
	private Category categories;

}
