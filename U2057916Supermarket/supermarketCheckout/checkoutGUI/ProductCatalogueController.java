package checkoutGUI;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import products.ProductCatalogue;


public class ProductCatalogueController {
    //Creates the Table view
    public javafx.scene.control.TableView<ProductCatalogue> catalogueTV;
    //Creates the columns for the tableView
    public TableColumn<ProductCatalogue, String> nameColumn;
    public TableColumn<ProductCatalogue, Double> priceColumn;
    public TableColumn<ProductCatalogue, String> descriptionColumn;
    public TableColumn<ProductCatalogue, String> supplierColumn;
    public TableColumn<ProductCatalogue, Integer> stockColumn;
    public TableColumn<ProductCatalogue, Integer> codeColumn;


    @FXML
    private void initialize() {
        //Links them to the class variables.
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("productSupplier"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("productStock"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));

        //Creates the items to add to the catalogue Table View.
        catalogueTV.getItems().add(new ProductCatalogue("apple", 1163826, 0.50, "GreensCo", "Delicious 1 of your 5 a day", 50));
        catalogueTV.getItems().add(new ProductCatalogue("cake", 1283943, 3.00, "YorkshireBakery", "Divine triple chocolate sponge cake! Perfect for any occasion", 5));
        catalogueTV.getItems().add(new ProductCatalogue("bread", 1870105, 1.50, "YorkshireBakery", "Goes well with everything", 20));
        catalogueTV.getItems().add(new ProductCatalogue("meat", 1133332, 5.00, "HudButchers", "Make your favourite stew with this fresh high quality meat", 15));
        catalogueTV.getItems().add(new ProductCatalogue("poultry", 1133331, 4.00, "HudButchers", "Make that delicious sunday roast", 15));
        catalogueTV.getItems().add(new ProductCatalogue("potatoes", 1162899, 2.00, "GreensCo", "Goes well with your sunday roast", 30));
        catalogueTV.getItems().add(new ProductCatalogue("vegetableMix", 1120908, 6.00, "YourMix", "A mix of broccoli, carrots, potatoes, peas and sweetcorn", 10));
        catalogueTV.getItems().add(new ProductCatalogue("softDrink", 2087110, 2.00, "DrinksCo", "A refreshing softDrink", 50));
        catalogueTV.getItems().add(new ProductCatalogue("milk", 1154327, 2.00, "SanDairies", "Locally sourced fresh milk", 20));
        catalogueTV.getItems().add(new ProductCatalogue("butter", 1578298, 1.77, "SanDairies", "Locally sourced Butter, made from fresh milk", 30));
    }

    public void setParent() {
    }
}

