package org.mule.examples.jobservice;

import org.mule.examples.jobservice.exceptions.ConflictException;
import org.mule.examples.jobservice.model.JobService;
import org.mule.examples.jobservice.request.UpdateJob;
import org.mule.examples.jobservice.response.Job;
import org.mule.examples.jobservice.response.Jobs;
import org.mule.module.apikit.exception.MuleRestException;
import org.mule.module.apikit.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JobServiceAPI {

	private JobService jobService;

	public void initialize() {
		jobService = new JobService();
		jobService.initialize();
	}
	
	public Jobs getJobs(){
		return getJobs();
	}
	
	public Jobs getJobs(String city){
		return getJobs(city,null);
	}
	
	public Jobs getJobs(String city, String category) {
		List<Job> jobsList = new ArrayList<Job>();
        List<org.mule.examples.jobservice.model.Job> jobs = jobService.getJobs();
		if (city!=null && category==null){ jobs = jobService.getJobs(city,null); }
		else { if (city!=null && category!=null){ jobs = jobService.getJobs(city,category);}}
		
		for (org.mule.examples.jobservice.model.Job job : jobs) {
			Job jobResp = new Job();
			jobResp.setCod_oferta(job.getCod_oferta());
			jobResp.setEmpresa(job.getEmpresa());
			jobResp.setLocalidad(job.getLocalidad());
			jobResp.setCategoria(job.getCategoria());
			jobResp.setJornada(job.getJornada());			
			jobResp.setDuracion(job.getDuracion());
			jobResp.setBolsa(job.getBolsa());
			jobResp.setFecha_inicio(job.getFecha_inicio());
			jobResp.setNum_plazas(job.getNum_plazas());
			jobsList.add(jobResp);
		}		
		Jobs jobsResp = new Jobs();
		jobsResp.setJobs(jobsList);
		return jobsResp;		
	}

	public Job getJob(String jobId) throws MuleRestException {
		if (!jobService.hasJob(jobId)) {
			throw new NotFoundException("Job " + jobId + " does not exist");
		}

		org.mule.examples.jobservice.model.Job job = jobService.getJob(jobId);
		Job jobResp = new Job();
		jobResp.setCod_oferta(job.getCod_oferta());
		jobResp.setEmpresa(job.getEmpresa());
		jobResp.setLocalidad(job.getLocalidad());
		jobResp.setCategoria(job.getCategoria());
		jobResp.setJornada(job.getJornada());
		jobResp.setDuracion(job.getDuracion());
		jobResp.setBolsa(job.getBolsa());
		jobResp.setFecha_inicio(job.getFecha_inicio());
		jobResp.setNum_plazas(job.getNum_plazas());		
		return jobResp;
	}	 

	public String addJob(org.mule.examples.jobservice.request.Job job) throws MuleRestException {
		if (jobService.hasJob(job.getCod_oferta())) {
			throw new ConflictException("There is already a job with id " + job.getCod_oferta());
		}

		org.mule.examples.jobservice.model.Job newJob = new org.mule.examples.jobservice.model.Job();
		newJob.setCod_oferta(job.getCod_oferta());
		newJob.setEmpresa(job.getEmpresa());
		newJob.setLocalidad(job.getLocalidad());
		newJob.setCategoria(job.getCategoria());
		newJob.setJornada(job.getJornada());
		newJob.setDuracion(job.getDuracion());
		newJob.setBolsa(job.getBolsa());
		newJob.setFecha_inicio(job.getFecha_inicio());
		newJob.setNum_plazas(job.getNum_plazas());

		jobService.addJob(newJob);
		return job.getCod_oferta();
	}
	
	public void updateJob(String jobId, UpdateJob updateJob) throws MuleRestException {
        if(!jobService.hasJob(jobId)) {
            throw new NotFoundException("Job " + jobId + " does not exist");
        }
        
        org.mule.examples.jobservice.model.Job job = jobService.getJob(jobId);
        if(updateJob.getLocalidad() != null) {
            job.setLocalidad(updateJob.getLocalidad());
        }
        
        if(updateJob.getCategoria() != null) {
            job.setCategoria(updateJob.getCategoria());
        }
        
        if(updateJob.getJornada() != null) {
            job.setJornada(updateJob.getJornada());
        }

        if(updateJob.getDuracion() != null) {
            job.setDuracion(updateJob.getDuracion());
        }

        if(updateJob.getBolsa() != null) {
            job.setBolsa(updateJob.getBolsa());
        }
        
        if(updateJob.getFecha_inicio() != null) {
            job.setFecha_inicio(updateJob.getFecha_inicio());
        }
        
        if(updateJob.getNum_plazas() != null) {
            job.setNum_plazas(updateJob.getNum_plazas());
        }
    }
	
	public void deleteJob(String jobId) throws MuleRestException {
        if(!jobService.hasJob(jobId)) {
            throw new NotFoundException("Job " + jobId + " does not exist");
        }
        jobService.deleteJob(jobId);
    }
}