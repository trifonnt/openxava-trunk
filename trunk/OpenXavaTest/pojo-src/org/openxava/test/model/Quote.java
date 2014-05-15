package org.openxava.test.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.*;

/**
 * 
 * @author Javier Paniza 
 */

@Entity
public class Quote extends Identifiable {
		
	@Column(length=4) @Required
	private int year;
	
	@Column(length=6) @Required
	private int number;
	
	@Required @DefaultValueCalculator(CurrentDateCalculator.class)
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simplest")
	private Customer customer;
	
	@ElementCollection
	@ListProperties("product.number, product.description, unitPrice, quantity, amount[quote.amountsSum, quote.taxes, quote.total], availabilityDate, remarks")
	private Collection<QuoteDetail> details;	
	
	public BigDecimal getAmountsSum() {
		BigDecimal sum = new BigDecimal(0);
		for (QuoteDetail detail: getDetails()) {
			sum = sum.add(detail.getAmount());
		}
		return sum;
	}
	
	public BigDecimal getTaxes() {
		return getAmountsSum().multiply(new BigDecimal("0.21"));
	}
	
	public BigDecimal getTotal() {
		return getAmountsSum().add(getTaxes());
	}	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<QuoteDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<QuoteDetail> details) {
		this.details = details;
	}

}
