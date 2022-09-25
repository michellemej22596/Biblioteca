/**
 * 
 */
package model;

/**
 * @author Michelle Mejía
 *Modela libros, hereda atributos y métodos de documentos
 */
public class Book extends Document {
private String editorial;
private String author;

public Book(String _title, String _id, String _subject, int _stockQty) {
	this.setTitle(_title);
	this.setId(_id);
	this.setSubject(_subject);
	this.setStockQty(_stockQty);
	
}

/**
 * @return the editorial
 */
public String getEditorial() {
	return editorial;
}

/**
 * @param editorial the editorial to set
 */
public void setEditorial(String editorial) {
	this.editorial = editorial;
}

/**
 * @return the author
 */
public String getAuthor() {
	return author;
}

/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	this.author = author;
}

}