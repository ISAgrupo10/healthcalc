package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.getDefault());
        HealthCalc healthCalc = new HealthCalcImpl();

        try {
            System.out.println("==========================================");
            System.out.println("   === ¡Bienvenido a HealthCalc! ===   ");
            System.out.println("==========================================");
            System.out.print("> Introduce tu sexo ('m' para hombre, 'f' para mujer): ");
            String sex = scanner.next().toLowerCase();

            System.out.print("> Introduce el peso en kilogramos (ej. 70,5): ");
            double weight = scanner.nextDouble();

            System.out.print("> Introduce la altura en metros (ej. 1,75): ");
            double heightMeters = scanner.nextDouble();
            double heightCm = heightMeters * 100; 

            System.out.println("\n--- Datos adicionales para el Índice de Adiposidad Visceral (VAI) ---");
            System.out.print("> Introduce la circunferencia de la cintura en cm: ");
            double cc = scanner.nextDouble();

            System.out.print("> Introduce los triglicéridos (mmol/L): ");
            double tg = scanner.nextDouble();

            System.out.print("> Introduce el colesterol HDL (mmol/L): ");
            double hdl = scanner.nextDouble();

            System.out.println("\nCalculando métricas...");
            System.out.println("------------------------------------------");

            double bmi = healthCalc.bmi(weight, heightMeters);
            String classification = healthCalc.bmiClassification(bmi);
            double ibw = healthCalc.idealBodyWeight(heightCm, sex);
            double vai = healthCalc.vai(sex, bmi, cc, tg, hdl);

            // Resultados:
            System.out.printf("1. IMC (BMI): %.2f kg/m2\n", bmi);
            System.out.println("   Clasificación: " + classification);
            System.out.printf("2. Peso Ideal (IBW - Lorentz): %.2f kg\n", ibw);
            System.out.printf("3. Índice de Adiposidad Visceral (VAI): %.2f\n", vai);
            System.out.println("------------------------------------------");

        } catch (InvalidHealthDataException e) {
            System.err.println("\n[ERROR DE DATOS]: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\n[ERROR]: Entrada inválida. Asegúrate de usar el formato numérico correcto.");
        } finally {
            scanner.close();
        }
    }
}
