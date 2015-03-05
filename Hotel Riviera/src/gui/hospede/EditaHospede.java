package gui.hospede;

import gui.Sistema;

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

public class EditaHospede extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nome, cpf, rg, idade, email, endereco;
	private JTextField telefone, numCartao, txtCep;
	private JButton btnBuscaCep;
	private Hospede hospede;
	private MaskFormatter format;
	private buscaCEP busca = new buscaCEP();

	/**
	 * Create the panel.
	 */
	public EditaHospede(Hospede h) {
		setBackground(new Color(51, 102, 153));
		this.hospede = h;
		setBounds(0, 0, 800, 600);
		setLayout(null);

		nome = new JTextField();
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

		rg = new JTextField();
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
		endereco.setBounds(145, 430, 525, 30);
		add(endereco);
		endereco.setColumns(10);

		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setForeground(new Color(255, 255, 255));
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(422, 218, 70, 15);
		add(telefone_1);

		try {
			format = new MaskFormatter("(##)####-####");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		telefone = new JFormattedTextField(format);
		telefone.setBounds(499, 210, 177, 30);
		telefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					rg.grabFocus();
			}
		});
		telefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(telefone);
		telefone.setColumns(10);

		JLabel numCartao_1 = new JLabel("Numero de cartao:");
		numCartao_1.setForeground(new Color(255, 255, 255));
		numCartao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		numCartao_1.setBounds(360, 268, 127, 15);
		add(numCartao_1);

		try {
			format = new MaskFormatter("####.####.####.####");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		numCartao = new JFormattedTextField(format);
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
				Sistema.setTela(new OpcoesDoHospede());
			}

		});
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(168, 516, 90, 30);
		add(btnVoltar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificaHospede(hospede);
			}
		});
		btnSalvar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnSalvar.setBounds(482, 516, 90, 30);
		add(btnSalvar);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				EditaHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(334, 11, 177, 95);
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
		txtCep.setBounds(196, 380, 148, 28);
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
					String bairro = busca.getBairro(CEP);
					String cidade = busca.getCidade(CEP);
					String end = busca.getEndereco(CEP);
					String uf = busca.getUF(CEP);

					endereco.setText(end + " - " + bairro + " - " + cidade
							+ "-" + uf);

				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,
							"A busca não pôde ser realizada\n"
									+ "Verifique sua conexão com a internet");
				}
			}
		});
		btnBuscaCep.setBounds(399, 378, 117, 30);
		btnBuscaCep.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		add(btnBuscaCep);

		preencheFormulario();
	}

	private void preencheFormulario() {
		nome.setText(hospede.getNome());
		cpf.setText(hospede.getCPF());
		rg.setText(hospede.getRG());
		idade.setText(hospede.getIdade());
		email.setText(hospede.getEmail());
		endereco.setText(hospede.getEndereco());
		telefone.setText(hospede.getTelefone());
		numCartao.setText(hospede.getNumCartao());
	}

	private void ModificaHospede(Hospede h) {
		try {
			h.setNome(nome.getText());
			h.setCpf(cpf.getText().replace(".", "").replace("-", ""));
			h.setEmail(email.getText());
			h.setEndereco(endereco.getText());
			h.setIdade(idade.getText());
			h.setRg(rg.getText().replace(".", ""));
			h.setTelefone(telefone.getText().replace("-", "").replace("(", "")
					.replace(")", ""));
			h.setNumCartao(numCartao.getText().replace(".", ""));
			Sistema.setTela(new OpcoesDoHospede());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}