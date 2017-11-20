package com.exa.pesa.core.model.checkpoint;

import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.model.parties.Person;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Andres on 22/10/2017.
 */
public class Logbook {
    private Integer id;
    private Integer siteId;
    private LocalDateTime inputDate;
    private LocalDateTime outputDate;
    private String name;
    private Parameter vehicleType;
    private String vehiclePlate;
    private Parameter vehicleColor;
    private Person contactPerson;
    private Parameter area;
    private Parameter materialType;
    private String observation;
    private Parameter inputReason;
    private Parameter outputReason;
    private String creationUser;
    private LocalDateTime creationDate;
    private String modificationUser;
    private LocalDateTime modificationDate;
    private Boolean voided;
    private String voidUser;
    private LocalDateTime voidDate;

    public Logbook() {
        super();
    }

    public Logbook(Integer id, Integer siteId, LocalDateTime inputDate, LocalDateTime outputDate, String name,
                   Parameter vehicleType,
                   String vehiclePlate, Parameter vehicleColor, Person contactPerson, Parameter area, Parameter
                           materialType, String observation, Parameter inputReason, Parameter outputReason, String
                           creationUser, LocalDateTime creationDate, String modificationUser, LocalDateTime
                           modificationDate, Boolean
                           voided, String voidUser, LocalDateTime voidDate) {
        this.id = id;
        this.siteId = siteId;
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
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.modificationUser = modificationUser;
        this.modificationDate = modificationDate;
        this.voided = voided;
        this.voidUser = voidUser;
        this.voidDate = voidDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public LocalDateTime getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDateTime inputDate) {
        this.inputDate = inputDate;
    }

    public LocalDateTime getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(LocalDateTime outputDate) {
        this.outputDate = outputDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parameter getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Parameter vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public Parameter getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(Parameter vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Parameter getArea() {
        return area;
    }

    public void setArea(Parameter area) {
        this.area = area;
    }

    public Parameter getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Parameter materialType) {
        this.materialType = materialType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Parameter getInputReason() {
        return inputReason;
    }

    public void setInputReason(Parameter inputReason) {
        this.inputReason = inputReason;
    }

    public Parameter getOutputReason() {
        return outputReason;
    }

    public void setOutputReason(Parameter outputReason) {
        this.outputReason = outputReason;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Boolean getVoided() {
        return voided;
    }

    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    public String getVoidUser() {
        return voidUser;
    }

    public void setVoidUser(String voidUser) {
        this.voidUser = voidUser;
    }

    public LocalDateTime getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(LocalDateTime voidDate) {
        this.voidDate = voidDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logbook logBook = (Logbook) o;

        if (id != null ? !id.equals(logBook.id) : logBook.id != null) return false;
        if (siteId != null ? !siteId.equals(logBook.siteId) : logBook.siteId != null) return false;
        if (inputDate != null ? !inputDate.equals(logBook.inputDate) : logBook.inputDate != null) return false;
        if (outputDate != null ? !outputDate.equals(logBook.outputDate) : logBook.outputDate != null) return false;
        if (name != null ? !name.equals(logBook.name) : logBook.name != null) return false;
        if (vehicleType != null ? !vehicleType.equals(logBook.vehicleType) : logBook.vehicleType != null) return false;
        if (vehiclePlate != null ? !vehiclePlate.equals(logBook.vehiclePlate) : logBook.vehiclePlate != null)
            return false;
        if (vehicleColor != null ? !vehicleColor.equals(logBook.vehicleColor) : logBook.vehicleColor != null)
            return false;
        if (contactPerson != null ? !contactPerson.equals(logBook.contactPerson) : logBook.contactPerson != null)
            return false;
        if (area != null ? !area.equals(logBook.area) : logBook.area != null) return false;
        if (materialType != null ? !materialType.equals(logBook.materialType) : logBook.materialType != null)
            return false;
        if (observation != null ? !observation.equals(logBook.observation) : logBook.observation != null) return false;
        if (inputReason != null ? !inputReason.equals(logBook.inputReason) : logBook.inputReason != null) return false;
        if (outputReason != null ? !outputReason.equals(logBook.outputReason) : logBook.outputReason != null)
            return false;
        if (creationUser != null ? !creationUser.equals(logBook.creationUser) : logBook.creationUser != null)
            return false;
        if (creationDate != null ? !creationDate.equals(logBook.creationDate) : logBook.creationDate != null)
            return false;
        if (modificationUser != null ? !modificationUser.equals(logBook.modificationUser) : logBook.modificationUser
                != null)
            return false;
        if (modificationDate != null ? !modificationDate.equals(logBook.modificationDate) : logBook.modificationDate
                != null)
            return false;
        if (voided != null ? !voided.equals(logBook.voided) : logBook.voided != null) return false;
        if (voidUser != null ? !voidUser.equals(logBook.voidUser) : logBook.voidUser != null) return false;
        return voidDate != null ? voidDate.equals(logBook.voidDate) : logBook.voidDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (inputDate != null ? inputDate.hashCode() : 0);
        result = 31 * result + (outputDate != null ? outputDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (vehicleType != null ? vehicleType.hashCode() : 0);
        result = 31 * result + (vehiclePlate != null ? vehiclePlate.hashCode() : 0);
        result = 31 * result + (vehicleColor != null ? vehicleColor.hashCode() : 0);
        result = 31 * result + (contactPerson != null ? contactPerson.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (materialType != null ? materialType.hashCode() : 0);
        result = 31 * result + (observation != null ? observation.hashCode() : 0);
        result = 31 * result + (inputReason != null ? inputReason.hashCode() : 0);
        result = 31 * result + (outputReason != null ? outputReason.hashCode() : 0);
        result = 31 * result + (creationUser != null ? creationUser.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (modificationUser != null ? modificationUser.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (voidUser != null ? voidUser.hashCode() : 0);
        result = 31 * result + (voidDate != null ? voidDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Logbook{" +
                "id=" + id +
                ", siteId=" + siteId +
                ", inputDate=" + inputDate +
                ", outputDate=" + outputDate +
                ", name='" + name + '\'' +
                ", vehicleType=" + vehicleType +
                ", vehiclePlate='" + vehiclePlate + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", contactPerson=" + contactPerson +
                ", area=" + area +
                ", materialType=" + materialType +
                ", observation='" + observation + '\'' +
                ", inputReason=" + inputReason +
                ", outputReason=" + outputReason +
                ", creationUser='" + creationUser + '\'' +
                ", creationDate=" + creationDate +
                ", modificationUser='" + modificationUser + '\'' +
                ", modificationDate=" + modificationDate +
                ", voided=" + voided +
                ", voidUser='" + voidUser + '\'' +
                ", voidDate=" + voidDate +
                '}';
    }
}
