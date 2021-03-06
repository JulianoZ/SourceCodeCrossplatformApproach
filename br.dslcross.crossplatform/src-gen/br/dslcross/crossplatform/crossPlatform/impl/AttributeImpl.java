/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.Attribute;
import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
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
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AttributeImpl#isMany <em>Many</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AttributeImpl#getArrayAllow <em>Array Allow</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.AttributeImpl#getConcreteTypes <em>Concrete Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends CommandFeatureImpl implements Attribute
{
  /**
   * The default value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected static final boolean MANY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMany() <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMany()
   * @generated
   * @ordered
   */
  protected boolean many = MANY_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * The default value of the '{@link #getArrayAllow() <em>Array Allow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayAllow()
   * @generated
   * @ordered
   */
  protected static final int ARRAY_ALLOW_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getArrayAllow() <em>Array Allow</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayAllow()
   * @generated
   * @ordered
   */
  protected int arrayAllow = ARRAY_ALLOW_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
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
    return CrossPlatformPackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isMany()
  {
    return many;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMany(boolean newMany)
  {
    boolean oldMany = many;
    many = newMany;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ATTRIBUTE__MANY, oldMany, many));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Type getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Type)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CrossPlatformPackage.ATTRIBUTE__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ATTRIBUTE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getArrayAllow()
  {
    return arrayAllow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArrayAllow(int newArrayAllow)
  {
    int oldArrayAllow = arrayAllow;
    arrayAllow = newArrayAllow;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.ATTRIBUTE__ARRAY_ALLOW, oldArrayAllow, arrayAllow));
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
      concreteTypes = new EObjectResolvingEList<Type>(Type.class, this, CrossPlatformPackage.ATTRIBUTE__CONCRETE_TYPES);
    }
    return concreteTypes;
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
      case CrossPlatformPackage.ATTRIBUTE__MANY:
        return isMany();
      case CrossPlatformPackage.ATTRIBUTE__NAME:
        return getName();
      case CrossPlatformPackage.ATTRIBUTE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case CrossPlatformPackage.ATTRIBUTE__ARRAY_ALLOW:
        return getArrayAllow();
      case CrossPlatformPackage.ATTRIBUTE__CONCRETE_TYPES:
        return getConcreteTypes();
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
      case CrossPlatformPackage.ATTRIBUTE__MANY:
        setMany((Boolean)newValue);
        return;
      case CrossPlatformPackage.ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case CrossPlatformPackage.ATTRIBUTE__TYPE:
        setType((Type)newValue);
        return;
      case CrossPlatformPackage.ATTRIBUTE__ARRAY_ALLOW:
        setArrayAllow((Integer)newValue);
        return;
      case CrossPlatformPackage.ATTRIBUTE__CONCRETE_TYPES:
        getConcreteTypes().clear();
        getConcreteTypes().addAll((Collection<? extends Type>)newValue);
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
      case CrossPlatformPackage.ATTRIBUTE__MANY:
        setMany(MANY_EDEFAULT);
        return;
      case CrossPlatformPackage.ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CrossPlatformPackage.ATTRIBUTE__TYPE:
        setType((Type)null);
        return;
      case CrossPlatformPackage.ATTRIBUTE__ARRAY_ALLOW:
        setArrayAllow(ARRAY_ALLOW_EDEFAULT);
        return;
      case CrossPlatformPackage.ATTRIBUTE__CONCRETE_TYPES:
        getConcreteTypes().clear();
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
      case CrossPlatformPackage.ATTRIBUTE__MANY:
        return many != MANY_EDEFAULT;
      case CrossPlatformPackage.ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CrossPlatformPackage.ATTRIBUTE__TYPE:
        return type != null;
      case CrossPlatformPackage.ATTRIBUTE__ARRAY_ALLOW:
        return arrayAllow != ARRAY_ALLOW_EDEFAULT;
      case CrossPlatformPackage.ATTRIBUTE__CONCRETE_TYPES:
        return concreteTypes != null && !concreteTypes.isEmpty();
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
    result.append(" (many: ");
    result.append(many);
    result.append(", name: ");
    result.append(name);
    result.append(", arrayAllow: ");
    result.append(arrayAllow);
    result.append(')');
    return result.toString();
  }

} //AttributeImpl
