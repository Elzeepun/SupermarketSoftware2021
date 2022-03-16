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

public class TenOrLessCheckoutController {
    public TextField codeTF;
    public TextField scanTotalTF;
    public Button finishBN;
    //Stores price of last scanned item. Allows this value to be removed from scanPrice if item is removed.
    public Double tempPrice;
    //Total Price of items scanned.
    public Double scanPrice = 0.0;
    public String tempTotal;
    NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);

    //TABLEVIEW
    public TableView<ScannedProduct> scannedTV;
    public TableColumn<ScannedProduct, String> nameColumn;
    public TableColumn<ScannedProduct, Double> priceColumn;
    public TableColumn<ScannedProduct, String> descriptionColumn;



    @FXML
    private void initialize(){
        //Links the table view columns to the scannedProduct class
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("scannedName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("scannedDescription"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("scannedPrice"));
    }


    //Function that lets the user scan items and adds them to the tableview.
    @FXML
    public void scan(ActionEvent actionEvent) {
        //If there already 10 items in the basket an error will be displayed.
        if (scannedTV.getItems().size() >= 10) {
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("10 Items exceeded");
            empty.setContentText("Please remove an item to proceed");
            empty.setHeaderText("Your basket has exceeded 10 Items");
            empty.showAndWait();
        } else{
            //Acquires the code in the textField
            String code = codeTF.getText();
            switch (code) {
                case "1163826":
                    scanPrice += 0.50;
                    tempTotal = gb.format(scanPrice);
                    scanTotalTF.setText(tempTotal);
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
                    scannedTV.getItems().add(new ScannedProduct("Bread", "Goes well with everything", 1.50));
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
                    scannedTV.getItems().add(new ScannedProduct("Potatoes", "Goes well with your sunday roasr", 2.00));
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
                    //If no code or an invalid product code is entered an error is displayed.
                    Alert accountAlert = new Alert(Alert.AlertType.ERROR);
                    accountAlert.setTitle("Product Error");
                    accountAlert.setContentText("No such Product Code");
                    accountAlert.setHeaderText("Product Code Invalid");
                    accountAlert.showAndWait();
                    break;
            }
        }
    }


    //Method that removes an item from the Table View.
    public void remove(ActionEvent ActionEvent) {
        ScannedProduct selectedItem = scannedTV.getSelectionModel().getSelectedItem();
        tempPrice = selectedItem.getScannedPrice();
        scanPrice -= tempPrice;
        if (scanPrice < 0.0){
            scanPrice = 0.0;
        }
        tempTotal = gb.format(scanPrice);
        scanTotalTF.setText(tempTotal);
        scannedTV.getItems().remove(selectedItem);
    }

    //Method that clears the text on the code textField.
    public void clearText(ActionEvent ActionEvent) {
        codeTF.setText("");
    }

    //Method that changes the scene to the payment selection scene.
    public void PaymentScene(ActionEvent actionEvent) throws IOException {
        if (scanPrice.equals(0.0)) {
            Alert empty = new Alert(Alert.AlertType.ERROR);
            empty.setTitle("Checkout ERROR");
            empty.setContentText("Please scan an item first");
            empty.setHeaderText("No items scanned");
            empty.showAndWait();
        } else {
            double amount = scanPrice; //Total money to transfer
            int basketQuantity = scannedTV.getItems().size();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("standardPaymentSelector.fxml"));
            Parent parent = loader.load();

            StandardPaymentSelectorController controller = loader.getController();
            controller.Payment(amount, basketQuantity);

            Stage stage = (Stage) finishBN.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.setTitle("Select Payment Method");
        }
    }

    public void setParent() {
    }
}
