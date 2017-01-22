package org.mule.examples.jobservice.response;

import org.mule.api.annotations.Transformer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;

public class Jobs {
	private List<Job> jobs;
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Transformer(resultMimeType = "application/json")
	public String toJson(Jobs jobs) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(jobs);
	}

	@Transformer(resultMimeType = "text/xml")
	public String toXml(Jobs jobs) throws IOException, JAXBException {
		JAXBContext context = JAXBContext.newInstance(getClass());

		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		m.marshal(jobs, boas);

		return new String(boas.toByteArray());
	}

}
