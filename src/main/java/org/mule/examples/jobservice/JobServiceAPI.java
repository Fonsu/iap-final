package org.mule.examples.jobservice;

import org.mule.examples.jobservice.exceptions.ConflictException;
import org.mule.examples.jobservice.model.JobService;
import org.mule.examples.jobservice.request.UpdateJob;
import org.mule.examples.jobservice.response.Job;
import org.mule.examples.jobservice.response.Jobs;
import org.mule.module.apikit.exception.MuleRestException;
import org.mule.module.apikit.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobServiceAPI {

	private JobService jobService;

	public void initialize() {
		jobService = new JobService();
		jobService.initialize();
	}

	public Jobs getJobs() {
		List<Job> jobsList = new ArrayList<Job>();
		List<org.mule.examples.jobservice.model.Job> jobs = jobService.getJobs();
		for (org.mule.examples.jobservice.model.Job job : jobs) {
			Job jobResp = new Job();
			jobResp.setCod_oferta(job.getCod_oferta());
			jobResp.setEmpresa(job.getEmpresa());
			jobResp.setLocalidad(job.getLocalidad());
			jobResp.setJornada(job.getJornada());
			jobResp.setDuracion(job.getJornada());
			jobResp.setBolsa(job.getBolsa());
			jobResp.setFecha_inicio(job.getFecha_inicio());
			jobResp.setNum_plazas(job.getNum_plazas());

			jobsList.add(jobResp);
		}

		Jobs jobsResp = new Jobs();
		jobsResp.setJobs(jobsList);
		return jobsResp;
	}

	/*
	 * public JobService getJob(String jobId) throws MuleRestException {
	 * if(!job.hasJob(jobId)) { throw new NotFoundException("Job " + jobId +
	 * " does not exist"); }
	 * 
	 * org.mule.examples.jobservice.model.JobService job = job.getJob(jobId);
	 * JobService jobResp = new JobService(); jobResp.setId(job.getId());
	 * jobResp.setName(job.getName()); jobResp.setHomeCity(job.getHomeCity());
	 * jobResp.setStadium(job.getJornada());
	 * jobResp.setMatches(job.getMatchesPlayed()); return jobResp; }
	 */

	public String addJob(org.mule.examples.jobservice.request.Job job) throws MuleRestException {
		if (jobService.hasJob(job.getCod_oferta())) {
			throw new ConflictException("There is already a job with id " + job.getCod_oferta());
		}

		org.mule.examples.jobservice.model.Job newJob = new org.mule.examples.jobservice.model.Job();
		newJob.setCod_oferta(job.getCod_oferta());
		newJob.setEmpresa(job.getEmpresa());
		newJob.setLocalidad(job.getLocalidad());
		newJob.setJornada(job.getJornada());
		newJob.setDuracion(job.getDuracion());
		newJob.setBolsa(job.getBolsa());
		newJob.setFecha_inicio(job.getFecha_inicio());
		newJob.setNum_plazas(job.getNum_plazas());

		jobService.addJob(newJob);
		return job.getCod_oferta();
	}

}
