package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class CurrencyBean {

	public double getAmount() {
		return amount;
		
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	private double amount, result;
	
	public void convert(ActionEvent evt) {
		result = amount / 67.5; 
	}

}
