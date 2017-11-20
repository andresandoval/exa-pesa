package com.exa.pesa.core.views.business;

import com.exa.pesa.core.model.business.Vehicle;

import java.util.Date;

/**
 * Created by Andres on 21/10/2017.
 */
public class VehicleView {
    private String plate;
    private String type;
    private String description;
    private Integer tolerance;
    private Date date;
    private Boolean inactive;

    public VehicleView() {
        super();
    }

    public VehicleView(String plate, String type, String description, Integer tolerance, Date date, Boolean
            inactive) {
        this.plate = plate;
        this.type = type;
        this.description = description;
        this.tolerance = tolerance;
        this.date = date;
        this.inactive = inactive;
    }

    public VehicleView(Vehicle vehicle) {
        this(vehicle.getPlate(), vehicle.getType(), vehicle.getDescription(), vehicle.getTolerance(),
                vehicle.getDate(), vehicle.getInactive());
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTolerance() {
        return tolerance;
    }

    public void setTolerance(Integer tolerance) {
        this.tolerance = tolerance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }
}
