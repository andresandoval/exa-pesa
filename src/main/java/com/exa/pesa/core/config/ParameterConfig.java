package com.exa.pesa.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "exa.params")
@Configuration
public class ParameterConfig {

    private String inputTypeGroup;
    private String outputTypeGroup;
    private String vehicleTypeGroup;
    private String colorGroup;
    private String areaGroup;
    private String materialTypeGroup;

    public String getInputTypeGroup() {
        return inputTypeGroup;
    }

    public void setInputTypeGroup(String inputTypeGroup) {
        this.inputTypeGroup = inputTypeGroup;
    }

    public String getOutputTypeGroup() {
        return outputTypeGroup;
    }

    public void setOutputTypeGroup(String outputTypeGroup) {
        this.outputTypeGroup = outputTypeGroup;
    }

    public String getVehicleTypeGroup() {
        return vehicleTypeGroup;
    }

    public void setVehicleTypeGroup(String vehicleTypeGroup) {
        this.vehicleTypeGroup = vehicleTypeGroup;
    }

    public String getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(String colorGroup) {
        this.colorGroup = colorGroup;
    }

    public String getAreaGroup() {
        return areaGroup;
    }

    public void setAreaGroup(String areaGroup) {
        this.areaGroup = areaGroup;
    }

    public String getMaterialTypeGroup() {
        return materialTypeGroup;
    }

    public void setMaterialTypeGroup(String materialTypeGroup) {
        this.materialTypeGroup = materialTypeGroup;
    }
}
