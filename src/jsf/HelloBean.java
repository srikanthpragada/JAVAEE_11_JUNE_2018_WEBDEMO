package jsf;

import java.time.LocalDate;

import javax.faces.bean.ManagedBean;

@ManagedBean 
public class HelloBean {

	 // property message 
	 public  String getMessage() {
		 return "Hello! Today is : " + LocalDate.now().toString();
	 }
}
