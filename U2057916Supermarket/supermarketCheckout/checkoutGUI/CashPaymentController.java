package checkoutGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.io.IOException;
import java.lang.String;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.stage.Stage;


public class CashPaymentController {
    public TextField toBePaidTF;
    public TextField changeDueTF;
    public Button checkoutBTN;
    public Double total;
    public Double origTotal;
    public int basketQ;
    public Double change;
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);


    //Function that sets the totalPrice and change from the previous scene.
    public void TotalPrice(double money, int quantity) {
        String value = gb.format(money);
        total = money;
        origTotal = money;
        this.toBePaidTF.setText(value);
        change = 0.0;
        basketQ = quantity;
    }



    //Functions that remove cash from the totalPrice.
    public void Add50Pounds(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            //Total price - 50
            total -= 50;
            //If the total is < 0, then the remainder will be added to the change and the total will be set to 0.
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            //Creates a variable to store the total and change in the GBP format.
            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            //Updates the textFields to display the new total and change.
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }
    }

    public void Add20Pounds(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 20;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }

    }

    public void Add10Pounds(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 10;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }

    }

    public void Add5Pounds(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 5;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }
    }

    public void Add1Pounds(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 1;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }
    }

    public void Add50Pence(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 0.50;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }
    }

    public void Add20Pence(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 0.20;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }

    }

    public void Add10Pence(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 0.10;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }

    }

    public void Add5Pence(ActionEvent ActionEvent) {
        if (total <=0) {
            Alert accountAlert = new Alert(Alert.AlertType.ERROR);
            accountAlert.setTitle("Payment Error");
            accountAlert.setContentText("Total has been met");
            accountAlert.setHeaderText("Please click on Checkout");
            accountAlert.showAndWait();
        } else {
            total -= 0.05;
            if (total < 0.0)
            {
                change -= total;
                total = 0.0;
            }

            String updateTotal = gb.format(total);
            String updateChange = gb.format(change);
            toBePaidTF.setText(updateTotal);
            changeDueTF.setText(updateChange);
        }

    }


    //Function that finalises the purchase.
    public void checkout(ActionEvent ActionEvent) throws IOException {
        //If the user has not finished paying for the items an error will be displayed.
        if (total > 0.0) {
            String updateTotal = gb.format(total);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Checkout Incomplete");
            alert.setHeaderText("ERROR");
            alert.setContentText("You are still due to pay " + updateTotal);
            alert.showAndWait();
        } else {
            //Loads the end scene.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("endScene.fxml"));
            Parent parent = loader.load();


            EndSceneController controller = loader.getController();
            controller.ChangeDue(origTotal, basketQ, change);


            Stage stage = (Stage) checkoutBTN.getScene().getWindow();

            stage.setScene(new Scene(parent));
            stage.setTitle("Checkout");
        }
    }
}
