package DealMesaage;
import java.awt.Font;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

//import com.sun.java_cup.internal.runtime.Scanner;
import java.util.Scanner;
public class barchart {
	
	ChartPanel frame1;
	public  barchart(String temp){
		CategoryDataset dataset = getDataSet(temp);
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "��״ͼ", // ͼ�����
                            "���", // Ŀ¼�����ʾ��ǩ
                            "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
         
         BarRenderer customBarRenderer = (BarRenderer) plot.getRenderer();

         customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//��ʾÿ��������ֵ
         customBarRenderer.setBaseItemLabelsVisible(true);
         //ע�⣺�˾�ܹؼ������޴˾䣬�����ֵ���ʾ�ᱻ���ǣ���������û����ʾ����������
         customBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
         ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
         customBarRenderer.setItemLabelAnchorOffset(10D);// ��������ͼ�ϵ�����ƫ��ֵ
         customBarRenderer.setItemLabelsVisible(true); 
         
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
          
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������
          
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
         
	}
	   private static CategoryDataset getDataSet(String temp) {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           try
           {
           File fxls=new File(temp);
           Workbook workbook=WorkbookFactory.create(fxls);
           Sheet sheet=workbook.getSheetAt(0);
           int rows = sheet.getLastRowNum();
           Scanner sc = new Scanner(System.in);
           int j=0,num=0,k=0;
           for (int row = 1; row < rows+1; row++)
 	      {
 	         Row r=sheet.getRow(row);
 	            // ��ָ���ļ��������еõ�����
	        	 Cell cell6 = r.getCell(2);
 	        	 cell6.setCellType(CellType.STRING);
                  if(r.getCell(2).getStringCellValue().equals("1")) {j++;}
                  else if(r.getCell(2).getStringCellValue().equals("0")) {num++;}
                  else {k++;}

 	      }
           dataset.addValue(num,"ǩ������","ǩ������");
           dataset.addValue(j,"��Ƭ��Ч","��Ƭ��Ч");
           dataset.addValue(k,"δ�ϴ���Ƭ","δ�ϴ���Ƭ");
           dataset.addValue(k+j+num,"������","������");
           workbook.close();
           }
           catch(Exception e)
           {
        	   
           }
           return dataset;
}
public ChartPanel getChartPanel(){
	return frame1;
	
}

}
