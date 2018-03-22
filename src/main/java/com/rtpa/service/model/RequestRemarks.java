package com.rtpa.service.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue("R")
public class RequestRemarks extends Remarks {
	@ManyToOne
	@JoinColumn(name="REQUEST_CODE")
	@JsonBackReference
	private Request request;

	protected RequestRemarks() {
		super();
	}

	public RequestRemarks(Request request) {
		super();
		this.request = request;
	}

	public Request getRequest() {
		return request;
	}

	@Override
	public String toString() {
		return "RequestRemarks [requestCode=" + request.getCode() + ", " + super.toString() + "]";
	}

}
