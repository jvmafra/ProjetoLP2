package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
// pagina sistema, nathaniel criou. Deve ter sido a janela que gustavin mito falou.
public class Sistema {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema window = new Sistema();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new LoginDeFuncionario();
		frame.setBounds(100, 100, 749, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
