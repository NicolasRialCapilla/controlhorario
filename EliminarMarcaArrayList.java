import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class EliminarMarcaArrayList implements ActionListener {

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Programa.marcas.remove(Programa.marcas_Option.getSelectedValue());
		Programa.marcas_Jornada.remove(Programa.marcas_Option.getSelectedValue());
		Programa.marcas_Option.setListData(Programa.marcas_Jornada.toArray());

		ModificarMarca.panel.hide();

		JOptionPane.showMessageDialog(null, "Marca eliminada correctamente. ", "Eliminar marca", 1);
	}

}
