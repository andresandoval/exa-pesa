package com.exa.pesa.core.views.checkpoint;

public class LogbookOutView {
    private String outputDate;
    private String outputReasonId;
    private String observation;

    public LogbookOutView() {
        super();
    }

    public LogbookOutView(String outputDate, String outputReasonId, String observation) {
        this.outputDate = outputDate;
        this.outputReasonId = outputReasonId;
        this.observation = observation;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getOutputReasonId() {
        return outputReasonId;
    }

    public void setOutputReasonId(String outputReasonId) {
        this.outputReasonId = outputReasonId;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
