import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase extends BaseTest{
	@BeforeClass
	public void caseBeforeClass(){
		System.out.println("case before class");
	}

	@BeforeMethod
	public void caseBeforeMethod(){
		System.out.println("case before method");
	}

	@AfterMethod
	public void caseAfterMethod(){
		System.out.println("case after method");
	}
	@Test
	public void test(){}
}
