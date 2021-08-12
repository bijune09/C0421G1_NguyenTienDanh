package model.bean.customer;

public class TypeCustomer {
    private int idTypeCustomer;
    private String typeCustomer;

    public TypeCustomer() {
    }

    public TypeCustomer(int idTypeCustomer, String typeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
        this.typeCustomer = typeCustomer;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
