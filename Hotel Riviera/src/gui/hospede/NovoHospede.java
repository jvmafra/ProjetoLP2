package gui.hospede;

import nucleo.excecoes.EntradaDeDadosException;
import gui.Sistema;
import gui.contratos.NovoContrato;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;

import nucleo.classes.pessoa.Hospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NovoHospede extends JPanel {
	private JTextField nome;
	private JTextField cpf;
	private JTextField rg;
	private JTextField idade;
	private JTextField email;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField numCartao;
	private boolean vemDoContrato;
	
	public NovoHospede(boolean vemDoContrato) {
		this.vemDoContrato = vemDoContrato;
		setBackground(new Color(51, 102, 153));
		MaskFormatter format = null;
		MaskFormatter format_1 = null;
		MaskFormatter format_2 = null;
		MaskFormatter format_3 = null;

		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.setBounds(322, 135, 177, 28);
		add(nome);
		nome.setColumns(10);
		
		try {
			format = new MaskFormatter("###.###.###-##");
			format.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		cpf = new JFormattedTextField(format);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cpf.setToolTipText("");
		cpf.setBounds(322, 184, 177, 28);
		add(cpf);
		cpf.setColumns(10);
	

		
		JLabel nome_1 = new JLabel("Nome:");
		nome_1.setForeground(new Color(255, 255, 255));
		nome_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		nome_1.setBounds(266, 141, 70, 15);
		add(nome_1);
		
		JLabel cpf_1 = new JLabel("CPF:");
		cpf_1.setForeground(new Color(255, 255, 255));
		cpf_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		cpf_1.setBounds(281, 190, 70, 15);
		add(cpf_1);
		
		JLabel rg_1 = new JLabel("RG:");
		rg_1.setForeground(new Color(255, 255, 255));
		rg_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		rg_1.setBounds(281, 235, 70, 15);
		add(rg_1);
		
//		try {
//			format_1 = new MaskFormatter("#.###.###");
//			format_1.setPlaceholderCharacter('_');
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
		
		rg = new JFormattedTextField(format_1);
		rg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rg.setBounds(322, 229, 177, 28);
		add(rg);
		rg.setColumns(10);
		
		JLabel idade_1 = new JLabel("Idade: ");
		idade_1.setForeground(new Color(255, 255, 255));
		idade_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		idade_1.setBounds(266, 280, 70, 15);
		add(idade_1);
		
		idade = new JTextField();
		idade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idade.setBounds(322, 274, 177, 28);
		add(idade);
		idade.setColumns(10);
		
		JLabel email_1 = new JLabel("E-mail:");
		email_1.setForeground(new Color(255, 255, 255));
		email_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		email_1.setBounds(266, 326, 70, 15);
		add(email_1);
		
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setBounds(322, 320, 177, 28);
		add(email);
		email.setColumns(10);
		
		JLabel endereco_1 = new JLabel("Endereco:");
		endereco_1.setForeground(new Color(255, 255, 255));
		endereco_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		endereco_1.setBounds(242, 375, 70, 15);
		add(endereco_1);
		
		endereco = new JTextField();
		endereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		endereco.setBounds(322, 369, 177, 28);
		add(endereco);
		endereco.setColumns(10);
		
		JLabel telefone_1 = new JLabel("Telefone:");
		telefone_1.setForeground(new Color(255, 255, 255));
		telefone_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		telefone_1.setBounds(245, 425, 70, 15);
		add(telefone_1);
		
		try {
			format_2 = new MaskFormatter("(##)####-####");
			format_2.setPlaceholderCharacter('_');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		telefone = new JFormattedTextField(format_2);
		telefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telefone.setText("(  )       -    ");
		telefone.setBounds(322, 419, 177, 28);
		add(telefone);
		telefone.setColumns(10);
		
		
		try {
			format_3 = new MaskFormatter("####.####.####.####");
			format_3.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel numCartao_1 = new JLabel("Numero de cartao:");
		numCartao_1.setForeground(new Color(255, 255, 255));
		numCartao_1.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		numCartao_1.setBounds(183, 475, 127, 15);
		add(numCartao_1);
		
		numCartao = new JFormattedTextField();
		numCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numCartao.setBounds(322, 469, 177, 28);
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
		btnVoltar.setBounds(166, 535, 117, 25);
		add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(new Color(51, 102, 153));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaCaixas();	
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(349, 535, 117, 25);
		add(btnLimpar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setForeground(new Color(51, 102, 153));
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Hospede hospede = new Hospede(nome.getText(), cpf.getText()
							.replace(".", "").replace("-", ""), rg.getText()
							.replace(".", ""), idade.getText(), email.getText(),
							telefone.getText(), endereco.getText(), numCartao
									.getText().replace(".", ""));
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
		btnConcluir.setBounds(536, 535, 117, 25);
		add(btnConcluir);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NovoHospede.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(334, 22, 169, 89);
		add(lblNewLabel);

	}
	
	private void limpaCaixas(){
		nome.setText("");
		cpf.setText("");
		rg.setText("");
		email.setText("");
		telefone.setText("");
		numCartao.setText("");
		idade.setText("");
		endereco.setText("");
	}
	
	private boolean vemDoContrato(){
		return vemDoContrato;
	}
}