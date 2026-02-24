package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public String bmiClassification(double bmi) throws InvalidHealthDataException {
        if (bmi <= 0) {
            throw new InvalidHealthDataException("BMI must be greater than 0.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("BMI must be within a possible biological range [0-150].");
        }
    
    if (bmi < 16) {
        return "Severe thinness";
    } else if (bmi < 17) {
        return "Moderate thinness";
    } else if (bmi < 18.5) {
        return "Mild thinness";
    } else if (bmi < 25) {
        return "Normal weight";
    } else if (bmi < 30) {
        return "Overweight";
    } else if (bmi < 35) {
        return "Obese Class I";
    } else if (bmi < 40) {
        return "Obese Class II";
    } else {
        return "Obese Class III";
    }
    }

    @Override
    public double bmi(double weight, double height) throws InvalidHealthDataException {
        if (weight <= 0) {
            throw new InvalidHealthDataException("Weight must be positive.");
        }
        if (height <= 0) {
            throw new InvalidHealthDataException("Height must be positive.");
        }
        if (weight < 1 || weight > 700) {
            throw new InvalidHealthDataException("Weight must be within a possible biological range [1-700] kg.");
        }
        if (height < 0.30 || height > 3.00) {
            throw new InvalidHealthDataException("Height must be within a possible biological range [0.30-3.00] m.");
        }
        return weight / Math.pow(height, 2);
    }
    
}
