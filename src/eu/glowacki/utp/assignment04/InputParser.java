package eu.glowacki.utp.assignment04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class InputParser {
	

	public static List<Person> parseToList(File file) {
		String line;
		List<Person> data=new ArrayList<Person>();
		String patternValidation="(\\w+)\\s(\\w+)\\s((\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d))";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null){
				if(line.matches(patternValidation)){
				String[] personData=line.split(" ");
				String[] date=personData[2].split("-");
				int year=Integer.parseInt(date[0]);
				int month=Integer.parseInt(date[1]);
				int day=Integer.parseInt(date[2]);
				Calendar cal=Calendar.getInstance();
				cal.set(year,month-1,day);
				Date birthdate=cal.getTime();
				Person person=new Person(personData[0],personData[1],birthdate);
				data.add(person);
				}
				else
					continue;
			}
			br.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	}
	public static Map<Integer,Person> parseToMap(File file) {
		String line;
		Map<Integer,Person> data=new HashMap<Integer,Person>();
		String patternValidation="(\\w+)\\s(\\w+)\\s((\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d))";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			for(int i=0;(line=br.readLine())!=null;i++){
				if(line.matches(patternValidation)){
				String[] personData=line.split(" ");
				String[] date=personData[2].split("-");
				int year=Integer.parseInt(date[0]);
				int month=Integer.parseInt(date[1]);
				int day=Integer.parseInt(date[2]);
				Calendar cal=Calendar.getInstance();
				cal.set(year,month-1,day);
				Date birthdate=cal.getTime();
				Person person=new Person(personData[0],personData[1],birthdate);
				data.put(i,person);
				}
				else
					continue;
			}
			br.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	}
	
}