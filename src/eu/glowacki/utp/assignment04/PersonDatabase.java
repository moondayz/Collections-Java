package eu.glowacki.utp.assignment04;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment04.comparators.*;

public final class PersonDatabase {

	public List<Person> sortedByFirstName(List<Person> data) {
		Collections.sort(data,new FirstNameComparator());
		return data;
	}
	
    public List<Person> sortedBySurnameFirstNameAndBirthdate(List<Person> sortedSurnameList, Map<Integer,Person> list) {
	    List<Person> sameValues=null;
		Map<Integer,Person> position;
		
		for(int i=0;i<sortedSurnameList.size();i++){
			
	/* 1. if */		if(sameValues!=null&&sameValues.get(0).get_surname().equals(sortedSurnameList.get(i).get_surname()))
				continue;
			
	/* 1. else */		else{
				
				String surname=sortedSurnameList.get(i).get_surname();
				position=list.entrySet().stream().filter(x->x.getValue().get_surname().equals(surname))
						.collect(Collectors.toMap(p->p.getKey(), p->p.getValue()));
				sameValues=new ArrayList<Person>(position.values());
				
   /* 1.1 if */    if(sameValues.size()>1){
					Collections.sort(sameValues);
					Map<Integer,Person> sortedFirstnameMap=new HashMap<Integer,Person>();
					Iterator<Entry<Integer,Person>> iter=position.entrySet().iterator();
					
					for(int l=0;l<sameValues.size();l++){
						Entry<Integer,Person> entry=iter.next();
						int index=entry.getKey();
						sortedSurnameList.set(index, sameValues.get(l));
						sortedFirstnameMap.put(index,sameValues.get(l));
					}
					
					List<Person> sameValuesFirstname=null;
					
					for(int m=0;m<sameValues.size();m++){
						
/* 1.1.1 if -2. for un icinde*/	
						if(sameValuesFirstname!=null&&sameValuesFirstname.get(0).get_firstName().equals(sameValues.get(m).get_firstName()))
							continue;
						
/* 1.1.1 else-for un icinde */		
						else{
							String firstname=sameValues.get(m).get_firstName();
							position=sortedFirstnameMap.entrySet().stream().filter(x->x.getValue().get_firstName().equals(firstname))
									.collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));
							sameValuesFirstname=new ArrayList<Person>(position.values());
			
		/* 1.1.1.1 if */	if(sameValuesFirstname.size()>1){
								Collections.sort(sameValuesFirstname,new BirthdateComparator());
								Iterator<Entry<Integer,Person>> ite=position.entrySet().iterator();
								
								for(int k=0;k<sameValuesFirstname.size();k++){
									Entry<Integer,Person> entry=ite.next();
									int index=entry.getKey();
									sortedSurnameList.set(index, sameValuesFirstname.get(k));
								}
							}
							
				
		/* 1.1.1.1 else */		else
								continue;
						}
					
					}
					
				}
					
	/* 1.1 else */	else
					continue;
			}
		}
		return sortedSurnameList;
	}
	
	public List<Person> sortedByBirthdate(List<Person> data) {
		Collections.sort(data,new BirthdateComparator());
		return null;
	}
	
	public Map<Integer,Person> bornOnDay(Date date,Map<Integer,Person> data) {
		return data.entrySet().stream().filter(x->x.getValue().get_birthdate().equals(date))
				.collect(Collectors.toMap(p->p.getKey(),p->p.getValue()));
	}
}