package com.rtpa.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_ATTRIBUTE")
public class Attribute {
	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	private int seqNo;
	private String value;
	private String status; // OK or NOK

	// MAPPINGS
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "SOURCE_ID")
	@JsonBackReference
	private Source source;

	@ManyToOne
	@JoinColumn(name = "ATTRIBUTE_TYPE_CODE")
	@JsonManagedReference
	private AttributeType type;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)	
	@JoinColumn(name = "ERROR_TYPE_CODE", nullable = true)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonManagedReference
	private ErrorType error;

	@OneToMany(mappedBy = "attribute")
	@JsonManagedReference
	private List<AttributeRemarks> remarks;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AttributeType getType() {
		return type;
	}

	public void setType(AttributeType type) {
		this.type = type;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public ErrorType getError() {
		return error;
	}

	public void setError(ErrorType error) {
		this.error = error;
	}

	public List<AttributeRemarks> getRemarks() {
//		remarks = remarks == null ? new ArrayList<>() : remarks;
		return remarks; // == null ? new ArrayList<>() : remarks;
	}

	public void setRemarks(List<AttributeRemarks> remarks) {
		this.remarks = remarks;
	}

	public AttributeRemarks addRemarks(String username, String message) {		
		AttributeRemarks remark = new AttributeRemarks(this);
		remark.setCreatedBy(username);
		remark.setCreatedDate(new Date());
		remark.setMessage(message);
		remark.setSequenceNumber(remarks.size() + 1);
		remarks.add(remark);
		return remark;
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
		Attribute other = (Attribute) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", seqNo=" + seqNo + ", value=" + value + ", status=" + status + "]";
	}

}
