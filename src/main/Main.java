package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	
	public static void altaEmpleado(File fich)
	{
		String nombreEmpresa,opcion,cif;
		int poblacion,telf,valoracion;
		
	

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
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			}
		} while (opcion != 5);
	}

}
