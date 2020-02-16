package org.huijingyuan.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.huijingyuan.dao.BookDao;
import org.huijingyuan.dao.BooktypeDao;
import org.huijingyuan.entity.Book;
import org.huijingyuan.ults.JdbcService;
import org.huijingyuan.ults.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddBookView extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_2;
	private String bookName;
	private String bookType;
	private String auther;
	JComboBox booktype_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookView frame = new AddBookView();
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
	public AddBookView() {
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("\u5F55\u5165\u56FE\u4E66\u4FE1\u606F");
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u5B57");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 bookName=textField.getText();
			     bookType=(String)booktype_1.getSelectedItem();
				 auther=textField_2.getText();
				Boolean b=  StringUtil.isEmpty(bookName)||StringUtil.isEmpty(bookType)||StringUtil.isEmpty(auther);
				if(b==true) {
					JOptionPane.showMessageDialog(null, "所填信息不全");
					
				}else {
					/**
					 * 将图书信息信息加到数据库中
					 */
					Book book=new Book(bookName,bookType,auther);
					BookDao bookdao=new BookDao();
				 int i=	bookdao.addBook(book);
				 if(i==1) {
					JOptionPane.showMessageDialog(null,"图书添加成功");
					textField.setText("");
					textField_2.setText("");
					
				 }
					
					
					
				}
				
			}
		});
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				
				textField_2.setText("");
				
			}

			private JTextField setText(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		/**
		 * 初始化一个列表，并且添加内容
		 */
		booktype_1 = new JComboBox();
		fillBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(booktype_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_2)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(button)
						.addComponent(booktype_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
	}
	
	private void fillBox() {
		JdbcService js=new JdbcService();
		BooktypeDao btd=new BooktypeDao();
		Connection con = null;
		try {
			con = js.getCon();
			ResultSet re= btd.queryBooktype(con);
			while(re.next()) {
				String booktype=re.getString("booktype");
				booktype_1.addItem(booktype);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				js.closeCon(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
}
