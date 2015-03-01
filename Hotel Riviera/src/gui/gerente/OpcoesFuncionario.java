package gui.gerente;

import gui.Sistema;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import nucleo.classes.pessoa.Funcionario;
public class OpcoesFuncionario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Funcionario> list;

	public OpcoesFuncionario() {
		setBackground(new Color(51, 102, 153));
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setForeground(new Color(51, 102, 153));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new NovoFuncionario());
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNovo.setBounds(524, 261, 90, 30);
		add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					JOptionPane.showMessageDialog(null, "Selecione um funcionário primeiro");
				else
					Sistema.setTela(new EditaFuncionario(list.getSelectedValue()));					
			}
		});
		btnEditar.setForeground(new Color(51, 102, 153));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(524, 353, 90, 30);
		add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new OpcoesPrivadas());
			}
		});
		btnVoltar.setBounds(378, 510, 90, 30);
		add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 193, 286, 266);
		add(scrollPane);
		list = new JList<Funcionario>();
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setBackground(new Color(51, 102, 153));
		list.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		final DefaultListModel<Funcionario> listModel = new DefaultListModel<Funcionario>();

		for (int i = 0; i < Sistema.getHotel().getFuncionarios().size(); i++) {
			listModel.addElement(Sistema.getHotel().getFuncionarios().get(i));
			}
		list.setModel(listModel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OpcoesFuncionario.class.getResource("/nucleo/icones/hotel4.png")));
		lblNewLabel.setBounds(346, 31, 141, 94);
		add(lblNewLabel);
	}

}
