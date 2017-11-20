package com.exa.pesa.core.model.checkpoint;

import com.exa.pesa.core.model.business.Vehicle;
import com.exa.pesa.core.persistence.entitities.checkpoint.JpaCheckIn;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Andres on 21/10/2017.
 */
public class CheckIn {

    private Integer id;
    private Integer siteId;
    private EntryType entryType;
    private LocalDateTime inputDate;
    private LocalDateTime outputDate;
    private Vehicle vehicle;
    private Boolean notRegistered;
    private String tiketNumber;
    private String lotCode;
    private Integer state;
    private String photoPath;
    private Boolean automatic;
    private String observation;
    private String creationUser;
    private Date creationDate;
    private String modificationUser;
    private Date modificationDate;
    private Boolean voided;
    private String voidUser;
    private Date voidDate;
    private Boolean meetsConditions;
    private Boolean qualified;

    public CheckIn() {
        super();
    }

    public CheckIn(Integer id, Integer siteId, EntryType entryType, LocalDateTime inputDate, LocalDateTime outputDate, Vehicle vehicle, Boolean notRegistered, String tiketNumber, String lotCode, Integer state, String photoPath, Boolean automatic, String observation, String creationUser, Date creationDate, String modificationUser, Date modificationDate, Boolean voided, String voidUser, Date voidDate, Boolean meetsConditions, Boolean qualified) {
        this.id = id;
        this.siteId = siteId;
        this.entryType = entryType;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.vehicle = vehicle;
        this.notRegistered = notRegistered;
        this.tiketNumber = tiketNumber;
        this.lotCode = lotCode;
        this.state = state;
        this.photoPath = photoPath;
        this.automatic = automatic;
        this.observation = observation;
        this.creationUser = creationUser;
        this.creationDate = creationDate;
        this.modificationUser = modificationUser;
        this.modificationDate = modificationDate;
        this.voided = voided;
        this.voidUser = voidUser;
        this.voidDate = voidDate;
        this.meetsConditions = meetsConditions;
        this.qualified = qualified;
    }

