import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.itextpdf.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class ExportarListadoUsuarios implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (null == MostrarUsuarios.usuarios_Option.getSelectedValue()) {
			JOptionPane.showMessageDialog(null,
					"Tiene que seleccionar los usuarios con CTRL + click o todos con CTRL + A. ", "Exportar usuarios ",
					0);
		} else {
			JFileChooser rutaArchivo = new JFileChooser();
			rutaArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("xls", "xls");
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

			if (!ruta.substring(ruta.length() - 4, ruta.length()).equals(".xls")) {
				ruta = ruta + ".xls";
			}

			File archivoXLS;
			Workbook libro;
			FileOutputStream archivo;
			Sheet hoja;
			Row cabecera;
			Row fila;
			Cell celda;

			String FILE_NAME = ruta;

			archivoXLS = new File(FILE_NAME);

			if (archivoXLS.exists()) {
				archivoXLS.delete();
			}

			libro = new HSSFWorkbook();

			try {
				archivo = new FileOutputStream(archivoXLS);

				hoja = libro.createSheet("Personal");

				cabecera = hoja.createRow(0);

				celda = cabecera.createCell(0);
				celda.setCellValue("ID");
				celda = cabecera.createCell(1);
				celda.setCellValue("DNI");
				celda = cabecera.createCell(2);
				celda.setCellValue("Nombre");
				celda = cabecera.createCell(3);
				celda.setCellValue("Primer apellido");
				celda = cabecera.createCell(4);
				celda.setCellValue("Segundo apellido");

				for (int i = 0; i < MostrarUsuarios.usuarios_Option.getSelectedValuesList().size(); i++) {
					fila = hoja.createRow(i+1);
					
					celda = fila.createCell(0);
					celda.setCellValue(((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).id);
					celda = fila.createCell(1);
					celda.setCellValue(((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).dni);
					celda = fila.createCell(2);
					celda.setCellValue(((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).nombre);
					celda = fila.createCell(3);
					celda.setCellValue(((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).apellido1);
					celda = fila.createCell(4);
					celda.setCellValue(((Usuario) MostrarUsuarios.usuarios_Option.getSelectedValue()).apellido2);
				}

				libro.write(archivo);

				archivo.close();

				Desktop.getDesktop().open(archivoXLS);

				JOptionPane.showMessageDialog(null, "Listado generado correctamente. ", "Exportar usuarios ", 1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (java.io.IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
