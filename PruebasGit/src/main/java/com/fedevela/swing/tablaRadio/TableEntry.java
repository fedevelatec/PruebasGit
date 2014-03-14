package com.fedevela.swing.tablaRadio;

import java.util.Date;

/**
 *
 * @author fvelazquez
 */
public class TableEntry {

    private int instanceNumber;
    private Long theId;
    private Date theExpirationDate;
    private Status theStatus;
    private Date theCreationDate;

    TableEntry() {
        instanceNumber++;
        theId = new Long(instanceNumber);
        theExpirationDate = new Date();
        theStatus = Status.Single;
        theCreationDate = new Date();
    }

    TableEntry(Long anId, Date anExpirationDate, Status aStatus, Date aCreationDate) {
        theId = anId;
        theExpirationDate = anExpirationDate;
        theStatus = aStatus;
        theCreationDate = aCreationDate;
    }

    public Long getId() {
        return theId;
    }

    public Date getExpirationDate() {
        return theExpirationDate;
    }

    public Status getStatus() {
        return theStatus;
    }

    public Date getCreationDate() {
        return theCreationDate;
    }

    public void setId(Long anId) {
        theId = anId;
    }

    public void setExpirationDate(Date anExpirationDate) {
        theExpirationDate = anExpirationDate;
    }

    public void setStatus(Status aStatus) {
        theStatus = aStatus;
    }

    public void setCreationDate(Date aCreationDate) {
        theCreationDate = aCreationDate;
    }
}
