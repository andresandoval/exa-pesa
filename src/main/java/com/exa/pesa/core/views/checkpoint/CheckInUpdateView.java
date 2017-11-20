package com.exa.pesa.core.views.checkpoint;

public class CheckInUpdateView {
    private Integer id;
    private Integer entryTypeId;
    private String ticketNumber;
    private String lotCode;
    private String vehiclePlate;
    private Boolean noReg;
    private String observation;
    private Boolean meetsConditions;
    private String user;

    public CheckInUpdateView() {
        super();
    }

    public CheckInUpdateView(Integer id, Integer entryTypeId, String ticketNumber, String lotCode, String
            vehiclePlate, Boolean noReg, String observation, Boolean meetsConditions, String user) {
        this.id = id;
        this.entryTypeId = entryTypeId;
        this.ticketNumber = ticketNumber;
        this.lotCode = lotCode;
        this.vehiclePlate = vehiclePlate;
        this.noReg = noReg;
        this.observation = observation;
        this.meetsConditions = meetsConditions;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntryTypeId() {
        return entryTypeId;
    }

    public void setEntryTypeId(Integer entryTypeId) {
        this.entryTypeId = entryTypeId;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
