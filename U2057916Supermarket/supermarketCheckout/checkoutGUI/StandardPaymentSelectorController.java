package checkoutGUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class StandardPaymentSelectorController {
    public Button cashBtn;
    public Button cardBtn;
    public Label priceLBL;
    public double total;
    public int basketQ;

    public StandardPaymentSelectorController() {
    }

    @FXML
    private void initialize() {
    }


    //Receives the money and basket quantity from the previous scene.
    public void Payment(double money, int quantity) {
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);
        String value = gb.format(money);
        total = money;
        basketQ = quantity;
        this.priceLBL.setText(value);
    }

    //Changes to the CashPayment Scene when clicked.
    public void payByCash(ActionEvent actionEvent) throws IOException {
        double amount = total;
        int quantity = basketQ;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cashPayment.fxml"));
        Parent parent = loader.load();
        CashPaymentController controller = loader.getController();
        controller.TotalPrice(amount, quantity);

        Stage stage = (Stage) cashBtn.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.setTitle("Select Payment Method");
    }

    //Changes to the CardPayment Scene when clicked.
    public void payByCard(ActionEvent actionEvent) throws IOException {
        double amount = total;
        int quantity = basketQ;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("cardPayment.fxml"));
        Parent parent = loader.load();
        CardPaymentController controller2 = loader.getController();
        controller2.TotalPrice(amount, quantity);

        Stage stage = (Stage) cashBtn.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.setTitle("Select Payment Method");
    }
}
