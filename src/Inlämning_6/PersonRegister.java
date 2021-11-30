package Inlämning_6;

import java.util.*;

public class PersonRegister {
	private HashMap<Person, Account> register = new HashMap<Person, Account>();
	
	public HashMap<Person, Account> getRegister() {
		return this.register;
	}
	public void setRegister(HashMap<Person, Account> value) {
		this.register = value;
	}
	public void addPerson(Person nyPerson) {
		this.register.put(nyPerson, null);
	}
	public Person findPerson(String pNbr) {
		for(Person p: register.keySet()) {
			if(p.getPNbr().equals(pNbr)) {
				return p;
			}
		}return null;
	}
	public void removePerson(String pNbr) {
		Person p = this.findPerson(pNbr);
		if (p != null) {
		this.register.remove(p);
		}
	}
	public Account findPersonAccount(String pNbr, String Nbr) {
		Account a = this.findPerson(pNbr).findAccount(Nbr);
		if(a != null) {
			return a;
		}else {
			return null;
		}
	}
	public double totBalancePerson(String pNbr) {
		double b = this.findPerson(pNbr).totBalance();
		return b;
	}

}
