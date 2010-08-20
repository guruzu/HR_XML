/**
 * 
 */
package com.hibernaterecipes.otherrequests;

import java.io.Serializable;

/**
 * @author Guruzu
 *
 */
public class Product implements Serializable {
	
	private Integer productId;
	private String productName;
	private Product parentProduct;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Product getParentProduct() {
		return parentProduct;
	}
	public void setParentProduct(Product parentProduct) {
		this.parentProduct = parentProduct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [parentProduct=" + parentProduct + ", productId="
				+ productId + ", productName=" + productName + "]";
	}
	
	

}
