package Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private int ID;

    private String Name;

    private String Password;

    private String Address;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public UserDetails() {
    }

    public UserDetails(int ID, String name, String password, String address) {
        this.ID = ID;
        Name = name;
        Password = password;
        Address = address;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
