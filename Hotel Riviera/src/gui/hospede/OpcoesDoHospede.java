package gui.hospede;
import gui.PaginaInicialHotel;
import gui.Sistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import nucleo.classes.pessoa.Hospede;

/**
 * Mostra a visao geral dos hospedes ja cadastrados no hotel. Pode-se:
 * ABRIR, EDITAR E CRIAR UM NOVO HOSPEDE 
 */
public class OpcoesDoHospede extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JList<Hospede> list;

	/**
	 * Create the panel.
	 */
	public OpcoesDoHospede() {
		setBackground(new Color(51, 102, 153));
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.setForeground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(537, 290, 90, 30);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sistema.setTela(new NovoHospede(false));
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(new Color(51, 102, 153));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sistema.setTela(new PaginaInicialHotel());
			}
		});
		btnVoltar.setBounds(359, 521, 90, 30);
		add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(OpcoesDoHospede.class.getResource("/nucleo/icones/hotel4 feito.png")));
		lblNewLabel.setBounds(334, 12, 144, 120);
		add(lblNewLabel);

		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(150, 171, 359, 30);
		add(textField);
		textField.setColumns(10);

		JLabel lblDigiteONome = new JLabel(
				"Digite o nome ou o CPF do hospede:");
		lblDigiteONome.setForeground(new Color(255, 255, 255));
		lblDigiteONome.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblDigiteONome.setBounds(154, 131, 280, 41);
		add(lblDigiteONome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 222, 335, 261);
		add(scrollPane);

		list = new JList<Hospede>();
		list.setFont(new Font("Dialog", Font.PLAIN, 13));
		list.setBackground(new Color(51, 102, 153));
		list.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(list);
		final DefaultListModel<Hospede> listModel = new DefaultListModel<Hospede>();

		for (int i = 0; i < Sistema.getHotel().getHospedes().size(); i++) {
			listModel.addElement(Sistema.getHotel().getHospedes().get(i));
			}
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(51, 102, 153));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String busca = textField.getText();
				if (busca.length() < 4){
					JOptionPane.showMessageDialog(null,
							"Seja mais especifico em sua busca");
					}
				else {
					listModel.clear();
					try {
						Long.parseLong(busca);
						for (int i = 0; i < Sistema.getHotel().getHospedes()
								.size(); i++) {
							if (Sistema.getHotel().getHospedes().get(i)
									.getCPF().contains(busca))
								listModel.addElement(Sistema.getHotel()
										.getHospedes().get(i));
						
						}
					} catch (Exception e) {
						for (int i = 0; i < Sistema.getHotel().getHospedes()
								.size(); i++) {
							if (Sistema.getHotel().getHospedes().get(i)
									.getNome().contains(busca))
								listModel.addElement(Sistema.getHotel()
										.getHospedes().get(i));
						}
					}
					
				}
			}
		});
		list.setModel(listModel);
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnBuscar.setBounds(537, 170, 90, 30);
		add(btnBuscar);

		JLabel lblResultadosDaSua = new JLabel("Resultados da busca:");
		lblResultadosDaSua.setForeground(new Color(255, 255, 255));
		lblResultadosDaSua.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		lblResultadosDaSua.setBounds(176, 169, 241, 30);
		add(lblResultadosDaSua);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setForeground(new Color(51, 102, 153));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null)
					mostraTelaDeErro();
				else
					Sistema.setTela(new ExibeHospede(list.getSelectedValue()));
			}
		});
		btnAbrir.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnAbrir.setBounds(537, 346, 90, 30);
		add(btnAbrir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedValue() != null)
					Sistema.setTela(new EditaHospede(list.getSelectedValue()));
				else
					mostraTelaDeErro();
			}
		});
		btnEditar.setForeground(new Color(51, 102, 153));
		btnEditar.setFont(new Font("NanumGothic", Font.PLAIN, 14));
		btnEditar.setBounds(537, 405, 90, 30);
		add(btnEditar);
		
	}

	private void mostraTelaDeErro() {
		JOptionPane.showMessageDialog(null,	"Selecione um hospede antes");

	}
}