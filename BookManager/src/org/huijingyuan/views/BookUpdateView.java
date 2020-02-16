package org.huijingyuan.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.huijingyuan.dao.BookDao;
import org.huijingyuan.entity.Book;
import org.huijingyuan.ults.JdbcService;
import org.huijingyuan.ults.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookUpdateView extends JInternalFrame {
	private JTextField bookname_1;
	private JTable table;
	private JTextField bookname_2;
	private JTextField bookauther;
	private JTextField booktype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUpdateView frame = new BookUpdateView();
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
	public BookUpdateView() {
		setMaximizable(true);
		setClosable(true);
		setEnabled(false);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		setBounds(100, 100, 450, 300);
		
		bookname_1 = new JTextField();
		bookname_1.setColumns(10);
		//根据图书名查图书的按钮以及其事件
		JButton btnNewButton = new JButton("\u6309\u56FE\u4E66\u540D\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String booknamep=bookname_1.getText();
				DefaultTableModel model=  (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				if(StringUtil.isNotEmpty(booknamep)) {
					JdbcService js=new JdbcService();
					BookDao bd=new BookDao();
					Connection con=null;
					try {
						 con=js.getCon();
						ResultSet re=bd.queryBookByName(con, booknamep);
						while(re.next()) {
							Vector v=new Vector();
							v.add(re.getString("bookname"));
							v.add(re.getString("booktype"));
							v.add(re.getString("bookauther"));
							model.addRow(v);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						try {
							js.closeCon(con);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					
					
				}else {
					JOptionPane.showMessageDialog(null,"输入内容为空");
				}
				
				
				
				
			}
		});
		//查询全部图书按钮
		JButton button = new JButton("\u67E5\u8BE2\u6240\u6709\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JdbcService js=new JdbcService();
				DefaultTableModel model=  (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				ResultSet re=null;
				try {
					Connection con=js.getCon();
					BookDao bookdao=new BookDao();
					re=bookdao.queryAllBook(con);
					while(re.next()) {
						Vector v=new Vector();
						v.add(re.getString("bookname"));
						v.add(re.getString("booktype"));
						v.add(re.getString("bookauther"));
						model.addRow(v);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u4E66\u540D");
		
		JLabel label_1 = new JLabel("\u4F5C\u8005");
		
		bookname_2 = new JTextField();
		bookname_2.setEditable(false);
		bookname_2.setColumns(10);
		
		bookauther = new JTextField();
		bookauther.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		//修改图书模块
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String booknamep=	bookname_2.getText();
				String booktypep=	booktype.getText();
				String bookautherp=	bookauther.getText();
				if(StringUtil.isEmpty(booknamep)) {
					JOptionPane.showMessageDialog(null,"图书名称为空");
					return;
				}
				if(StringUtil.isEmpty(booktypep)) {
					JOptionPane.showMessageDialog(null,"图书类别为空");
					return;
				}
				if(StringUtil.isEmpty(booknamep)) {
					JOptionPane.showMessageDialog(null,"图书作者为空");
					return;
				}
				
				
				Book book=new Book(booknamep,booktypep,bookautherp);
				
				JdbcService js=new JdbcService();
				BookDao bd=new BookDao();
				Connection con=null;
				try {
					con=js.getCon();
					int i=	bd.updateBook(con, book);
					if(i==1) {
						JOptionPane.showMessageDialog(null,"图书信息修改完成");
					}else{
						JOptionPane.showMessageDialog(null,"图书信息修改失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						js.closeCon(con);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname_p=bookname_2.getText();
				JdbcService js=new JdbcService();
				BookDao bd=new BookDao();
				Connection con=null;
				if(StringUtil.isNotEmpty(bookname_p)) {
					try {
						con=js.getCon();
						int i=	bd.deleteBookByName(con, bookname_p);
						if(i>0) {
							JOptionPane.showMessageDialog(null,"图书删除成功");
						}else {
							JOptionPane.showMessageDialog(null,"没有该类图书名");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						try {
							js.closeCon(con);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					
				}
				
				
				
				
				
				
				
				
			}
		});
		
		booktype = new JTextField();
		booktype.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(bookname_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(booktype, Alignment.LEADING)
								.addComponent(bookname_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
						.addComponent(button_1))
					.addGap(35)
					.addComponent(label_1)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(button_2)
							.addGap(35))
						.addComponent(bookauther, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
					.addGap(89))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookname_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookname_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookauther, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(booktype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int i=table.getSelectedRow();
				String book_name=(String)table.getValueAt(i, 0);
				String book_type=(String)table.getValueAt(i, 1);
				String book_ahther=(String)table.getValueAt(i, 2);
				bookname_2.setText(book_name);
				booktype.setText(book_type);
				bookauther.setText(book_ahther);
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u7684\u540D\u79F0", "\u4E66\u7684\u7C7B\u522B", "\u4E66\u7684\u4F5C\u8005"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
