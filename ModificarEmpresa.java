import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ModificarEmpresa implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String aux = JOptionPane.showInputDialog(null, "Inserte el nuevo nombre de la empresa. ",
				"Modificar el nombre de la empresa", 3);

		if (aux == null || aux == "" || aux.equals("")) {
			JOptionPane.showMessageDialog(null, "No ha modificado el nombre de la empresa. ", "Modificar empresa ", 1);
		} else {
			Programa.nombreEmpresa = aux;
			Programa.panel.setTitle("Control horario - " + Programa.nombreEmpresa);
			JOptionPane.showMessageDialog(null, "Nombre modificado correctamente. ", "Modificar empresa ", 1);
		}
	}

}
