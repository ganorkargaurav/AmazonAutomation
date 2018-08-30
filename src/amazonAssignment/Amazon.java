package amazonAssignment;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FirstScripts.Search;
import FirstScripts.SolarisTestCases;

	public class Amazon extends AmazonTestCases {

	AmazonTestCases amazon = new AmazonTestCases();
	
	@BeforeClass
	public void setupClass() throws InterruptedException {
		
		amazon.launchWebsite();
		amazon.signIn();
				
	}
	
		
	@DataProvider(name="SearchItems")
	public Object[][] searchData() throws IOException {
		
		String[][] searchItems = new String[4][2];
    	Search objExcelFile = new Search();
        String filePath = System.getProperty("user.dir")+"\\Excels";
        searchItems = objExcelFile.readExcel(filePath,"AmazonSearch.xlsx","SearchItems");
		return searchItems;
    }
	
	@Test(dataProvider="SearchItems",priority = 0 )
	public void searchAndAdd (String item, String brand) throws InterruptedException  {
		
		AmazonTestCases.searchAndAddToCart(item, brand);
		
	}
	
	@Test(priority = 1)
	public void amazonTestCasesExecution() throws InterruptedException  {
				
		amazon.cartTotalVerification();
		amazon.deleteCartItems();
			
	}
	
	@Test(priority = 2)
	public void signOut()  {
		
		amazon.signOut();
			
	}
	


}
