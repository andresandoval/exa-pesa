package com.exa.pesa.core.persistence.entitities.checkpoint;

import com.exa.pesa.core.model.business.Parameter;
import com.exa.pesa.core.model.checkpoint.Logbook;
import com.exa.pesa.core.model.parties.Person;
import com.exa.pesa.core.persistence.entitities.parties.JpaPerson;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Andres on 22/10/2017.
 */
@Entity
@Table(name = "Bitacora")
public class JpaLogbook {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_local", nullable = false)
    private Integer siteId;

    @Column(name = "fechaingreso", nullable = false)
    private LocalDateTime inputDate;

    @Column(name = "fechasalida", nullable = true)
    private LocalDateTime outputDate;

    @Column(name = "nombre", nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipovehiculo")
    private JpaLogbookParameter vehicleType;

    @Column(name = "placavehiculo", nullable = true)
    private String vehiclePlate;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "colorvehiculo")
    private JpaLogbookParameter vehicleColor;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_personacontacto")
    private JpaPerson contactPerson;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "area")
    private JpaLogbookParameter area;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "clasematerial")
    private JpaLogbookParameter materialType;

    @Column(name = "observacion", nullable = true)
    private String observation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "motivoentrada")
    private JpaLogbookParameter inputReason;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "motivosalida")
    private JpaLogbookParameter outputReason;

    @Column(name = "usucre", nullable = false)
    private String creationUser;

    @Column(name = "feccre", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "usumod", nullable = true)
    private String modificationUser;

    @Column(name = "fecmod", nullable = true)
    private LocalDateTime modificationDate;

    @Column(name = "anulado", nullable = false)
    private Boolean voided;

    @Column(name = "usuanu", nullable = true)
    private String voidUser;

    @Column(name = "fecanu", nullable = true)
    private LocalDateTime voidDate;

    public JpaLogbook() {
        super();
    }

    public JpaLogbook(Integer siteId, LocalDateTime inputDate, LocalDateTime outputDate, String name,
                      JpaLogbookParameter vehicleType, String vehiclePlate, JpaLogbookParameter vehicleColor,
                      JpaPerson contactPerson, JpaLogbookParameter area, JpaLogbookParameter materialType, String
                              observation, JpaLogbookParameter inputReason, JpaLogbookParameter outputReason, String
                              creationUser, LocalDateTime creationDate, String modificationUser, LocalDateTime
                              modificationDate, Boolean voided, String voidUser, LocalDateTime voidDate) {
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

    public JpaLogbook(Logbook model) {
        this.siteId = model.getSiteId();
        this.inputDate = model.getInputDate();
        this.outputDate = model.getOutputDate();
        this.name = model.getName();
        this.vehicleType = new JpaLogbookParameter(model.getVehicleType());
        if (!model.getVehicleType().getId().equals("0")) {
            this.vehiclePlate = model.getVehiclePlate();
            this.vehicleColor = new JpaLogbookParameter(model.getVehicleColor());
        }
        if (Objects.nonNull(model.getContactPerson())) {
            this.contactPerson = new JpaPerson(model.getContactPerson());
        }
        this.area = new JpaLogbookParameter(model.getArea());
        this.materialType = new JpaLogbookParameter(model.getMaterialType());
        this.observation = model.getObservation();
        this.inputReason = new JpaLogbookParameter(model.getInputReason());
        if (Objects.nonNull(model.getOutputReason())) {
            this.outputReason = new JpaLogbookParameter(model.getOutputReason());
        }
        this.creationDate = LocalDateTime.now();
        this.modificationUser = null;
        this.modificationDate = null;
        this.voided = false;
        this.voidUser = null;
        this.voidDate = null;
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

    public JpaLogbookParameter getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(JpaLogbookParameter vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public JpaLogbookParameter getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(JpaLogbookParameter vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public JpaPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(JpaPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public JpaLogbookParameter getArea() {
        return area;
    }

    public void setArea(JpaLogbookParameter area) {
        this.area = area;
    }

    public JpaLogbookParameter getMaterialType() {
        return materialType;
    }

    public void setMaterialType(JpaLogbookParameter materialType) {
        this.materialType = materialType;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public JpaLogbookParameter getInputReason() {
        return inputReason;
    }

    public void setInputReason(JpaLogbookParameter inputReason) {
        this.inputReason = inputReason;
    }

    public JpaLogbookParameter getOutputReason() {
        return outputReason;
    }

    public void setOutputReason(JpaLogbookParameter outputReason) {
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

    public Logbook getModel() {
        Parameter vehicleTypeParam = Objects.isNull(vehicleType) ? null : vehicleType.getParameter().getModel();
        Parameter vehicleColorParam = Objects.isNull(vehicleColor) ? null : vehicleColor.getParameter().getModel();
        Person contactPersonModel = Objects.isNull(contactPerson) ? null : contactPerson.getModel();
        Parameter areaParam = Objects.isNull(area) ? null : area.getParameter().getModel();
        Parameter materialTypeParam = Objects.isNull(materialType) ? null : materialType.getParameter().getModel();
        Parameter inputReasonParam = Objects.isNull(inputReason) ? null : inputReason.getParameter().getModel();
        Parameter outputReasonParam = Objects.isNull(outputReason) ? null : outputReason.getParameter().getModel();

        return new Logbook(id, siteId, inputDate, outputDate, name, vehicleTypeParam, vehiclePlate, vehicleColorParam,
                contactPersonModel,
                areaParam, materialTypeParam, observation, inputReasonParam, outputReasonParam, creationUser,
                creationDate,
                modificationUser, modificationDate, voided, voidUser, voidDate);
    }
}
