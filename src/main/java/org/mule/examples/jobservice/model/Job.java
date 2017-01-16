/**
 * MuleSoft Examples
 * Copyright 2014 MuleSoft, Inc.
 *
 * This product includes software developed at
 * MuleSoft, Inc. (http://www.mulesoft.com/).
 */

package org.mule.examples.jobservice.model;

public class Job {

	private String cod_oferta;
	private String empresa;
	private String localidad;
	private String jornada;
	private String duracion;
	private String bolsa;
	private String fecha_inicio;
	private String num_plazas;

	public String getId() {
		return cod_oferta;
	}

	public void setId(String id) {
		this.cod_oferta = id;
	}

	public String getCod_oferta() {
		return cod_oferta;
	}

	public void setCod_oferta(String cod_oferta) {
		this.cod_oferta = cod_oferta;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getBolsa() {
		return bolsa;
	}

	public void setBolsa(String bolsa) {
		this.bolsa = bolsa;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(String num_plazas) {
		this.num_plazas = num_plazas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Job job = (Job) o;

		if (cod_oferta != null ? !cod_oferta.equals(job.cod_oferta) : job.cod_oferta != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return cod_oferta != null ? cod_oferta.hashCode() : 0;
	}
}