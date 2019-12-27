import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class A�adirUsuarioArrayList implements ActionListener {
	
	boolean mascara = false;

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if ((A�adirUsuario.dni_Field.getText().isEmpty() || A�adirUsuario.dni_Field.getText().equals(null))
				|| (A�adirUsuario.nombre_Field.getText().isEmpty() || A�adirUsuario.nombre_Field.getText().equals(null))
				|| (A�adirUsuario.apellido1_Field.getText().isEmpty()
						|| A�adirUsuario.apellido1_Field.getText().equals(null))
				|| (A�adirUsuario.apellido2_Field.getText().isEmpty()
						|| A�adirUsuario.apellido2_Field.getText().equals(null))) {
			JOptionPane.showMessageDialog(null, "Tiene que informar los campos DNI, nombre y apellidos. ",
					"A�adir usuario", 1);
		} else {
			/*
			if (A�adirUsuario.dni_Field.getText().length() == 9) {
				if (Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(0))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(1))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(2))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(3))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(4))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(5))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(6))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(7))
						&& Character.isAlphabetic(A�adirUsuario.dni_Field.getText().charAt(8))) {
					mascara = true;
				}
			} else if (A�adirUsuario.dni_Field.getText().length() == 10) {
				if (Character.isAlphabetic(A�adirUsuario.dni_Field.getText().charAt(0))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(1))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(2))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(3))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(4))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(5))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(6))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(7))
						&& Character.isDigit(A�adirUsuario.dni_Field.getText().charAt(8))
						&& Character.isAlphabetic(A�adirUsuario.dni_Field.getText().charAt(9))) {
					mascara = true;
				}
			}

			if (mascara) {
			*/
				Usuario usuario = new Usuario(A�adirUsuario.dni_Field.getText().toUpperCase(),
						A�adirUsuario.nombre_Field.getText(), A�adirUsuario.apellido1_Field.getText(),
						A�adirUsuario.apellido2_Field.getText());

				if (Programa.usuarios.contains(usuario)) {
					JOptionPane.showMessageDialog(null, "Este usuario ya existe en la base de datos. ",
							"A�adir usuario ", 0);
				} else {
					Programa.usuarios.add(usuario);
					Programa.usuario_Option.addItem(usuario);
					A�adirMarcaAntigua.usuario_Option.addItem(usuario);

					A�adirUsuario.panel.hide();

					JOptionPane.showMessageDialog(null, "Usuario creado correctamente. ", "A�adir usuario ", 1);
				}
				/*
			} else {
				JOptionPane.showMessageDialog(null, "El DNI requiere de formato NNNNNNNNL o LNNNNNNNNL. ",
						"A�adir usuario", 1);
			}
			*/
				
		}

	}

}
