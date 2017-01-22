package org.mule.examples.jobservice.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonAutoDetect
@XmlRootElement(namespace = "http://mulesoft.com/schemas")
public class UpdateJob {

	private String localidad;
	private String categoria;
	private String jornada;
	private String duracion;
	private String bolsa;
	private String fecha_inicio;
	private String num_plazas;

    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }    
    
    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getBolsa() {
        return bolsa;
    }

    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }
    
    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getFecha_inicio() {
		return fecha_inicio;
	}

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    
    @JsonProperty
    @XmlElement(required = false, namespace = "http://mulesoft.com/schemas")
    public String getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(String num_plazas) {
		this.num_plazas = num_plazas;
	}    

}
