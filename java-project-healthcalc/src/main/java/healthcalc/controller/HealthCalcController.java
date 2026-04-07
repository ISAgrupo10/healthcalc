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
    	
    view.getBtnCalcularVAI().addActionListener(e -> calcularVAI());
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
