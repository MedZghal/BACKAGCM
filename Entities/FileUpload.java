package com.perfectsolution.Clinique.Entities;

import java.io.*;
import javax.xml.bind.annotation.*;
import javax.validation.constraints.*;
import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "Fileupload")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FileUpload.findAll", query = "SELECT f FROM FileUpload f"), @NamedQuery(name = "FileUpload.findByImg", query = "SELECT f FROM FileUpload f WHERE f.img = :img"), @NamedQuery(name = "FileUpload.findByPatient", query = "SELECT f FROM FileUpload f WHERE f.numPatient.numFichPatient = :numPatient"), @NamedQuery(name = "FileUpload.findByDateUplode", query = "SELECT f FROM FileUpload f WHERE f.dateUplode = :dateUplode"), @NamedQuery(name = "FileUpload.findById", query = "SELECT f FROM FileUpload f WHERE f.id = :id") })
public class FileUpload implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = Integer.MAX_VALUE)
    @Column(name = "img")
    private String img;
    @Column(name = "Dateuplode")
    @Temporal(TemporalType.DATE)
    private Date dateUplode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "num_patient", referencedColumnName = "num_fich_patient")
    @ManyToOne(optional = false)
    private Patient numPatient;
    
    public FileUpload() {
    }
    
    public FileUpload(final Integer id) {
        this.id = id;
    }
    
    public FileUpload(final Integer id, final String img) {
        this.id = id;
        this.img = img;
    }
    
    public String getImg() {
        return this.img;
    }
    
    public void setImg(final String img) {
        this.img = img;
    }
    
    public Date getDateUplode() {
        return this.dateUplode;
    }
    
    public void setDateUplode(final Date dateUplode) {
        this.dateUplode = dateUplode;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    @JsonIgnore
    public Patient getNumPatient() {
        return this.numPatient;
    }
    
    public void setNumPatient(final Patient numPatient) {
        this.numPatient = numPatient;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += ((this.id != null) ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof FileUpload)) {
            return false;
        }
        final FileUpload other = (FileUpload)object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
    @Override
    public String toString() {
        return "com.rest.entities.FileUpload[ id=" + this.id + " ]";
    }
}
