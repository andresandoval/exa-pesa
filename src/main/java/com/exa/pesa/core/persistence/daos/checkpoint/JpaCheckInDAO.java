package com.exa.pesa.core.persistence.daos.checkpoint;

import com.exa.pesa.core.persistence.entitities.checkpoint.JpaCheckIn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres on 21/10/2017.
 */
public interface JpaCheckInDAO extends CrudRepository<JpaCheckIn, Integer> {

    @Query(value = "SELECT gar.* FROM Garita gar WHERE " +
            "gar.Estado = ?1 AND " +
            "gar.FechaSalida IS NULL AND " +
            "gar.Anulado = 0 AND " +
            "gar.IDGarita NOT IN (SELECT IDGarita FROM Peso_Bruto WHERE Anulado = 1)", nativeQuery = true)
    public List<JpaCheckIn> findAllEntriesByState(Integer state);

    @Query(value = "SELECT gar.* FROM Garita gar WHERE " +
            "gar.Estado = ?1 AND " +
            "gar.TipoEntrada = ?2 AND " +
            "gar.Anulado = 0 AND " +
            "gar.IDGarita NOT IN (SELECT IDGarita FROM Peso_Bruto WHERE Anulado = 1)", nativeQuery = true)
    public List<JpaCheckIn> findByStateAndEntryType(Integer state, Integer entryType);

    @Query(value = "SELECT gar.* FROM Garita gar WHERE " +
            "((gar.Estado = ?1) OR (gar.Estado = 1)) AND " +
            "gar.TipoEntrada = ?2 AND " +
            "gar.Anulado = 0 AND " +
            "gar.IDGarita NOT IN (SELECT IDGarita FROM Peso_Bruto WHERE Anulado = 1)", nativeQuery = true)
    public List<JpaCheckIn> findByStateAndEntryTypeIncludedInTransit(Integer state, Integer entryType);

    @Query(value = "SELECT NumTicket + 1 FROM Consect_Ticket where Tipo_Ticket=?1", nativeQuery = true)
    Integer getNumTiquet(String type);

    @Procedure(name = "saveData")
    public void saveData(
            @Param("ID_Local") Integer siteId,
            @Param("TipoEntrada") Integer entryTypeId,
            @Param("Fecha") Date date,
            @Param("Placa") String vehiclePlate,
            @Param("NoReg") Boolean noReg,
            @Param("NumTiquet") String ticketNumber,
            @Param("CodLote") String loteCode,
            @Param("Estado") Integer state,
            @Param("Automatico") Boolean automatic,
            @Param("Observacion") String observation,
            @Param("CumpleCond") Boolean meetsConditions,
            @Param("Calificado") Boolean qualified,
            @Param("Usuario") String user,
            @Param("IDGarita") Integer checkpointId
    );

    @Procedure(name = "updateData")
    public void updateData(
            @Param("Garita_ID") Integer id,
            @Param("TipoEntrada") Integer entryTypeId,
            @Param("tiquetNum") String ticketNumber,
            @Param("ingresoNum") String loteCode,
            @Param("ID_Camion") String vehiclePlate,
            @Param("NoReg") Boolean noReg,
            @Param("Obs") String observation,
            @Param("CumpleCond") Boolean meetsConditions,
            @Param("Usuario") String user

    );

    @Procedure(name="updateState")
    public void updateState(
            @Param("IDGarita") Integer id,
            @Param("estado") Integer state,
            @Param("act_placa") Boolean updatePlate,
            @Param("placa") String vehiclePlate,
            @Param("usuario") String user
    );

}