    public CheckIn(JpaCheckIn checkIn) {
        this(checkIn.getId(), checkIn.getSiteId(), Objects.nonNull(checkIn.getEntryType()) ? new EntryType(checkIn.getEntryType()) : null, checkIn.getInputDate(), checkIn.getOutputDate(), Objects.nonNull(checkIn.getTransport()) ? new Vehicle(checkIn.getTransport()) : null, checkIn.getNotRegistered(), checkIn.getTiketNumber(), checkIn.getLotCode(), checkIn.getState(), checkIn.getPhotoPath(), checkIn.getAutomatic(), checkIn.getObservation(), checkIn.getCreationUser(), checkIn.getCreationDate(), checkIn.getModificationUser(), checkIn.getModificationDate(), checkIn.getVoided(), checkIn.getVoidUser(), checkIn.getVoidDate(), checkIn.getMeetsConditions(), checkIn.getQualified());
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

    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getNotRegistered() {
        return notRegistered;
    }

    public void setNotRegistered(Boolean notRegistered) {
        this.notRegistered = notRegistered;
    }

    public String getTiketNumber() {
        return tiketNumber;
    }

    public void setTiketNumber(String tiketNumber) {
        this.tiketNumber = tiketNumber;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
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

    public Date getVoidDate() {
        return voidDate;
    }

    public void setVoidDate(Date voidDate) {
        this.voidDate = voidDate;
    }

    public Boolean getMeetsConditions() {
        return meetsConditions;
    }

    public void setMeetsConditions(Boolean meetsConditions) {
        this.meetsConditions = meetsConditions;
    }

    public Boolean getQualified() {
        return qualified;
    }

    public void setQualified(Boolean qualified) {
        this.qualified = qualified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckIn that = (CheckIn) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (siteId != null ? !siteId.equals(that.siteId) : that.siteId != null) return false;
        if (entryType != null ? !entryType.equals(that.entryType) : that.entryType != null) return false;
        if (inputDate != null ? !inputDate.equals(that.inputDate) : that.inputDate != null) return false;
        if (outputDate != null ? !outputDate.equals(that.outputDate) : that.outputDate != null) return false;
        if (vehicle != null ? !vehicle.equals(that.vehicle) : that.vehicle != null) return false;
        if (notRegistered != null ? !notRegistered.equals(that.notRegistered) : that.notRegistered != null)
            return false;
        if (tiketNumber != null ? !tiketNumber.equals(that.tiketNumber) : that.tiketNumber != null) return false;
        if (lotCode != null ? !lotCode.equals(that.lotCode) : that.lotCode != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (photoPath != null ? !photoPath.equals(that.photoPath) : that.photoPath != null) return false;
        if (automatic != null ? !automatic.equals(that.automatic) : that.automatic != null) return false;
        if (observation != null ? !observation.equals(that.observation) : that.observation != null) return false;
        if (creationUser != null ? !creationUser.equals(that.creationUser) : that.creationUser != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (modificationUser != null ? !modificationUser.equals(that.modificationUser) : that.modificationUser != null)
            return false;
        if (modificationDate != null ? !modificationDate.equals(that.modificationDate) : that.modificationDate != null)
            return false;
        if (voided != null ? !voided.equals(that.voided) : that.voided != null) return false;
        if (voidUser != null ? !voidUser.equals(that.voidUser) : that.voidUser != null) return false;
        if (voidDate != null ? !voidDate.equals(that.voidDate) : that.voidDate != null) return false;
        if (meetsConditions != null ? !meetsConditions.equals(that.meetsConditions) : that.meetsConditions != null)
            return false;
        return qualified != null ? qualified.equals(that.qualified) : that.qualified == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (siteId != null ? siteId.hashCode() : 0);
        result = 31 * result + (entryType != null ? entryType.hashCode() : 0);
        result = 31 * result + (inputDate != null ? inputDate.hashCode() : 0);
        result = 31 * result + (outputDate != null ? outputDate.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (notRegistered != null ? notRegistered.hashCode() : 0);
        result = 31 * result + (tiketNumber != null ? tiketNumber.hashCode() : 0);
        result = 31 * result + (lotCode != null ? lotCode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        result = 31 * result + (automatic != null ? automatic.hashCode() : 0);
        result = 31 * result + (observation != null ? observation.hashCode() : 0);
        result = 31 * result + (creationUser != null ? creationUser.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (modificationUser != null ? modificationUser.hashCode() : 0);
        result = 31 * result + (modificationDate != null ? modificationDate.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (voidUser != null ? voidUser.hashCode() : 0);
        result = 31 * result + (voidDate != null ? voidDate.hashCode() : 0);
        result = 31 * result + (meetsConditions != null ? meetsConditions.hashCode() : 0);
        result = 31 * result + (qualified != null ? qualified.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", siteId=" + siteId +
                ", entryType=" + entryType +
                ", inputDate=" + inputDate +
                ", outputDate=" + outputDate +
                ", vehicle=" + vehicle +
                ", notRegistered=" + notRegistered +
                ", tiketNumber='" + tiketNumber + '\'' +
                ", lotCode='" + lotCode + '\'' +
                ", state=" + state +
                ", photoPath='" + photoPath + '\'' +
                ", automatic=" + automatic +
                ", observation='" + observation + '\'' +
                ", creationUser='" + creationUser + '\'' +
                ", creationDate=" + creationDate +
                ", modificationUser='" + modificationUser + '\'' +
                ", modificationDate=" + modificationDate +
                ", voided=" + voided +
                ", voidUser='" + voidUser + '\'' +
                ", voidDate=" + voidDate +
                ", meetsConditions=" + meetsConditions +
                ", qualified=" + qualified +
                '}';
    }
}
