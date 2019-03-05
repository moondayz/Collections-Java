package eu.glowacki.utp.assignment04.test;



import java.io.File;
import java.util.*;

import org.junit.*;

import eu.glowacki.utp.assignment04.*;

public final class InputParserTest {
	private static File file=null;
	private static Scanner sc=null;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		sc=new Scanner(System.in);
	}
	@AfterClass
	public static void tearDownAfterClass(){
		
	}
	@Before
	public void setUp(){
		System.out.println("Please enter a file location...");
		String fileLocation=sc.nextLine();
		file=new File(fileLocation);
		
	}
	@After
	public void tearDown(){
		
	}
	@Test
	public void assertInputParse(){
		List<Person> data=InputParser.parseToList(file);
		Assert.assertTrue("Dosyada istenen formatta veri bulunmamaktadir",data.size()!=0);
		Map<Integer,Person> data2=InputParser.parseToMap(file);
		Assert.assertTrue("Dosyada istenen formatta veri bulunmamaktadir", data2.size()!=0);
	}
}