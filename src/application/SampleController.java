package application;

import Inlämning_6.Account;
import Inlämning_6.Person;
import Inlämning_6.PersonRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
//implements Initializable {
	PersonRegister reg = new PersonRegister();
	
	@FXML
	private TextField txtPName;
	@FXML
	private TextField txtPNbr;
	@FXML
	private TextField txtAccNbr;
	@FXML
	private TextField txtAmount;
	@FXML
	private Label lblResponse;
	@FXML
    private TextArea txtResults;
	
	
//    @FXML
//    private TableView<Account> accTable;
//	@FXML
//    private TableColumn<Account, String> accColumn;
//    @FXML
//    private TableColumn<Account, Double> balColumn;
	
	@FXML
	public void txtAreaEdit() {
		txtResults.setEditable(false);
	}
	
	@FXML
	public void btnAddPerson_Click(ActionEvent event) {
		String pName = txtPName.getText();
		String pNumber = txtPNbr.getText();
		Person newPerson = new Person(pNumber, pName);
		if(reg.findPerson(pNumber) == null) {
			reg.addPerson(newPerson);
			txtResults.setText("Person added");		
		}else {
			txtResults.setText("Person already exists");
		}		
	}
		
	@FXML
	public void btnFindPerson_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		Person findPerson = reg.findPerson(pNumber);
		if(findPerson != null) {
			txtResults.setText("Person Found: \n" + findPerson.getPNbr() + "\n" + findPerson.getName());
			txtPNbr.setText(findPerson.getPNbr());
			txtPName.setText(findPerson.getName());
		}else {
			txtResults.setText("Person not found.");
		}
	}
	
	@FXML
	public void btnRemovePerson_Click(ActionEvent event) {
		String pNbr = txtPNbr.getText();
		if(reg.findPerson(pNbr) != null) {
			reg.removePerson(pNbr);
			txtResults.setText("Person removed.");
		}else {
			txtResults.setText("Person not found.");
		}
	}
	
	@FXML
	public void btnAddAccount_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		Person tmpPerson = reg.findPerson(pNumber);
		String accNbr = txtAccNbr.getText();
		if (tmpPerson != null) {
			Account newacc = new Account(accNbr, 0);
			if(tmpPerson.findAccount(accNbr) == null) {
				tmpPerson.addAccount(newacc);
				newacc.setOwner(tmpPerson);
				txtResults.setText("Account Added.");
			}else {
				txtResults.setText("Account already exists.");
			}
		}else {
			txtResults.setText("Person not found.");
		}
	}
	
	@FXML
	public void btnDeposit_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		String accNbr = txtAccNbr.getText();
		double amount = Double.parseDouble(txtAmount.getText());
		
		Account accDep = reg.findPersonAccount(pNumber, accNbr);
		if (accDep != null) {
			accDep.credit(amount);
			txtResults.setText("Amount deposited.");
		}else {
			txtResults.setText("Person or account not found");
		}
	}
	
	@FXML
	public void btnWithdraw_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		String accNbr = txtAccNbr.getText();
		double amount = Double.parseDouble(txtAmount.getText());

		Account accWD = reg.findPersonAccount(pNumber, accNbr);
		if (accWD != null) {
			accWD.withdraw(amount);
			txtResults.setText("Amount withdrawn.");
		}else {
			txtResults.setText("Person or account not found.");
		}
	}
	
	@FXML
	public void btnShowBalance_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		Person showPerson = reg.findPerson(pNumber);
		double balance;
		
		if(showPerson != null) {
			balance = reg.totBalancePerson(pNumber);
			txtResults.setText("Total Balance: " + balance + ".");
		}else {
			txtResults.setText("Person not found.");
		}
	}
	
	@FXML
	public void btnDisplayAccounts_Click(ActionEvent event) {
		String pNumber = txtPNbr.getText();
		Person dspPerson = reg.findPerson(pNumber);
		
		if(dspPerson != null) {
			String accNbrTxt = dspPerson.getAccountNumber().toString();
			String accBalTxt = dspPerson.getAccountBalance().toString();
			txtResults.setText("Account Number(s): " + accNbrTxt + "\nAccount Balance(s): " + accBalTxt);
		}else {
			txtResults.setText("Person not found.");
		}
	}
}
//	@Override
//	public void initialize(URL url, ResourceBundle resourceBundle) {
//		accColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("nbr"));
//		balColumn.setCellValueFactory(new PropertyValueFactory<Account, Double>("balance"));
//	}
	
//	@FXML
//	public void btnDisplayAccounts_Click(ActionEvent event) {
//		String pNumber = txtPNbr.getText();
//		Person dspPerson = reg.findPerson(pNumber);
//		
////		ArrayList<Account> dspAccount = dspPerson.getAccounts();
////		ObservableList<Account> dspList = FXCollections.observableArrayList(dspAccount);
////		
////		ArrayList<String> dspNumber = dspPerson.getAccountNumber();
////		ObservableList<String> dspList1 = FXCollections.observableArrayList(dspNumber);
////		
////		ArrayList<Double> dspBalance = dspPerson.getAccountBalance();
////		ObservableList<Double> dspList2 = FXCollections.observableArrayList(dspBalance);
////		
////		accColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("dspList1"));
////		accTable.setItems(dspList);
//	}
	
