package DealMesaage;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class showno extends JFrame{    
	
	@SuppressWarnings("null")
	public showno() {        
		super();        
		setTitle("δ����ͼƬ");        
		setBounds(200, 200, 480, 300);        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		//��������������        
		String[] columnNames= {"A","B"};        
		//��������������        
		String[][] tableValues1 = new String[100][2];
		
		File xlsFile2=new File("poi2.xls");
		 //�õ�������
	     Workbook workbook2 = null;
		try {
			workbook2 = WorkbookFactory.create(xlsFile2);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     //�õ�������
	     Sheet sheet2=workbook2.getSheetAt(0);
	     //��excle��õ�����
	     int m=0;
	      for (int row = 1; row < sheet2.getLastRowNum()+1; row++)
	      {
	         Row r=sheet2.getRow(row);
	         
	         Cell cell = r.getCell(2);
        	 cell.setCellType(CellType.STRING);
        	 if(r.getCell(2).getStringCellValue().equals("2"))
        	{
        		 Cell cell1 = r.getCell(1);
            	 cell1.setCellType(CellType.STRING);
            	 Cell cell2 = r.getCell(2);
            	 cell2.setCellType(CellType.STRING);
            	 tableValues1[m][0]=r.getCell(0).getStringCellValue();
        		 tableValues1[m][1]=r.getCell(1).getStringCellValue();
        		 m++;
            }
        	 
	      }
	      try {
			workbook2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		//����ָ�����������ݵı��        
		JTable table =new JTable(tableValues1,columnNames);        
		//������ʾ���Ĺ������        
		JScrollPane scrollpane=new JScrollPane(table);        
		//�����������ӵ��߽粼�ֵ��м�       
		getContentPane().add(scrollpane,BorderLayout.CENTER);            
		}
	
	}
