package checkoutGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class CardPaymentController {
    public Label totalLBL;
    public TextField cardNumTF;
    public Button authoriseBTN;
    public Double total;
    public Double origTotal;
    public int basketQ;
    //Receives GBP currency format
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);

    //Function that sets the totalPrice from the previous scene.
    public void TotalPrice(double money, int quantity) {
        String value = gb.format(money);
        total = money;
        origTotal = money;
        this.totalLBL.setText(value);
        basketQ = quantity;
    }

    //No security
    public void checkout(ActionEvent ActionEvent) throws IOException {
        //If no number is entered an error id displayed.
        if (cardNumTF.getText().equals("")){
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("Card ERROR");
            empty.setContentText("Please enter a valid card number between 13 and 19 digits");
            empty.setHeaderText("Invalid Card Number");
            empty.showAndWait();
        } else {
            //The end scene is loaded.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("endScene.fxml"));
            Parent parent = loader.load();

            EndSceneController controller = loader.getController();
            controller.ChangeDue(origTotal, basketQ, 0.0);

            Stage stage = (Stage) authoriseBTN.getScene().getWindow();

            stage.setScene(new Scene(parent));
            stage.setTitle("Checkout");
        }
    }
}
