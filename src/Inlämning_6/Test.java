package Inlämning_6;

public class Test {

	public static void main(String[] args) {
		// Skapa fyra konton
		Account account1 = new Account("123", 1000);
		Account account2 = new Account("456", 500);
		Account account3 = new Account("234", 100);
		Account account4 = new Account("345", 50);
		
		//Skapa två personer
		Person person1 = new Person("1234", "Espen");
		Person person2 = new Person("2345", "Michael");
		
		//Skapa ett register
		PersonRegister regtest = new PersonRegister();
		
		//Koppla konton till personer
		account1.setOwner(person1);
		account2.setOwner(person1);
		account3.setOwner(person2);
		account4.setOwner(person2);

		//Koppla person till konto
		person1.addAccount(account1);
		person1.addAccount(account2);
		person2.addAccount(account3);
		person2.addAccount(account4);
		
		//Lägga in personer i register
		regtest.addPerson(person1);
		regtest.addPerson(person2);
		
		//Tester
		System.out.println(regtest.totBalancePerson("1234"));
		Person tmpC = regtest.findPerson("1234");
			if (tmpC != null) {
				System.out.println("Hittade: " + tmpC.getName());
		}
		Account tmpac = regtest.findPersonAccount("1234", "123");
				if (tmpac != null) {
					System.out.println("Hittade: " + tmpac.getBalance());
				}
	}

}
