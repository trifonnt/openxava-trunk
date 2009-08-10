package org.openxava.invoicing.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.invoicing.calculators.*;

@Entity
@View(members="product; quantity, pricePerUnit, amount") // tmp pricePerUnit 
public class Detail extends Identifiable {
	
	@ManyToOne // Lazy fetching fails on removing a detail from parent
	private CommercialDocument parent;
		
	private int quantity;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@ReferenceView("Simple")
	@NoFrame
	private Product product;
	
	@DefaultValueCalculator(value=PricePerUnitCalculator.class,
		properties=@PropertyValue(name="productNumber", from="product.number")
	)
	@Stereotype("MONEY")
	private BigDecimal pricePerUnit;	

	@Stereotype("MONEY") 
	// tmp @Depends("product.number, quantity") 
	@Depends("pricePerUnit, quantity") // tmp pricePerUnit
	public BigDecimal getAmount() {
		// tmp return new BigDecimal(quantity).multiply(product.getPrice());
		return new BigDecimal(quantity).multiply(getPricePerUnit());
	}
	
	// Getters and setters
	
	public CommercialDocument getParent() {
		return parent;
	}

	public void setParent(CommercialDocument parent) {
		this.parent = parent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	

}
