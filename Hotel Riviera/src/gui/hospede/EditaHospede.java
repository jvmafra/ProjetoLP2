package gui.hospede;

import gui.Sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nucleo.classes.pessoa.Hospede;

import javax.swing.JTextField;

import java.awt.Color;

public class EditaHospede extends JPanel {
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
	private Hospede hospede;
	/**
	 * Create the panel.
	 */
	public EditaHospede(Hospede h) {
		setBackground(Color.WHITE);

		this.hospede = h;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(322, 79, 177, 28);
		nome.setText(hospede.getNome());
		add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(322, 135, 177, 28);
		cpf.setText(hospede.getCPF());
		add(cpf);
		cpf.setColumns(10);
		
		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		nome_1.setBounds(266, 85, 70, 15);
		add(nome_1);
		
		JLabel cpf_1 = new JLabel("CPF:");
		cpf_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		cpf_1.setBounds(281, 141, 70, 15);
		add(cpf_1);
		
		JLabel rg_1 = new JLabel("RG:");
		rg_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		rg_1.setBounds(281, 196, 70, 15);
		add(rg_1);
		
		rg = new JTextField();
		rg.setBounds(322, 190, 177, 28);
		rg.setText(hospede.getRG());
		add(rg);
		rg.setColumns(10);
		
		JLabel idade_1 = new JLabel("Idade: ");
		idade_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		idade_1.setBounds(266, 248, 70, 15);
		add(idade_1);
		
		idade = new JTextField();
		idade.setBounds(322, 242, 177, 28);
		idade.setText(hospede.getIdade());
		add(idade);
		idade.setColumns(10);
		
		JLabel email_1 = new JLabel("E-mail:");
		email_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		email_1.setBounds(266, 306, 70, 15);
		add(email_1);
		
		email = new JTextField();
		email.setBounds(322, 300, 177, 28);
		email.setText(hospede.getEmail());
		add(email);
		email.setColumns(10);
		
		JLabel endereco_1 = new JLabel("Endereco:");
		endereco_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		endereco_1.setBounds(245, 359, 70, 15);
		add(endereco_1);
		
		endereco = new JTextField();
		endereco.setBounds(322, 353, 177, 28);
		endereco.setText(hospede.getEndereco());
		add(endereco);
		endereco.setColumns(10);
		
		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(245, 409, 70, 15);
		add(telefone_1);
		
		telefone = new JTextField();
		telefone.setBounds(322, 403, 177, 28);
		telefone.setText(hospede.getTelefone());
		add(telefone);
		telefone.setColumns(10);
		
		JLabel numCartao_1 = new JLabel("Numero de cartao:");
		numCartao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		numCartao_1.setBounds(183, 457, 127, 15);
		add(numCartao_1);
		
		numCartao = new JTextField();
		numCartao.setBounds(322, 451, 177, 28);
		numCartao.setText(hospede.getNumeroCartao());
		add(numCartao);
		numCartao.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(165, 513, 117, 25);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificaHospede(hospede);
				Sistema.setTela(new ConsultaHospede());
			}
		});
		btnSalvar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnSalvar.setBounds(481, 513, 117, 25);
		add(btnSalvar);
		
		
	}
	private void ModificaHospede(Hospede h){
		h.setNome(nome.getText());
		h.setCpf(cpf.getText());
		h.setEmail(email.getText());
		h.setEndereco(endereco.getText());
		h.setIdade(idade.getText());
		h.setRg(rg.getText());
		try {
			h.setTelefone(telefone.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,	e.getMessage());
		}
		h.setNumCartao(numCartao.getText());
	}
	
	private Hospede getHospede(){
		return hospede;
	}
}