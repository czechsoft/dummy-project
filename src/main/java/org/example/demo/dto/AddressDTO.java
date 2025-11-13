package org.example.demo.dto;

public class AddressDTO {
    private Long id;
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }

    public String getFlatNumber() { return flatNumber; }
    public void setFlatNumber(String flatNumber) { this.flatNumber = flatNumber; }
}
