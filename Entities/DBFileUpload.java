package com.perfectsolution.Clinique.Entities;

import java.io.*;
import javax.xml.bind.annotation.*;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "filesupload")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "filesupload.findAll", query = "SELECT d.id AS id,d.fileName AS fileName,d.fileType AS fileType FROM DBFileUpload d WHERE d.numPatient= :numPatient"), @NamedQuery(name = "filesupload.Delete", query = "DELETE FROM DBFileUpload d WHERE d.id = :idfile") })
public class DBFileUpload implements Serializable
{
    @Size(max = 300)
    @Column(name = "file_name")
    private String fileName;
    @Size(max = 300)
    @Column(name = "file_type")
    private String fileType;
    @Lob
    @Column(name = "data")
    private byte[] data;
    @Column(name = "num_patient")
    private Integer numPatient;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    
    public DBFileUpload() {
    }
    
    public DBFileUpload(final String fileName, final String fileType, final byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
    public DBFileUpload(final String fileName, final String fileType, final byte[] data, final Integer numPatient) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.numPatient = numPatient;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public String getFileType() {
        return this.fileType;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
    
    public void setFileType(final String fileType) {
        this.fileType = fileType;
    }
    
    public DBFileUpload(final String id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.id != null) ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof DBFileUpload)) {
            return false;
        }
        final DBFileUpload other = (DBFileUpload)object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
    @Override
    public String toString() {
        return "com.perfectsolution.Clinique.Entities.DBFileUpload[ id=" + this.id + " ]";
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public void setData(final byte[] data) {
        this.data = data;
    }
    
    public Integer getNumPatient() {
        return this.numPatient;
    }
    
    public void setNumPatient(final Integer numPatient) {
        this.numPatient = numPatient;
    }
}
