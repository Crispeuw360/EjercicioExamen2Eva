package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

import clases.*;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

public class Main {

	public static int mostrarMenu() {
		System.out.println("1. Mostrar animales");
		System.out.println("2. Añadir animales");
		System.out.println("3. Modificar la edad de un animal por su id");
		System.out.println("4. Eliminar un animal por su id");
		System.out.println("5. Salir");
		return Utilidades.leerInt();
	}
	public static int calcularEdad(LocalDate fechaNacimiento) {
	    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
	}
	
	public static void altaEmpresa(File fich)
	{
		String nombreEmpresa,opcion,cif,dni,nombre,email,repetir = null,puesto,tipoIntro,cursoAcadem,grupo;
		int poblacion,telf,valoracion,opcion2;
		
		Tipo tipo = null;
		boolean estado;
		LocalDate fechaNac;
	

		if (fich.exists()) 
		{
			System.out.println("El fichero ya existe, se añadirán al final");
			MyObjectOutputStream moos;
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(fich));
				moos = new MyObjectOutputStream(new FileOutputStream(fich, true));
				do {
					System.out.println("Introduce el CIF");
					cif = Utilidades.introducirCadena();
					Empresa em = (Empresa) ois.readObject();
					if (cif.equalsIgnoreCase(em.getCif())) {
						System.err.println("Error este CIF ya existe");
						System.out.println(em.toString());
					}
					ois.close();
					System.out.println("Introduce el nombre de la empresa: ");
					nombreEmpresa = Utilidades.introducirCadena();
					System.out.println("Introduce la poblacion: ");
					poblacion = Utilidades.leerInt();
					System.out.println("Introduce el telefono: ");
					telf = Utilidades.leerInt();
					do {
						System.out.println("Introduce La valoracion del 1 al 10: ");
						valoracion = Utilidades.leerInt();
					} while (valoracion > 0 && valoracion < 11);
					HashMap<String, Agente> h = null;
					
					Empresa aux = new Empresa(cif, nombreEmpresa, poblacion, telf, valoracion, h);
					System.out.println("Empresa creada");
					System.out.println("Ahora se crearan los Agentes");
					do {
						System.out.println("Introduce el dni del Agente");
						dni = Utilidades.introducirCadena();
						System.out.println("Introduce el nombre del Agente");
						nombre = Utilidades.introducirCadena();
						System.out.println("Introduce el email del Agente");
						email = Utilidades.introducirCadena();
						System.out.println("Elije el tipo de Agente");
						System.out.println("1. Trabajador");
						System.out.println("2. Alumna");
						opcion2 = Utilidades.leerInt();
						switch (opcion2) {
						case 1:
							System.out.println("introduce el puesto del Trabajador");
							puesto = Utilidades.introducirCadena();
							do {
								System.out.println("Introduce el Tipo: CONTACTO/TUTOR");
								tipoIntro = Utilidades.introducirCadena().toUpperCase();
								try {
									tipo = Tipo.valueOf(tipoIntro);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} while (tipoIntro == null);
							estado = true;
							Trabajador t = new Trabajador(aux,dni,nombre,email,puesto,tipo,estado);
							h.put(t.getDni(), t);
							System.out.println("Quieres añadir mas agentes?");
							repetir = Utilidades.introducirCadena("Si", "No");
							break;
						case 2:
							System.out.println("Introducir la fecha Nacimiento DD/MM/AA");
							fechaNac = Utilidades.leerFechaDMA();
							System.out.println("Introduce el cursoAcademico");
							cursoAcadem = Utilidades.introducirCadena();
							System.out.println("Introduce el grupo");
							grupo = Utilidades.introducirCadena();
							Alumna a = new Alumna(aux,dni,nombre,email,fechaNac,cursoAcadem,grupo);
							h.put(a.getDni(), a);
							System.out.println("Quieres añadir mas agentes?");
							repetir = Utilidades.introducirCadena("Si", "No");
							break;
						}
					} while (repetir.equalsIgnoreCase("si"));
					System.out.println(aux.toString());
					moos.writeObject(aux);
					System.out.println("Se ha guardado Correctamente");
					moos.close();
					System.out.println("Quieres añadir mas empresas?");
					opcion = Utilidades.introducirCadena("Si", "No");
				} while (!opcion.equalsIgnoreCase("si"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			
			ObjectInputStream ois;
			ObjectOutputStream oos;
			try {
				ois = new ObjectInputStream(new FileInputStream(fich));
				oos = new ObjectOutputStream(new FileOutputStream(fich));
				do {
					System.out.println("Introduce el CIF");
					cif = Utilidades.introducirCadena();
					Empresa em = (Empresa) ois.readObject();
					if (cif.equalsIgnoreCase(em.getCif())) {
						System.err.println("Error este CIF ya existe");
						System.out.println(em.toString());
					}
					ois.close();
					System.out.println("Introduce el nombre de la empresa: ");
					nombreEmpresa = Utilidades.introducirCadena();
					System.out.println("Introduce la poblacion: ");
					poblacion = Utilidades.leerInt();
					System.out.println("Introduce el telefono: ");
					telf = Utilidades.leerInt();
					do {
						System.out.println("Introduce La valoracion del 1 al 10: ");
						valoracion = Utilidades.leerInt();
					} while (valoracion > 0 && valoracion < 11);
					HashMap<String, Agente> h = null;
					Empresa aux = new Empresa(cif, nombreEmpresa, poblacion, telf, valoracion, h);
					System.out.println("Empresa creada");
					System.out.println("Ahora se crearan los Agentes");
					do {
						System.out.println("Introduce el dni del Agente");
						dni = Utilidades.introducirCadena();
						System.out.println("Introduce el nombre del Agente");
						nombre = Utilidades.introducirCadena();
						System.out.println("Introduce el email del Agente");
						email = Utilidades.introducirCadena();
						System.out.println("Elije el tipo de Agente");
						System.out.println("1. Trabajador");
						System.out.println("2. Alumna");
						opcion2 = Utilidades.leerInt();
						switch (opcion2) {
						case 1:
							System.out.println("introduce el puesto del Trabajador");
							puesto = Utilidades.introducirCadena();
							do {
								System.out.println("Introduce el Tipo: CONTACTO/TUTOR");
								tipoIntro = Utilidades.introducirCadena().toUpperCase();
								try {
									tipo = Tipo.valueOf(tipoIntro);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} while (tipoIntro == null);
							estado = true;
							Trabajador t = new Trabajador(aux,dni,nombre,email,puesto,tipo,estado);
							h.put(t.getDni(), t);
							System.out.println("Quieres añadir mas agentes?");
							repetir = Utilidades.introducirCadena("Si", "No");
							break;
						case 2:
							System.out.println("Introducir la fecha Nacimiento DD/MM/AA");
							fechaNac = Utilidades.leerFechaDMA();
							System.out.println("Introduce el cursoAcademico");
							cursoAcadem = Utilidades.introducirCadena();
							System.out.println("Introduce el grupo");
							grupo = Utilidades.introducirCadena();
							Alumna a = new Alumna(aux,dni,nombre,email,fechaNac,cursoAcadem,grupo);
							h.put(a.getDni(), a);
							System.out.println("Quieres añadir mas agentes?");
							repetir = Utilidades.introducirCadena("Si", "No");
							break;
						}
					} while (repetir.equalsIgnoreCase("si"));
					System.out.println(aux.toString());
					oos.writeObject(aux);
					System.out.println("Se ha guardado Correctamente");
					oos.close();
					System.out.println("Quieres añadir mas empresas?");
					opcion = Utilidades.introducirCadena("Si", "No");
				} while (!opcion.equalsIgnoreCase("si"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void bajaTrabajador(File fich)
	{
		boolean modificado = false;
		boolean finArchivo = false;
		boolean empresaEncontrada = false;
        boolean trabajadorEncontrado = false;
		
		File fichAux = new File("fichAux.dat");
		
		if(fich.exists()) 
		{
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichAux));
				System.out.println("Introduce el nombre de la empresa:");
		        String nombreEmpresa = Utilidades.introducirCadena();
		        
		        System.out.println("Introduce el DNI del trabajador:");
		        String dniTrabajador = Utilidades.introducirCadena();

				// Leer mientras no se alcance el fin del archivo
				while (!finArchivo) {
					try {
						Empresa aux = (Empresa) ois.readObject();
						if (aux.getNombEmpresa().equalsIgnoreCase(nombreEmpresa)) 
						{
							HashMap<String, Agente> agentes = aux.getMapa();
							if(agentes.containsKey(dniTrabajador))
							{
								 Agente agente = agentes.get(dniTrabajador);
								 if(agente instanceof Trabajador)
								 {
									 Trabajador trabajador = (Trabajador)agente;
									 if(trabajador.isEstado())
									 {
										 trabajador.setEstado(false);
										 trabajadorEncontrado = true;
										 System.out.println("El trabajador con DNI " + dniTrabajador + " ha sido dado de baja.");
										 modificado = true;
									 }else
									 {
										 System.out.println("El trabajador ya esta de baja");
									 }
									 
								 }
							}else
							{
								System.out.println("No hay un agente con ese dni");
							}
						} else {
							System.out.println("No hay una Empresa con ese nombre");
						}
						oos.writeObject(aux);
					} catch (EOFException e) {
						// Fin del archivo alcanzado
						finArchivo = true;
					}
				}
				oos.close();
				ois.close();
				
				if (!empresaEncontrada) {
	                System.out.println("No se encontró una empresa con el nombre proporcionado.");
	            } else if (!trabajadorEncontrado) {
	                System.out.println("No se encontró un trabajador con el DNI especificado en la empresa.");
	            }
				if (modificado) 
				{
					System.out.println("El archivo ha sido actualizado correctamente.");
					if (fich.delete()) {
						fichAux.renameTo(fich);
					}else
					{
						System.out.println("Error al borrar el archivo");
					}
				}else
				{
					System.out.println("El archivo no se ha modificado");
				}

			} catch (Exception e) {
				System.out.println("Fatal error");
			}
		} else {
			System.err.println("Error no hay fichero");
		}
	
	}
	
	public static void eliminarAlumnas(File fich) {
	    boolean finArchivo = false;
	    boolean empresaModificada = false;
	    boolean alumnasEliminadas = false;

	    File fichAux = new File("fichAux.dat");

	    if (fich.exists()) {
	        try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichAux));

	            System.out.println("Introduce el curso académico (p.e 2021-2022):");
	            String cursoAcademico = Utilidades.introducirCadena();

	            // Leer y procesar empresas mientras no se alcance el fin del archivo
	            while (!finArchivo) {
	                try {
	                    Empresa empresa = (Empresa) ois.readObject();
	                    HashMap<String, Agente> agentes = empresa.getMapa();
	                    HashMap<String, Agente> agentesRestantes = new HashMap<>();
	                    boolean tieneAlumnas = false;

	                    System.out.println("Procesando empresa: " + empresa.getNombEmpresa());
	                    for (Agente agente : agentes.values()) {
	                        if (agente instanceof Alumna) {
	                            Alumna alumna = (Alumna) agente;
	                            if (alumna.getCursoAcadem().equals(cursoAcademico)) {
	                                tieneAlumnas = true;
	                                int edadActual = calcularEdad(alumna.getFechaNac());
	                                System.out.println("Alumna a eliminar: " + alumna.getNombre() + " (Edad actual: " + edadActual + ")");
	                            } else {
	                                agentesRestantes.put(agente.getDni(), agente);
	                            }
	                        } else {
	                            agentesRestantes.put(agente.getDni(), agente);
	                        }
	                    }

	                    if (tieneAlumnas) {
	                        System.out.println("¿Deseas eliminar todas las alumnas del curso " + cursoAcademico + 
	                                " en la empresa " + empresa.getNombEmpresa() + "? (Si/No)");
	                        String confirmacion = Utilidades.introducirCadena();

	                        if (confirmacion.equalsIgnoreCase("Si")) {
	                            alumnasEliminadas = true;
	                            empresaModificada = true;
	                            empresa.setMapa(agentesRestantes);

	                            if (agentesRestantes.isEmpty()) {
	                                System.out.println("La empresa " + empresa.getNombEmpresa() +" se eliminará ya que no tiene más agentes.");
	                                continue; // No escribir la empresa si no tiene agentes restantes
	                            }
	                        } else {
	                            System.out.println("No se eliminó ninguna alumna de la empresa " +
	                                    empresa.getNombEmpresa());
	                            agentesRestantes = agentes; // Restaurar todos los agentes
	                        }
	                    }
	                    
	                    empresa.setMapa(agentesRestantes);
	                    oos.writeObject(empresa);
	                } catch (EOFException e) {
	                    finArchivo = true; // Fin del archivo alcanzado
	                }
	            }

	            oos.close();
	            ois.close();

	            // Si hubo modificaciones, reemplazar el archivo original
	            if (empresaModificada) {
	                if (fich.delete()) {
	                    fichAux.renameTo(fich);
	                    System.out.println("Archivo actualizado correctamente.");
	                } else {
	                    System.out.println("Error al reemplazar el archivo original.");
	                }
	            } else {
	                fichAux.delete(); // Eliminar el archivo auxiliar si no hay cambios
	                if (!alumnasEliminadas) {
	                    System.out.println("No se encontró ninguna alumna del curso " + cursoAcademico + ".");
	                }
	            }

	        } catch (Exception e) {
	            System.out.println("Error durante la operación: " + e.getMessage());
	        }
	    } else {
	        System.out.println("El archivo no existe. No se puede realizar la operación.");
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion;
		File fich = new File("EmpresasDual.dat");
		
		do {
			opcion = mostrarMenu();
			switch (opcion) {
			case 1:
				altaEmpresa(fich);
				break;
			case 2:
				bajaTrabajador(fich);
				break;
			case 3:
				eliminarAlumnas(fich);
				break;
			case 4:
				
				break;
			}
		} while (opcion != 5);
	}

}
