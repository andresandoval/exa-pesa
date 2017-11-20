package com.exa.pesa.core.views.checkpoint;

import java.util.Date;

public class CheckInCreationView {
    private Integer siteId;
    private Integer entryTypeId;
    private Date date;
    private String vehiclePlate;
    private Boolean noReg;
    private String ticketNumber;
    private String lotCode;
    private Integer state;
    private Boolean automatic;
    private String observation;
    private Boolean meetsConditions;
    private Boolean qualified;
    private String user;
    private Integer checkpointId;

    public CheckInCreationView() {
        super();
    }

    public CheckInCreationView(Integer siteId, Integer entryTypeId, Date date, String vehiclePlate, Boolean noReg,
                               String ticketNumber, String lotCode, Integer state, Boolean automatic, String
                                       observation, Boolean meetsConditions, Boolean qualified, String user, Integer
                                       checkpointId) {
        this.siteId = siteId;
        this.entryTypeId = entryTypeId;
        this.date = date;
        this.vehiclePlate = vehiclePlate;
        this.noReg = noReg;
        this.ticketNumber = ticketNumber;
        this.lotCode = lotCode;
        this.state = state;
        this.automatic = automatic;
        this.observation = observation;
        this.meetsConditions = meetsConditions;
        this.qualified = qualified;
        this.user = user;
        this.checkpointId = checkpointId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getEntryTypeId() {
        return entryTypeId;
    }

    public void setEntryTypeId(Integer entryTypeId) {
        this.entryTypeId = entryTypeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public Boolean getNoReg() {
        return noReg;
    }

    public void setNoReg(Boolean noReg) {
        this.noReg = noReg;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(Integer checkpointId) {
        this.checkpointId = checkpointId;
    }
}
