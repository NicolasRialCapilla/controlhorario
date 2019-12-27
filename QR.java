import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import com.google.zxing.*;
import com.google.zxing.common.*;
import com.google.zxing.qrcode.*;

public class QR {
	public static void main(String[] args) throws IOException {
		JFrame panel = new JFrame("Código QR");
		panel.setSize(500, 300);
		panel.setLocationRelativeTo(null);
		String informacion = "Nombre: Nicolás. \nApellido: Rial. \nEdad: 25 años. ";
		BitMatrix matrix;
		try {
			matrix = new QRCodeWriter().encode(informacion, BarcodeFormat.QR_CODE, 200, 200);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}
		BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < 200; y++) {
			for (int x = 0; x < 200; x++) {
				int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
				image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
			}
		}
		ImageIO.write(image, "png", new FileOutputStream("C:/qrcode.png"));
		ImageIcon qr = new ImageIcon("C:/qrcode.png");
		panel.getContentPane().add(new JLabel(qr));
		panel.setVisible(true);
	}
}