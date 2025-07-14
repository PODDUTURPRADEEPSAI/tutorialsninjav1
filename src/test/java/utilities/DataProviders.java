package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public   String [][] Logindata() throws IOException{
		String path=".\\testdata\\data.xlsx";
		
		ExcelUtility utility =new ExcelUtility(path);
		
		int Row_count=utility.getRowCount("Sheet1");
		int Cell_count=utility.getCellCount("Sheet1", 1);
		
		String row_col[][] =new String[Row_count][Cell_count];
		for(int i=1;i<=Row_count;i++) {
			
			for(int j=0;i<Cell_count;j++) {
				row_col[i-1][j]=utility.getCellData("Sheet1",i,j);
					
			}
		}
		return row_col;
		
	}
}

