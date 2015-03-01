package gui.hospede;

import gui.Sistema;
import gui.contratos.NovoContrato;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import nucleo.classes.arquivo.buscaCEP;
import nucleo.classes.pessoa.Hospede;
import nucleo.excecoes.EntradaDeDadosException;

public class NovoHospede extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nome;
	private JTextField cpf;
	private JTextField rg;
	private JTextField idade;
	private JTextField email;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField numCartao;
	private boolean vemDoContrato;
	private buscaCEP busca = new buscaCEP();
	private JTextField txtCep;
	private JButton btnBuscaCep;

	public NovoHospede(boolean vemDoContrato) {
		this.vemDoContrato = vemDoContrato;
		setBackground(new Color(51, 102, 153));
		MaskFormatter format = null;
		MaskFormatter format_1 = null;
		MaskFormatter format_2 = null;
		MaskFormatter format_3 = null;

		setBounds(0, 0, 800, 600);
		setLayout(null);

		try {
			format = new MaskFormatter(maskNome());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		nome = new JFormattedTextField(format);
		
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					idade.grabFocus();
			}
		});
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.setBounds(130, 160, 372, 30);
		add(nome);
		nome.setColumns(10);

		try {
			format = new MaskFormatter("###.###.###-##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cpf = new JFormattedTextField(format);
		cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					rg.grabFocus();
			}
		});
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cpf.setToolTipText("");
		cpf.setBounds(130, 210, 127, 30);
		add(cpf);
		cpf.setColumns(10);

		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setForeground(new Color(255, 255, 255));
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		nome_1.setBounds(75, 169, 70, 15);
		add(nome_1);

		JLabel cpf_1 = new JLabel("CPF:");
		cpf_1.setForeground(new Color(255, 255, 255));
		cpf_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		cpf_1.setBounds(75, 218, 70, 15);
		add(cpf_1);

		JLabel rg_1 = new JLabel("RG:");
		rg_1.setForeground(new Color(255, 255, 255));
		rg_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		rg_1.setBounds(75, 267, 70, 15);
		add(rg_1);

		rg = new JFormattedTextField(format_1);
		rg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					numCartao.grabFocus();
			}
		});
		rg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rg.setBounds(130, 260, 127, 30);
		add(rg);
		rg.setColumns(10);

		JLabel idade_1 = new JLabel("Idade: ");
		idade_1.setForeground(new Color(255, 255, 255));
		idade_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		idade_1.setBounds(523, 169, 70, 15);
		add(idade_1);

		idade = new JTextField();
		idade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					cpf.grabFocus();
			}
		});
		idade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idade.setBounds(585, 160, 91, 30);
		add(idade);
		idade.setColumns(10);

		JLabel email_1 = new JLabel("E-mail:");
		email_1.setForeground(new Color(255, 255, 255));
		email_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		email_1.setBounds(72, 318, 64, 15);
		add(email_1);

		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtCep.grabFocus();
			}
		});
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setBounds(130, 310, 372, 30);
		add(email);
		email.setColumns(10);

		JLabel endereco_1 = new JLabel("Endereco:");
		endereco_1.setForeground(new Color(255, 255, 255));
		endereco_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		endereco_1.setBounds(65, 435, 70, 15);
		add(endereco_1);

		endereco = new JTextField();
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		endereco.setBounds(145, 429, 525, 30);
		add(endereco);
		endereco.setColumns(10);

		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setForeground(new Color(255, 255, 255));
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(422, 218, 70, 15);
		add(telefone_1);

		try {
			format_2 = new MaskFormatter("(##)####-####");
			format_2.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		telefone = new JFormattedTextField(format_2);
		telefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					rg.grabFocus();
			}
		});
		telefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telefone.setBounds(499, 210, 177, 30);
		add(telefone);
		telefone.setColumns(10);

		JLabel numCartao_1 = new JLabel("Numero de cartao:");
		numCartao_1.setForeground(new Color(255, 255, 255));
		numCartao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		numCartao_1.setBounds(360, 268, 127, 15);
		add(numCartao_1);

		try {
			format_3 = new MaskFormatter("####.####.####.####");
			format_3.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		numCartao = new JFormattedTextField(format_3);
		numCartao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					email.grabFocus();
			}
		});
		numCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numCartao.setBounds(499, 260, 177, 30);
		add(numCartao);
		numCartao.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vemDoContrato())
					Sistema.setTela(new NovoContrato());
				else
					Sistema.setTela(new OpcoesDoHospede());

			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(166, 513, 90, 30);
		add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(51, 102, 153));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCaixas();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(349, 513, 90, 30);
		add(btnLimpar);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(new Color(51, 102, 153));
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Hospede hospede = new Hospede(nome.getText(), cpf.getText()
							.replace(".", "").replace("-", ""), rg.getText()
							.replace(".", ""), idade.getText(),
							email.getText(), telefone.getText(), endereco
									.getText(), numCartao.getText().replace(
									".", ""));
					Sistema.getHotel().adicionaHospede(hospede);
					JOptionPane.showMessageDialog(null, "Hospede criado!");
					if (vemDoContrato())
						Sistema.setTela(new NovoContrato());
					else
						Sistema.setTela(new OpcoesDoHospede());
				} catch (EntradaDeDadosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConcluir.setBounds(536, 513, 90, 30);
		add(btnConcluir);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovoHospede.class
				.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(334, 22, 169, 89);
		add(lblNewLabel);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnBuscaCep.grabFocus();
			}
		});
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCep.setColumns(10);
		txtCep.setBounds(196, 380, 148, 30);
		add(txtCep);

		JLabel lbCEP = new JLabel("Busque pelo CEP:");
		lbCEP.setForeground(Color.WHITE);
		lbCEP.setFont(new Font("Dialog", Font.PLAIN, 14));
		lbCEP.setBounds(65, 386, 121, 15);
		add(lbCEP);

		btnBuscaCep = new JButton("Busca CEP");
		btnBuscaCep.setForeground(new Color(51, 102, 153));
		btnBuscaCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String CEP = txtCep.getText();
				try {
					String end = busca.getEndereco(CEP);
					String bairro = busca.getBairro(CEP);
					String cidade = busca.getCidade(CEP);
					String uf = busca.getUF(CEP);

					endereco.setText(end + " - " + bairro
							+ " - " + cidade + "-" + uf);

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,
							"A busca não pôde ser realizada\n"
									+ "Verifique sua conexão com a internet");
				}
			}
		});
		btnBuscaCep.setBounds(398, 379, 117, 30);
		btnBuscaCep.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(btnBuscaCep);

	}

	private void limpaCaixas() {
		nome.setText("");
		cpf.setText("");
		rg.setText("");
		email.setText("");
		telefone.setText("");
		numCartao.setText("");
		idade.setText("");
		endereco.setText("");
	}

	private boolean vemDoContrato() {
		return vemDoContrato;
	}

	private String maskNome() {
		String nome = "";
		for (int i = 0; i < 50; i++) {
			nome += "U";
		}
		return nome;

	}
}