import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

public class AñadirMarcaAntigua implements ActionListener {

	static JFrame panel;
	static JTextField hora_Field;
	static JTextField minutos_Field;
	static JTextField segundos_Field;
	static JComboBox<Usuario> usuario_Option = new JComboBox(Programa.usuarios.toArray());
	static JComboBox<String> tipo_Option = new JComboBox<String>(Programa.tipos_Marcas);
	static JCalendar calendario = new JCalendar();

	@Override
	public void actionPerformed(ActionEvent e) {
		panel = new JFrame("Añadir marca pasada");
		panel.setSize(500, 300);
		panel.getContentPane().setBackground(new Color(245, 245, 245));
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(null);

		JLabel usuario_Label = new JLabel(" Usuario: ");
		usuario_Label.setSize(100, 30);
		usuario_Label.setLocation(20, 15);
		panel.getContentPane().add(usuario_Label);
		usuario_Option.setSize(250, 30);
		usuario_Option.setLocation(80, 15);
		usuario_Option.setFocusable(true);
		usuario_Option.setBackground(Color.WHITE);
		panel.getContentPane().add(usuario_Option);

		calendario.setSize(200, 200);
		calendario.setLocation(80, 60);
		panel.getContentPane().add(calendario);

		JLabel hora_Label = new JLabel("Hora: ");
		hora_Label.setSize(100, 30);
		hora_Label.setLocation(350, 60);
		panel.getContentPane().add(hora_Label);
		hora_Field = new JTextField();
		hora_Field.setLocation(420, 65);
		hora_Field.setSize(50, 20);
		panel.getContentPane().add(hora_Field);

		JLabel minutos_Label = new JLabel("Minutos: ");
		minutos_Label.setSize(100, 30);
		minutos_Label.setLocation(350, 90);
		panel.getContentPane().add(minutos_Label);
		minutos_Field = new JTextField();
		minutos_Field.setLocation(420, 95);
		minutos_Field.setSize(50, 20);
		panel.getContentPane().add(minutos_Field);

		JLabel segundos_Label = new JLabel("Segundos: ");
		segundos_Label.setSize(100, 30);
		segundos_Label.setLocation(350, 120);
		panel.getContentPane().add(segundos_Label);
		segundos_Field = new JTextField();
		segundos_Field.setLocation(420, 125);
		segundos_Field.setSize(50, 20);
		panel.getContentPane().add(segundos_Field);

		tipo_Option.setSize(120, 30);
		tipo_Option.setLocation(350, 160);
		tipo_Option.setFocusable(true);
		tipo_Option.setBackground(Color.WHITE);
		panel.getContentPane().add(tipo_Option);

		JButton boton_añadir = new JButton("Añadir");
		boton_añadir.setLocation(360, 215);
		boton_añadir.setSize(100, 30);
		boton_añadir.setVisible(true);
		boton_añadir.addActionListener(new AñadirMarcaAntiguaArrayList());
		panel.getContentPane().add(boton_añadir);

		panel.setVisible(true);
	}

}
