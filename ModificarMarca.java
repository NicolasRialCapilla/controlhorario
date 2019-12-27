import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModificarMarca implements ActionListener {

	static JFrame panel;
	static JTextField hora_Field;
	static JTextField minutos_Field;
	static JTextField segundos_Field;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (null == Programa.marcas_Option.getSelectedValue()) {
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar una marca válida. ", "Modificar marca", 0);
		} else {
			panel = new JFrame("Modificar marca ");
			panel.setSize(400, 200);
			panel.getContentPane().setBackground(new Color(245, 245, 245));
			panel.setLocationRelativeTo(null);
			panel.setResizable(false);
			panel.setLayout(new GridLayout(4, 2));

			JLabel hora_Label = new JLabel("          Hora: ");
			panel.getContentPane().add(hora_Label);
			hora_Field = new JTextField();
			hora_Field.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(245, 245, 245), 7), BorderFactory.createSoftBevelBorder(0,
							Color.WHITE, Color.WHITE, new Color(220, 220, 220), Color.WHITE)));
			panel.getContentPane().add(hora_Field);

			JLabel minutos_Label = new JLabel("          Minutos: ");
			panel.getContentPane().add(minutos_Label);
			minutos_Field = new JTextField();
			minutos_Field.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(245, 245, 245), 7), BorderFactory.createSoftBevelBorder(0,
							Color.WHITE, Color.WHITE, new Color(220, 220, 220), Color.WHITE)));
			panel.getContentPane().add(minutos_Field);

			JLabel segundos_Label = new JLabel("          Segundos: ");
			panel.getContentPane().add(segundos_Label);
			segundos_Field = new JTextField();
			segundos_Field.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(new Color(245, 245, 245), 7), BorderFactory.createSoftBevelBorder(0,
							Color.WHITE, Color.WHITE, new Color(220, 220, 220), Color.WHITE)));
			panel.getContentPane().add(segundos_Field);

			JButton boton_añadir = new JButton("Modificar");
			boton_añadir.setBorder(BorderFactory.createMatteBorder(5, 40, 5, 80, new Color(245, 245, 245)));
			boton_añadir.addActionListener(new ModificarMarcaArrayList());
			panel.getContentPane().add(boton_añadir);

			JButton boton_eliminar = new JButton("Eliminar");
			boton_eliminar.setBorder(BorderFactory.createMatteBorder(5, 80, 5, 40, new Color(245, 245, 245)));
			boton_eliminar.addActionListener(new EliminarMarcaArrayList());
			panel.getContentPane().add(boton_eliminar);

			panel.setVisible(true);
		}
	}

}
