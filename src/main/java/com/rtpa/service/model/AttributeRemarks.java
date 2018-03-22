package com.rtpa.service.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue("A")
public class AttributeRemarks extends Remarks {
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ATTRIBUTE_ID")
	@JsonBackReference
	private Attribute attribute;

	protected AttributeRemarks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttributeRemarks(Attribute attribute) {
		super();
		this.attribute = attribute;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		return "AttributeRemarks [attribute=" + attribute.getId() + ", " + super.toString() + "]";
	}

}
