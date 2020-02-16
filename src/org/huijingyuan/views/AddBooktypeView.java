package org.huijingyuan.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.huijingyuan.dao.BooktypeDao;
import org.huijingyuan.entity.BookType;
import org.huijingyuan.ults.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBooktypeView extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooktypeView frame = new AddBooktypeView();
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
	public AddBooktypeView() {
		setClosable(true);
		setTitle("\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
		
			
			
			public void actionPerformed(ActionEvent e) {
				String booktype=	textField.getText();
				String bookdes=	textArea.getText();
				StringUtil stringutl=new StringUtil();
				boolean i=StringUtil.isNotEmpty(booktype);
				boolean t=StringUtil.isNotEmpty(bookdes);
				
				if(i&&t) {
					BookType booktyp=new BookType(booktype,bookdes);
					BooktypeDao  booktypedao=new BooktypeDao();
					int n=  booktypedao.addType(booktyp);
					if(n==1) {
						JOptionPane.showMessageDialog(null, "图书类别添加成功");
					}
				}else {
					JOptionPane.showMessageDialog(null, "信息输入不全");
				}
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textArea)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(58)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1)
								.addComponent(button))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(41)
							.addComponent(button_1)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
