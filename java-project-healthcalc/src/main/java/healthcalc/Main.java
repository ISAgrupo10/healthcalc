package healthcalc;
import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HealthCalc healthCalc = new HealthCalcImpl();

        try {
            System.out.println("===¡Bienvenido a Health Calculator! ===");

            // Input
            System.out.print("Introduce el peso en kilogramos: ");
            double weight = scanner.nextDouble();

            System.out.print("Introduce la altura en metros: ");
            double height = scanner.nextDouble();

            //Primero calculamos el BMI
            double bmi = healthCalc.bmi(weight, height);
            //Ahora clasificamos
            String classification = healthCalc.bmiClassification(bmi);

            // Output
            System.out.println("\nResultados:");
            System.out.println("ICM: " + bmi);
            System.out.println("Clasificación según IMC: " + classification);

        } catch (InvalidHealthDataException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: formato de entrada inválido.");
        } finally {
            scanner.close();
        }
    }
}
