package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Arquivos;
import classes.HotelOpiniaoServicosPeriodo.Hotel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

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
			System.out.println("Pode isso não");
		janela.contentPane.removeAll();
		janela.contentPane.add(novaTela);
		janela.revalidate();
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
