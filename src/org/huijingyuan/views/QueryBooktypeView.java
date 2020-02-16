package org.huijingyuan.views;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.huijingyuan.dao.BooktypeDao;
import org.huijingyuan.entity.BookType;
import org.huijingyuan.ults.StringUtil;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QueryBooktypeView extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_booktype;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryBooktypeView frame = new QueryBooktypeView();
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
	public QueryBooktypeView() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u67E5\u8BE2");
		setClosable(true);
		setBounds(100, 100, 450, 450);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text=textField.getText();
				ResultSet resultset=null;
				
				StringUtil su=new StringUtil();
				DefaultTableModel model=  (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				if(su.isNotEmpty(text)) {
					BooktypeDao btd=new BooktypeDao();
					try {
						resultset=btd.queryBookType(text);
						
						while(resultset.next()) {
							Vector vector=new Vector();
							vector.add(resultset.getInt("id"));
							vector.add(resultset.getString("booktype"));
							vector.add(resultset.getString("bookdes"));
							
						 model.addRow(vector);
							
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"输入内容为空");
				}
				
				
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u5168\u90E8\u7C7B\u522B");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=  (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				BooktypeDao btd=new BooktypeDao();
				ResultSet resultset=null;
				try {
					resultset=btd.queryAllBookType();
					
					while(resultset.next()) {
						Vector vector=new Vector();
						vector.add(resultset.getInt("id"));
						vector.add(resultset.getString("booktype"));
						vector.add(resultset.getString("bookdes"));
						
					 model.addRow(vector);
						
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(button_2)
					.addContainerGap(53, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(button_2))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B");
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u63CF\u8FF0");
		
		textField_booktype = new JTextField();
		textField_booktype.setColumns(10);
		
		JTextArea textArea_bookdes = new JTextArea();
		
		/**
		 * 修改button，并且给其添加事件
		 */
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String booktype=	textField_booktype.getText();
				String bookdes =	textArea_bookdes.getText();
				BookType  booktype1=new BookType(booktype,bookdes);
				BooktypeDao  btd=new BooktypeDao();
				try {
					int i=btd.updataBooktype(booktype1);
					if(i==1) {
						JOptionPane.showMessageDialog(null,"修改成功");
					}else {
						JOptionPane.showMessageDialog(null,"修改失败");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		/**
		 * 删除图书种类的button
		 */
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String booktype=	textField_booktype.getText();
				boolean b=StringUtil.isNotEmpty(booktype);
				if(b) {
				
				
					BooktypeDao btd=new BooktypeDao();
					try {
						int count=btd.deleteBooktype(booktype);
						if(count==1) {
							JOptionPane.showMessageDialog(null,"删除成功");
						}
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"所选内容为空");
				}
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(28)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_booktype)
								.addComponent(textArea_bookdes, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_booktype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(textArea_bookdes, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int i=table.getSelectedRow();
				String booktype_name=(String)table.getValueAt(i, 1);
				String booktype_des=(String)table.getValueAt(i, 2);
				
				textField_booktype.setText(booktype_name);
				textArea_bookdes.setText(booktype_des);
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D", "\u63CF\u8FF0\u56FE\u4E66\u7C7B"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
}
