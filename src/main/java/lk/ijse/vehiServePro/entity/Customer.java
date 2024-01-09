package lk.ijse.vehiServePro.entity;

public class Customer {

    private String id;
    private String name;
    private String address;
    private String email;
    private String contact;

    public Customer(String id,String name,String address,String email,String contact){
        this.id = id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.contact=contact;
    }
    public Customer(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
