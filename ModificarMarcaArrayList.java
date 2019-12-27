import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ModificarMarcaArrayList implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		int hora = 0;
		int minutos = 0;
		int segundos = 0;

		if ((ModificarMarca.hora_Field.getText().isEmpty() || ModificarMarca.hora_Field.getText().equals(null))
				|| (ModificarMarca.minutos_Field.getText().isEmpty()
						|| ModificarMarca.minutos_Field.getText().equals(null))
				|| (ModificarMarca.segundos_Field.getText().isEmpty()
						|| ModificarMarca.segundos_Field.getText().equals(null))) {
			JOptionPane.showMessageDialog(null, "Tiene que informar los campos hora, minutos y segundos. ",
					"Modificar marca", 1);
		} else if ((!isNumeric(ModificarMarca.hora_Field.getText()) || ModificarMarca.hora_Field.getText().equals(null))
				|| (!isNumeric(ModificarMarca.minutos_Field.getText())
						|| ModificarMarca.minutos_Field.getText().equals(null))
				|| (!isNumeric(ModificarMarca.segundos_Field.getText())
						|| ModificarMarca.segundos_Field.getText().equals(null))) {
			JOptionPane.showMessageDialog(null,
					"Tiene que insertar los campos hora, minutos y segundos con un formato numérico válido. ",
					"Modificar marca", 1);
		} else if (isNumeric(ModificarMarca.hora_Field.getText()) && isNumeric(ModificarMarca.minutos_Field.getText())
				&& isNumeric(ModificarMarca.segundos_Field.getText())) {
			hora = Integer.parseInt(ModificarMarca.hora_Field.getText());
			minutos = Integer.parseInt(ModificarMarca.minutos_Field.getText());
			segundos = Integer.parseInt(ModificarMarca.segundos_Field.getText());

			if ((hora > 24 || hora < 0) || (minutos > 59 || minutos < 0) || (segundos > 59 || segundos < 0)) {
				JOptionPane.showMessageDialog(null,
						"Tiene que insertar los campos hora, minutos y segundos con un formato numérico válido. ",
						"Modificar marca", 1);
			} else {
				Programa.marcas_Jornada.get(Programa.marcas_Option.getSelectedIndex()).cambiarHora(hora, minutos,
						segundos);
				Programa.marcas.get(Programa.marcas_Option.getSelectedIndex()).cambiarHora(hora, minutos, segundos);
				Programa.marcas_Option.setListData(Programa.marcas_Jornada.toArray());
				

				ModificarMarca.panel.hide();

				JOptionPane.showMessageDialog(null, "Marca modificada correctamente. ", "Modificar marca", 1);
			}
		}
	}

	public static boolean isNumeric(String cadena) {
		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

}
