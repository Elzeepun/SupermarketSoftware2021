package products;

public class ScannedProduct {
    private String scannedName;
    private String scannedDescription;
    private Double scannedPrice;

    //Class that links with the scanned product table View.
    public ScannedProduct(String scannedName, String scannedDescription, Double scannedPrice) {
        this.scannedName = scannedName;
        this.scannedDescription = scannedDescription;
        this.scannedPrice = scannedPrice;
    }

    public String getScannedName() {
        return scannedName;
    }

    public void setScannedName(String scannedName) {
        this.scannedName = scannedName;
    }

    public String getScannedDescription() {
        return scannedDescription;
    }

    public void setScannedDescription(String scannedDescription) {
        this.scannedDescription = scannedDescription;
    }

    public Double getScannedPrice() {
        return scannedPrice;
    }

    public void setScannedPrice(Double scannedPrice) {
        this.scannedPrice = scannedPrice;
    }
}
