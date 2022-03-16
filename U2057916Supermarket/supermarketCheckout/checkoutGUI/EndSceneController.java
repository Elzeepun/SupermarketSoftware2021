package checkoutGUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.Locale;

public class EndSceneController {
    public Label changeDueLBL;
    public Button finishBTN;
    public Double totalPrice;
    public int totalQuantity;
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);

    //Method that receives the changeDue from the previous scene.
    public void ChangeDue(double amount, int quantity, double chng) {
        String change = gb.format(chng);
        totalPrice = amount;
        totalQuantity = quantity;
        this.changeDueLBL.setText("You are due " + change + " change");
    }

    //Program that closes the scene
    @FXML
    public void EndProgram() {
        //End the scene
        Stage stage = (Stage) finishBTN.getScene().getWindow();
        stage.close();
    }
}
