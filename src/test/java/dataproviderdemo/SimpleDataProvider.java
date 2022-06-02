package dataproviderdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleDataProvider {
	@DataProvider(name = "numbers")
	public Object[][] toSendNumbers() {
		Object[][]a= {{1,2},{2,3},{3,4}};
		return a;
	}
	@Test(dataProvider = "numbers")
	public void dataDrivenCase(int x, int y) {
		System.out.println("X:"+x+"  "+"Y:"+y);
	}
}
