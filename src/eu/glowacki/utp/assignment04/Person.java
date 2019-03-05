package eu.glowacki.utp.assignment04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
	
	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	
	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}
	

	public String get_firstName() {
		return _firstName;
	}


	public String get_surname() {
		return _surname;
	}


	public Date get_birthdate() {
		return _birthdate;
	}


	@Override
	public int compareTo(Person otherPerson) {
		
		return  new String(this._surname).compareTo(otherPerson._surname);
	}
	public String toString(){
		return this._firstName+" "+this._surname+" "+this.birthdayToString();
	}
	public String birthdayToString(){
		return new SimpleDateFormat("yyyy-MM-dd").format(this._birthdate);
	}
}