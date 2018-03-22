package com.rtpa.service.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_SOURCE")
public class Source extends AbstractPersistable<Long>{

	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int runNumber;
	private Date runDate;

	// MAPPING
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "REQUEST_CODE")
	@JsonBackReference
	private Request request;

	@ManyToOne
	@JoinColumn(name = "SOURCE_TYPE_CODE")
	@JsonManagedReference
	private SourceType type;

	@OneToMany(mappedBy = "source")
	@JsonManagedReference
	private List<Attribute> attributes;

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SourceType getType() {
		return type;
	}

	public void setType(SourceType type) {
		this.type = type;
	}

	public int getRunNumber() {
		return runNumber;
	}

	public void setRunNumber(int runNumber) {
		this.runNumber = runNumber;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public Attribute findAttribute(long attributeId) {
		return Arrays.stream(attributes.toArray(new Attribute[0]))
			.filter(attribute -> Long.valueOf(attribute.getId()).equals(attributeId))
			.findFirst()
			.orElse(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Source other = (Source) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", runNumber=" + runNumber + ", runDate=" + runDate + "]";
	}

}
