import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class ImprimirListadoUsuarios implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (null == MostrarUsuarios.usuarios_Option.getSelectedValue()) {
			JOptionPane.showMessageDialog(null,
					"Tiene que seleccionar los usuarios con CTRL + click o todos con CTRL + A. ", "Listar usuarios ",
					0);
		} else {
			JFileChooser rutaArchivo = new JFileChooser();
			rutaArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("pdf", "pdf");
			rutaArchivo.setFileFilter(filtro);
			rutaArchivo.setAcceptAllFileFilterUsed(false);
			String ruta = "";

			try {
				if (rutaArchivo.showSaveDialog(null) == rutaArchivo.APPROVE_OPTION) {
					ruta = rutaArchivo.getSelectedFile().getAbsolutePath();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			if (!ruta.substring(ruta.length()-4, ruta.length()).equals(".pdf")) {
				ruta = ruta + ".pdf";
			}

			Document document = new Document();

			try {
				String FILE_NAME = ruta;

				PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

				document.open();

				Paragraph paragraphHello = new Paragraph();

				paragraphHello.add("Empleados: ");

				paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);

				document.add(paragraphHello);

				Paragraph paragraphLorem = new Paragraph();
				paragraphLorem.add("\n");

				for (int i = 0; i < MostrarUsuarios.usuarios_Option.getSelectedValuesList().size(); i++) {
					paragraphLorem.add(
							((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).toStringUsuario() + " \n");
				}

				java.util.List<Element> paragraphList = new ArrayList<>();

				paragraphList = paragraphLorem;

				Font f = new Font();
				f.setFamily(FontFamily.COURIER.name());
				f.setStyle(Font.BOLDITALIC);
				f.setSize(8);

				Paragraph p3 = new Paragraph();
				p3.setFont(f);
				p3.add("\n");
				p3.add("Listado de: " + Programa.nombreEmpresa);

				document.add(paragraphLorem);
				document.add(p3);
				document.close();
				
				Desktop.getDesktop().open(new File(FILE_NAME));
				
				JOptionPane.showMessageDialog(null, "Listado generado correctamente. ", "Listar usuarios ", 1);

			} catch (FileNotFoundException | DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}

		}
	}

}
