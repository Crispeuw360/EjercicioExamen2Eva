package clases;

import java.time.LocalDate;

public class Alumna extends Agente {
	private static final long serialVersionUID = -6581737303602649103L;
	private LocalDate fechaNac;
	private String CursoAcadem;
	private String grupo;
	
	public Alumna(Empresa empresa, String dni, String nombre, String email, LocalDate fechaNac, String cursoAcadem,String grupo)
	{
		super(empresa, dni, nombre, email);
		this.fechaNac = fechaNac;
		this.CursoAcadem = LocalDate.now().getYear()+"-"+LocalDate.now().getYear()+1;
		this.grupo = grupo;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCursoAcadem() {
		return CursoAcadem;
	}

	public void setCursoAcadem(String cursoAcadem) {
		CursoAcadem = cursoAcadem;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	
}
