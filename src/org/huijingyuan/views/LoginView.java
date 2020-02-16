package org.huijingyuan.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.huijingyuan.dao.UserDao;
import org.huijingyuan.entity.User;
import org.huijingyuan.ults.JdbcService;
import org.huijingyuan.ults.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u5C0F\u61D2\u4EBA\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/org/huijingyuan/image/book.png")));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("方正兰亭超细黑简体", Font.PLAIN, 21));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/org/huijingyuan/image/user.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setIcon(new ImageIcon(LoginView.class.getResource("/org/huijingyuan/image/password_2.png")));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//test();
				test();
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/org/huijingyuan/image/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			textField_1.setText("");
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginView.class.getResource("/org/huijingyuan/image/format_2.png")));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(76)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_3)
									.addComponent(lblNewLabel_1))
								.addGap(18))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNewButton_1)
								.addGap(41))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
								.addContainerGap())))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(90)
						.addComponent(lblNewLabel)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * 设置登录验证
	 */
	
	//验证输入字符串是否为空
	private void test() {
		// TODO Auto-generated method stub
	String user_name	=  textField_1.getText();
	String password     =       new String(passwordField.getPassword());
	JdbcService  jdbcs=new JdbcService();
	UserDao dao=new UserDao();
	User  u=null;
		
	if(StringUtil.isNotEmpty(user_name)&&StringUtil.isNotEmpty(password)) {
		
		
		 User us=new User(user_name,password);
		 Connection con;
		try {
			con = jdbcs.getCon();
			  u= dao.login(con, us);
			     jdbcs.closeCon(con);	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	dispose();
		  new MainView().setVisible(true);
		 
	}else {
		
		JOptionPane.showMessageDialog(null, "输入信息不完整");
	}
	
			
	}
}
