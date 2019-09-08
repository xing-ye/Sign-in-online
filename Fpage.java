package DealMesaage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import org.apache.poi.EncryptedDocumentException;

import  DealMesaage.barchart;

public class Fpage {
 static JFrame jf = new JFrame("成绩分析系统");
	private static void firtPage() {
		// 1.设置窗体大小和标题
		jf.setPreferredSize(new Dimension(660, 700));
		// 2.设置关闭窗口就是关闭程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 最精准的布局模式空布局
		jf.setLayout(null);
		// 设置定位
		JLabel jl = new JLabel("学生签到系统", JLabel.CENTER);
		jl.setPreferredSize(new Dimension(680, 30));
		jf.add(jl);
		jl.setBounds(0, 0, 690, 30);
		jl.setFont(new Font("宋体", Font.BOLD, 24));
		jl.setForeground(Color.decode("#375a7f"));
		// 菜单栏
		// 新建一个菜单条
		JMenuBar jb = new JMenuBar();
		jf.add(jb);
		jb.setBounds(0, 40, 690, 30);
		jb.setBackground(Color.decode("#65991a"));
		// 新建一个菜单选项
		JMenu jmenu = new JMenu("图像对比");
		jmenu.setPreferredSize(new Dimension(220, 30));
		jmenu.setForeground(Color.white);
		jb.add(jmenu);
		JMenuItem jmm = new JMenuItem("开始对比");
		jmenu.add(jmm);
        JTextField t1;
        t1 =new JTextField(25);
        t1.setFont(new Font("宋体",Font.BOLD,25));
        JLabel nameLabel = new JLabel("用户名");
        nameLabel.setFont(new Font("宋体",Font.BOLD,25));
        nameLabel.setHorizontalAlignment(JTextField.CENTER);
		// 新建一个菜单项
        
		JMenu jmenu0 = new JMenu("未签到人数");
		jmenu0.setPreferredSize(new Dimension(220, 30));
		jmenu0.setForeground(Color.white);
		jb.add(jmenu0);
		// 新建一个菜单项
		JMenuItem jmm1 = new JMenuItem("签到成功");
		JMenuItem jm = new JMenuItem("照片无效");
		JMenuItem jmi = new JMenuItem("未上传照片");
		jmenu0.add(jmm1);
		jmenu0.add(jm);
		jmenu0.add(jmi);
		// 新建一个菜单选项
		JMenu jmenu1 = new JMenu("图形");
		jmenu1.setForeground(Color.white);
		jmenu1.setPreferredSize(new Dimension(220, 30));
		jb.add(jmenu1);
		// 新建一个菜单项
		JMenuItem jm0 = new JMenuItem("柱状图");
		jmenu1.add(jm0);
		// 以下是显示位移的地方
		// 放置图片
		JLabel jl3 = new JLabel(new ImageIcon("back.jpg"));
		jf.add(jl3);
		jl3.setBounds(0, 80, 700, 700);
		//开始监听事件
jmm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ReadExcle.readexcel("a.xls");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		jmm1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new shouname().setVisible(true);
			}
		});
         jm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new showme().setVisible(true);
			}
		});
         jmi.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				new showno().setVisible(true);
 			}
 		});
         
         jm0.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				//销毁当前页面
  				//closeThis();
  				JFrame frame=new JFrame("Java数据统计图");
  				frame.setLayout(new GridLayout(2,2,10,10));
  				
  				try {
  					frame.add(new barchart("poi2.xls").getChartPanel());
  				} catch (EncryptedDocumentException e1) {
  					// TODO Auto-generated catch block
  					e1.printStackTrace();
  				}
  				frame.setBounds(50, 50, 1000, 800);
  				frame.setVisible(true);
  			}
  		});
		// 3.设置窗体可见
		jf.pack();
		jf.setVisible(true);
	}
	public static void closeThis(){
		jf.dispose();
		}
	public static void main(String[] args) {
		firtPage();
	}
}