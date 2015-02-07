package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import classes.Arquivos;
import classes.HotelOpiniaoServicosPeriodo.Hotel;

public class Sistema extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Sistema janela;
	private static Hotel hotel;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					criaHotel();
					setTela(new LoginDeFuncionario());
				} catch (Exception e) {
					e.printStackTrace();
				}
				criaHotel();
				setTela(new LoginDeFuncionario());
				
			}
		});
	}


	private Sistema() {
		setTitle("Hotel Riviera Campina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	private static void iniciaSistema(){
		janela = new Sistema();
		janela.setVisible(true);
		
	}
	
	public static void setTela(JPanel novaTela) {
		if(janela == null) iniciaSistema();

		if(novaTela == null)
			throw new IllegalArgumentException();

		janela.contentPane.removeAll();
		janela.contentPane.add(novaTela);
		janela.repaint();
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
