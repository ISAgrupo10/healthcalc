package healthcalc.controller;

import java.awt.Color;
import healthcalc.HealthCalcImpl;
import healthcalc.vista.HealthCalcVista;
import healthcalc.exceptions.InvalidHealthDataException;


public class HealthCalcController {

    private final HealthCalcVista view;
    private final HealthCalcImpl model;

    public HealthCalcController(HealthCalcVista view) {
        this.view = view;
        this.model = new HealthCalcImpl();

        initController();
    }

    private void initController() {

    view.getBtnCalcularBMI().addActionListener(e -> calcularBMI());	
    view.getBtnCalcularVAI().addActionListener(e -> calcularVAI());
    }

	private void calcularBMI() {
    try {
        double peso = Double.parseDouble(view.getTextFieldPesoBMI().getText());
        double altura = Double.parseDouble(view.getTextFieldAlturaBMI().getText());

        double resultado = model.bmi(peso, altura);
        String clasificacion = model.bmiClassification(resultado);

        view.getLblResultadoBMI().setForeground(new Color(0, 128, 0));
        view.getLblResultadoBMI().setText(
            String.format("BMI: %.2f | Classification: %s", resultado, clasificacion)
        );

    } catch (InvalidHealthDataException e) {
        view.getLblResultadoBMI().setForeground(Color.RED);
        view.getLblResultadoBMI().setText(e.getMessage());

    } catch (NumberFormatException e) {
        view.getLblResultadoBMI().setForeground(Color.RED);
        view.getLblResultadoBMI().setText("Error: Invalid values");
    }
}

	private void calcularVAI() {
		try {
			String sexoSeleccionado=view.getComboBoxVAISexo().getSelectedItem().toString();
			String sex;
			
			if(sexoSeleccionado.equals("Masculino")) {
				sex="m";
			}else {
				sex="f";
			}
			double bmi=Double.parseDouble(view.getTextFieldIMC().getText());
			double trigl=Double.parseDouble(view.getTextFieldTrigli().getText());
			double hdl=Double.parseDouble(view.getTextFieldHDL().getText());
			double cc=Double.parseDouble(view.getTextFieldCircunf().getText());

			double resultado = model.vai(sex, bmi, cc, trigl, hdl);
			view.getLblResultadoVAI().setForeground(new Color (0,128,0));
			view.getLblResultadoVAI().setText(String.format("VAI: %.2f", resultado));
			
		
		}catch(InvalidHealthDataException e){
			view.getLblResultadoVAI().setForeground(Color.RED);
			view.getLblResultadoVAI().setText(e.getMessage());
		}catch (NumberFormatException e) {
			view.getLblResultadoVAI().setForeground(Color.RED);
			view.getLblResultadoVAI().setText("Error: Invalid values");
		}
	}

}
