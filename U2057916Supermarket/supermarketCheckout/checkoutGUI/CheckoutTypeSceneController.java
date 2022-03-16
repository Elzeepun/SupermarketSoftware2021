package checkoutGUI;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckoutTypeSceneController {
    public Button buildCheckout;
    public ComboBox<String> checkoutType;


    public void initialize() {
        //Initialises the comboBox.
        checkoutType.getItems().removeAll(checkoutType.getItems());
        checkoutType.getItems().addAll("Standard", "Cash Only", "Card Only", "Ten Items Or Fewer");
        checkoutType.getSelectionModel().select("Standard");
    }

    //Checkout type scene selection comboBox and button actionEvent
    public void SceneSelection(ActionEvent actionEvent) throws IOException {
        switch (checkoutType.getValue()) {
            //Ten items or fewer scene is selected
            case "Ten Items Or Fewer": {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("checkoutTenOrLess.fxml"));
                Scene TenOrLessScene = new Scene(loader.load());
                TenOrLessCheckoutController controller = loader.getController();
                controller.setParent();

                Stage TenOrLess = new Stage();
                TenOrLess.setScene(TenOrLessScene);
                TenOrLess.setTitle("Ten or Less Checkout System");
                TenOrLess.initModality(Modality.NONE);
                TenOrLess.show();
                break;
            }
            //Standard checkout is selected.
            case "Standard": {
                //String cash holds standardPayment choice.
                String cash = "standardPayment";
                //Next scene is loaded
                FXMLLoader loader = new FXMLLoader(getClass().getResource("standardCheckout.fxml"));
                Scene StandardScene = new Scene(loader.load());

                //CheckoutController is loaded.
                CheckoutController controller = loader.getController();
                //Sets this controller as the parent controller.
                controller.setParent();

                //transfers the standardPayment choice to the next scene.
                controller.checkoutType(cash);

                //Creates the new stage.
                Stage Standard = new Stage();
                Standard.setScene(StandardScene);
                Standard.setTitle("Standard Checkout System");
                Standard.initModality(Modality.NONE);
                Standard.show();
                break;
            }
            case "Cash Only": {
                String cash = "cashPayment";

                FXMLLoader loader = new FXMLLoader(getClass().getResource("standardCheckout.fxml"));
                Scene StandardScene = new Scene(loader.load());
                CheckoutController controller = loader.getController();
                controller.setParent();
                controller.checkoutType(cash);

                Stage Standard = new Stage();
                Standard.setScene(StandardScene);
                Standard.setTitle("Cash Only Checkout System");
                Standard.initModality(Modality.NONE);
                Standard.show();
                break;
            }
            case "Card Only": {
                String card = "cardPayment";

                FXMLLoader loader = new FXMLLoader(getClass().getResource("standardCheckout.fxml"));
                Scene StandardScene = new Scene(loader.load());
                CheckoutController controller = loader.getController();
                controller.setParent();
                controller.checkoutType(card);

                Stage Standard = new Stage();
                Standard.setScene(StandardScene);
                Standard.setTitle("Card Only Checkout System");
                Standard.initModality(Modality.NONE);
                Standard.show();
                break;
            }
        }
    }

    //Opens the catalogue scene as a popup
    public void DisplayCatalogue(ActionEvent ActionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("productCatalogue.fxml"));
        Scene CatalogueScene = new Scene(loader.load());
        ProductCatalogueController controller = loader.getController();
        controller.setParent();

        Stage Catalogue = new Stage();
        Catalogue.setScene(CatalogueScene);
        Catalogue.setTitle("Product Catalogue");
        Catalogue.initModality(Modality.NONE);
        Catalogue.show();
    }
}
