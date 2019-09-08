package DealMesaage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

//import java.io.BufferedReader; 
//import java.io.InputStreamReader; 

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
 
public class ReadExcle {

	@SuppressWarnings("deprecation")
	public static void readexcel(String temp) throws IOException
	   {
		FingerPrint fp1 = new FingerPrint(ImageIO.read(new File("D:\\javaworkspace\\wlsjk\\ComAndSelet\\1.jpg")));     
		File xlsFile2=new File(temp);
		// 创建工作薄
	      Workbook workbook2=WorkbookFactory.create(xlsFile2);
	      // 创建工作表
	      
	      Sheet sheet2=workbook2.getSheetAt(0);
	      List<String> data=new ArrayList<String>();
	      int rows = sheet2.getLastRowNum();
	      for (int row = 1; row < rows+1; row++)
	      {
	         Row r=sheet2.getRow(row);
	         Cell cell11 = r.getCell(1);
        	 cell11.setCellType(CellType.STRING);
        	 String b;
        	 b= String.valueOf(r.getCell(1).getStringCellValue());
        	 System.out.printf(b);
        	 File testFile = new File("D:\\javaworkspace\\wlsjk\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\myproject\\upload\\"+b+".jpg");
	         for (int col = 0; col < 3; col++)
	         {
	        	 Cell cell4 = r.getCell(col);
	        	 cell4.setCellType(CellType.STRING);	
	        	 if(col==2) {
	        		 if(!testFile .exists()) {
	                	 //testFile.createNewFile();
	                	 System.out.println("测试文件不存在");
	                	 data.add(((row-1)*3+2),"2");
	                	 }
	        		 else {
	        			 FingerPrint fp2 =new FingerPrint(ImageIO.read(testFile));
	        			 double ttt=FingerPrint.testCompare(fp1, fp2);
	        			 if(ttt>0.600000) {
	        				 System.out.println("签到成功");
	        				 data.add(r.getCell(col).getStringCellValue());
	        			 }
	        			 else {
	        				 System.out.println("签到失败");
	        				 data.add(((row-1)*3+2),"1");
	        				 }
	        		 }
		        	
	        	 }
	        	 else {
	            // 在指定文件工作表中得到数据
	        	 
	        	 data.add(r.getCell(col).getStringCellValue());}

	         }
	      }
	      System.out.println(data);
	        FileInputStream fs=new FileInputStream(System.getProperty("user.dir") + "\\poi2.xls");  //获取head.xls
			POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
			HSSFWorkbook wb=new HSSFWorkbook(ps);  
			HSSFSheet sheet3=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表
			HSSFRow row=sheet3.getRow(0);  //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
			System.out.println(sheet3.getLastRowNum()+" "+row.getLastCellNum());  //分别得到最后一行的行号，和一条记录的最后一个单元格
			FileOutputStream out=new FileOutputStream(System.getProperty("user.dir") + "\\poi2.xls");  //向head.xls中写数据
			for(int row1=1;row1<rows+1;row1++) 
			{
			   row=sheet3.createRow((short)(sheet3.getLastRowNum()+1)); //在现有行号后追加数据
			   Row r=sheet3.getRow(row1);
			for (int col = 0; col < 3; col++)
	         {
	            // 向工作表中添加数据
	        	 Cell cell = r.getCell(col);
	        	 cell.setCellType(CellType.STRING);
	             row.createCell(col).setCellValue(data.get((row1-1)*3+col));
	         }}
			out.flush();
			wb.write(out);  
			out.close();  
			System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());  
	     workbook2.close();
	   }

}
