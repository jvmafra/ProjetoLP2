package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Quartos.QuartoExecutivoDuplo;
import classes.Quartos.QuartoExecutivoSimples;
import classes.Quartos.QuartoExecutivoTriplo;
import classes.Quartos.QuartoLuxoDuplo;
import classes.Quartos.QuartoLuxoSimples;
import classes.Quartos.QuartoLuxoTriplo;
import classes.Quartos.QuartoPresidencial;

public class SelecaoQuartos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField diaria;
	JRadioButton presidencial;
	JRadioButton luxosimples;
	JRadioButton luxoduplo;
	JRadioButton luxotriplo;
	JRadioButton executivosimples;
	JRadioButton executivoduplo;
	JRadioButton executivotriplo;
	JCheckBox cama_extra;
	
	private final Action selecionaPresidencial = new SwingAction();
	private final Action selecionaLuxoSimples = new SwingAction_1();
	private final Action selecionaLuxoDuplo = new SwingAction_2();
	private final Action selecionaLuxoTriplo = new SwingAction_3();
	private final Action selecionaExecutivoSimples = new SwingAction_4();
	private final Action selecionaExecutivoDuplo = new SwingAction_5();
	private final Action selecionaExecutivoTriplo = new SwingAction_6();
	private final Action marcaCamaExtra = new SwingAction_7();
	private JTextField adicional;
	

	/**
	 * Create the frame.
	 */
	public SelecaoQuartos() {
		ButtonGroup bg = new ButtonGroup(); 
		
		presidencial = new JRadioButton("Presidencial");
		presidencial.setBounds(205, 240, 97, 25);
		presidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(false);
			}
		});
		presidencial.setAction(selecionaPresidencial);
		presidencial.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(presidencial);
		
		luxosimples = new JRadioButton("Luxo Simples");
		luxosimples.setBounds(205, 156, 103, 25);
		luxosimples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(true);
			}
		});
		luxosimples.setAction(selecionaLuxoSimples);
		luxosimples.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(luxosimples);
		
		luxoduplo = new JRadioButton("Luxo Duplo");
		luxoduplo.setBounds(205, 184, 93, 25);
		luxoduplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(true);
			}
		});
		
		luxoduplo.setAction(selecionaLuxoDuplo);
		luxoduplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(luxoduplo);
		
		luxotriplo = new JRadioButton("Luxo Triplo");
		luxotriplo.setBounds(205, 212, 93, 25);
		luxotriplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(false);
			}
		});
		luxotriplo.setAction(selecionaLuxoTriplo);
		luxotriplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(luxotriplo);
		
		executivosimples = new JRadioButton("Executivo Simples");
		executivosimples.setBounds(205, 68, 133, 25);
		executivosimples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(true);
			}
		});
		executivosimples.setAction(selecionaExecutivoSimples);
		executivosimples.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(executivosimples);
		
		executivoduplo = new JRadioButton("Executivo Duplo");
		executivoduplo.setBounds(205, 96, 123, 25);
		executivoduplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(true);
			}
		});
		executivoduplo.setAction(selecionaExecutivoDuplo);
		executivoduplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(executivoduplo);
		
		executivotriplo = new JRadioButton("Executivo Triplo");
		executivotriplo.setBounds(205, 124, 121, 25);
		executivotriplo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cama_extra.setVisible(false);
			}
		});
		executivotriplo.setAction(selecionaExecutivoTriplo);
		executivotriplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		bg.add(executivotriplo);
		setLayout(null);
		
		
		
		//java.awt.Container c = getContentPane(); 
		add(presidencial); 
		add(luxosimples); 
		add(luxoduplo); 
		add(luxotriplo);
		add(executivosimples);
		add(executivoduplo);
		add(executivotriplo);
		
		
		cama_extra = new JCheckBox("Cama extra");
		cama_extra.setBounds(385, 157, 93, 25);
		cama_extra.setAction(marcaCamaExtra);
		cama_extra.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		cama_extra.setVisible(false);
		
		JLabel diaria1 = new JLabel("Di\u00E1ria: R$");
		diaria1.setBounds(86, 282, 59, 17);
		diaria1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		diaria = new JTextField();
		diaria.setBounds(205, 281, 86, 20);
		diaria.setEditable(false);
		diaria.setColumns(10);
		
		JButton botao_voltar = new JButton("Voltar");
		botao_voltar.setBounds(123, 392, 69, 25);
		botao_voltar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JLabel adicional1 = new JLabel("Adicional: R$");
		adicional1.setBounds(86, 334, 78, 17);
		adicional1.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		adicional = new JTextField();
		adicional.setBounds(205, 333, 86, 20);
		adicional.setEditable(false);
		adicional.setColumns(10);
		add(cama_extra);
		add(diaria1);
		add(diaria);
		add(botao_voltar);
		add(adicional1);
		add(adicional);
		
		JButton avancar = new JButton("Avan\u00E7ar");
		avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new DadosDaReserva());
				repaint();
				
			}
		});
		avancar.setBounds(332, 392, 83, 25);
		avancar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		add(avancar);
		
