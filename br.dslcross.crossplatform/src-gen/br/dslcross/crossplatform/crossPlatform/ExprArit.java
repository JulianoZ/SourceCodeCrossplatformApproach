/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr Arit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.ExprArit#getTermos <em>Termos</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.ExprArit#getOp <em>Op</em>}</li>
 * </ul>
 *
 * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getExprArit()
 * @model
 * @generated
 */
public interface ExprArit extends EObject
{
  /**
   * Returns the value of the '<em><b>Termos</b></em>' containment reference list.
   * The list contents are of type {@link br.dslcross.crossplatform.crossPlatform.Termo}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Termos</em>' containment reference list.
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getExprArit_Termos()
   * @model containment="true"
   * @generated
   */
  EList<Termo> getTermos();

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute list.
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getExprArit_Op()
   * @model unique="false"
   * @generated
   */
  EList<String> getOp();

} // ExprArit
