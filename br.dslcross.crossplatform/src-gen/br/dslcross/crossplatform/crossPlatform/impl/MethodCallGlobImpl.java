/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.Attribute;
import br.dslcross.crossplatform.crossPlatform.AttributeCall;
import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
import br.dslcross.crossplatform.crossPlatform.Global;
import br.dslcross.crossplatform.crossPlatform.MethodCallGlob;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call Glob</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.MethodCallGlobImpl#getObj <em>Obj</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.MethodCallGlobImpl#getCalledOpGlobal <em>Called Op Global</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.MethodCallGlobImpl#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodCallGlobImpl extends MinimalEObjectImpl.Container implements MethodCallGlob
{
  /**
   * The cached value of the '{@link #getObj() <em>Obj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObj()
   * @generated
   * @ordered
   */
  protected Attribute obj;

  /**
   * The cached value of the '{@link #getCalledOpGlobal() <em>Called Op Global</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalledOpGlobal()
   * @generated
   * @ordered
   */
  protected Global calledOpGlobal;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<AttributeCall> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MethodCallGlobImpl()
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
    return CrossPlatformPackage.Literals.METHOD_CALL_GLOB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Attribute getObj()
  {
    if (obj != null && obj.eIsProxy())
    {
      InternalEObject oldObj = (InternalEObject)obj;
      obj = (Attribute)eResolveProxy(oldObj);
      if (obj != oldObj)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.METHOD_CALL_GLOB__OBJ, oldObj, obj));
      }
    }
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute basicGetObj()
  {
    return obj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setObj(Attribute newObj)
  {
    Attribute oldObj = obj;
    obj = newObj;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.METHOD_CALL_GLOB__OBJ, oldObj, obj));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Global getCalledOpGlobal()
  {
    if (calledOpGlobal != null && calledOpGlobal.eIsProxy())
    {
      InternalEObject oldCalledOpGlobal = (InternalEObject)calledOpGlobal;
      calledOpGlobal = (Global)eResolveProxy(oldCalledOpGlobal);
      if (calledOpGlobal != oldCalledOpGlobal)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL, oldCalledOpGlobal, calledOpGlobal));
      }
    }
    return calledOpGlobal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Global basicGetCalledOpGlobal()
  {
    return calledOpGlobal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCalledOpGlobal(Global newCalledOpGlobal)
  {
    Global oldCalledOpGlobal = calledOpGlobal;
    calledOpGlobal = newCalledOpGlobal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL, oldCalledOpGlobal, calledOpGlobal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<AttributeCall> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<AttributeCall>(AttributeCall.class, this, CrossPlatformPackage.METHOD_CALL_GLOB__ARGS);
    }
    return args;
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
      case CrossPlatformPackage.METHOD_CALL_GLOB__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case CrossPlatformPackage.METHOD_CALL_GLOB__OBJ:
        if (resolve) return getObj();
        return basicGetObj();
      case CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL:
        if (resolve) return getCalledOpGlobal();
        return basicGetCalledOpGlobal();
      case CrossPlatformPackage.METHOD_CALL_GLOB__ARGS:
        return getArgs();
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
      case CrossPlatformPackage.METHOD_CALL_GLOB__OBJ:
        setObj((Attribute)newValue);
        return;
      case CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL:
        setCalledOpGlobal((Global)newValue);
        return;
      case CrossPlatformPackage.METHOD_CALL_GLOB__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends AttributeCall>)newValue);
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
      case CrossPlatformPackage.METHOD_CALL_GLOB__OBJ:
        setObj((Attribute)null);
        return;
      case CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL:
        setCalledOpGlobal((Global)null);
        return;
      case CrossPlatformPackage.METHOD_CALL_GLOB__ARGS:
        getArgs().clear();
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
      case CrossPlatformPackage.METHOD_CALL_GLOB__OBJ:
        return obj != null;
      case CrossPlatformPackage.METHOD_CALL_GLOB__CALLED_OP_GLOBAL:
        return calledOpGlobal != null;
      case CrossPlatformPackage.METHOD_CALL_GLOB__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MethodCallGlobImpl
