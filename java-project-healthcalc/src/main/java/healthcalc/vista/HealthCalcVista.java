package healthcalc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JButton;


public class HealthCalcVista extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFieldPesoBMI;
	private JTextField textFieldAlturaBMI;
	private JButton btnCalcularBMI;
	private JLabel lblResultadoBMI;

	private JTextField textFieldIMC;
	private JTextField textFieldTrigli;
	private JTextField textFieldHDL;
	private JTextField textFieldCircunf;
	private JComboBox<String> comboBoxVAISexo;
	private JButton btnCalcularVAI;
	private JLabel lblResultadoVAI;
	private JLabel lblIMC;
	private JLabel lblTrigliceridos;
	private JLabel lblNewCircunf;
	private JLabel lblHDL;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcVista frame = new HealthCalcVista();
					new healthcalc.controller.HealthCalcController(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HealthCalcVista() {
		setTitle("HealthCalc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelBMI = new JPanel(new BorderLayout());
tabbedPane.addTab("Calcular BMI", null, panelBMI, null);


JPanel panelBMIContainer = new JPanel(new BorderLayout());
panelBMIContainer.setBorder(new EmptyBorder(20, 40, 20, 40));
panelBMI.add(panelBMIContainer, BorderLayout.CENTER);


JPanel panelBMIForm = new JPanel();
panelBMIContainer.add(panelBMIForm, BorderLayout.NORTH);

panelBMIForm.setLayout(new FormLayout(new ColumnSpec[] {
        FormSpecs.DEFAULT_COLSPEC,
        FormSpecs.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("150px"),
        FormSpecs.RELATED_GAP_COLSPEC,
        ColumnSpec.decode("200px"),},
    new RowSpec[] {
        FormSpecs.DEFAULT_ROWSPEC,
        FormSpecs.RELATED_GAP_ROWSPEC,
        FormSpecs.DEFAULT_ROWSPEC,
        FormSpecs.RELATED_GAP_ROWSPEC,
        FormSpecs.DEFAULT_ROWSPEC,
        FormSpecs.RELATED_GAP_ROWSPEC,
        FormSpecs.DEFAULT_ROWSPEC
}));

JLabel lblPesoBMI = new JLabel("Peso (kg):");
panelBMIForm.add(lblPesoBMI, "1, 1, right, center");

textFieldPesoBMI = new JTextField();
textFieldPesoBMI.setColumns(10);
panelBMIForm.add(textFieldPesoBMI, "3, 1, 3, 1, fill, default");

JLabel lblAlturaBMI = new JLabel("Altura (m):");
panelBMIForm.add(lblAlturaBMI, "1, 3, right, center");

textFieldAlturaBMI = new JTextField();
textFieldAlturaBMI.setColumns(10);
panelBMIForm.add(textFieldAlturaBMI, "3, 3, 3, 1, fill, default");


JPanel panelBotonBMI = new JPanel();
btnCalcularBMI = new JButton("Calcular BMI");
btnCalcularBMI.setPreferredSize(new java.awt.Dimension(160, 35));
panelBotonBMI.add(btnCalcularBMI);

panelBMIForm.add(panelBotonBMI, "3, 5, 3, 1, center, center");

JPanel panelBMIResultado = new JPanel();
panelBMIResultado.setBorder(new EmptyBorder(20, 0, 0, 0));
panelBMIContainer.add(panelBMIResultado, BorderLayout.CENTER);

lblResultadoBMI = new JLabel("BMI: -");
panelBMIResultado.add(lblResultadoBMI);


		
		

		
		JPanel panelIBW = new JPanel();
		tabbedPane.addTab("Calcular IBW", null, panelIBW, null);
		
		JPanel panelVAI = new JPanel();
		panelVAI.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblVAISexo = new JLabel("Sexo");
		panelVAI.add(lblVAISexo, "4, 4, left, default");
		
		comboBoxVAISexo = new JComboBox();
		comboBoxVAISexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		panelVAI.add(comboBoxVAISexo, "6, 4, fill, default");
		
		lblIMC = new JLabel("IMC");
		lblIMC.setBackground(new Color(192, 192, 192));
		panelVAI.add(lblIMC, "8, 4, left, default");
		
		textFieldIMC = new JTextField();
		panelVAI.add(textFieldIMC, "10, 4, fill, default");
		textFieldIMC.setColumns(10);
		
		lblTrigliceridos = new JLabel("Triglicéridos (mmol/l)");
		panelVAI.add(lblTrigliceridos, "4, 8, left, default");
		
		textFieldTrigli = new JTextField();
		panelVAI.add(textFieldTrigli, "6, 8, fill, default");
		textFieldTrigli.setColumns(10);
		
		lblHDL = new JLabel("HDL (mmol/l)");
		panelVAI.add(lblHDL, "8, 8, left, default");
		
		textFieldHDL = new JTextField();
		panelVAI.add(textFieldHDL, "10, 8, fill, default");
		textFieldHDL.setColumns(10);
		
		lblNewCircunf = new JLabel("Circunferencia \r\nde cintura(cm)");
		panelVAI.add(lblNewCircunf, "4, 12, center, default");
		
		textFieldCircunf = new JTextField();
		panelVAI.add(textFieldCircunf, "6, 12, fill, default");
		textFieldCircunf.setColumns(10);
		
		btnCalcularVAI = new JButton("Calcular VAI");
		panelVAI.add(btnCalcularVAI, "10, 12");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("Calcular VAI", null, panel, null);
		
		panel.add(panelVAI);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		lblResultadoVAI = new JLabel("VAI: -");
		panel_1.add(lblResultadoVAI);
	}
	// TEXTFIELDS
	public JTextField getTextFieldIMC() {
	    return textFieldIMC;
	}

	public JTextField getTextFieldTrigli() {
	    return textFieldTrigli;
	}

	public JTextField getTextFieldHDL() {
	    return textFieldHDL;
	}

	public JTextField getTextFieldCircunf() {
	    return textFieldCircunf;
	}

	// COMBOBOX
	public JComboBox<String> getComboBoxVAISexo() {
	    return comboBoxVAISexo;
	}

	// BOTÓN
	public JButton getBtnCalcularVAI() {
	    return btnCalcularVAI;
	}

	// LABEL RESULTADO
	public JLabel getLblResultadoVAI() {
	    return lblResultadoVAI;
	}

	public JTextField getTextFieldPesoBMI() {
		return textFieldPesoBMI;
	}

	public JTextField getTextFieldAlturaBMI() {
		return textFieldAlturaBMI;
	}

	public JButton getBtnCalcularBMI() {
		return btnCalcularBMI;
	}

	public JLabel getLblResultadoBMI() {
		return lblResultadoBMI;
	}
}
