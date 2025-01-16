package clases;

import java.io.Serializable;
import java.util.HashMap;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 9925742517498554L;
	private String cif;
	private String nombEmpresa;
	private int poblacion;
	private int telf;
	private int valoracion;
	private HashMap<String,Agente> mapa;
	
	public Empresa(String cif, String nombEmpresa, int poblacion, int telf, int valoracion,HashMap<String, Agente> mapa) 
	{
		this.cif = cif;
		this.nombEmpresa = nombEmpresa;
		this.poblacion = poblacion;
		this.telf = telf;
		this.valoracion = valoracion;
		this.mapa = mapa;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombEmpresa() {
		return nombEmpresa;
	}

	public void setNombEmpresa(String nombEmpresa) {
		this.nombEmpresa = nombEmpresa;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getTelf() {
		return telf;
	}

	public void setTelf(int telf) {
		this.telf = telf;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public HashMap<String, Agente> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<String, Agente> mapa) {
		this.mapa = mapa;
	}

	@Override
	public String toString() {
		return "Empresa [cif=" + cif + ", nombEmpresa=" + nombEmpresa + ", poblacion=" + poblacion + ", telf=" + telf
				+ ", valoracion=" + valoracion + ", mapa=" + mapa + "]";
	}
	
	
	
}
