/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.Modele;

/**
 *
 * @author PC-MEHDI
 */
public class Warehouse {
    private Long  id ;
    private String LOCALIZATION  ;
    private Long VOLUME  ;
    private Long CAPACITE  ;
    private Long NBEMP  ;
    private String STATUS  ;
    private String AVAILABILITY;

    public Warehouse(Long id, String LOCALIZATION, Long VOLUME, Long CAPACITE, Long NBEMP, String STATUS, String AVAILABILITY) {
        this.id = id;
        this.LOCALIZATION = LOCALIZATION;
        this.VOLUME = VOLUME;
        this.CAPACITE = CAPACITE;
        this.NBEMP = NBEMP;
        this.STATUS = STATUS;
        this.AVAILABILITY = AVAILABILITY;
    }

    public Warehouse(String LOCALIZATION, Long VOLUME, Long CAPACITE, Long NBEMP, String STATUS, String AVAILABILITY) {
        this.LOCALIZATION = LOCALIZATION;
        this.VOLUME = VOLUME;
        this.CAPACITE = CAPACITE;
        this.NBEMP = NBEMP;
        this.STATUS = STATUS;
        this.AVAILABILITY = AVAILABILITY;
    }

    public Warehouse() {
    }

    public Long getId() {
        return id;
    }

    public String getLOCALIZATION() {
        return LOCALIZATION;
    }

    public Long getVOLUME() {
        return VOLUME;
    }

    public Long getCAPACITE() {
        return CAPACITE;
    }

    public Long getNBEMP() {
        return NBEMP;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getAVAILABILITY() {
        return AVAILABILITY;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLOCALIZATION(String LOCALIZATION) {
        this.LOCALIZATION = LOCALIZATION;
    }

    public void setVOLUME(Long VOLUME) {
        this.VOLUME = VOLUME;
    }

    public void setCAPACITE(Long CAPACITE) {
        this.CAPACITE = CAPACITE;
    }

    public void setNBEMP(Long NBEMP) {
        this.NBEMP = NBEMP;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public void setAVAILABILITY(String AVAILABILITY) {
        this.AVAILABILITY = AVAILABILITY;
    }
}
