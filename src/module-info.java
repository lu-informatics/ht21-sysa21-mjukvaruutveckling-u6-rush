module ht21-sysa21-mjukvaruutveckling-u6-rush {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
