package org.huijingyuan.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class myInfView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myInfView frame = new myInfView();
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
	public myInfView() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblMyInformation = new JLabel("my information");
		lblMyInformation.setIcon(new ImageIcon(myInfView.class.getResource("/org/huijingyuan/image/book.png")));
		getContentPane().add(lblMyInformation, BorderLayout.CENTER);

	}

}
