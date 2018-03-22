package com.rtpa.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "T_ATTRIBUTE_TYPE")
public class AttributeType {

	// Fields
	@Id
	private String code;
	private String label;
	
	@Column(nullable = true)
	private String description;
	
	@Column
	@Max(value=30)
	@Min(value=0)
	private int size;
	
	@Column(name = "prec", nullable = true)
	private Integer precision;

	// Mapping
	@ManyToOne
	@JoinColumn(name = "SOURCE_TYPE_CODE")	
	@JsonBackReference
	private SourceType sourceType;

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Integer getPrecision() {
		return precision;
	}

	public void setPrecision(Integer precision) {
		this.precision = precision;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		AttributeType other = (AttributeType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttributeType [code=" + code + ", label=" + label + ", description=" + description + ", size=" + size
				+ ", precision=" + precision + "]";
	}

}
