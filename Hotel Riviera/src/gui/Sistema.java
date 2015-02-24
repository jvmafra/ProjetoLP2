package gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import nucleo.classes.arquivo.Arquivos;
import nucleo.classes.hotel.Hotel;

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
				
//				try {
//					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
				criaHotel();
				setTela(new LoginDeFuncionario(false));
			}
		});
	}


	private Sistema() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Arquivos.salvaHotel(hotel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setTitle("Hotel Riviera Campina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		//this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}
	private static void iniciaSistema(){
		janela = new Sistema();
		janela.setVisible(true);
		
	}
	
	public static void setTela(JPanel novaTela) {
		if(janela == null) iniciaSistema();

		if(novaTela == null)
			System.out.println("Pode isso nao");
		janela.contentPane.removeAll();
		janela.contentPane.add(novaTela);
		janela.revalidate();
	}
	
	public static Hotel getHotel() {
		if (hotel == null){
			criaHotel();
			}
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
	
	public static Calendar DateToCalendar(Date data){
		Calendar cal = null;
		cal= new GregorianCalendar();
		cal.setTime(data);  
		return cal;
	}

}
