import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	@BeforeClass
	public void beforeClass(){
		System.out.println("Base before class");
	}

	@BeforeMethod
	public void beforeMethod(){
		System.out.println("Base before method");
	}

	@AfterMethod
	public void afterMethod(){
		System.out.println("Base after method");
	}
}
