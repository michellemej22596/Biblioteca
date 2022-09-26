/**
 * 
 */
package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Article;
import model.Book;
import model.Customer;
import model.Document;
import model.Magazine;
/**
 * @author Michelle Mejía
 *
 */
public class driverProgram {

	/**
	 * @param 
	 *Programa principal, posee toda la logística y métodos necesarios para realizar las consultas y acciones de la Biblioteca.
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		/**
		 *Creación de listas documentos y clientes, se guardaran objetos de estos mismos tipos con sus respectivos atributos.
		 */
	
		ArrayList<Document> Documentos = new ArrayList<Document>();
		ArrayList<Customer> Clientes = new ArrayList<Customer>();
		
		/**
		 *Bienvenida y menú
		 *Se realizará a través de un switch y un ciclo while.
		 */
	
		
System.out.println("¡Bienvenido al programa!");
		
		System.out.println("¿Qué desea realizar el día de hoy?");
		
		Scanner entrada = new Scanner(System.in);
		String option1 = "";
		
while (!option1.equals("9")) {
			
			menu();
			option1 = "" + entrada.nextLine();
			switch (option1) {
			
			/**
			 * Añadir un documento de tipo libro, revista u artículo científico.
			 * Se preguntan y asignan atributos por primera vez.
			 */
			
			case "1":{
				
				System.out.println("¿Qué tipo de documento deseas añadir?");
				System.out.println("1. Libro \n2. Revista \n3. Artículo Científico");
				String opcion = entrada.nextLine();
				
				if(opcion.equals("1")){
					System.out.println("¿Cuál es el título del libro que deseas añadir?");
					String _title = entrada.nextLine();
					System.out.println("Ingrese el Id del libro solicitado");
					String _id = entrada.nextLine();
					System.out.println("Ingrese la materia del libro solicitado");
					String _subject = entrada.nextLine();
					System.out.println("Ingrese la cantidad en stock ");
					int _stockQty = Integer.parseInt(entrada.nextLine());
					Documentos.add(new Book(_title, _id, _subject, _stockQty));
					System.out.println("El libro se ha añadido con éxito.");
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
					System.out.println("La revista se ha añadido con éxito.");
					
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
					System.out.println("El artículo se ha añadido con éxito.");
				}
				
				if(!opcion.equals("1") || opcion.equals("2") || opcion.equals("3")){
					System.out.println("Ingrese una opción válida");
				}
				}break;
				
				/**
				 *Realiza la búsqueda de un documento por Id y devuelve el título
				 *Utiliza el método searchByID.
				 */
				
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
		
				/**
				 *Devuelve la cantidad de documentos que contienen una materia en específico
				 */
			
			case "3":{ 
				System.out.println("*********************");
				System.out.println("Ingrese la materia que desea buscar");
				String subject = entrada.nextLine();
				System.out.println("Existe(n) "+countBySubject(subject, Documentos)+" documento(s) coincidente(s).");

				}break;
				
				
				/**
				 *Solicita los datos del cliente para su respectiva creación
				 */
				
			case "4":{
				System.out.println("*********************");
				System.out.println("Por favor ingresa los siguientes datos acerca del cliente que desea realizar un préstamo");
				System.out.println("Id: ");
				String c_id = entrada.nextLine();
				System.out.println("Nombre: ");
				String c_name = entrada.nextLine();
				System.out.println("Dirección: ");
				String c_address = entrada.nextLine();
				Customer customer= new Customer(c_id, c_name, c_address, 0);
				Clientes.add(customer);
				System.out.println("El cliente se ha añadido con éxito.");
				}break;
				
				/**
				 *Solicita id del cliente y título del libro.
				 *Si el cliente posee menos de 5 préstamos activos y hay disponibilidad, se realiza el préstamo
				 *Se añade el préstamo al cliente y quita 1 en el stock del libro.
				 */
				
			case "5":{
				System.out.println("*********************");
				System.out.println("Ingrese el Id del cliente que desea realizar el préstamo");
				String c_id = entrada.nextLine();
				Customer cliente= searchCustomerByID(c_id, Clientes);
				System.out.println("Ingrese el título del documento que desea prestar");
				String title = entrada.nextLine();
				Document docBuscado = searchBytitle(title, Documentos);
				
				if (docBuscado != null && cliente !=null ) {
					
					if (cliente.getBorrowedItems()<5 && docBuscado.getStockQty()>0) {
						cliente.setBorrowedItems(cliente.getBorrowedItems()+1);
						docBuscado.setStockQty(docBuscado.getStockQty()-1);
						System.out.println("El préstamo se ha realizado con éxito");
					}else {
						System.out.println("Lamentablemente ha habido un error al solicitar el préstamo, esto puede occurrir si el número de préstamos activos del cliente supera los 5 o si no existen ejemplares disponibles.");
					}
				}
				else {
					System.out.println("Ha ocurrido un error, por favor intente de nuevo, revise que el ID y título solicitados sean correctos.");
				}
			}break;
				
			/**
			 *Solicita id del cliente y título del libro.
			 *Se quita el préstamo al cliente y añade 1 en el stock del libro.
			 *De no coincidir, se tira un error.
			 */
			case "6":{
				System.out.println("*********************");
				System.out.println("Ingrese el Id del cliente que realizó el retorno");
				String c_id = entrada.nextLine();
				Customer cliente= searchCustomerByID(c_id, Clientes);
				System.out.println("Ingrese el Id del documento que fue retornado");
				String codigo = entrada.nextLine();
				Document docBuscado = searchByID(codigo, Documentos);
				
				if (docBuscado != null && cliente !=null ) {
					System.out.println("El retorno se ha realizado con éxito.");
					docBuscado.setStockQty(docBuscado.getStockQty()+1);
					cliente.setBorrowedItems(cliente.getBorrowedItems()-1);
				}
				else {
					System.out.println("Ha ocurrido un error, por favor intente de nuevo, revise que los IDs solicitados sean correctos.");
				}
				
				}break;
				
				/**
				 *Solicita id del cliente e imprime el número de préstamos activos.
				 */
				
			case "7":{
				System.out.println("*********************");
				System.out.println("Ingrese el Id del cliente que desea buscar");
				String c_id = entrada.nextLine();
				Customer cliente= searchCustomerByID(c_id, Clientes);
				System.out.println(cliente.getName()+" posee "+cliente.getBorrowedItems()+" préstamos activos.");
				}break;
				
				/**
				 *Solicita el título del documento a buscar y devuelve el stock.
				 */
				
			case "8":{
				System.out.println("*********************");
				System.out.println("Ingrese el nombre del documento que desea buscar");
				String title = entrada.nextLine();
				System.out.println("Existe(n) "+countStock(title, Documentos)+" ejemplar(es) disponible(s) en la biblioteca.");
				
				}break;
				
				/**
				 *Agradecimiento y salida
				 */
				
			case "9":{
				System.out.println("¡Muchas gracias por utilizar el programa!");
			}break;
			
			/**
			 *Programación defensiva
			 */
			default:{
				System.out.println("Por favor ingrese una opción válida.");
			}
			}
			
		}
		
		
	}
	
	/**
	 *Recorre la lista de documentos y devuelve el objeto que tenga un ID coincidente
	 */

