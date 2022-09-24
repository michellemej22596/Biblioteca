/**
 * 
 */
package model;

/**
 * @author Michelle Mejía
 *
 */
public class Customer {
private String id;
private String name;
private String address;
private int borrowedItems;

public Customer( String c_id,String c_name, String c_address, int c_borrowedItems) {
	this.setId( c_id);
	this.setName( c_name);
	this.setAddress(c_address);
	this.setBorrowedItems(c_borrowedItems);
	
}
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
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
/**
 * @return the borrowedItems
 */
public int getBorrowedItems() {
	return borrowedItems;
}
/**
 * @param borrowedItems the borrowedItems to set
 */
public void setBorrowedItems(int borrowedItems) {
	this.borrowedItems = borrowedItems;
}


}
