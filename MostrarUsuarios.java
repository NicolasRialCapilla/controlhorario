import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class MostrarUsuarios implements ActionListener {

	static JFrame panel;
	static JList usuarios_Option = new JList<Usuario>();
	static JLabel qr;
	static JLabel ID_Label;
	static String informacion;
	static BitMatrix matrix;
	static BufferedImage image;
	static ImageIcon imagenQR;

	static boolean ordenID = true;
	static boolean ordenNombre = true;
	static boolean ordenApellido = true;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		panel = new JFrame("Usuarios ");
		panel.setSize(800, 400);
		panel.getContentPane().setBackground(new Color(245, 245, 245));
		panel.setLocationRelativeTo(null);
		panel.setResizable(false);
		panel.setLayout(null);

		JLabel iD_Label = new JLabel("ID: ");
		iD_Label.setSize(50, 30);
		iD_Label.setLocation(650, 100);
		panel.getContentPane().add(iD_Label);

		ID_Label = new JLabel();
		ID_Label.setSize(60, 30);
		ID_Label.setLocation(680, 100);
		ID_Label.setHorizontalAlignment(2);
		ID_Label.setFocusable(true);
		ID_Label.setHorizontalAlignment(0);
		ID_Label.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
				BorderFactory.createLineBorder(Color.WHITE, 2)));
		panel.getContentPane().add(ID_Label);

		JLabel usuarios_Label = new JLabel("Usuarios: ");
		usuarios_Label.setSize(100, 30);
		usuarios_Label.setLocation(20, 50);
		panel.getContentPane().add(usuarios_Label);

		usuarios_Option.setSize(600, 200);
		usuarios_Option.setLocation(20, 80);
		usuarios_Option.setFocusable(true);
		usuarios_Option.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		usuarios_Option.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1), BorderFactory.createLineBorder(Color.WHITE, 2)));
		usuarios_Option.setListData(Programa.usuarios.toArray());
		usuarios_Option.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (usuarios_Option.getSelectedValuesList().size() == 1) {
					ID_Label.setText("" + ((Usuario) usuarios_Option.getSelectedValue()).id);
					informacion = ((Usuario) usuarios_Option.getSelectedValue()).toStringUsuario();
				} else if (usuarios_Option.getSelectedValuesList().size() == 0) {
					ID_Label.setText("");

					if (Programa.nombreEmpresa.equals("")) {
						informacion = "Control horario. Desarrollado por: Nicolás Rial.";
					} else {
						informacion = "Control horario: " + Programa.nombreEmpresa
								+ ". Desarrollado por: Nicolás Rial.";
					}
				} else {
					ID_Label.setText("" + ((Usuario) usuarios_Option.getSelectedValue()).id + " - "
							+ ((Usuario) usuarios_Option.getSelectedValue()).id);
					String resultado = "";
					for (int i = 0; i < usuarios_Option.getSelectedValuesList().size(); i++) {
						resultado += usuarios_Option.getSelectedValuesList().get(i).toString() + "\n";
					}
					informacion = resultado;
				}

				try {
					qr();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		panel.getContentPane().add(usuarios_Option);

		JButton ordenar_ID = new JButton("Ordenar por ID");
		ordenar_ID.setSize(120, 30);
		ordenar_ID.setLocation(130, 25);
		ordenar_ID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ordenID) {
					Programa.usuarios.sort(Comparator.naturalOrder());
				} else {
					Programa.usuarios.sort(Comparator.reverseOrder());
				}
				ordenID = !ordenID;
				usuarios_Option.setListData(Programa.usuarios.toArray());
			}
		});
		panel.getContentPane().add(ordenar_ID);

		JButton ordenar_Nombre = new JButton("Ordenar por nombre");
		ordenar_Nombre.setSize(150, 30);
		ordenar_Nombre.setLocation(270, 25);
		ordenar_Nombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ordenNombre) {
					Programa.usuarios.sort(new OrdenarUsuarioPorNombre());
				} else {
					Programa.usuarios.sort(new OrdenarUsuarioPorNombre().reversed());
				}
				ordenNombre = !ordenNombre;
				usuarios_Option.setListData(Programa.usuarios.toArray());
			}
		});
		panel.getContentPane().add(ordenar_Nombre);

		JButton ordenar_Apellido = new JButton("Ordenar por apellido");
		ordenar_Apellido.setSize(150, 30);
		ordenar_Apellido.setLocation(440, 25);
		ordenar_Apellido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ordenApellido) {
					Programa.usuarios.sort(new OrdenarUsuarioPorApellido());
				} else {
					Programa.usuarios.sort(new OrdenarUsuarioPorApellido().reversed());
				}
				ordenApellido = !ordenApellido;
				usuarios_Option.setListData(Programa.usuarios.toArray());
			}
		});
		panel.getContentPane().add(ordenar_Apellido);

		JButton cerrar = new JButton("Cancelar");
		cerrar.setSize(100, 30);
		cerrar.setLocation(50, 320);
		cerrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.hide();
			}
		});
		panel.getContentPane().add(cerrar);

		JButton imprimir = new JButton("Imprimir listado");
		imprimir.setSize(150, 30);
		imprimir.setLocation(170, 320);
		imprimir.addActionListener(new ImprimirListadoUsuarios());
		panel.getContentPane().add(imprimir);

		JButton exportar = new JButton("Exportar a Excel");
		exportar.setSize(150, 30);
		exportar.setLocation(340, 320);
		exportar.addActionListener(new ExportarListadoUsuarios());
		panel.getContentPane().add(exportar);

		JButton eliminar = new JButton("Eliminar usuario");
		eliminar.setSize(130, 30);
		eliminar.setLocation(635, 155);
		eliminar.addActionListener(new EliminarUsuario());
		panel.getContentPane().add(eliminar);

		try {
			qrInicio();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		panel.setVisible(true);

	}

	public static void qrInicio() throws FileNotFoundException, IOException {
		if (Programa.nombreEmpresa.equals("")) {
			informacion = "Control horario. Desarrollado por: Nicolás Rial.";
		} else {
			informacion = "Control horario: " + Programa.nombreEmpresa + ". Desarrollado por: Nicolás Rial.";
		}

		try {
			matrix = new QRCodeWriter().encode(informacion, BarcodeFormat.QR_CODE, 120, 120);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}

		image = new BufferedImage(120, 120, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < 120; y++) {
			for (int x = 0; x < 120; x++) {
				int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
				image.setRGB(x, y, (grayValue == 0 ? 0 : 0xF5F5F5));
			}
		}

		imagenQR = new ImageIcon(image);

		qr = new JLabel(imagenQR);
		qr.setFocusable(true);
		qr.setSize(120, 120);
		qr.setLocation(640, 220);
		panel.getContentPane().add(qr);
	}

	public static void qr() throws FileNotFoundException, IOException {
		try {
			matrix = new QRCodeWriter().encode(informacion, BarcodeFormat.QR_CODE, 120, 120);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}

		image = new BufferedImage(120, 120, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < 120; y++) {
			for (int x = 0; x < 120; x++) {
				int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
				image.setRGB(x, y, (grayValue == 0 ? 0 : 0xF5F5F5));
			}
		}

		imagenQR = new ImageIcon(image);

		qr = new JLabel(imagenQR);
		qr.setFocusable(true);
		qr.setSize(120, 120);
		qr.setLocation(640, 220);
	}

}
