package nucleo.classes.arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import nucleo.classes.hotel.Hotel;

public class Arquivos {
	public final static String DIR = "Documentos do Hotel";
	static {
		try {
			new File(DIR).mkdir();
			new File(DIR + "//Hotel").mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void salvaHotel(Hotel hotel) throws Exception {
		File file = new File(DIR + "//Hotel", "Hotel");
		if (file.exists()) {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(file));
			out.writeObject(hotel);
			out.close();
		} else {
			file.createNewFile();
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(file));
			out.writeObject(hotel);
			out.close();
		}
	}

	public static Hotel carregaHotel() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					new File(DIR + "//Hotel", "Hotel")));
			Object obj = in.readObject();
			in.close();
			return (Hotel) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean extisteHotel() {
		File file = new File(DIR + "//Hotel", "Hotel");
		return file.exists();
	}
}