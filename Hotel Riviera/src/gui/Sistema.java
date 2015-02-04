package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import classes.Arquivos;
import classes.HotelOpiniaoServicosPeriodo.Hotel;
// pagina sistema, nathaniel criou. Deve ter sido a janela que gustavin mito falou.
public class Sistema {

	private JFrame frame;
	private static Hotel hotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema window = new Sistema();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Sistema() {
		criaHotel();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new LoginDeFuncionario();
		frame.setBounds(100, 100, 749, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static Hotel getHotel() {
		if (hotel == null)
			criaHotel();
		return hotel;
		
	}
	
	private static void criaHotel() {
		if (Arquivos.extisteHotel()){
			hotel = Arquivos.carregaHotel();
		} else {
				hotel = new Hotel();
		try {
			Arquivos.salvaHotel(hotel);
		} catch (Exception e) {
			System.out.println("Hotel nao criado");
			}
		}
	}
		

}

