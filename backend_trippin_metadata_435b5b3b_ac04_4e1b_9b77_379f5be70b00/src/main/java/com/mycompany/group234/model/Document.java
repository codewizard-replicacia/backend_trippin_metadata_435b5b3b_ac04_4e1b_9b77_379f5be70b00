package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.mycompany.group234.model.Person;
import com.mycompany.group234.model.Document;
import com.mycompany.group234.model.Airline;
import com.mycompany.group234.model.Airport;
import com.mycompany.group234.model.Trip;
import com.mycompany.group234.model.PlanItem;
import com.mycompany.group234.model.Event;
import com.mycompany.group234.model.PublicTransportation;
import com.mycompany.group234.model.Flight;
import com.mycompany.group234.model.Employee;
import com.mycompany.group234.model.Manager;
import com.mycompany.group234.model.complex.Location;
import com.mycompany.group234.model.complex.City;
import com.mycompany.group234.model.complex.AirportLocation;
import com.mycompany.group234.model.complex.EventLocation;
import com.mycompany.group234.enums.PersonGender;
import com.mycompany.group234.enums.Feature;
import com.mycompany.group234.converter.PersonGenderConverter;
import com.mycompany.group234.converter.FeatureConverter;
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Document")
@Table(name = "\"Document\"", schema =  "\"trippin_metadata\"")
@Data
                        
public class Document {
	public Document () {   
  }
	  
  @Id
  @Column(name = "\"DocId\"", nullable = false )
  private String docId;
	  
  @Column(name = "\"DocName\"", nullable = true )
  private String docName;
  
	  
  @Column(name = "\"mimeType\"", nullable = true )
  private String mimeType;
  
	  
  @Column(name = "\"DocLocation\"", nullable = true )
  private String docLocation;
  
	  
  @Column(name = "\"DocSize\"", nullable = true )
  private String docSize;
  
  @Column(name = "\"Content\"")
  @EdmMediaStream(contentTypeAttribute = "mimeType")
  private byte[] content;
  
  
	@OneToOne(mappedBy = "ticket")
private PlanItem planItem;
  
   
  
  
  
	@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "\"PersonUserName\"", insertable = false, updatable = false)
private Person  person ;

@Column(name =  "\"PersonUserName\"")
private String personUserName;
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Document [" 
  + "DocId= " + docId  + ", " 
  + "DocName= " + docName  + ", " 
  + "mimeType= " + mimeType  + ", " 
  + "DocLocation= " + docLocation  + ", " 
  + "DocSize= " + docSize 
 + "]";
	}
	
}