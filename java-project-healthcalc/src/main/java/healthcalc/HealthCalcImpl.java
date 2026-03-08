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

    @Override
    public double vai(String sex, double bmi, double cc, double tg, double hdl) throws InvalidHealthDataException {
        if (!sex.equals("m") && !sex.equals("f")) {
            throw new InvalidHealthDataException("Sex must be 'm' or 'f'.");
        }
        if (bmi <= 0 || cc <= 0 || tg <= 0 || hdl <= 0) {
            throw new InvalidHealthDataException("Parameters cannot be negative or zero.");
        }
        if (bmi > 150) {
            throw new InvalidHealthDataException("BMI exceeds realistic human limits.");
        }
        if (cc > 300) {
            throw new InvalidHealthDataException("Waist circumference exceeds realistic human limits.");
        }
        if (tg > 20) {
            throw new InvalidHealthDataException("Triglycerides exceed realistic biological limits.");
        }
        if (hdl > 5) {
            throw new InvalidHealthDataException("HDL cholesterol exceeds realistic biological limits.");
        }

        double vaiResult;
        if (sex.equals("m")) {
            vaiResult = (cc / (39.68 + (1.88 * bmi))) * (tg / 1.03) * (1.31 / hdl);
        } else {
            vaiResult = (cc / (36.58 + (1.89 * bmi))) * (tg / 0.81) * (1.52 / hdl);
        }
        return vaiResult;
    }

    @Override
    public double idealBodyWeight(double height, String sex) throws InvalidHealthDataException {
        if (!sex.equals("m") && !sex.equals("f")) {
            throw new InvalidHealthDataException("Sex must be 'm' or 'f'.");
        }
        // Limitando a 30cm (0.3m) y 300cm (3m) en concordancia con BMITest, pero en cm.
        if (height < 30 || height > 300) {
            throw new InvalidHealthDataException("Height must be between 30 cm and 300 cm.");
        }

        double ibwResult;
        if (sex.equals("m")) {
            ibwResult = (height - 100) - ((height - 150) / 4.0);
        } else {
            ibwResult = (height - 100) - ((height - 150) / 2.0);
        }
        return ibwResult;
    }
    
}
