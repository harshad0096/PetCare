package com.harshad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Integer servies;
    @Column(nullable = false)
    private Integer workerid;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String address2;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    
    private String state;
    @Column(nullable = false)
    private String zip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getDriverId() {
        return workerid;
    }

    public void setDriverId(Integer driverId) {
        this.workerid = driverId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCarId() {
        return servies;
    }

    public void setCarId(Integer carId) {
        this.servies = carId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", carId=" + servies +
                ", driverId=" + workerid +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    public void setemail(String email) {
    }
}