//		GroupLayout groupLayout = new GroupLayout(########        ERRO AQUI           #########);
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(176)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(presidencial)
//						.addComponent(executivotriplo)
//						.addComponent(executivoduplo)
//						.addComponent(executivosimples, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
//						.addComponent(luxotriplo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
//						.addComponent(luxoduplo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
//						.addComponent(luxosimples, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
//					.addContainerGap())
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(29)
//					.addComponent(botao_voltar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
//					.addComponent(avancar)
//					.addGap(42))
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(85)
//					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
//						.addComponent(diaria1)
//						.addComponent(adicional1))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addComponent(diaria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//						.addComponent(adicional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
//					.addComponent(cama_extra)
//					.addGap(102))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addGap(38)
//					.addComponent(presidencial)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(luxosimples, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(luxoduplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(luxotriplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(executivosimples, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(executivoduplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(executivotriplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
//						.addGroup(groupLayout.createSequentialGroup()
//							.addGap(18)
//							.addComponent(cama_extra))
//						.addGroup(groupLayout.createSequentialGroup()
//							.addPreferredGap(ComponentPlacement.UNRELATED)
//							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//								.addComponent(diaria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//								.addComponent(diaria1))
//							.addPreferredGap(ComponentPlacement.RELATED)
//							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//								.addComponent(adicional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//								.addComponent(adicional1))
//							.addGap(18)
//							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
//								.addComponent(botao_voltar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
//								.addComponent(avancar))
//							.addContainerGap())))
//		);
//		setLayout(groupLayout);

	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Presidencial");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto presidental");
		}
		public void actionPerformed(ActionEvent e) {
			diaria.setText(String.valueOf(QuartoPresidencial.VALOR_DA_DIARIA));
			if (cama_extra.isSelected()){
				retiraCamaExtra();
			}	
				
		}
	
	}
	private class SwingAction_1 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Luxo Simples");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto de luxo simples");
		}
		public void actionPerformed(ActionEvent e) {		
			diaria.setText(String.valueOf(QuartoLuxoSimples.VALOR_DA_DIARIA));
			if (cama_extra.isSelected())
				colocaAdicional();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Luxo Duplo");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto de luxo duplo");
		}
		public void actionPerformed(ActionEvent e) {
			diaria.setText(String.valueOf(QuartoLuxoDuplo.VALOR_DA_DIARIA));
			if (cama_extra.isSelected())
				colocaAdicional();
		}
	}
	
	private class SwingAction_3 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_3() {
			putValue(NAME, "Luxo Triplo");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto de luxo triplo");
		}
		public void actionPerformed(ActionEvent e) {
			diaria.setText(String.valueOf(QuartoLuxoTriplo.VALOR_DA_DIARIA));
			if (cama_extra.isSelected())
				retiraCamaExtra();
		}
	}
	private class SwingAction_4 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_4() {
			putValue(NAME, "Executivo Simples");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto executivo simples");
		}
		public void actionPerformed(ActionEvent e) {
			diaria.setText(String.valueOf(QuartoExecutivoSimples.VALOR_DA_DIARIA));
			if (cama_extra.isSelected())
				colocaAdicional();
		}	
	}
	private class SwingAction_5 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_5() {
			putValue(NAME, "Executivo Duplo");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto executivo duplo");
		}
		public void actionPerformed(ActionEvent e) {
				diaria.setText(String.valueOf(QuartoExecutivoDuplo.VALOR_DA_DIARIA));
				if (cama_extra.isSelected())
					colocaAdicional();
		}
	}
	private class SwingAction_6 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_6() {
			putValue(NAME, "Executivo Triplo");
			putValue(SHORT_DESCRIPTION, "Seleciona um quarto executivo tirplo");
		}
		public void actionPerformed(ActionEvent e) {
			diaria.setText(String.valueOf(QuartoExecutivoTriplo.VALOR_DA_DIARIA));
			if (cama_extra.isSelected())
				retiraCamaExtra();
		}
	}
	private class SwingAction_7 extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SwingAction_7() {
			putValue(NAME, "Cama extra");
			putValue(SHORT_DESCRIPTION, "Marque se deseja que seja adicionada uma cama extra");
		}
		public void actionPerformed(ActionEvent e) {
			if (cama_extra.isSelected())
				if (luxosimples.isSelected() || luxoduplo.isSelected() || executivosimples.isSelected() || executivoduplo.isSelected())
					colocaAdicional();
				else{
					mensagemErro();
					desmarcaCaixa();
				}
			else
				retiraAdicional();
		}
	
	}
	
	private void retiraAdicional() {
		adicional.setText("");
	}
	private void colocaAdicional() {
		adicional.setText("20,00");
	}
	private void mensagemErro() {
		JOptionPane.showMessageDialog(null, "Esse quarto não possui a opção de cama extra.");
	}
	
	private void desmarcaCaixa() {
		cama_extra.setSelected(false);
	}
	
	private void retiraCamaExtra() {
		retiraAdicional();
		desmarcaCaixa();
		mensagemErro();
	}
	
}
