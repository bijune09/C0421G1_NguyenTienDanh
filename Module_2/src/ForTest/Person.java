package ForTest;

public abstract class Person {
    private int id;
    private String name;
    private String dob;
    private boolean gender;
    private String identityNumber;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(int id, String name, String dob, boolean gender, String identityNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person:" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", gender=" + gender +
                ", identityNumber='" + identityNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'';
    }
}
