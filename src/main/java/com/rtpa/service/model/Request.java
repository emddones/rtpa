package com.rtpa.service.model;

/**
 * No concept of region yet.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_REQUEST")
public class Request {
	// FIELDS
	@Id
	private String code;

	// MAPPINGS
	@OneToMany(mappedBy = "request")
	@JsonManagedReference
	private List<Source> sources;

	@OneToMany(mappedBy = "request")
	@JsonManagedReference
	private List<RequestRemarks> remarks;

	public Request() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public List<RequestRemarks> getRemarks() {
		return remarks == null ? new ArrayList<>() : remarks;
	}

	public void setRemarks(List<RequestRemarks> remarks) {
		this.remarks = remarks;
	}

	@JsonIgnore
	public void addRemarks(String username, String message) {
		List<RequestRemarks> remarksList = getRemarks();
		RequestRemarks remark = new RequestRemarks(this);
		remark.setCreatedBy(username);
		remark.setCreatedDate(new Date());
		remark.setMessage(message);
		remark.setSequenceNumber(remarksList.size() + 1);
		remarksList.add(remark);
	}
	
	@JsonIgnore
	public Source findSource(long sourceId) {
		return Arrays.stream(sources.toArray(new Source[0]))
				.filter(aSource -> Long.valueOf(aSource.getId()).equals(sourceId))
		        .findFirst()
		        .orElse(null);
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
		Request other = (Request) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [code=" + code + "]";
	}

}
