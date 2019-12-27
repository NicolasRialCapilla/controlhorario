
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AñadirUsuario implements ActionListener {

	static JFrame panel;
	static JTextField dni_Field;
	static JTextField nombre_Field;
	static JTextField apellido1_Field;
	static JTextField apellido2_Field;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel = new JFrame("Añadir usuario ");
		panel.setSize(400, 220);
		panel.getContentPane().setBackground(new Color(245, 245, 245));
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(null);

		JLabel dni_Label = new JLabel("DNI: ");
		dni_Label.setSize(150, 30);
		dni_Label.setLocation(40, 15);
		panel.getContentPane().add(dni_Label);
		dni_Field = new JTextField();
		dni_Field.setSize(160, 25);
		dni_Field.setLocation(190, 15);
		panel.getContentPane().add(dni_Field);

		JLabel nombre_Label = new JLabel("Nombre: ");
		nombre_Label.setSize(160, 30);
		nombre_Label.setLocation(40, 45);
		panel.getContentPane().add(nombre_Label);
		nombre_Field = new JTextField();
		nombre_Field.setSize(160, 25);
		nombre_Field.setLocation(190, 45);
		panel.getContentPane().add(nombre_Field);

		JLabel apellido1_Label = new JLabel("Primer apellido: ");
		apellido1_Label.setSize(160, 30);
		apellido1_Label.setLocation(40, 75);
		panel.getContentPane().add(apellido1_Label);
		apellido1_Field = new JTextField();
		apellido1_Field.setSize(160, 25);
		apellido1_Field.setLocation(190, 75);
		panel.getContentPane().add(apellido1_Field);

		JLabel apellido2_Label = new JLabel("Segundo apellido: ");
		apellido2_Label.setSize(160, 30);
		apellido2_Label.setLocation(40, 105);
		panel.getContentPane().add(apellido2_Label);
		apellido2_Field = new JTextField();
		apellido2_Field.setSize(160, 25);
		apellido2_Field.setLocation(190, 105);
		panel.getContentPane().add(apellido2_Field);

		JButton boton_añadir = new JButton("Añadir");
		boton_añadir.setSize(100, 30);
		boton_añadir.setLocation(80, 145);
		boton_añadir.addActionListener(new AñadirUsuarioArrayList());
		panel.getContentPane().add(boton_añadir);
		
		JButton boton_cancelar = new JButton("Cancelar");
		boton_cancelar.setSize(100, 30);
		boton_cancelar.setLocation(220, 145);
		boton_cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.hide();
			}
			
		});
		panel.getContentPane().add(boton_cancelar);

		panel.setVisible(true);

	}

}
