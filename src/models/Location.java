package models;

/**
 *
 * @author RR17
 */
public class Location {
     private int id;
     private String street;
     private String postal;
     private String city;
     private String state;
     private String country_id;

    public Location(int id, String street, String postal, String city, String state, String country_id) {
        this.id = id;
        this.street = street;
        this.postal = postal;
        this.city = city;
        this.state = state;
        this.country_id = country_id;
    }
    
    public Location() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    
   
}