public static Document searchByID(String id, ArrayList<Document> libreria) {
	for (Document buscado: libreria) {
		if (buscado.getId().equals(id)) {
			return buscado;
		}
	}
	
	return null;
}

/**
 *Recorre la lista de documentos y devuelve el objeto que tenga un título coincidente
 */
public static Document searchBytitle(String title, ArrayList<Document> libreria) {
	for (Document buscado: libreria) {
		if (buscado.getTitle().equals(title)) {
			return buscado;
		}
	}
	
	return null;
}


/**
 *Recorre la lista de clientes y devuelve el objeto que tenga un ID coincidente
 */
public static Customer searchCustomerByID(String id, ArrayList<Customer> Clientela) {
	for (Customer cliente: Clientela) {
		if (cliente.getId().equals(id)) {
			return cliente;
		}
	}
	
	return null;
}

/**
 *Recorre la lista de documentos y devuelve el número de documentos que tengan una materia coincidente
 */
public static int countBySubject(String subject, ArrayList<Document> libreria) {
	int contador= 0;
	for (Document buscado: libreria) {
		System.out.println(buscado.getSubject());
		if (buscado.getSubject().equals(subject)) {
			contador ++;
		}
	}
	
	return contador;
}

/**
 *Recorre la lista de documentos y devuelve el número de ejemplares que tengan un título coincidente
 */
public static int countStock(String title, ArrayList<Document> libreria) {
	int contador= 0;
	for (Document buscado: libreria) {
		if (buscado.getTitle().equals(title)) {
			return buscado.getStockQty();
		}
	}
	
	return contador;
}

/**
 *Imprime el menú
 */
	public static void menu(){
		
		System.out.println("*********************");
		System.out.println("Seleccione una opción:");
		System.out.println("1. Ingresar documento");
		System.out.println("2. Mostrar publicación por Id");
		System.out.println("3. Número de documentos según materia");
		System.out.println("4. Ingresar cliente");
		System.out.println("5. Préstamo de documento");
		System.out.println("6. Devolución de documento");
		System.out.println("7. Cantidad de documentos prestados a un cliente");
		System.out.println("8. Disponibilidad de libros y artículos");
		System.out.println("9. Salir");
	}
	
	
	
	
}