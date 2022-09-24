/**
 * 
 */
package model;

/**
 * @author Michelle Mejía
 *
 */
public class Document {

	protected String id;
	protected String title;
	protected String subject;
	protected int stockQty;
	protected boolean available;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the stockQty
	 */
	public int getStockQty() {
		return stockQty;
	}
	/**
	 * @param stockQty the stockQty to set
	 */
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}
	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}
	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
