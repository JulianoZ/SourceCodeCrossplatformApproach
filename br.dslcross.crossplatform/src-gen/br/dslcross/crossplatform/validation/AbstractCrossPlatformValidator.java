/*
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractCrossPlatformValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage.eINSTANCE);
		return result;
	}
}