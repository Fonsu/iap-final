package org.mule.examples.jobservice.model;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mule.examples.jobservice.model.Job;

public class JobService {

	private static final Logger LOGGER = Logger.getLogger(JobService.class);

	private HashMap<String, Job> jobs = new HashMap<String, Job>();

	@SuppressWarnings("unchecked")
	public void initialize() {
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("jobs.json")));
			JSONArray jobs = (JSONArray) jsonObject.get("jobs");
			Iterator<JSONObject> iterator = jobs.iterator();
			while (iterator.hasNext()) {
				addJob(iterator.next());
			}

		} catch (Exception e) {
			LOGGER.error("Error initializing jobService. Cause: ", e);
		}
	}

	private void addJob(JSONObject jsonObject) {
		Job job = new Job();
		job.setCod_oferta((String) jsonObject.get("cod_oferta"));
		job.setEmpresa((String) jsonObject.get("empresa"));
		job.setLocalidad((String) jsonObject.get("localidad"));
		job.setCategoria((String) jsonObject.get("categoria"));
		job.setJornada((String) jsonObject.get("jornada"));
		job.setDuracion((String) jsonObject.get("duracion"));
		job.setBolsa((String) jsonObject.get("bolsa"));
		job.setFecha_inicio((String) jsonObject.get("fecha_inicio"));

		this.jobs.put(job.getCod_oferta(), job);
	}

	// TODO Implement jobs by city/category
	public List<Job> getJobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobs.addAll(this.jobs.values());
		return jobs;
	}

	public List<Job> getJobs(String city, String category) {
		List<Job> jobs = getJobs();
		List<Job> jobsFiltered = new ArrayList<Job>();
		if(city == null && category == null){
			return jobs;
		} 
		
		if (city != null && category == null) {			
			for (Job job : jobs) {
				if (job.getLocalidad().equals(city)) {
					jobsFiltered.add(job);
				}
			}
			return jobsFiltered;
		} else {
			if (city != null && category != null) {
				for (Job job : jobs) {
					if (job.getLocalidad().equals(city) && job.getCategoria().equals(category)) {
						jobsFiltered.add(job);
					}
				}				
			}			
		}						
		return jobsFiltered;
	}	

	public boolean hasJob(String id) {
		return jobs.containsKey(id);
	}

	public Job getJob(String id) {
		return jobs.get(id);
	}

	public void addJob(Job job) {
		jobs.put(job.getCod_oferta(), job);
	}
	
	public void deleteJob(String id) {
        jobs.remove(id);
    }

}
