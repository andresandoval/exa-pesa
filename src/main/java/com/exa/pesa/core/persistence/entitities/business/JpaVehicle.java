package com.exa.pesa.core.persistence.entitities.business;

import com.exa.pesa.core.model.business.Vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Andres on 21/10/2017.
 */
@Entity
@Table(name = "transporte")
public class JpaVehicle {

    @Id
    @Column(name = "chapa_camion", nullable = false)
    private String plate;

    @Column(name = "tipovehiculo", nullable = false)
    private String type;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "tolerancia", nullable = false)
    private Integer tolerance;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "inactivo", nullable = false)
    private Boolean inactive;

    public JpaVehicle() {
        super();
    }

    public JpaVehicle(String plate, String type, String description, Integer tolerance, Date date, Boolean inactive) {
        this.plate = plate;
        this.type = type;
        this.description = description;
        this.tolerance = tolerance;
        this.date = date;
        this.inactive = inactive;
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

    public Vehicle getModel() {
        return new Vehicle(plate, type, description, tolerance, date, inactive);
    }
}
