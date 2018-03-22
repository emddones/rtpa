package com.rtpa.service.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "T_SOURCE_TYPE")
public class SourceType {
	// FIELDS
	@Id
	private String code;
	private boolean isReferenceSource;

	// MAPPINGS
	@OneToMany(mappedBy="sourceType")
	@JsonBackReference
	private List<AttributeType> attributes;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isReferenceSource() {
		return isReferenceSource;
	}

	public void setReferenceSource(boolean isReferenceSource) {
		this.isReferenceSource = isReferenceSource;
	}

	

	public List<AttributeType> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributeType> attributes) {
		this.attributes = attributes;
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
		SourceType other = (SourceType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SourceType [code=" + code + ", isReferenceSource=" + isReferenceSource + "]";
	}

}
