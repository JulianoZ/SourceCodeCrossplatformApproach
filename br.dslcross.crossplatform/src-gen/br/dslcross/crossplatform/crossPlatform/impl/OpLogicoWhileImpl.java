/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.ComLog;
import br.dslcross.crossplatform.crossPlatform.CommandOperation;
import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
import br.dslcross.crossplatform.crossPlatform.ExprLogica;
import br.dslcross.crossplatform.crossPlatform.OpLogicoWhile;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Op Logico While</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.OpLogicoWhileImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.OpLogicoWhileImpl#getE <em>E</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.OpLogicoWhileImpl#getCmdList <em>Cmd List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OpLogicoWhileImpl extends CommandOperationImpl implements OpLogicoWhile
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected ComLog left;

  /**
   * The cached value of the '{@link #getE() <em>E</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE()
   * @generated
   * @ordered
   */
  protected ExprLogica e;

  /**
   * The cached value of the '{@link #getCmdList() <em>Cmd List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCmdList()
   * @generated
   * @ordered
   */
  protected EList<CommandOperation> cmdList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OpLogicoWhileImpl()
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
    return CrossPlatformPackage.Literals.OP_LOGICO_WHILE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ComLog getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(ComLog newLeft, NotificationChain msgs)
  {
    ComLog oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.OP_LOGICO_WHILE__LEFT, oldLeft, newLeft);
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
  public void setLeft(ComLog newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.OP_LOGICO_WHILE__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.OP_LOGICO_WHILE__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.OP_LOGICO_WHILE__LEFT, newLeft, newLeft));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprLogica getE()
  {
    return e;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE(ExprLogica newE, NotificationChain msgs)
  {
    ExprLogica oldE = e;
    e = newE;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.OP_LOGICO_WHILE__E, oldE, newE);
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
  public void setE(ExprLogica newE)
  {
    if (newE != e)
    {
      NotificationChain msgs = null;
      if (e != null)
        msgs = ((InternalEObject)e).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.OP_LOGICO_WHILE__E, null, msgs);
      if (newE != null)
        msgs = ((InternalEObject)newE).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CrossPlatformPackage.OP_LOGICO_WHILE__E, null, msgs);
      msgs = basicSetE(newE, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.OP_LOGICO_WHILE__E, newE, newE));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<CommandOperation> getCmdList()
  {
    if (cmdList == null)
    {
      cmdList = new EObjectContainmentEList<CommandOperation>(CommandOperation.class, this, CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST);
    }
    return cmdList;
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
      case CrossPlatformPackage.OP_LOGICO_WHILE__LEFT:
        return basicSetLeft(null, msgs);
      case CrossPlatformPackage.OP_LOGICO_WHILE__E:
        return basicSetE(null, msgs);
      case CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST:
        return ((InternalEList<?>)getCmdList()).basicRemove(otherEnd, msgs);
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
      case CrossPlatformPackage.OP_LOGICO_WHILE__LEFT:
        return getLeft();
      case CrossPlatformPackage.OP_LOGICO_WHILE__E:
        return getE();
      case CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST:
        return getCmdList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CrossPlatformPackage.OP_LOGICO_WHILE__LEFT:
        setLeft((ComLog)newValue);
        return;
      case CrossPlatformPackage.OP_LOGICO_WHILE__E:
        setE((ExprLogica)newValue);
        return;
      case CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST:
        getCmdList().clear();
        getCmdList().addAll((Collection<? extends CommandOperation>)newValue);
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
      case CrossPlatformPackage.OP_LOGICO_WHILE__LEFT:
        setLeft((ComLog)null);
        return;
      case CrossPlatformPackage.OP_LOGICO_WHILE__E:
        setE((ExprLogica)null);
        return;
      case CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST:
        getCmdList().clear();
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
      case CrossPlatformPackage.OP_LOGICO_WHILE__LEFT:
        return left != null;
      case CrossPlatformPackage.OP_LOGICO_WHILE__E:
        return e != null;
      case CrossPlatformPackage.OP_LOGICO_WHILE__CMD_LIST:
        return cmdList != null && !cmdList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OpLogicoWhileImpl
