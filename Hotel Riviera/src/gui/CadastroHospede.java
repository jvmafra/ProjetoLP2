package gui;

import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import classes.HotelOpiniaoServicosPeriodo.Hotel;
import classes.Pessoa.Hospede;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JToolBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;


public class CadastroHospede extends JFrame {
	private JTextField nome;
	private JFormattedTextField cpf;
	private JTextField rg;
	private JTextField telefone;
	private JTextField email;
	private JTextField endereco;
	private final Action action = new SwingAction();
	private JFormattedTextField numCartao;
	
	Hotel hotel = new Hotel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHospede frame = new CadastroHospede();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroHospede() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroHospede.class.getResource("/icones/hotel22.png")));
		setTitle("Cadastro");
		
		setBounds(100, 100, 737, 503);
		
		MaskFormatter format = null;
		
		
		try {
			format = new MaskFormatter("###.###.###-##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		try {
			format = new MaskFormatter("#######");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		try {
			format = new MaskFormatter("####.####.####.####");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		JButton concluir = new JButton("Concluir");
		concluir.setBounds(594, 384, 91, 28);
		concluir.setAction(action);
		concluir.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JButton limpar = new JButton("Limpar");
		limpar.setBounds(435, 384, 131, 28);
		limpar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome.setText("");
				cpf.setText("");
				rg.setText("");
				telefone.setText("");
				email.setText("");
				endereco.setText("");
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(limpar);
		getContentPane().add(concluir);
				
				JPanel MargemGeral = new JPanel();
				MargemGeral.setBounds(12, 12, 713, 463);
				getContentPane().add(MargemGeral);
				MargemGeral.setLayout(null);
				
				JPanel DadosHospedes = new JPanel();
				DadosHospedes.setBounds(13, 14, 662, 119);
				MargemGeral.add(DadosHospedes);
				DadosHospedes.setBorder(new TitledBorder(null, "Dados do hospede.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				DadosHospedes.setLayout(null);
				
				JLabel nome_1 = new JLabel("Nome");
				nome_1.setBounds(12, 20, 39, 12);
				DadosHospedes.add(nome_1);
				nome_1.setFont(new Font("Dialog", Font.PLAIN, 10));
				
				nome = new JTextField();
				nome.setBounds(61, 20, 145, 19);
				DadosHospedes.add(nome);
				nome.setColumns(10);
				
				JLabel cpf_1 = new JLabel("CPF");
				cpf_1.setBounds(18, 50, 28, 18);
				DadosHospedes.add(cpf_1);
				cpf_1.setFont(new Font("Dialog", Font.PLAIN, 10));
				cpf = new JFormattedTextField(format);
				cpf.setBounds(61, 50, 96, 19);
				DadosHospedes.add(cpf);
				cpf.setColumns(10);
				
				JLabel email_1 = new JLabel("E-mail");
				email_1.setBounds(12, 88, 44, 18);
				DadosHospedes.add(email_1);
				email_1.setFont(new Font("Dialog", Font.PLAIN, 10));
				
				email = new JTextField();
				email.setBounds(61, 85, 165, 19);
				DadosHospedes.add(email);
				email.setColumns(10);
				rg = new JFormattedTextField(format);
				rg.setBounds(61, 120, 96, 19);
				DadosHospedes.add(rg);
				rg.setColumns(10);
				
				JLabel rg_1 = new JLabel("RG");
				rg_1.setBounds(20, 120, 22, 18);
				DadosHospedes.add(rg_1);
				rg_1.setFont(new Font("Dialog", Font.PLAIN, 10));
				
						telefone = new JTextField();
						telefone.setBounds(353, 20, 134, 19);
						DadosHospedes.add(telefone);
						telefone.setColumns(10);
						
						JLabel telefone_1 = new JLabel("Telefone");
						telefone_1.setBounds(290, 20, 62, 18);
						DadosHospedes.add(telefone_1);
						telefone_1.setFont(new Font("Dialog", Font.PLAIN, 10));
						
						endereco = new JTextField();
						endereco.setBounds(353, 55, 134, 19);
						DadosHospedes.add(endereco);
						endereco.setColumns(10);
						
						JLabel endereco_1 = new JLabel("Endere\u00E7o");
						endereco_1.setBounds(290, 55, 56, 13);
						DadosHospedes.add(endereco_1);
						endereco_1.setFont(new Font("Dialog", Font.PLAIN, 10));
						
						JLabel lblCarto = new JLabel("Cart\u00E3o");
						lblCarto.setBounds(290, 90, 49, 18);
						DadosHospedes.add(lblCarto);
						lblCarto.setFont(new Font("Dialog", Font.PLAIN, 10));
						numCartao = new JFormattedTextField(format);
						numCartao.setBounds(353, 90, 134, 19);
						DadosHospedes.add(numCartao);
						numCartao.setColumns(10);
						
						JPanel EstrategiasPagamento = new JPanel();
						EstrategiasPagamento.setBounds(361, 198, 311, 113);
						MargemGeral.add(EstrategiasPagamento);
						EstrategiasPagamento.setBorder(new TitledBorder(null, "Estratégia de cobrança.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						EstrategiasPagamento.setLayout(null);
						
						JPanel QuartosDisponiveis = new JPanel();
						QuartosDisponiveis.setBounds(13, 198, 299, 253);
						MargemGeral.add(QuartosDisponiveis);
						QuartosDisponiveis.setBorder(new TitledBorder(null, "Quartos disponiveis.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						QuartosDisponiveis.setLayout(null);
						
						JSpinner Data_inicial = new JSpinner();
						Data_inicial.setBounds(99, 32, 188, 20);
						Data_inicial.setModel(new SpinnerDateModel(new Date(1423018800000L), new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
						QuartosDisponiveis.add(Data_inicial);
						
						JSpinner Data_final = new JSpinner();
						Data_final.setBounds(99, 64, 188, 20);
						Data_final.setModel(new SpinnerDateModel(new Date(1423018800000L), new Date(1423018800000L), null, Calendar.DAY_OF_YEAR));
						QuartosDisponiveis.add(Data_final);
						
						JLabel inicio = new JLabel("Inicio");
						inicio.setBounds(12, 34, 70, 15);
						QuartosDisponiveis.add(inicio);
						
						JLabel lblFinal = new JLabel("Final");
						lblFinal.setBounds(12, 66, 70, 15);
						QuartosDisponiveis.add(lblFinal);
						
						JButton btnPesquisar = new JButton("Pesquisar");
						btnPesquisar.setBounds(109, 96, 117, 25);
						QuartosDisponiveis.add(btnPesquisar);
						
						JList list = new JList();
						list.setBounds(30, 134, 243, 49);
						QuartosDisponiveis.add(list);
						DefaultListModel d = new DefaultListModel();
						for (int i = 0; i < hotel.getQuartos().size(); i++) {
							d.addElement(hotel.getQuartos().get(i));
						}
						list.setModel(d);
						  
						
						
						
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{concluir, limpar, telefone_1, telefone, nome_1, cpf_1, rg_1, email_1, rg, email, nome, cpf, endereco_1, numCartao, endereco, lblCarto}));

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Concluir");
			putValue(SHORT_DESCRIPTION, "Cadastro de hospede");
		}
		public void actionPerformed(ActionEvent e) {	
			try {
				Hospede hospede = new Hospede(nome.getText(), cpf.getText().replace(".","").replace("-",""), 
						rg.getText().replace(".",""), "18", email.getText(), telefone.getText(), 
						endereco.getText(), numCartao.getText().replace(".",""));
				JOptionPane.showMessageDialog(null, "Hospede criado!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}
}