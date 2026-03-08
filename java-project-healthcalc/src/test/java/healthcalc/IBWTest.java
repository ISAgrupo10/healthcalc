package healthcalc;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import healthcalc.exceptions.InvalidHealthDataException;

@DisplayName("Tests para el Peso Corporal Ideal (IBW).")
public class IBWTest {

    private HealthCalc healthCalc;

    @BeforeEach
    void setUp() {
        healthCalc = new HealthCalcImpl();
    }

    @Nested
    @DisplayName("Cálculo del IBW (Fórmula de Lorentz)")
    class IBWMetricTests {

        @Test
        @DisplayName("Cálculo de IBW para hombre con altura estándar")
        void testIbwHombreValido() throws InvalidHealthDataException {
            // Arrange
            double height = 180.0;
            String sex = "m";
            double expected = (180.0 - 100) - ((180.0 - 150) / 4);

            // Act
            double result = healthCalc.idealBodyWeight(height, sex);

            // Assert
            assertEquals(expected, result, 0.01);
        }

        @Test
        @DisplayName("Cálculo de IBW para mujer con altura estándar")
        void testIbwMujerValido() throws InvalidHealthDataException {
            // Arrange
            double height = 165.0;
            String sex = "f";
            double expected = (165.0 - 100) - ((165.0 - 150) / 2);

            // Act
            double result = healthCalc.idealBodyWeight(height, sex);

            // Assert
            assertEquals(expected, result, 0.01);
        }

        @Test
        @DisplayName("Lanzar excepción cuando el sexo no es 'm' ni 'f'")
        void testSexoInvalido() {
            assertAll(
                () -> assertThrows(InvalidHealthDataException.class, () -> healthCalc.idealBodyWeight(170.0, "x")),
                () -> assertThrows(InvalidHealthDataException.class, () -> healthCalc.idealBodyWeight(170.0, "M")),
                () -> assertThrows(InvalidHealthDataException.class, () -> healthCalc.idealBodyWeight(170.0, ""))
            );
        }

        @ParameterizedTest(name = "Altura mínima inválida: {0} cm")
        @ValueSource(doubles = {-50.0, 0.0, 29.0})
        @DisplayName("Bloqueo de alturas inferiores al límite biológico mínimo (30 cm)")
        void testAlturaMinimaImposible(double height) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.idealBodyWeight(height, "m"));
        }

        @ParameterizedTest(name = "Altura máxima inválida: {0} cm")
        @ValueSource(doubles = {300.1, 400.0})
        @DisplayName("Bloqueo de alturas superiores al límite biológico máximo (300 cm)")
        void testAlturaMaximoImposible(double height) {
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.idealBodyWeight(height, "m"));
        }
    }
}