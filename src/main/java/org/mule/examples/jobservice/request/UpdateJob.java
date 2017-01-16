/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */

package org.mule.examples.jobservice.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonAutoDetect
@XmlRootElement(namespace = "http://mulesoft.com/schemas")
public class UpdateJob {

	// TODO Clase para actualizar trabajo

	private String name;

	@JsonProperty
	@XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
