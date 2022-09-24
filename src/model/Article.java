/**
 * 
 */
package model;

/**
 * @author Michelle Mejía
 *
 */
public class Article extends Document {
private String author;

public Article(String _title, String _id, String _subject, int _stockQty) {
	this.setTitle(_title);
	this.setId(_id);
	this.setSubject(_subject);
	this.setStockQty(_stockQty);
	
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
