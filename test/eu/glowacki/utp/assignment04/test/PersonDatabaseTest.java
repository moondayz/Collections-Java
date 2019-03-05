package eu.glowacki.utp.assignment04.test;

import java.io.*;
import java.util.*;

import org.junit.*;

import eu.glowacki.utp.assignment04.*;
public class PersonDatabaseTest {
	private static Scanner sc=null;
	private static PersonDatabase pd=null;
	private static File file=null;
	private static List<Person> data=null;
	private static Map<Integer,Person> dataMap=null;
	@BeforeClass
	public static void setUpBeforeClass(){
		sc=new Scanner(System.in);
		pd=new PersonDatabase();
	}
	@AfterClass
	public static void tearDownAfterClass(){
		
	}
	@Before
	public void setUp(){
		System.out.println("Please enter a file location...");
		String fileLocation=sc.nextLine();
		file=new File(fileLocation);
		data=InputParser.parseToList(file);
		dataMap=InputParser.parseToMap(file);
	}
	@After
	public void tearDown(){
		
	}
	@Test
	public void assertSortedByFirstname(){
		List<Person> sortedList=pd.sortedByFirstName(data);
		Assert.assertEquals("The data is not sorted...", data,sortedList);
	}
	@Test
	public void assertSortedBySurnameFirstnameBirthdate(){
		List<Person> sortedList=pd.sortedBySurnameFirstNameAndBirthdate(data, dataMap);
		Assert.assertEquals("Data i not sorted...",data, sortedList);
		List<Person> surnameSort=data;
		Collections.sort(surnameSort);
		Assert.assertEquals("Data is only sorted by surname.", surnameSort, sortedList);
	}
	@Test
	public void assertSortedByBirthdate(){
		List<Person> sortedList=pd.sortedByBirthdate(data);
		Assert.assertEquals("Data is not sorted...", data, sortedList);
	}
	@Test
	public void assertBornOnDay(){
		System.out.println("Please enter birthdate for filtering (Style=yyyy-MM-dd)");
		String birthdate=sc.nextLine();
		String[] date=birthdate.split("-");
		int year=Integer.parseInt(date[0]);
		int month=Integer.parseInt(date[1]);
		int day=Integer.parseInt(date[2]);
		Calendar cal=Calendar.getInstance();
		cal.set(year,month-1,day);
		Date birth=cal.getTime();
		Map<Integer,Person> filteredList=pd.bornOnDay(birth, dataMap);
		Assert.assertEquals("Filtreleme iþlemi yapýlmamýþtýr...", dataMap, filteredList);
	}
}