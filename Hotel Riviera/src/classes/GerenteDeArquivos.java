package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import classes.Baba.Baba;
import classes.Carro.Carro;
import classes.Pessoa.Hospede;
import classes.Quartos.*;


public class GerenteDeArquivos {
	private final static String DIR = "Documentos do Hotel", HOSPEDES = "//Hospedes", 
								QUARTOS = "//Quartos", BABAS = "//Babas", CARROS = "\\Carros";
	static {
		try {
			new File(DIR).mkdir();
			new File(DIR+HOSPEDES).mkdir();
			new File(DIR+QUARTOS).mkdir();
			new File(DIR+BABAS).mkdir();
			new File(DIR+CARROS).mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void salvaCarro(Carro carro, boolean editando) throws Exception{
		File file = new File(DIR + CARROS, carro.getPlaca());
		if (!editando) {
			if (file.exists()){
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(carro);
				out.close();
			}
			file.createNewFile();
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(carro);
		out.close();
	}
	
	public static Carro getCarro(String placaDoCarro){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(DIR + CARROS, placaDoCarro)));
			Object obj = in.readObject();
			in.close();
			return (Carro) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public static void salvaBaba(Baba baba, boolean editando) throws Exception{
		File file = new File(DIR + BABAS, baba.getNome());
		if (!editando) {
			if (file.exists()){
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(baba);
				out.close();
			}
			file.createNewFile();
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(baba);
		out.close();
	}
	
	public static Baba getBaba(String nomeDaBaba){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(DIR + BABAS, nomeDaBaba)));
			Object obj = in.readObject();
			in.close();
			return (Baba) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	

	public static void salvaHospede(Hospede hospede, boolean editando) throws Exception {
		File file = new File(DIR + HOSPEDES, hospede.getNome());
		
		if (!editando) {
			if (file.exists()) {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(hospede);
				out.close();
			}
			file.createNewFile();			
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(hospede);
		out.close();
	}
	
	public static Hospede getHospede(String filename) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(DIR+HOSPEDES, filename)));
		Object obj = in.readObject();
		in.close();
		return (Hospede) obj;
	}
	
	public static Quarto getQuarto(int numeroDoQuarto){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(DIR + QUARTOS, "Quarto n" + numeroDoQuarto)));
			Object obj = in.readObject();
			in.close();
			return (Quarto) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
	
	public static void salvaQuarto(Quarto quarto, boolean editando) throws Exception {
		File arquivo = new File(DIR + QUARTOS, "Quarto n" + quarto.getNumeroDoQuarto());
		if (!editando) {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
			out.writeObject(quarto);	
			//arquivo.createNewFile();			
		}

	}


	static String[] getListFiles() {
		File dir = new File(DIR);
		String[] files = dir.list();

		return files;
	}
	

	public static void excluirHospede(Hospede hospede) {
		File file = new File(DIR + HOSPEDES, hospede.getNome());
		file.delete();
	}
}