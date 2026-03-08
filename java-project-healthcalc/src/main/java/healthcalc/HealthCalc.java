package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;

public interface HealthCalc {
	
	/**
	 * Calculate the BMI classification of a person.
	 * The BMI classification is based on the following table:
	 * - Severe thinness: BMI < 16
	 * - Moderate thinness: 16 <= BMI < 17
	 * - Mild thinness: 17 <= BMI < 18.5
	 * - Normal weight: 18.5 <= BMI < 25
	 * - Overweight: 25 <= BMI < 30
	 * - Obese Class I: 30 <= BMI < 35
	 * - Obese Class II: 35 <= BMI < 40
	 * - Obese Class III: BMI >= 40
	 *
	 * @param bmi	Body Mass Index of the person (kg/m2).
	 * @return	 	The BMI classification of the person.
	 * @throws Exception
	 */
	public String bmiClassification(double bmi) throws InvalidHealthDataException;
	public double bmi(double weight, double height) throws InvalidHealthDataException;

	/**
	 * Calculate the Visceral Adiposity Index (VAI) of a person.
	 * * The VAI is calculated using different formulas depending on sex:
	 * * For men:
	 * VAI = [CC / (39.68 + (1.88 * BMI))] × (TG / 1.03) × (1.31 / HDL)
	 * * For women:
	 * VAI = [CC / (36.58 + (1.89 * BMI))] × (TG / 0.81) × (1.52 / HDL)
	 * * Where:
	 * - sex must be "m" (male) or "f" (female)
	 * - BMI is Body Mass Index (kg/m2)
	 * - CC is Waist Circumference (cm)
	 * - TG is Triglycerides (mmol/L)
	 * - HDL is HDL cholesterol (mmol/L)
	 * * @param sex   Sex of the person ("m" or "f")
	 * @param bmi   Body Mass Index (kg/m2)
	 * @param cc    Waist circumference (cm)
	 * @param tg    Triglycerides (mmol/L)
	 * @param hdl   HDL cholesterol (mmol/L)
	 * @return      The Visceral Adiposity Index (VAI)
	 * @throws InvalidHealthDataException if parameters are invalid
	 */
	public double vai(String sex, double bmi, double cc, double tg, double hdl) throws InvalidHealthDataException;
	
	public double idealBodyWeight(double height, String sex) throws InvalidHealthDataException;
}