package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;

public interface HealthCalc {
	
	public String bmiClassification(double bmi) throws InvalidHealthDataException;
	public double bmi(double weight, double height) throws InvalidHealthDataException;
	public double vai(String sex, double bmi, double cc, double tg, double hdl) throws InvalidHealthDataException;
	public double idealBodyWeight(double height, String sex) throws InvalidHealthDataException;

}
