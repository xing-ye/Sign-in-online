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
 static JFrame jf = new JFrame("�ɼ�����ϵͳ");
	private static void firtPage() {
		// 1.���ô����С�ͱ���
		jf.setPreferredSize(new Dimension(660, 700));
		// 2.���ùرմ��ھ��ǹرճ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �׼�Ĳ���ģʽ�ղ���
		jf.setLayout(null);
		// ���ö�λ
		JLabel jl = new JLabel("ѧ��ǩ��ϵͳ", JLabel.CENTER);
		jl.setPreferredSize(new Dimension(680, 30));
		jf.add(jl);
		jl.setBounds(0, 0, 690, 30);
		jl.setFont(new Font("����", Font.BOLD, 24));
		jl.setForeground(Color.decode("#375a7f"));
		// �˵���
		// �½�һ���˵���
		JMenuBar jb = new JMenuBar();
		jf.add(jb);
		jb.setBounds(0, 40, 690, 30);
		jb.setBackground(Color.decode("#65991a"));
		// �½�һ���˵�ѡ��
		JMenu jmenu = new JMenu("ͼ��Ա�");
		jmenu.setPreferredSize(new Dimension(220, 30));
		jmenu.setForeground(Color.white);
		jb.add(jmenu);
		JMenuItem jmm = new JMenuItem("��ʼ�Ա�");
		jmenu.add(jmm);
        JTextField t1;
        t1 =new JTextField(25);
        t1.setFont(new Font("����",Font.BOLD,25));
        JLabel nameLabel = new JLabel("�û���");
        nameLabel.setFont(new Font("����",Font.BOLD,25));
        nameLabel.setHorizontalAlignment(JTextField.CENTER);
		// �½�һ���˵���
        
		JMenu jmenu0 = new JMenu("δǩ������");
		jmenu0.setPreferredSize(new Dimension(220, 30));
		jmenu0.setForeground(Color.white);
		jb.add(jmenu0);
		// �½�һ���˵���
		JMenuItem jmm1 = new JMenuItem("ǩ���ɹ�");
		JMenuItem jm = new JMenuItem("��Ƭ��Ч");
		JMenuItem jmi = new JMenuItem("δ�ϴ���Ƭ");
		jmenu0.add(jmm1);
		jmenu0.add(jm);
		jmenu0.add(jmi);
		// �½�һ���˵�ѡ��
		JMenu jmenu1 = new JMenu("ͼ��");
		jmenu1.setForeground(Color.white);
		jmenu1.setPreferredSize(new Dimension(220, 30));
		jb.add(jmenu1);
		// �½�һ���˵���
		JMenuItem jm0 = new JMenuItem("��״ͼ");
		jmenu1.add(jm0);
		// ��������ʾλ�Ƶĵط�
		// ����ͼƬ
		JLabel jl3 = new JLabel(new ImageIcon("back.jpg"));
		jf.add(jl3);
		jl3.setBounds(0, 80, 700, 700);
		//��ʼ�����¼�
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
  				//���ٵ�ǰҳ��
  				//closeThis();
  				JFrame frame=new JFrame("Java����ͳ��ͼ");
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
		// 3.���ô���ɼ�
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