package org.huijingyuan.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//将窗口这只为最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("\u6570\u636E\u7EF4\u62A4");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_3.add(mnNewMenu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		//设置添加图书的功能
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBookView innerView=new AddBookView();
				innerView.setVisible(true);
				desktopPane.add(innerView);
				
				
			}
		});
		mnNewMenu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUpdateView buv=new BookUpdateView();
				buv.setVisible(true);
				desktopPane.add(buv);
			
			}
		});
		mnNewMenu_1.add(menuItem_3);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_3.add(mnNewMenu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooktypeView  abtv =new AddBooktypeView();
				abtv.setVisible(true);
				desktopPane.add(abtv);
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBooktypeView  qbv=new QueryBooktypeView();
				qbv.setVisible(true);
				desktopPane.add(qbv);
			
			}
			
		});
		mnNewMenu.add(menuItem_4);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int b=	JOptionPane.showConfirmDialog(null, "是否要退出");
				if(b==0) {
					dispose();
				}
			}
		});
		mnNewMenu_3.add(menuItem);
		
		JMenu mnNewMenu_5 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u6211\u4EEC\u7684\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myInfView innerView=new myInfView();
				innerView.setVisible(true);
				desktopPane.add(innerView);
				
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
