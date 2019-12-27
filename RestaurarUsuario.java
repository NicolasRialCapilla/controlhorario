import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RestaurarUsuario implements ActionListener {

	static JFrame panel;
	static JComboBox<Usuario> usuario_Option = new JComboBox(Programa.usuariosEliminados.toArray());

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel = new JFrame("Restaurar usuario ");
		panel.setSize(400, 150);
		panel.getContentPane().setBackground(new Color(245, 245, 245));
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(null);

		JLabel usuario_Label = new JLabel("Usuario: ");
		usuario_Label.setSize(100, 30);
		usuario_Label.setLocation(65, 19);
		panel.getContentPane().add(usuario_Label);

		usuario_Option.setSize(200, 30);
		usuario_Option.setLocation(125, 20);
		usuario_Option.setFocusable(true);
		usuario_Option.setBackground(Color.WHITE);
		panel.getContentPane().add(usuario_Option);

		JButton boton_añadir = new JButton("Restaurar");
		boton_añadir.setSize(100, 30);
		boton_añadir.setLocation(90, 70);
		boton_añadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (null == usuario_Option.getSelectedItem()) {
					JOptionPane.showMessageDialog(null, "Tiene que seleccionar un usuario. ", "Restaurar usuario ", 0);
				} else {
					Programa.usuariosEliminados.remove(usuario_Option.getSelectedItem());
					usuario_Option.removeItem(usuario_Option.getSelectedItem());
					Programa.usuarios.add((Usuario) usuario_Option.getSelectedItem());
					
					Programa.usuario_Option.add((Component) usuario_Option.getSelectedItem());
					
					JOptionPane.showMessageDialog(null, "Usuario restaurado correctamente. ", "Restaurar usuario ", 1);
				}
			}

		});
		
		panel.getContentPane().add(boton_añadir);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(100, 30);
		cancelar.setLocation(210, 70);
		panel.getContentPane().add(cancelar);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.hide();
			}

		});

		panel.setVisible(true);
	}

}
