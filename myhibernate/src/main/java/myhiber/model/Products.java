/**
 * 
 */
package myhiber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Parik
 *
 */

@Entity
public class Products {

	@Id
	private int ProductId;
	private String ProductName;
	private float Price ;
	private String ProductCompany ;
	private int Rating ;
//	public Products(int productId, String productName, float price, String productCompany, int rating) {
//		super();
//		ProductId = productId;
//		ProductName = productName;
//		Price = price;
//		ProductCompany = productCompany;
//		Rating = rating;
//	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public String getProductCompany() {
		return ProductCompany;
	}
	public void setProductCompany(String productCompany) {
		ProductCompany = productCompany;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
	@Override
	public String toString() {
		return this.ProductId + " " + this.ProductName + " " + this.ProductCompany + " " + this.Price + " " + this.Rating ;
	}
	
	
	
	
	
	
	
}
