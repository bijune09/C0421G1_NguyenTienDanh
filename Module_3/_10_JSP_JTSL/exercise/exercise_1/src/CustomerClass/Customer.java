package CustomerClass;

public class Customer {
    String name;
    String dob;
    String address;
    String imgURL;

    public Customer() {
    }

    public Customer(String name, String dob, String address, String imgURL) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
