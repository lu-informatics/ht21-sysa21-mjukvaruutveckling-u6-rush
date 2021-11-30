package Inlämning_6;

import java.util.*;

public class Person {
	private String pNbr;
	private String name;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public String getPNbr() {
		return pNbr;
	}
	public void setPNbr(String pNbr) {
		this.pNbr = pNbr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account newAccount) {
		this.accounts.add(newAccount);
		}
	public Person(String pNbr, String name) {
		this.setPNbr(pNbr);
		this.setName(name);
	}
	public Account findAccount(String Nbr) {
		for (Account a: this.accounts) {
			if(a.getNbr().equals(Nbr)) {
				return a;
			}
		}return null;
	}
	public double totBalance() {
		double summa = 0;
		for(int i = 0; i < accounts.size(); i++) {
			summa += accounts.get(i).getBalance();
		}return summa;
	}
	public ArrayList<String> getAccountNumber(){
		ArrayList<String> accNumberList = new ArrayList<String>(); 
		for(int i = 0; i < accounts.size(); i++) {
			accNumberList.add(accounts.get(i).getNbr());
		}			
		return accNumberList;
	}
	public ArrayList<Double> getAccountBalance(){
		ArrayList<Double> accBalanceList = new ArrayList<Double>(); 
		for(int i = 0; i < accounts.size(); i++) {
			accBalanceList.add(accounts.get(i).getBalance());
		}			
		return accBalanceList;
	}
	
}
