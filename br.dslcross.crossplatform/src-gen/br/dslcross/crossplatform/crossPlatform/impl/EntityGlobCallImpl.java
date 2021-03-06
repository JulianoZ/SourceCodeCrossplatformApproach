/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
import br.dslcross.crossplatform.crossPlatform.EntityGlobCall;
import br.dslcross.crossplatform.crossPlatform.GlobalEntity;
import br.dslcross.crossplatform.crossPlatform.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity Glob Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.EntityGlobCallImpl#getConcreteTypes <em>Concrete Types</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.EntityGlobCallImpl#getOpGlobCall <em>Op Glob Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityGlobCallImpl extends CommandFeatureImpl implements EntityGlobCall
{
  /**
   * The cached value of the '{@link #getConcreteTypes() <em>Concrete Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConcreteTypes()
   * @generated
   * @ordered
   */
  protected EList<Type> concreteTypes;

  /**
   * The cached value of the '{@link #getOpGlobCall() <em>Op Glob Call</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpGlobCall()
   * @generated
   * @ordered
   */
  protected GlobalEntity opGlobCall;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntityGlobCallImpl()
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
    return CrossPlatformPackage.Literals.ENTITY_GLOB_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Type> getConcreteTypes()
  {
    if (concreteTypes == null)
    {
      concreteTypes = new EObjectResolvingEList<Type>(Type.class, this, CrossPlatformPackage.ENTITY_GLOB_CALL__CONCRETE_TYPES);
    }
    return concreteTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GlobalEntity getOpGlobCall()
  {
    if (opGlobCall != null && opGlobCall.eIsProxy())
    {
      InternalEObject oldOpGlobCall = (InternalEObject)opGlobCall;
      opGlobCall = (GlobalEntity)eResolveProxy(oldOpGlobCall);
      if (opGlobCall != oldOpGlobCall)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL, oldOpGlobCall, opGlobCall));
      }
    }
    return opGlobCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalEntity basicGetOpGlobCall()
  {
    return opGlobCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setOpGlobCall(GlobalEntity newOpGlobCall)
  {
    GlobalEntity oldOpGlobCall = opGlobCall;
    opGlobCall = newOpGlobCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL, oldOpGlobCall, opGlobCall));
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
      case CrossPlatformPackage.ENTITY_GLOB_CALL__CONCRETE_TYPES:
        return getConcreteTypes();
      case CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL:
        if (resolve) return getOpGlobCall();
        return basicGetOpGlobCall();
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
      case CrossPlatformPackage.ENTITY_GLOB_CALL__CONCRETE_TYPES:
        getConcreteTypes().clear();
        getConcreteTypes().addAll((Collection<? extends Type>)newValue);
        return;
      case CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL:
        setOpGlobCall((GlobalEntity)newValue);
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
      case CrossPlatformPackage.ENTITY_GLOB_CALL__CONCRETE_TYPES:
        getConcreteTypes().clear();
        return;
      case CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL:
        setOpGlobCall((GlobalEntity)null);
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
      case CrossPlatformPackage.ENTITY_GLOB_CALL__CONCRETE_TYPES:
        return concreteTypes != null && !concreteTypes.isEmpty();
      case CrossPlatformPackage.ENTITY_GLOB_CALL__OP_GLOB_CALL:
        return opGlobCall != null;
    }
    return super.eIsSet(featureID);
  }

} //EntityGlobCallImpl
