package org.openxava.annotations;

import java.lang.annotation.*;

/**
 * A group of @OnChange associated to the same member. <p>
 * 
 * Applies to properties and references.<p>
 * 
 * It allows to define a value different for @OnChange in each view.<br>
 * Example:
 * <pre>
 * @OnChanges({
 *   @OnChange(forViews="DEFAULT", value= ... ),
 *   @OnChange(forViews="Simple, VerySimple", value= ... ),
 *   @OnChange(forViews="Complete", value= ... )
 * })
 * </pre>
 *
 * @author Javier Paniza
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface OnChanges {
	
	OnChange [] value();
	
}
