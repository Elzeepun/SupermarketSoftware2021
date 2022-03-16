package products;

//Class that links to the productCatalogue Table View.
public class ProductCatalogue {

    public String productName;
    public int productCode;
    public double productPrice;
    public String productSupplier;
    public String productDescription;
    public int productStock;

    public ProductCatalogue(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public ProductCatalogue(String name, int code, double price, String supplier, String description, int stock){
        productName = name;
        productCode = code;
        productPrice = price;
        productSupplier = supplier;
        productDescription = description;
        productStock = stock;
    }

    public static void main(String[] args){
        ProductCatalogue Apple = new ProductCatalogue("apple", 1163826, 0.50, "GreensCo", "Delicious apples, 1 of your 5-a-day", 50);
        ProductCatalogue Cake = new ProductCatalogue("cake", 1283943, 3.00, "YorkshireBakery", "Divine triple chocolate sponge cake! Perfect for any occasion", 5);
        ProductCatalogue Bread = new ProductCatalogue("bread", 1870105, 1.50, "YorkshireBakery", "Goes well with everything",20);
        ProductCatalogue Meat = new ProductCatalogue("meat", 1133332, 5.00, "HudButchers", "Make your favourite stew with this fresh high quality meat", 15);
        ProductCatalogue Poultry = new ProductCatalogue("poultry",1133331 , 4.00, "HudButchers", "Make that delicious sunday roast",15);
        ProductCatalogue Potatoes = new ProductCatalogue("potatoes",1162899, 2.00, "GreensCo", "Goes well with your sunday roast",30);
        ProductCatalogue VegetableMix = new ProductCatalogue("vegetableMix",1120908, 6.00, "YourMix", "",10);
        ProductCatalogue SoftDrink = new ProductCatalogue("softDrink",2087110, 2.00, "DrinksCo", "",50);
        ProductCatalogue Milk = new ProductCatalogue("milk",1154327, 2.00, "SanDairies", "",20);
        ProductCatalogue Butter = new ProductCatalogue("butter",1578298, 1.77, "SanDairies", "",30);
    }
}
