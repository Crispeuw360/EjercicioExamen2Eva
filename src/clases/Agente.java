package clases;

import java.io.Serializable;

public class Agente implements Serializable{
	private static final long serialVersionUID = 8802225769193950818L;

	static int contadorBase=100;
	
	protected String cod;
	protected String dni;
	protected String nombre;
	protected String email;
	
	public Agente(Empresa empresa, String dni, String nombre, String email) 
	{
		try {
			this.cod = empresa.getNombEmpresa().substring(0,5).toUpperCase()+contadorBase;
			contadorBase++;
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.err.println("Error Nombre de la empresa demasiado corto, se guardara un codigo diferente");
			this.cod = empresa.getNombEmpresa().toUpperCase()+contadorBase;
			contadorBase++;
		}
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Agente [cod=" + cod + ", dni=" + dni + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
}
