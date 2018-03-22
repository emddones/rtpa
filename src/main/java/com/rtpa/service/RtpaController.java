package com.rtpa.service;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rtpa.service.dto.NewRemarks;
import com.rtpa.service.model.Attribute;
import com.rtpa.service.model.Request;
import com.rtpa.service.model.Source;

@RestController
@RequestMapping("/requests")
@CrossOrigin
public class RtpaController {

	@Autowired
	private RequestRepository requests;

	@Autowired
	private AttributeRemarksRepository attributeRemarks;
	
	@Autowired
	private AttributeRepository attributes;

	// @CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Request findRequest(@PathVariable("id") String id) {
		Request request = requests.findById(id).get();
		return request;
		// return Response.status(Response.Status.OK).entity(request).build();
	}

	@RequestMapping(value = "/{requestId}/sources/{sourceId}/attributes/{attributeId}", method = RequestMethod.POST)
	public Response addAttributeRemarks(@PathVariable("requestId") String requestId,
			@PathVariable("sourceId") long sourceId, @PathVariable("attributeId") long attributeId,
			@RequestBody NewRemarks remarks) {

		Attribute attribute = attributes.findById(attributeId).get();
		
		attributeRemarks.save(attribute.addRemarks(remarks.getUsername(), remarks.getMessage()));
		
		Request request = requests.findById(requestId).get();
		Source source = request.findSource(sourceId);		
		
		return Response.status(Response.Status.OK).entity(source).build();
	}
}
