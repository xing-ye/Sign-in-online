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
       		                 "柱状图", // 图表标题
                            "类别", // 目录轴的显示标签
                            "人数", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         
         BarRenderer customBarRenderer = (BarRenderer) plot.getRenderer();

         customBarRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值
         customBarRenderer.setBaseItemLabelsVisible(true);
         //注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
         customBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
         ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
         customBarRenderer.setItemLabelAnchorOffset(10D);// 设置柱形图上的文字偏离值
         customBarRenderer.setItemLabelsVisible(true); 
         
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
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
 	            // 在指定文件工作表中得到数据
	        	 Cell cell6 = r.getCell(2);
 	        	 cell6.setCellType(CellType.STRING);
                  if(r.getCell(2).getStringCellValue().equals("1")) {j++;}
                  else if(r.getCell(2).getStringCellValue().equals("0")) {num++;}
                  else {k++;}

 	      }
           dataset.addValue(num,"签到人数","签到人数");
           dataset.addValue(j,"照片无效","照片无效");
           dataset.addValue(k,"未上传照片","未上传照片");
           dataset.addValue(k+j+num,"总人数","总人数");
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
