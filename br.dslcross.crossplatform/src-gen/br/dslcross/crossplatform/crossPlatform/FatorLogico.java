/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fator Logico</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getN <em>N</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getV <em>V</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOp1 <em>Op1</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOp2 <em>Op2</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExprLog <em>Expr Log</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExpr1 <em>Expr1</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOpRel <em>Op Rel</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExpr2 <em>Expr2</em>}</li>
 * </ul>
 *
 * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico()
 * @model
 * @generated
 */
public interface FatorLogico extends EObject
{
  /**
   * Returns the value of the '<em><b>N</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>N</em>' attribute.
   * @see #setN(String)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_N()
   * @model
   * @generated
   */
  String getN();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getN <em>N</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>N</em>' attribute.
   * @see #getN()
   * @generated
   */
  void setN(String value);

  /**
   * Returns the value of the '<em><b>V</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>V</em>' reference.
   * @see #setV(Attribute)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_V()
   * @model
   * @generated
   */
  Attribute getV();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getV <em>V</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>V</em>' reference.
   * @see #getV()
   * @generated
   */
  void setV(Attribute value);

  /**
   * Returns the value of the '<em><b>Op1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op1</em>' attribute.
   * @see #setOp1(String)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_Op1()
   * @model
   * @generated
   */
  String getOp1();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOp1 <em>Op1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op1</em>' attribute.
   * @see #getOp1()
   * @generated
   */
  void setOp1(String value);

  /**
   * Returns the value of the '<em><b>Op2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op2</em>' attribute.
   * @see #setOp2(String)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_Op2()
   * @model
   * @generated
   */
  String getOp2();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOp2 <em>Op2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op2</em>' attribute.
   * @see #getOp2()
   * @generated
   */
  void setOp2(String value);

  /**
   * Returns the value of the '<em><b>Expr Log</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr Log</em>' containment reference.
   * @see #setExprLog(ExprLogica)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_ExprLog()
   * @model containment="true"
   * @generated
   */
  ExprLogica getExprLog();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExprLog <em>Expr Log</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr Log</em>' containment reference.
   * @see #getExprLog()
   * @generated
   */
  void setExprLog(ExprLogica value);

  /**
   * Returns the value of the '<em><b>Expr1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr1</em>' containment reference.
   * @see #setExpr1(ExprL)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_Expr1()
   * @model containment="true"
   * @generated
   */
  ExprL getExpr1();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExpr1 <em>Expr1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr1</em>' containment reference.
   * @see #getExpr1()
   * @generated
   */
  void setExpr1(ExprL value);

  /**
   * Returns the value of the '<em><b>Op Rel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op Rel</em>' attribute.
   * @see #setOpRel(String)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_OpRel()
   * @model
   * @generated
   */
  String getOpRel();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getOpRel <em>Op Rel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op Rel</em>' attribute.
   * @see #getOpRel()
   * @generated
   */
  void setOpRel(String value);

  /**
   * Returns the value of the '<em><b>Expr2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr2</em>' containment reference.
   * @see #setExpr2(ExprL)
   * @see br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage#getFatorLogico_Expr2()
   * @model containment="true"
   * @generated
   */
  ExprL getExpr2();

  /**
   * Sets the value of the '{@link br.dslcross.crossplatform.crossPlatform.FatorLogico#getExpr2 <em>Expr2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr2</em>' containment reference.
   * @see #getExpr2()
   * @generated
   */
  void setExpr2(ExprL value);

} // FatorLogico
