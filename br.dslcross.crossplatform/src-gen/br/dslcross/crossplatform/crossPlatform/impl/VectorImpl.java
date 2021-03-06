/**
 * generated by Xtext 2.24.0
 */
package br.dslcross.crossplatform.crossPlatform.impl;

import br.dslcross.crossplatform.crossPlatform.CrossPlatformPackage;
import br.dslcross.crossplatform.crossPlatform.Vector;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.VectorImpl#getCol1 <em>Col1</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.VectorImpl#getArray <em>Array</em>}</li>
 *   <li>{@link br.dslcross.crossplatform.crossPlatform.impl.VectorImpl#getCol2 <em>Col2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VectorImpl extends MinimalEObjectImpl.Container implements Vector
{
  /**
   * The default value of the '{@link #getCol1() <em>Col1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCol1()
   * @generated
   * @ordered
   */
  protected static final String COL1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCol1() <em>Col1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCol1()
   * @generated
   * @ordered
   */
  protected String col1 = COL1_EDEFAULT;

  /**
   * The default value of the '{@link #getArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArray()
   * @generated
   * @ordered
   */
  protected static final int ARRAY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getArray() <em>Array</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArray()
   * @generated
   * @ordered
   */
  protected int array = ARRAY_EDEFAULT;

  /**
   * The default value of the '{@link #getCol2() <em>Col2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCol2()
   * @generated
   * @ordered
   */
  protected static final String COL2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCol2() <em>Col2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCol2()
   * @generated
   * @ordered
   */
  protected String col2 = COL2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VectorImpl()
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
    return CrossPlatformPackage.Literals.VECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCol1()
  {
    return col1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCol1(String newCol1)
  {
    String oldCol1 = col1;
    col1 = newCol1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.VECTOR__COL1, oldCol1, col1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getArray()
  {
    return array;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArray(int newArray)
  {
    int oldArray = array;
    array = newArray;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.VECTOR__ARRAY, oldArray, array));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCol2()
  {
    return col2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCol2(String newCol2)
  {
    String oldCol2 = col2;
    col2 = newCol2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CrossPlatformPackage.VECTOR__COL2, oldCol2, col2));
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
      case CrossPlatformPackage.VECTOR__COL1:
        return getCol1();
      case CrossPlatformPackage.VECTOR__ARRAY:
        return getArray();
      case CrossPlatformPackage.VECTOR__COL2:
        return getCol2();
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
      case CrossPlatformPackage.VECTOR__COL1:
        setCol1((String)newValue);
        return;
      case CrossPlatformPackage.VECTOR__ARRAY:
        setArray((Integer)newValue);
        return;
      case CrossPlatformPackage.VECTOR__COL2:
        setCol2((String)newValue);
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
      case CrossPlatformPackage.VECTOR__COL1:
        setCol1(COL1_EDEFAULT);
        return;
      case CrossPlatformPackage.VECTOR__ARRAY:
        setArray(ARRAY_EDEFAULT);
        return;
      case CrossPlatformPackage.VECTOR__COL2:
        setCol2(COL2_EDEFAULT);
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
      case CrossPlatformPackage.VECTOR__COL1:
        return COL1_EDEFAULT == null ? col1 != null : !COL1_EDEFAULT.equals(col1);
      case CrossPlatformPackage.VECTOR__ARRAY:
        return array != ARRAY_EDEFAULT;
      case CrossPlatformPackage.VECTOR__COL2:
        return COL2_EDEFAULT == null ? col2 != null : !COL2_EDEFAULT.equals(col2);
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
    result.append(" (col1: ");
    result.append(col1);
    result.append(", array: ");
    result.append(array);
    result.append(", col2: ");
    result.append(col2);
    result.append(')');
    return result.toString();
  }

} //VectorImpl
