package com.exa.pesa.core.views.checkpoint;

import com.exa.pesa.core.model.checkpoint.Logbook;
import com.exa.pesa.core.util.TimeUtils;
import com.exa.pesa.core.views.business.ParameterView;
import com.exa.pesa.core.views.parties.PersonView;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Andres on 22/10/2017.
 */
public class LogbookView {
    private Integer id;
    private String inputDate;
    private String outputDate;
    private String name;
    private ParameterView vehicleType;
    private String vehiclePlate;
    private ParameterView vehicleColor;
    private PersonView contactPerson;
    private ParameterView area;
    private ParameterView materialType;
    private String observation;
    private ParameterView inputReason;
    private ParameterView outputReason;

    public LogbookView() {
        super();
    }

    public LogbookView(Integer id, String inputDate, String outputDate, String name, ParameterView vehicleType, String
            vehiclePlate, ParameterView vehicleColor, PersonView contactPerson, ParameterView area, ParameterView
                               materialType, String observation, ParameterView inputReason, ParameterView
            outputReason) {
        this.id = id;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.name = name;
        this.vehicleType = vehicleType;
        this.vehiclePlate = vehiclePlate;
        this.vehicleColor = vehicleColor;
        this.contactPerson = contactPerson;
        this.area = area;
        this.materialType = materialType;
        this.observation = observation;
        this.inputReason = inputReason;
        this.outputReason = outputReason;
    }

    public LogbookView(Logbook logBook) {
        this.id = logBook.getId();
        this.inputDate = TimeUtils.localDateTimeToIsoString(logBook.getInputDate());
        this.outputDate = TimeUtils.localDateTimeToIsoString(logBook.getOutputDate());
        this.name = logBook.getName();
        this.vehicleType = Objects.nonNull(logBook.getVehicleType()) ? new ParameterView(logBook.getVehicleType()) :
                null;
        this.vehiclePlate = logBook.getVehiclePlate();
        this.vehicleColor = Objects.nonNull(logBook.getVehicleColor()) ? new ParameterView(logBook.getVehicleColor())
                : null;
        this.contactPerson = Objects.nonNull(logBook.getContactPerson()) ? new PersonView(logBook.getContactPerson())
                : null;
        this.area = Objects.nonNull(logBook.getArea()) ? new ParameterView(logBook.getArea()) : null;
        this.materialType = Objects.nonNull(logBook.getMaterialType()) ? new ParameterView(logBook.getMaterialType())
                : null;
        this.observation = logBook.getObservation();
        this.inputReason = Objects.nonNull(logBook.getInputReason()) ? new ParameterView(logBook.getInputReason()) :
                null;
        this.outputReason = Objects.nonNull(logBook.getOutputReason()) ? new ParameterView(logBook.getOutputReason())
                : null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParameterView getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(ParameterView vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public ParameterView getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(ParameterView vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public PersonView getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(PersonView contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ParameterView getArea() {
        return area;
    }

    public void setArea(ParameterView area) {
        this.area = area;
    }

    public ParameterView getMaterialType() {
        return materialType;
    }

    public void setMaterialType(ParameterView materialType) {
        this.materialType = materialType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ParameterView getInputReason() {
        return inputReason;
    }

    public void setInputReason(ParameterView inputReason) {
        this.inputReason = inputReason;
    }

    public ParameterView getOutputReason() {
        return outputReason;
    }

    public void setOutputReason(ParameterView outputReason) {
        this.outputReason = outputReason;
    }
}
