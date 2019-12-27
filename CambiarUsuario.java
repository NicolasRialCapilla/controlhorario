import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarUsuario implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Programa.marcas((Usuario) Programa.usuario_Option.getSelectedItem());
	}

}
