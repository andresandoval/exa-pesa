package com.exa.pesa.core.model.business;

import com.exa.pesa.core.persistence.entitities.business.JpaVehicle;

import java.util.Date;

/**
 * Created by Andres on 21/10/2017.
 */
public class Vehicle {
    private String plate;
    private String type;
    private String description;
    private Integer tolerance;
    private Date date;
    private Boolean inactive;

    public Vehicle() {
        super();
    }

    public Vehicle(String plate, String type, String description, Integer tolerance, Date date, Boolean inactive) {
        this.plate = plate;
        this.type = type;
        this.description = description;
        this.tolerance = tolerance;
        this.date = date;
        this.inactive = inactive;
    }

    public Vehicle(JpaVehicle jpaVehicle) {
        this(jpaVehicle.getPlate(), jpaVehicle.getType(), jpaVehicle.getDescription(), jpaVehicle.getTolerance(), jpaVehicle.getDate(), jpaVehicle.getInactive());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (plate != null ? !plate.equals(vehicle.plate) : vehicle.plate != null) return false;
        if (type != null ? !type.equals(vehicle.type) : vehicle.type != null) return false;
        if (description != null ? !description.equals(vehicle.description) : vehicle.description != null)
            return false;
        if (tolerance != null ? !tolerance.equals(vehicle.tolerance) : vehicle.tolerance != null) return false;
        if (date != null ? !date.equals(vehicle.date) : vehicle.date != null) return false;
        return inactive != null ? inactive.equals(vehicle.inactive) : vehicle.inactive == null;
    }

    @Override
    public int hashCode() {
        int result = plate != null ? plate.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tolerance != null ? tolerance.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (inactive != null ? inactive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plate='" + plate + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", tolerance=" + tolerance +
                ", date=" + date +
                ", inactive=" + inactive +
                '}';
    }
}
