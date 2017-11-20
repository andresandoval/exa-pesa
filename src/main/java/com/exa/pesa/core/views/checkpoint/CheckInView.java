package com.exa.pesa.core.views.checkpoint;

import com.exa.pesa.core.model.checkpoint.CheckIn;
import com.exa.pesa.core.util.TimeUtils;
import com.exa.pesa.core.views.business.VehicleView;

import java.util.Objects;

/**
 * Created by Andres on 21/10/2017.
 */
public class CheckInView {

    private Integer id;
    private Integer siteId;
    private EntryTypeView entryType;
    private String inputDate;
    private String outputDate;
    private VehicleView transport;
    private Boolean notRegistered;
    private String tiketNumber;
    private String lotCode;
    private Integer state;
    private String photoPath;
    private Boolean automatic;
    private String observation;
    private Boolean meetsConditions;
    private Boolean qualified;

    public CheckInView() {
        super();
    }

    public CheckInView(Integer id, Integer siteId, EntryTypeView entryType, String inputDate, String outputDate,
                       VehicleView transport, Boolean notRegistered, String tiketNumber, String lotCode, Integer
                               state, String photoPath, Boolean automatic, String observation, Boolean
                               meetsConditions, Boolean qualified) {
        this.id = id;
        this.siteId = siteId;
        this.entryType = entryType;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.transport = transport;
        this.notRegistered = notRegistered;
        this.tiketNumber = tiketNumber;
        this.lotCode = lotCode;
        this.state = state;
        this.photoPath = photoPath;
        this.automatic = automatic;
        this.observation = observation;
        this.meetsConditions = meetsConditions;
        this.qualified = qualified;
    }

    public CheckInView(CheckIn checkIn) {

        this.id = checkIn.getId();
        this.siteId = checkIn.getSiteId();
        this.entryType = Objects.nonNull(checkIn.getEntryType()) ? new EntryTypeView(checkIn
                .getEntryType()) : null;
        this.inputDate = TimeUtils.localDateTimeToIsoString(checkIn.getInputDate());
        this.outputDate = TimeUtils.localDateTimeToIsoString(checkIn.getOutputDate());
        this.transport = Objects.nonNull(checkIn.getVehicle()) ? new VehicleView(checkIn.getVehicle
                ()) : null;
        ;
        this.notRegistered = checkIn.getNotRegistered();
        this.tiketNumber = checkIn.getTiketNumber();
        this.lotCode = checkIn.getLotCode();
        this.state = checkIn.getState();
        this.photoPath = checkIn.getPhotoPath();
        this.automatic = checkIn.getAutomatic();
        this.observation = checkIn.getObservation();
        this.meetsConditions = checkIn.getMeetsConditions();
        this.qualified = checkIn.getQualified();
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

    public EntryTypeView getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryTypeView entryType) {
        this.entryType = entryType;
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

    public VehicleView getTransport() {
        return transport;
    }

    public void setTransport(VehicleView transport) {
        this.transport = transport;
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
}
