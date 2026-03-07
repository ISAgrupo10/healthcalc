package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HealthCalc healthCalc = new HealthCalcImpl();

        try {
            System.out.println("==========================================");
            System.out.println("   === ¡Bienvenido a HealthCalc! ===   ");
            System.out.println("==========================================");

            // 1. Recolección de datos básicos
            System.out.print("> Introduce tu sexo ('m' para hombre, 'f' para mujer): ");
            String sex = scanner.next().toLowerCase();

            System.out.print("> Introduce el peso en kilogramos (ej. 70,5): ");
            double weight = scanner.nextDouble();

            System.out.print("> Introduce la altura en metros (ej. 1,75): ");
            double heightMeters = scanner.nextDouble();
            double heightCm = heightMeters * 100; // Lo pasamos a cm para la fórmula de Lorentz

            // 2. Recolección de datos clínicos para el VAI
            System.out.println("\n--- Datos Clínicos (VAI) ---");
            System.out.print("> Introduce la circunferencia de la cintura en cm (ej. 90,0): ");
            double cc = scanner.nextDouble();

            System.out.print("> Introduce los triglicéridos en mmol/L (ej. 1,5): ");
            double tg = scanner.nextDouble();

            System.out.print("> Introduce el colesterol HDL en mmol/L (ej. 1,2): ");
            double hdl = scanner.nextDouble();

            System.out.println("\nCalculando métricas...\n");

            // 3. Cálculos y Resultados
            // Métrica 1: BMI
            double bmi = healthCalc.bmi(weight, heightMeters);
            String classification = healthCalc.bmiClassification(bmi);
            System.out.println("------------------------------------------");
            System.out.println(" 1. Índice de Masa Corporal (IMC/BMI)");
            System.out.println("------------------------------------------");
            System.out.printf(" Resultado: %.2f kg/m2\n", bmi);
            System.out.println(" Clasificación: " + classification + "\n");

            // Métrica 2: IBW (Lorentz)
            double ibw = healthCalc.idealBodyWeight(heightCm, sex);
            System.out.println("------------------------------------------");
            System.out.println(" 2. Peso Corporal Ideal (IBW - Lorentz)");
            System.out.println("------------------------------------------");
            System.out.printf(" Resultado: %.2f kg\n\n", ibw);

            // Métrica 3: VAI
            double vai = healthCalc.vai(sex, bmi, cc, tg, hdl);
            System.out.println("------------------------------------------");
            System.out.println(" 3. Índice de Adiposidad Visceral (VAI)");
            System.out.println("------------------------------------------");
            System.out.printf(" Resultado: %.2f\n", vai);
            System.out.println("==========================================");

        } catch (InvalidHealthDataException e) {
            System.err.println("\n[ERROR DE DATOS]: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n[ERROR DE FORMATO]: Por favor, comprueba el formato de los números. Usa la coma (,) para los decimales si tu sistema está en español.");
        } finally {
            scanner.close();
        }
    }
}