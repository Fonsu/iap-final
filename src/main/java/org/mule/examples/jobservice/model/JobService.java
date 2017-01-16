package org.mule.examples.jobservice.model;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
			LOGGER.error("Error initializing jobs. Cause: ", e);
		}
	}

	private void addJob(JSONObject jsonObject) {
		Job job = new Job();
		job.setCod_oferta((String) jsonObject.get("cod_oferta"));
		job.setEmpresa((String) jsonObject.get("empresa"));
		job.setLocalidad((String) jsonObject.get("localidad"));
		job.setJornada((String) jsonObject.get("jornada"));
		job.setDuracion((String) jsonObject.get("duracion"));
		job.setBolsa((String) jsonObject.get("bolsa"));
		job.setFecha_inicio((String) jsonObject.get("fecha_inicio"));

		this.jobs.put(job.getCod_oferta(), job);
	}

	/*
	 * private Date getDate(int shiftDays) { Calendar date =
	 * GregorianCalendar.getInstance(); date.add(GregorianCalendar.DATE,
	 * shiftDays); date.set(GregorianCalendar.HOUR_OF_DAY,5);
	 * date.set(GregorianCalendar.MINUTE, 0); date.set(GregorianCalendar.SECOND,
	 * 0); date.set(GregorianCalendar.MILLISECOND, 0); return date.getTime(); }
	 */

	public List<Job> getJobs() {
		List<Job> jobs = new ArrayList<Job>();
		jobs.addAll(this.jobs.values());
		return jobs;
	}
	// TODO Implement jobs by city/category

	/*
	 * public List<Team> getTeams(String homeCity) { List<Team> teams =
	 * getTeams(); if(homeCity == null) { return teams; }
	 * 
	 * List<Team> teamsByCity = new ArrayList<Team>(); for(Team team : teams) {
	 * if(team.getHomeCity().equals(homeCity)) { teamsByCity.add(team); } }
	 * return teamsByCity; }
	 * 
	 * public List<Job> getJobs(String id) { List<Job> jobs = getJobs(); if(id
	 * == null) { return jobs; } return null; }
	 */

	public boolean hasJob(String id) {
		return jobs.containsKey(id);
	}

	public Job getJob(String id) {
		return jobs.get(id);
	}

	public void addJob(Job job) {
		jobs.put(job.getCod_oferta(), job);
	}

}
