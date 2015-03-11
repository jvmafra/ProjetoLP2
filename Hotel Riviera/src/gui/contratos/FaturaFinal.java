package gui.contratos;

import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nucleo.classes.pessoa.Contrato;

public class FaturaFinal extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea servicos;
	private Contrato contrato;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumCartao;
	private JTextField textFieldQuarto;
	private JTextField textFieldValorQuarto;
	private JTextField textFieldServicos;
	private JTextField textFieldMulta;
	private JTextField textFieldTotal;

	/**
	 * Create the panel.
	 */
	public FaturaFinal(Contrato contrato) {
		this.contrato = contrato;
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnOK = new JButton("Voltar aos contratos\r\n");
		btnOK.setForeground(new Color(51, 102, 153));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesDeContrato());			
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOK.setBounds(544, 516, 161, 30);
		add(btnOK);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VisualizaContrato.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(326, 11, 161, 105);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(462, 145, 290, 360);
		
		servicos = new JTextArea();
		servicos.setBackground(new Color(51, 102, 153));
		servicos.setForeground(new Color(255, 255, 255));
		servicos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		servicos.setText(getContrato().imprimeCadaServicoEspecial());
		servicos.setEditable(false);
		
		scrollPane.setViewportView(servicos);
		add(scrollPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(27, 151, 173, 38);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(272, 145, 200, 50);
		add(lblCpf);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogradouro.setBounds(27, 207, 200, 50);
		add(lblLogradouro);
		
		JLabel lblNumeroDoCartao = new JLabel("Numero do cartao");
		lblNumeroDoCartao.setForeground(Color.WHITE);
		lblNumeroDoCartao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroDoCartao.setBounds(27, 268, 200, 50);
		add(lblNumeroDoCartao);
		
		JLabel lblQuartoAlugado = new JLabel("Quarto alugado");
		lblQuartoAlugado.setForeground(Color.WHITE);
		lblQuartoAlugado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuartoAlugado.setBounds(27, 329, 200, 50);
		add(lblQuartoAlugado);
		
		JLabel lblValorDosServios = new JLabel("Valor dos servi\u00E7os: R$");
		lblValorDosServios.setForeground(Color.WHITE);
		lblValorDosServios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorDosServios.setBounds(79, 410, 200, 50);
		add(lblValorDosServios);
		
		JLabel lblMultaR = new JLabel("Multa: R$");
		lblMultaR.setForeground(Color.WHITE);
		lblMultaR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMultaR.setBounds(153, 450, 200, 50);
		add(lblMultaR);
		
		JLabel lblValorTotalR = new JLabel("Valor a pagar: R$");
		lblValorTotalR.setForeground(Color.WHITE);
		lblValorTotalR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorTotalR.setBounds(109, 496, 200, 50);
		add(lblValorTotalR);
		
		JLabel lblPeriodo = new JLabel("Diarias");
		lblPeriodo.setForeground(Color.WHITE);
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPeriodo.setBounds(334, 329, 200, 50);
		add(lblPeriodo);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNome.setForeground(new Color(51, 102, 153));
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(27, 182, 222, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldCPF.setForeground(new Color(51, 102, 153));
		textFieldCPF.setEditable(false);
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(273, 182, 179, 30);
		add(textFieldCPF);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setForeground(new Color(51, 102, 153));
		textFieldLogradouro.setEditable(false);
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(27, 243, 302, 30);
		add(textFieldLogradouro);
		
		textFieldNumCartao = new JTextField();
		textFieldNumCartao.setForeground(new Color(51, 102, 153));
		textFieldNumCartao.setEditable(false);
		textFieldNumCartao.setColumns(10);
		textFieldNumCartao.setBounds(27, 302, 302, 30);
		add(textFieldNumCartao);
		
		textFieldQuarto = new JTextField();
		textFieldQuarto.setForeground(new Color(51, 102, 153));
		textFieldQuarto.setEditable(false);
		textFieldQuarto.setColumns(10);
		textFieldQuarto.setBounds(27, 369, 290, 30);
		add(textFieldQuarto);
		
		textFieldValorQuarto = new JTextField();
		textFieldValorQuarto.setForeground(new Color(51, 102, 153));
		textFieldValorQuarto.setColumns(10);
		textFieldValorQuarto.setBounds(333, 369, 92, 30);
		add(textFieldValorQuarto);
		
		textFieldServicos = new JTextField();
		textFieldServicos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldServicos.setForeground(new Color(51, 102, 153));
		textFieldServicos.setEditable(false);
		textFieldServicos.setColumns(10);
		textFieldServicos.setBounds(222, 418, 124, 30);
		add(textFieldServicos);
		
		textFieldMulta = new JTextField();
		textFieldMulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldMulta.setForeground(new Color(51, 102, 153));
		textFieldMulta.setEditable(false);
		textFieldMulta.setColumns(10);
		textFieldMulta.setBounds(222, 459, 124, 34);
		add(textFieldMulta);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setForeground(new Color(51, 102, 153));
		textFieldTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(222, 507, 124, 30);
		add(textFieldTotal);
		
		modificaCampos();

	}
	
	public Contrato getContrato(){
		return contrato;
	}
	
	public void modificaCampos() {
		textFieldNome.setText(getContrato().getNome());
		textFieldCPF.setText(getContrato().getCPF());
		textFieldLogradouro.setText(getContrato().getEndereco());
		textFieldNumCartao.setText(getContrato().getHospede().getNumCartao());
		textFieldQuarto.setText(getContrato().getQuarto().toString());
		textFieldValorQuarto.setText(String.valueOf(getContrato().getPeriodo().getNumeroDias()));
		textFieldServicos.setText(String.valueOf(getContrato().calculaValorServicos()));
		textFieldMulta.setText(String.valueOf(getContrato().calculaMulta()));
		textFieldTotal.setText(String.valueOf(getContrato().calculaValorTotal()));
		
	}
	

}