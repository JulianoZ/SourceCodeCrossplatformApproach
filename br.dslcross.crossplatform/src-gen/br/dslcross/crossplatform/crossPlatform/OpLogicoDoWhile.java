/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Op Logico Do While</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.OpLogicoDoWhile#getCmdList <em>Cmd List</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.OpLogicoDoWhile#getE <em>E</em>}</li>
 * </ul>
 *
 * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getOpLogicoDoWhile()
 * @model
 * @generated
 */
public interface OpLogicoDoWhile extends CommandOperation
{
  /**
   * Returns the value of the '<em><b>Cmd List</b></em>' containment reference list.
   * The list contents are of type {@link br.dslcross.crossplatform.crossPlatform.CommandOperation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cmd List</em>' containment reference list.
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getOpLogicoDoWhile_CmdList()
   * @model containment="true"
   * @generated
   */
  EList<CommandOperation> getCmdList();

  /**
   * Returns the value of the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>E</em>' containment reference.
   * @see #setE(ExprLogica)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getOpLogicoDoWhile_E()
   * @model containment="true"
   * @generated
   */
  ExprLogica getE();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.OpLogicoDoWhile#getE <em>E</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E</em>' containment reference.
   * @see #getE()
   * @generated
   */
  void setE(ExprLogica value);

} // OpLogicoDoWhile
