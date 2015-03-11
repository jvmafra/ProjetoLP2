package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import nucleo.classes.arquivo.Arquivos;
import nucleo.classes.hotel.Hotel;

public class Sistema extends JFrame {

	private static final long serialVersionUID = 1L;

	private static Sistema janela;
	private static Hotel hotel;
	private JPanel contentPane;
	private static JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (Exception e) {
				}

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
					e1.printStackTrace();
				}
			}
		});
		setTitle("Hotel Riviera Campina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setResizable(false);

		btnHome = new JButton("INÍCIO");
		btnHome.setForeground(new Color(51, 102, 153));
		btnHome.setIcon(null);
		btnHome.setBounds(10, 10, 90, 30);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
	}

	private static void iniciaSistema() {
		janela = new Sistema();
		janela.setVisible(true);

	}

	public static void setTela(JPanel novaTela) {
		if (janela == null)
			iniciaSistema();

		if (novaTela == null)
			System.err.println("Tela inválida");

		if (!(novaTela instanceof PaginaInicialHotel || novaTela instanceof LoginDeFuncionario))
			novaTela.add(btnHome);
		janela.contentPane.removeAll();
		janela.contentPane.add(novaTela);
		janela.repaint();
		janela.revalidate();

	}

	public static Hotel getHotel() {
		if (hotel == null) {
			criaHotel();
		}
		return hotel;

	}

	private static void criaHotel() {
		if (Arquivos.extisteHotel()) {
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

	public static Calendar DateToCalendar(Date data) {
		Calendar cal = null;
		cal = new GregorianCalendar();
		cal.setTime(data);
		return cal;
	}

	public static Calendar getHoje() {
		return new GregorianCalendar();
	}

}
