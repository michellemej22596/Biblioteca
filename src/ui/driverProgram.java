/**
 * 
 */
package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Article;
import model.Book;
import model.Document;
import model.Magazine;
/**
 * @author Michelle Mejía
 *
 */
public class driverProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
	
		ArrayList<Document> Documentos = new ArrayList<Document>();
		
System.out.println("¡Bienvenido al programa!");
		
		System.out.println("¿Qué desea realizar el día de hoy?");
		
		Scanner entrada = new Scanner(System.in);
		String option1 = "";
		
while (!option1.equals("8")) {
			
			menu();
			option1 = "" + entrada.nextLine();
			switch (option1) {
			
			case "1":{
				
				System.out.println("¿Qué tipo de documento deseas añadir?");
				System.out.println("1. Libro \n2. Revista \n3. Artículo Científico");
				String opcion = entrada.nextLine();
				
				if(opcion.equals("1")){
					System.out.println("¿Cuál es el título del libro(s) que deseas añadir?");
					String _title = entrada.nextLine();
					System.out.println("Ingrese el Id del libro solicitado");
					String _id = entrada.nextLine();
					System.out.println("Ingrese la materia del libro solicitado");
					String _subject = entrada.nextLine();
					System.out.println("Ingrese la cantidad en stock ");
					int _stockQty = Integer.parseInt(entrada.nextLine());
					Documentos.add(new Book(_title, _id, _subject, _stockQty));
				}
				
				if(opcion.equals("2")){
					System.out.println("¿Cuál es el título de la revista que deseas añadir?");
					String _title = entrada.nextLine();
					System.out.println("Ingrese el Id de la revista solicitada");
					String _id = entrada.nextLine();
					System.out.println("Ingrese la materia de la revista solicitada");
					String _subject = entrada.nextLine();
					System.out.println("Ingrese la cantidad en stock ");
					int _stockQty = Integer.parseInt(entrada.nextLine());
					Documentos.add(new Magazine(_title, _id, _subject, _stockQty));
				}
				
				if(opcion.equals("3")){
					System.out.println("¿Cuál es el título del artículo que deseas añadir?");
					String _title = entrada.nextLine();
					System.out.println("Ingrese el Id del artículo solicitado");
					String _id = entrada.nextLine();
					System.out.println("Ingrese la materia del artículo solicitado");
					String _subject = entrada.nextLine();
					System.out.println("Ingrese la cantidad en stock ");
					int _stockQty = Integer.parseInt(entrada.nextLine());
					Documentos.add(new Article(_title, _id, _subject, _stockQty));
				}
				
				System.out.println("La publicación se ha añadido con éxito.");
				
				}break;
				
			case "2":{
				System.out.println("*********************");
				System.out.println("Ingrese el Id del documento que desea buscar");
				String codigo = entrada.nextLine();
					Document docBuscado = searchByID(codigo, Documentos);
					
					if (docBuscado != null) {
						System.out.println("El documento que busca se titula "+ docBuscado.getTitle());
					}
					else {
						System.out.println("No existe ningún registro del ID que busca, por favor intente de nuevo.");
					}
				}break;
		
			
			case "3":{ 
				System.out.println("*********************");
				System.out.println("Ingrese la materia que desea buscar");
				String subject = entrada.nextLine();
				System.out.println("Existe(n) "+countBySubject(subject, Documentos)+" documento(s) coincidente(s).");

				}break;
				
				
			case "4":{
				System.out.println("*********************");
				}break;
				
			case "5":{
				System.out.println("*********************");
				}break;
				
			case "6":{
				System.out.println("*********************");
				}break;
				
			case "7":{
				System.out.println("*********************");
				System.out.println("Ingrese el nombre del documento que desea buscar");
				String title = entrada.nextLine();
				System.out.println("Existe(n) "+countStock(title, Documentos)+" ejemplar(es) disponible(s) en la biblioteca.");
				
				}break;
				
			case "8":{
				System.out.println("¡Muchas gracias por utilizar el programa!");
			}break;
			
			default:{
				System.out.println("Por favor ingrese una opción válida.");
			}
			}
			
		}
		
		
	}

public static Document searchByID(String id, ArrayList<Document> libreria) {
	for (Document buscado: libreria) {
		if (buscado.getId().equals(id)) {
			return buscado;
		}
	}
	
	return null;
}

public static int countBySubject(String subject, ArrayList<Document> libreria) {
	int contador= 0;
	for (Document buscado: libreria) {
		if (buscado.getSubject().equals(subject)) {
			contador ++;
			return contador;
		}
	}
	
	return contador;
}

public static int countStock(String title, ArrayList<Document> libreria) {
	int contador= 0;
	for (Document buscado: libreria) {
		if (buscado.getTitle().equals(title)) {
			return buscado.getStockQty();
		}
	}
	
	return contador;
}
	
	public static void menu(){
		
		System.out.println("*********************");
		System.out.println("Seleccione una opción:");
		System.out.println("1. Ingresar documento");
		System.out.println("2. Mostrar publicación por Id");
		System.out.println("3. Número de documentos según materia");
		System.out.println("4. Préstamo de documento");
		System.out.println("5. Devolución de documento");
		System.out.println("6. Cantidad de documentos prestados a un cliente");
		System.out.println("7. Disponibilidad de libros y artículos");
		System.out.println("8. Salir");
	}
	
	
	
	
}