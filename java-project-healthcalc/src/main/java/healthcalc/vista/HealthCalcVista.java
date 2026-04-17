package healthcalc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

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
	private JPanel panel_6;
	private JLabel lblTituloVAI;

	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblResultIBW;
	private JLabel lblAlturaIBW;
	private JLabel lblNewLabel_1;
	private JTextField textFieldAlturaIBW;
	private JComboBox<String> comboBoxIBWSexo;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JButton btnCalcularIBW;

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
		panelIBW.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panelIBW.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);

		lblNewLabel = new JLabel("¡Bienvenido a la calculadora de IBW!");
		lblNewLabel.setFont(new Font("Rockwell Nova", Font.PLAIN, 18));
		panel_5.add(lblNewLabel);

		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_COLSPEC,
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
				FormSpecs.DEFAULT_ROWSPEC,}));

		lblAlturaIBW = new JLabel("Altura (cm): ");
		lblAlturaIBW.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panel_3.add(lblAlturaIBW, "8, 6, right, default");

		textFieldAlturaIBW = new JTextField();
		panel_3.add(textFieldAlturaIBW, "10, 6, fill, default");
		textFieldAlturaIBW.setColumns(10);

		lblNewLabel_1 = new JLabel("Sexo: ");
		lblNewLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panel_3.add(lblNewLabel_1, "8, 12, right, default");

		comboBoxIBWSexo = new JComboBox();
		comboBoxIBWSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		panel_3.add(comboBoxIBWSexo, "10, 12, fill, default");

		btnCalcularIBW = new JButton("Calcular IBW");
		btnCalcularIBW.setFont(new Font("Rockwell Nova", Font.PLAIN, 11));
		panel_3.add(btnCalcularIBW, "10, 16");

		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);

		lblResultIBW = new JLabel("IBW: -");
		lblResultIBW.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		panel_4.add(lblResultIBW);
		
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
		lblVAISexo.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panelVAI.add(lblVAISexo, "4, 4, left, default");
		
		comboBoxVAISexo = new JComboBox();
		comboBoxVAISexo.setFont(new Font("Rockwell Nova", Font.PLAIN, 11));
		comboBoxVAISexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		panelVAI.add(comboBoxVAISexo, "6, 4, fill, default");
		
		lblIMC = new JLabel("IMC");
		lblIMC.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		lblIMC.setBackground(new Color(192, 192, 192));
		panelVAI.add(lblIMC, "8, 4, left, default");
		
		textFieldIMC = new JTextField();
		panelVAI.add(textFieldIMC, "10, 4, fill, default");
		textFieldIMC.setColumns(10);
		
		lblTrigliceridos = new JLabel("Triglicéridos (mmol/l)");
		lblTrigliceridos.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panelVAI.add(lblTrigliceridos, "4, 8, left, default");
		
		textFieldTrigli = new JTextField();
		panelVAI.add(textFieldTrigli, "6, 8, fill, default");
		textFieldTrigli.setColumns(10);
		
		lblHDL = new JLabel("HDL (mmol/l)");
		lblHDL.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panelVAI.add(lblHDL, "8, 8, left, default");
		
		textFieldHDL = new JTextField();
		panelVAI.add(textFieldHDL, "10, 8, fill, default");
		textFieldHDL.setColumns(10);
		
		lblNewCircunf = new JLabel("Circunferencia \r\nde cintura(cm)");
		lblNewCircunf.setFont(new Font("Rockwell Nova", Font.PLAIN, 12));
		panelVAI.add(lblNewCircunf, "4, 12, center, default");
		
		textFieldCircunf = new JTextField();
		panelVAI.add(textFieldCircunf, "6, 12, fill, default");
		textFieldCircunf.setColumns(10);
		
		btnCalcularVAI = new JButton("Calcular VAI");
		btnCalcularVAI.setFont(new Font("Rockwell Nova", Font.PLAIN, 11));
		panelVAI.add(btnCalcularVAI, "10, 12");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		tabbedPane.addTab("Calcular VAI", null, panel, null);
		
		panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.NORTH);
		
		lblTituloVAI = new JLabel("¡Bienvenido a la calculadora de VAI!");
		lblTituloVAI.setFont(new Font("Rockwell Nova", Font.PLAIN, 18));
		panel_6.add(lblTituloVAI);
		
		panel.add(panelVAI);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		lblResultadoVAI = new JLabel("VAI: -");
		lblResultadoVAI.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		panel_1.add(lblResultadoVAI);
	}

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

	public JComboBox<String> getComboBoxVAISexo() {
	    return comboBoxVAISexo;
	}

	public JButton getBtnCalcularVAI() {
	    return btnCalcularVAI;
	}

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

	public JComboBox<String> getcomboBoxIBWSexo() {
	    return comboBoxIBWSexo;
	}
	
	public JLabel getLblResultadoIBW() {
	    return lblResultIBW;
	}
	
	public JButton getBtnCalcularIBW() {
	    return btnCalcularIBW;
	}
	
	public JTextField getTextFieldAlturaIBW() {
	    return textFieldAlturaIBW;
	}
}