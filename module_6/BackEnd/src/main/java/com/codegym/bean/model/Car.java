package com.codegym.bean.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;


    @Column(name = "start_point")
    private String startPoint;


    private String destination;

    private String phone;

    private String email;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    private Station station;

    @ManyToOne(targetEntity = CarType.class)
    @JoinColumn(name = "car_type_id", referencedColumnName = "id")
    private CarType carType;

    public Car() {
    }


    public Car(Long id, String code, String startPoint, String destination, String phone, String email, String startTime, String endTime, Station station, CarType carType) {
        this.id = id;
        this.code = code;
        this.startPoint = startPoint;
        this.destination = destination;
        this.phone = phone;
        this.email = email;
        this.startTime = startTime;
        this.endTime = endTime;
        this.station = station;
        this.carType = carType;
    }


    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}


