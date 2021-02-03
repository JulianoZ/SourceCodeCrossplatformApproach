/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.AbrevCmd;
import br.dslcross.crossplatform.crossPlatform.Attribute;
import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
import br.dslcross.crossplatform.crossPlatform.ExprArit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abrev Cmd</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AbrevCmdImpl#getExpr1 <em>Expr1</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AbrevCmdImpl#getOpIn <em>Op In</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AbrevCmdImpl#getExpr2 <em>Expr2</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AbrevCmdImpl#getExpr3 <em>Expr3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbrevCmdImpl extends CommandOperationImpl implements AbrevCmd
{
  /**
   * The cached value of the '{@link #getExpr1() <em>Expr1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr1()
   * @generated
   * @ordered
   */
  protected Attribute expr1;

  /**
   * The default value of the '{@link #getOpIn() <em>Op In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpIn()
   * @generated
   * @ordered
   */
  protected static final String OP_IN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOpIn() <em>Op In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpIn()
   * @generated
   * @ordered
   */
  protected String opIn = OP_IN_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr2() <em>Expr2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr2()
   * @generated
   * @ordered
   */
  protected Attribute expr2;

  /**
   * The cached value of the '{@link #getExpr3() <em>Expr3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr3()
   * @generated
   * @ordered
   */
  protected ExprArit expr3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbrevCmdImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CrossPlatformPackage.Literals.ABREV_CMD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute getExpr1()
  {
    if (expr1 != null && expr1.eIsProxy())
    {
      InternalEObject oldExpr1 = (InternalEObject)expr1;
      expr1 = (Attribute)eResolveProxy(oldExpr1);
      if (expr1 != oldExpr1)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.ABREV_CMD__EXPR1, oldExpr1, expr1));
      }
    }
    return expr1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute basicGetExpr1()
  {
    return expr1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpr1(Attribute newExpr1)
  {
    Attribute oldExpr1 = expr1;
    expr1 = newExpr1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ABREV_CMD__EXPR1, oldExpr1, expr1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getOpIn()
  {
    return opIn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOpIn(String newOpIn)
  {
    String oldOpIn = opIn;
    opIn = newOpIn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ABREV_CMD__OP_IN, oldOpIn, opIn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute getExpr2()
  {
    if (expr2 != null && expr2.eIsProxy())
    {
      InternalEObject oldExpr2 = (InternalEObject)expr2;
      expr2 = (Attribute)eResolveProxy(oldExpr2);
      if (expr2 != oldExpr2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.ABREV_CMD__EXPR2, oldExpr2, expr2));
      }
    }
    return expr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute basicGetExpr2()
  {
    return expr2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpr2(Attribute newExpr2)
  {
    Attribute oldExpr2 = expr2;
    expr2 = newExpr2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ABREV_CMD__EXPR2, oldExpr2, expr2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprArit getExpr3()
  {
    return expr3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr3(ExprArit newExpr3, NotificationChain msgs)
  {
    ExprArit oldExpr3 = expr3;
    expr3 = newExpr3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ABREV_CMD__EXPR3, oldExpr3, newExpr3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpr3(ExprArit newExpr3)
  {
    if (newExpr3 != expr3)
    {
      NotificationChain msgs = null;
      if (expr3 != null)
        msgs = ((InternalEObject)expr3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.ABREV_CMD__EXPR3, null, msgs);
      if (newExpr3 != null)
        msgs = ((InternalEObject)newExpr3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.ABREV_CMD__EXPR3, null, msgs);
      msgs = basicSetExpr3(newExpr3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ABREV_CMD__EXPR3, newExpr3, newExpr3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.ABREV_CMD__EXPR3:
        return basicSetExpr3(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.ABREV_CMD__EXPR1:
        if (resolve) return getExpr1();
        return basicGetExpr1();
      case CrossPlatformPackage.ABREV_CMD__OP_IN:
        return getOpIn();
      case CrossPlatformPackage.ABREV_CMD__EXPR2:
        if (resolve) return getExpr2();
        return basicGetExpr2();
      case CrossPlatformPackage.ABREV_CMD__EXPR3:
        return getExpr3();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.ABREV_CMD__EXPR1:
        setExpr1((Attribute)newValue);
        return;
      case CrossPlatformPackage.ABREV_CMD__OP_IN:
        setOpIn((String)newValue);
        return;
      case CrossPlatformPackage.ABREV_CMD__EXPR2:
        setExpr2((Attribute)newValue);
        return;
      case CrossPlatformPackage.ABREV_CMD__EXPR3:
        setExpr3((ExprArit)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.ABREV_CMD__EXPR1:
        setExpr1((Attribute)null);
        return;
      case CrossPlatformPackage.ABREV_CMD__OP_IN:
        setOpIn(OP_IN_EDEFAULT);
        return;
      case CrossPlatformPackage.ABREV_CMD__EXPR2:
        setExpr2((Attribute)null);
        return;
      case CrossPlatformPackage.ABREV_CMD__EXPR3:
        setExpr3((ExprArit)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.ABREV_CMD__EXPR1:
        return expr1 != null;
      case CrossPlatformPackage.ABREV_CMD__OP_IN:
        return OP_IN_EDEFAULT == null ? opIn != null : !OP_IN_EDEFAULT.equals(opIn);
      case CrossPlatformPackage.ABREV_CMD__EXPR2:
        return expr2 != null;
      case CrossPlatformPackage.ABREV_CMD__EXPR3:
        return expr3 != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (OpIn: ");
    result.append(opIn);
    result.append(')');
    return result.toString();
  }

} //AbrevCmdImpl