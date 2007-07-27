package org.openxava.annotations;

import java.lang.annotation.*;

/**
 * Declares that a property depends on other one. <p>
 * 
 * Applies to properties.<p>
 * 
 * OpenXava uses this info in order to know when to recalculate
 * values of a property in the user interface.<br>
 * Example:
 * <pre>
 * @Depends(properties="unitPrice")  	
 * public BigDecimal getUnitPriceInPesetas() {
 *   if (unitPrice == null) return null;
 *   return unitPrice.multiply(new BigDecimal("166.386")).setScale(0, BigDecimal.ROUND_HALF_UP);
 * }
 * </pre>
 * In this case if the unitPrice changes in the user interface, the value of 
 * unitPriceInPesetas is recalculated and redisplayed.
 * 
 * @author Javier Paniza
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Depends {

	/**
	 * Comma separated list of the properties this property depend on.
	 */
	String properties();
	
}
