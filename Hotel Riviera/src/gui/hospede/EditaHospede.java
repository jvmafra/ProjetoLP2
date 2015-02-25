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
import javax.swing.ImageIcon;

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
		setBackground(new Color(51, 102, 153));
		this.hospede = h;
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(322, 131, 177, 28);
		nome.setText(hospede.getNome());
		add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(322, 179, 177, 28);
		cpf.setText(hospede.getCPF());
		add(cpf);
		cpf.setColumns(10);
		
		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setForeground(new Color(255, 255, 255));
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		nome_1.setBounds(266, 136, 70, 15);
		add(nome_1);
		
		JLabel cpf_1 = new JLabel("CPF:");
		cpf_1.setForeground(new Color(255, 255, 255));
		cpf_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		cpf_1.setBounds(281, 184, 70, 15);
		add(cpf_1);
		
		JLabel rg_1 = new JLabel("RG:");
		rg_1.setForeground(new Color(255, 255, 255));
		rg_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		rg_1.setBounds(281, 235, 70, 15);
		add(rg_1);
		
		rg = new JTextField();
		rg.setBounds(322, 230, 177, 28);
		rg.setText(hospede.getRG());
		add(rg);
		rg.setColumns(10);
		
		JLabel idade_1 = new JLabel("Idade: ");
		idade_1.setForeground(new Color(255, 255, 255));
		idade_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		idade_1.setBounds(266, 284, 70, 15);
		add(idade_1);
		
		idade = new JTextField();
		idade.setBounds(322, 279, 177, 28);
		idade.setText(hospede.getIdade());
		add(idade);
		idade.setColumns(10);
		
		JLabel email_1 = new JLabel("E-mail:");
		email_1.setForeground(new Color(255, 255, 255));
		email_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		email_1.setBounds(266, 334, 70, 15);
		add(email_1);
		
		email = new JTextField();
		email.setBounds(322, 329, 177, 28);
		email.setText(hospede.getEmail());
		add(email);
		email.setColumns(10);
		
		JLabel endereco_1 = new JLabel("Endereco:");
		endereco_1.setForeground(new Color(255, 255, 255));
		endereco_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		endereco_1.setBounds(242, 386, 70, 15);
		add(endereco_1);
		
		endereco = new JTextField();
		endereco.setBounds(322, 381, 177, 28);
		endereco.setText(hospede.getEndereco());
		add(endereco);
		endereco.setColumns(10);
		
		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setForeground(new Color(255, 255, 255));
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(245, 436, 70, 15);
		add(telefone_1);
		
		telefone = new JTextField();
		telefone.setBounds(322, 431, 177, 28);
		telefone.setText(hospede.getTelefone());
		add(telefone);
		telefone.setColumns(10);
		
		JLabel numCartao_1 = new JLabel("Numero de cartao:");
		numCartao_1.setForeground(new Color(255, 255, 255));
		numCartao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		numCartao_1.setBounds(190, 485, 127, 15);
		add(numCartao_1);
		
		numCartao = new JTextField();
		numCartao.setBounds(322, 480, 177, 28);
		numCartao.setText(hospede.getNumCartao());
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
		btnVoltar.setBounds(166, 547, 117, 25);
		add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(51, 102, 153));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificaHospede(hospede);
			}
		});
		btnSalvar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnSalvar.setBounds(480, 547, 117, 25);
		add(btnSalvar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditaHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(334, 11, 177, 95);
		add(lblNewLabel);
		
		
	}
	private void ModificaHospede(Hospede h){
		try {
			h.setNome(nome.getText());
			h.setCpf(cpf.getText());
			h.setEmail(email.getText());
			h.setEndereco(endereco.getText());
			h.setIdade(idade.getText());
			h.setRg(rg.getText());
			h.setTelefone(telefone.getText());
			h.setNumCartao(numCartao.getText());
			Sistema.setTela(new OpcoesDoHospede());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,	e.getMessage());
		}
		
	}
	
	private Hospede getHospede(){
		return hospede;
	}
}