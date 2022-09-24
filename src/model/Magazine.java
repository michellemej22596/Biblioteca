/**
 * 
 */
package model;

/**
 * @author Michelle Mejía
 *
 */
public class Magazine extends Document {
	
	private int MagazineNumber;
	private int year;
	
	/**
	 * @return the magazineNumber
	 */
	public int getMagazineNumber() {
		return MagazineNumber;
	}

	/**
	 * @param magazineNumber the magazineNumber to set
	 */
	public void setMagazineNumber(int magazineNumber) {
		MagazineNumber = magazineNumber;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	public Magazine(String _title, String _id, String _subject, int _stockQty) {
		this.setTitle(_title);
		this.setId(_id);
		this.setSubject(_subject);
		this.setStockQty(_stockQty);
		
	}
}
