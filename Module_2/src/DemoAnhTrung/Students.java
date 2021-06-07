package DemoAnhTrung;

public class Students {
    private int id , age;
    private String name, address;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Students(int id, String name, int age, String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Students(){
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
