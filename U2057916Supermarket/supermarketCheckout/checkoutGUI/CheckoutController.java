package checkoutGUI;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.lang.String;
import java.text.NumberFormat;
import java.util.Locale;

import javafx.stage.Stage;
import products.ScannedProduct;


public class CheckoutController {
    public TextField codeTF;
    public TextField scanTotalTF;
    public Button finishBN;
    //Stores price of last scanned item. Allows this value to be removed from scanPrice if item is removed.
    public Double tempPrice;
    //Total Price of items scanned.
    public Double scanPrice = 0.0;
    public String checkoutType;
    public String tempTotal;
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);


    //Initializes TableView
    public TableView<ScannedProduct> scannedTV;
    public TableColumn<ScannedProduct, String> nameColumn;
    public TableColumn<ScannedProduct, Double> priceColumn;
    public TableColumn<ScannedProduct, String> descriptionColumn;

    //Method to set the parent controller
    public void setParent(){
        //Sets the parent Controller
    }


    @FXML
    private void initialize(){
        //Initialises the tableView columns.
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("scannedName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("scannedDescription"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("scannedPrice"));

    }

    //Method that takes the checkoutType from the previous scene.
    public void checkoutType(String type) {
       checkoutType = type;
    }

    // Function that adds items to SCANNEDTV.
    @FXML
    public void scan(ActionEvent ActionEvent) {

        String code = codeTF.getText(); //Get's the code in the textfield
        switch (code) {
            case "1163826":
                //Adds 50p to the scanned price.
                scanPrice += 0.50;
                //Stores the total price in GBP format
                tempTotal = gb.format(scanPrice);
                //Displays the updates scannedPrice in the TextField.
                scanTotalTF.setText(tempTotal);
                //Adds the product to the tableView.
                scannedTV.getItems().add(new ScannedProduct("Apple", "Delicious one of your 5 a day", 0.50));
                break;
            case "1283943":
                scanPrice += 3.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Cake", "Divine triple chocolate sponge cake! Perfect for any occasion", 3.00));
                break;
            case "1870105":
                scanPrice += 1.50;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Bread", "Goes well with everything",1.50));
                break;
            case "1133332":
                scanPrice += 5.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Meat", "Make your favourite stew with this fresh high quality meat", 5.00));
                break;
            case "1133331":
                scanPrice += 4.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Poultry", "Make that delicious sunday roast", 4.00));
                break;
            case "1162899":
                scanPrice += 2.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Potatoes", "Goes well with your sunday roast", 2.00));
                break;
            case "1120908":
                scanPrice += 6.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Vegetable Mix", "A mix of broccoli, carrots, potatoes, peas and sweetcorn", 6.00));
                break;
            case "2087110":
                scanPrice += 2.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("SoftDrink", "A refreshing softDrink", 2.00));
                break;
            case "1154327":
                scanPrice += 2.00;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Milk", "Locally sourced fresh milk", 2.00));
                break;
            case "1578298":
                scanPrice += 1.77;
                tempTotal = gb.format(scanPrice);
                scanTotalTF.setText(tempTotal);
                scannedTV.getItems().add(new ScannedProduct("Butter", "Locally sourced Butter, made from fresh milk", 1.77));
                break;
            default:
                //If the written code doesn't match then this error is displayed instead.
                Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                accountAlert.setTitle("Product Error");
                accountAlert.setContentText("No such Product Code");
                accountAlert.setHeaderText("Product Code Invalid");
                accountAlert.showAndWait();
                break;
        }
    }



    //Method that removes an item from the tableView.
    public void remove(ActionEvent ActionEvent) {
        //Receives the selected item
        ScannedProduct selectedItem = scannedTV.getSelectionModel().getSelectedItem();
        //Saves the price of the selected item in a temporary variable.
        tempPrice = selectedItem.getScannedPrice();
        //Removes the temporary price from the total price.
        scanPrice -= tempPrice;
        //The totalPrice is reset to 0 if it goes below 0.
        if (scanPrice < 0.0){
            scanPrice = 0.0;
        }
        //The updated totalPrice is displayed in the textField.
        tempTotal = gb.format(scanPrice);
        scanTotalTF.setText(tempTotal);
        //The selected entry is removed from the table.
        scannedTV.getItems().remove(selectedItem);
    }

    //Clear's the text in the price textField.
    public void clearText(ActionEvent ActionEvent) {
        //Empties the textField.
        codeTF.setText("");
    }


    //Accesses the payment scenes depending on the checkout type selected.
    public void PaymentScene(ActionEvent ActionEvent) throws IOException {
        //If no item has been scanned an error will be displayed.
        if (scanPrice.equals(0.0)) {
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("Checkout ERROR");
            empty.setContentText("Please scan an item first");
            empty.setHeaderText("No items scanned");
            empty.showAndWait();
        } else { //PAYMENT METHOD
            //A switch case to determine the payment method from the checkoutType chosen.
            switch (checkoutType) {
                //If cashOnly was selected then the scene will change to the cash payment scene.
                case "cashPayment": {
                    //The total price is received as a double and saved to the variable amount.
                    double amount = scanPrice;
                    //The number of items that have been scanned is saved to this variable.
                    int basketQuantity = scannedTV.getItems().size();

                    //Loads the next scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cashPayment.fxml"));
                    Parent parent = loader.load();
                    //Loads the next controller to be used.
                    CashPaymentController controller = loader.getController();

                    //calls the TotalPrice method from the next Controller to send the price and quantity to the payment scene.
                    controller.TotalPrice(amount, basketQuantity);

                    //Sets the new stage.
                    Stage stage = (Stage) finishBN.getScene().getWindow();

                    stage.setScene(new Scene(parent));
                    stage.setTitle("Cash Payment");

                    break;
                }
                case "cardPayment": { //CARD ONLY
                    double amount = scanPrice;
                    int basketQuantity = scannedTV.getItems().size();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cardPayment.fxml"));
                    Parent parent = loader.load();

                    CardPaymentController controller = loader.getController();
                    controller.TotalPrice(amount, basketQuantity);

                    Stage stage = (Stage) finishBN.getScene().getWindow();
                    stage.setScene(new Scene(parent));
                    stage.setTitle("Card Payment");

                    break;
                }
                case "standardPayment": { //STANDARD
                    double amount = scanPrice;
                    int basketQuantity = scannedTV.getItems().size();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("standardPaymentSelector.fxml"));
                    Parent parent = loader.load();

                    StandardPaymentSelectorController controller = loader.getController();
                    controller.Payment(amount, basketQuantity);

                    Stage stage = (Stage) finishBN.getScene().getWindow();
                    stage.setScene(new Scene(parent));
                    stage.setTitle("Select Payment Method");

                    break;
                }
            }
        }
    }
}
