package clases;

public class Trabajador extends Agente {
	private static final long serialVersionUID = -2208602547083320589L;
	private String puesto;
	private Tipo tipo;
	private boolean estado = true;
	
	public Trabajador(Empresa empresa, String dni, String nombre, String email, String puesto, Tipo tipo,boolean estado) 
	{
		super(empresa, dni, nombre, email);
		this.puesto = puesto;
		this.tipo = tipo;
		this.estado = estado;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return super.toString()+"Trabajador [puesto=" + puesto + ", tipo=" + tipo + ", estado=" + estado + "]";
	}

}
