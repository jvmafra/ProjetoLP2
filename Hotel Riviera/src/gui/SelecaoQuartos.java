package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SelecaoQuartos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecaoQuartos frame = new SelecaoQuartos();
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
	public SelecaoQuartos() {
		setFrameIcon(new ImageIcon("C:\\Users\\Mafra\\git\\Hotel Riviera\\src\\icones\\cama2.png"));
		setTitle("Selecionar quarto");
		setBounds(100, 100, 494, 384);
		
		JRadioButton presidencial = new JRadioButton("Presidencial");
		presidencial.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton luxosimples = new JRadioButton("Luxo Simples");
		luxosimples.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton luxoduplo = new JRadioButton("Luxo Duplo");
		luxoduplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton luxotriplo = new JRadioButton("Luxo Triplo");
		luxotriplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton executivosimples = new JRadioButton("Executivo Simples");
		executivosimples.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton executivoduplo = new JRadioButton("Executivo Duplo");
		executivoduplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JRadioButton executivotriplo = new JRadioButton("Executivo Triplo");
		executivotriplo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		
		JCheckBox cama_extra = new JCheckBox("Cama extra");
		cama_extra.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		
		JButton avancar = new JButton("Avan\u00E7ar");
		avancar.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(presidencial)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(executivotriplo)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(executivoduplo)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(executivosimples, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(luxotriplo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(luxoduplo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(luxosimples, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(165, Short.MAX_VALUE)))))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(196, Short.MAX_VALUE)
					.addComponent(avancar)
					.addGap(193))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(279, Short.MAX_VALUE)
					.addComponent(cama_extra)
					.addGap(102))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(presidencial)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(luxosimples, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(luxoduplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(luxotriplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(executivosimples, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(executivoduplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(executivotriplo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cama_extra)
					.addGap(18)
					.addComponent(avancar)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
