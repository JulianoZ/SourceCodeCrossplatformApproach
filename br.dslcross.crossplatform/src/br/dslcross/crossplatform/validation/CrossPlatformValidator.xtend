/*
 * generated by Xtext 2.13.0
 */
package br.dslcross.crossplatform.validation

import java.util.HashMap
import org.eclipse.xtext.validation.Check
import br.dslcross.crossplatform.crossPlatform.Attribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.util.List
import br.dslcross.crossplatform.crossPlatform.MethodCallOp
import br.dslcross.crossplatform.crossPlatform.Operation



import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage
import br.dslcross.crossplatform.crossPlatform.DSLConcreteTypeRef
import br.dslcross.crossplatform.crossPlatform.DSLGenericType
import br.dslcross.crossplatform.crossPlatform.DSLGenericTypeRef
import br.dslcross.crossplatform.crossPlatform.DSLTypeRef
import br.dslcross.crossplatform.crossPlatform.MethodCallGlob
import br.dslcross.crossplatform.crossPlatform.OperationGlobCall
import br.dslcross.crossplatform.crossPlatform.OperationGlobal
import br.dslcross.crossplatform.crossPlatform.Type


/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class CrossPlatformValidator extends AbstractCrossPlatformValidator {
	
//	public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
//			warning('Name should start with a capital', 
//					CrossPlatformPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}


@Check
	def checkMethodCallOp(MethodCallOp mOpCall) {
		val mOp = mOpCall.call
		var int countConcret = 0
		for (p : mOp.params) {
			if (p.type instanceof DSLGenericTypeRef) {							
			} else {				
				countConcret++
			}
		}		
		if (mOpCall.args.size != countConcret) {
			error(
				'Parameters don\'t match with local method. Size:  MethodCallOp ' + mOpCall.args.size + ' Local ' +
					countConcret, CrossPlatformPackage.Literals.METHOD_CALL_OP__ARGS)
		}

	}
 	
	
	
	
	@Check
	def checkMethodCallGlobal(MethodCallGlob mcCallGlob) {
		val mc = mcCallGlob.calledOpGlobal
		var int countConcret = 0
		for (p : mc.params) {
			if (p.type instanceof DSLGenericTypeRef) {
				// println("Tipo gen�rico : " + p.type.toString + "  " + p.name)
				countConcret++				
			} else {
				// println("Tipo concreto : " + p.type.toString + "  " + p.name)
				countConcret++
			}
		}
		// println("Contagem: MethodCallGlob : " + mcCallGlob.params.size + "  countConcret " + countConcret)
		if (mcCallGlob.args.size != countConcret) {
			error(
				'Parameters don\'t match with global method. Size:  MetCallGlob ' + mcCallGlob.args.size +
					' Global ' + countConcret, CrossPlatformPackage.Literals.METHOD_CALL_GLOB__ARGS)
		}

	}
	
	
	/*
	@Check
	def checkGlobalUses(OperationGlobCall gmu) {
		val gms = gmu.opGlobCall

		//if (gmu.concreteTypes.size != gms.genericTypes.size) {
		//	error('Concrete types don\'t match generic types',
		//		CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__CONCRETE_TYPES)
		//}

		val concreteTypesSize = gmu.concreteTypes.size;
		val typeConcretizationMap = new HashMap<String, Type>()

		for (var i = 0; i < concreteTypesSize; i++) {
			val concreteTypeGmu = gmu.concreteTypes.get(i);
			val genericTypeGms = gms.genericTypes.get(i);
			typeConcretizationMap.put(genericTypeGms.name, concreteTypeGmu)
		}

		//if (gmu.params.size != gms.params.size) {
		//	error('Parameters don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__PARAMS)
		//}

		//if (!typeMatch(gmu.typeGlobal, gms.type, typeConcretizationMap)) {
		//	error('Return type doesn\'t match', CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__TYPE_GLOBAL)
		//}

		val paramsSize = gmu.params.size;

		for (var i = 0; i < paramsSize; i++) {
			val paramGmu = gmu.params.get(i);
			val paramGms = gms.params.get(i);
			if (!typeMatch(paramGmu.type, paramGms.type, typeConcretizationMap)) {
				error('Parameter types don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__PARAMS)
			}
			if (!paramGmu.name.equals(paramGms.name)) {
				error('Parameter names don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__PARAMS)
			}
		}
	}
	*/
	
	
	@Check
	def checkGlobalImplements(OperationGlobal gmi) {
		val gms = gmi.opGlobal

		//if (gmi.genericTypes.size != gms.genericTypes.size) {
		//	error('Generic types don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOBAL__GENERIC_TYPES)
		//}

		val genericTypesSize = gmi.genericTypes.size;

		for (var i = 0; i < genericTypesSize; i++) {
			val genericTypeGmu = gmi.genericTypes.get(i);
			val genericTypeGms = gms.genericTypes.get(i);
			if (!genericTypeMatch(genericTypeGmu, genericTypeGms)) {
				error('Generic types don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOBAL__GENERIC_TYPES)
			}
		}
		
		//if (gmi.params.size != gms.params.size) {
		if (gmi.params.size < gms.params.size) {
			error('Parameters don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOBAL__PARAMS)
		}

		//if (!typeMatch(gmi.type, gms.type, null)) {
		//	error('Return type doesn\'t match', CrossPlatformPackage.Literals.OPERATION_GLOBAL__TYPE)
		//}

		//val paramsSize = gmi.params.size;
		//Verifica a menor quantidade de parametros para n�o dar erro no array :=> val paramGms = gms.params.get(i);. Ex: implementsGlobal <E> SelectSpecificIdObject(e: <E>, id: int, context: Context): <E>{
		var int paramsSize = 0		
		val paramsSizeGmi = gmi.params.size; 
		val paramsSizeGms = gms.params.size;
		if (paramsSizeGmi <= paramsSizeGms){
			paramsSize = paramsSizeGmi
		}else{
			paramsSize = paramsSizeGms
		}
		//Verifica a menor quantidade de parametros para n�o dar erro no array :=> val paramGms = gms.params.get(i);

		for (var i = 0; i < paramsSize; i++) {
			val paramGmi = gmi.params.get(i);
			val paramGms = gms.params.get(i);
			if (!typeMatch(paramGmi.type, paramGms.type, null)) {
				error('Parameter types don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOBAL__PARAMS)
			}
			if (!paramGmi.name.equals(paramGms.name)) {
				error('Parameter names don\'t match', CrossPlatformPackage.Literals.OPERATION_GLOB_CALL__PARAMS)
			}
		}
	}
	
	
	
	
	def genericTypeMatch(DSLGenericType genericType1, DSLGenericType genericType2) {
		return genericType1.name.equals(genericType2.name)
	}	
	


	def typeMatch(DSLTypeRef type1, DSLTypeRef type2, HashMap<String, Type> typeConcretizationMap) {
		if (type1 instanceof DSLConcreteTypeRef && type2 instanceof DSLConcreteTypeRef) {
			val ctr1 = type1 as DSLConcreteTypeRef
			val ctr2 = type2 as DSLConcreteTypeRef
			if (ctr1.ref.equals(ctr2.ref))
				return true;
		}

		if (type1 instanceof DSLGenericTypeRef && type2 instanceof DSLGenericTypeRef) {
			val gtr1 = type1 as DSLGenericTypeRef;
			val gtr2 = type2 as DSLGenericTypeRef;
			if (gtr1.ref.name.equals(gtr2.ref.name))
				return true;
		}

		if (type1 instanceof DSLConcreteTypeRef && type2 instanceof DSLGenericTypeRef &&
			typeConcretizationMap !== null) {
			val ctr1 = type1 as DSLConcreteTypeRef
			val gtr2 = type2 as DSLGenericTypeRef;
			val ctr2 = typeConcretizationMap.get(gtr2.ref.name)
			if (ctr1.ref.equals(ctr2))
				return true;

		}
		return false;

	}





}

	
