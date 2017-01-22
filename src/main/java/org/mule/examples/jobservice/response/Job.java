package org.mule.examples.jobservice.response;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import javax.xml.bind.annotation.XmlElement;

@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Job {

	private String cod_oferta;
	private String empresa;
	private String localidad;
	private String categoria;
	private String jornada;
	private String duracion;
	private String bolsa;
	private String fecha_inicio;
	private String num_plazas;

	@JsonProperty
	@XmlElement(required = true)
	public String getCod_oferta() {
		return cod_oferta;
	}

	public void setCod_oferta(String id) {
		this.cod_oferta = id;
	}

	@JsonProperty
	@XmlElement(required = true)
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@JsonProperty
	@XmlElement(required = true)
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@JsonProperty
	@XmlElement(required = true)
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@JsonProperty
	@XmlElement(required = false)
	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	@JsonProperty
	@XmlElement(required = false)
	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@JsonProperty
	@XmlElement(required = false)
	public String getBolsa() {
		return bolsa;
	}

	public void setBolsa(String bolsa) {
		this.bolsa = bolsa;
	}

	@JsonProperty
	@XmlElement(required = false)
	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	@JsonProperty
	@XmlElement(required = false)
	public String getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(String num_plazas) {
		this.num_plazas = num_plazas;
	}

}