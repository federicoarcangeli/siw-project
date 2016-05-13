package it.uniroma3.validator;

public class DoubleValidator {

	public DoubleValidator() {
	}

	public double doubleValidator(String str){
		double dbl;
		try {
			dbl=Double.parseDouble(str);
		} catch(NumberFormatException e) {
			return 0.0;
		}
		return dbl;
	}
}
