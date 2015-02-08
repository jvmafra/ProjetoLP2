package gui.opcoesdogerente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NovaRefeicao extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public NovaRefeicao() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel lblData = new JLabel("Data: ");
		lblData.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblData.setBounds(288, 196, 70, 15);
		add(lblData);
		
		JSpinner data_refeicao = new JSpinner();
		data_refeicao.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		data_refeicao.setModel(new SpinnerDateModel(new Date(1423360800000L), null, null, Calendar.DAY_OF_YEAR));
		data_refeicao.setBounds(339, 193, 143, 20);
		add(data_refeicao);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblValor.setBounds(288, 243, 70, 15);
		add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(339, 241, 114, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnConcluir.setBounds(469, 327, 117, 25);
		add(btnConcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnLimpar.setBounds(336, 327, 117, 25);
		add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnVoltar.setBounds(196, 327, 117, 25);
		add(btnVoltar);

	}
}
