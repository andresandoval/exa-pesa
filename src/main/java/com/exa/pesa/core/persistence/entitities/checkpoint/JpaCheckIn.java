package com.exa.pesa.core.persistence.entitities.checkpoint;

import com.exa.pesa.core.model.business.Vehicle;
import com.exa.pesa.core.model.checkpoint.CheckIn;
import com.exa.pesa.core.model.checkpoint.EntryType;
import com.exa.pesa.core.persistence.entitities.business.JpaVehicle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Andres on 21/10/2017.
 */
@Entity
@Table(name = "garita")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "saveData", procedureName = "dbo.insert_garita", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_Local", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "TipoEntrada", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Fecha", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Placa", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "NoReg", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "NumTiquet", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "CodLote", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Estado", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Automatico", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Observacion", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CumpleCond", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Calificado", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Usuario", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.INOUT, name = "IDGarita", type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "updateData", procedureName = "dbo.actualizar_garita", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Garita_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "TipoEntrada", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tiquetNum", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "ingresoNum", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_Camion", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "NoReg", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Obs", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CumpleCond", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Usuario", type = String.class)
        }),
        @NamedStoredProcedureQuery(name = "updateState", procedureName = "dbo.actualizarestado_lote", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "IDGarita", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "estado", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "act_placa", type = Boolean.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "placa", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "usuario", type = String.class)
        })
})
public class JpaCheckIn {

    @Id
    @Column(name = "idgarita", nullable = false)
    private Integer id;

    @Column(name = "id_local", nullable = false)
    private Integer siteId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoentrada")
    private JpaEntryType entryType;

    @Column(name = "fecha_garita", nullable = false)
    private LocalDateTime inputDate;

    @Column(name = "fechasalida", nullable = true)
    private LocalDateTime outputDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placa")
    private JpaVehicle transport;

    @Column(name = "noregistrado", nullable = false)
    private Boolean notRegistered;

    @Column(name = "numtiquet", nullable = false)
    private String tiketNumber;

    @Column(name = "codlote", nullable = true)
    private String lotCode;

    @Column(name = "estado", nullable = false)
    private Integer state;

    @Column(name = "dirfoto", nullable = true)
    private String photoPath;

    @Column(name = "automatico", nullable = false)
    private Boolean automatic;

    @Column(name = "observacion", nullable = true)
    private String observation;

    @Column(name = "usucre", nullable = false)
    private String creationUser;

    @Column(name = "feccre", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "usumod", nullable = true)
    private String modificationUser;

    @Column(name = "fecmod", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @Column(name = "anulado", nullable = false)
    private Boolean voided;

    @Column(name = "usuanu", nullable = true)
    private String voidUser;

    @Column(name = "fecanu", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date voidDate;

    @Column(name = "cumplecond", nullable = false)
    private Boolean meetsConditions;

    @Column(name = "calificado", nullable = false)
    private Boolean qualified;

    public JpaCheckIn() {
        super();
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

    public JpaEntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(JpaEntryType entryType) {
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

    public JpaVehicle getTransport() {
        return transport;
    }

    public void setTransport(JpaVehicle transport) {
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

    public CheckIn getModel() {
        EntryType modelEntryType = Objects.nonNull(entryType) ? entryType.getModel() : null;
        Vehicle modelVehicle = Objects.nonNull(transport) ? transport.getModel() : null;

        return new CheckIn(id, siteId, modelEntryType, inputDate, outputDate, modelVehicle,
                notRegistered, tiketNumber, lotCode, state, photoPath, automatic, observation, creationUser,
                creationDate, modificationUser, modificationDate, voided, voidUser, voidDate, meetsConditions,
                qualified);
    }
}
