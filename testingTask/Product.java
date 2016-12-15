package testingTask;
public class Product {
    private final int id;
    private String type;
    private String manufacturer;
    private String productionDate;
    private String expiryDate;

    public Product (int id) {
        this.id = id;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void setManufacturer (String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProductionDate (String productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpiryDate (String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getId () {return this.id;}

    public String getType () {return this.type;}

    public String getManufacturer () {return  this.manufacturer;}

    public String getProductionDate () {return  this.productionDate;}

    public String getExpiryDate () {return  this.expiryDate;}
}

