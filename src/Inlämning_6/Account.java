package Inlämning_6;

public class Account {
	private  String nbr;
	private double balance;
	private Person owner;
	
	public String getNbr() {
		return nbr;
	}
	public void setNbr(String nbr) {
		this.nbr = nbr;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public void credit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		balance -= amount;
	}
	public Account(String Nbr, double amount) {
		this.setNbr(Nbr);
		this.setBalance(amount);
	}
	
}
