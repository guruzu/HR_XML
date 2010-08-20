/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

import com.hibernaterecipes.chapter4.custommappings.PhoneCh4_4;

/**
 * @author Guruzu
 *
 */
public class PhoneCompositeUserType implements CompositeUserType {

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#assemble(java.io.Serializable, org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	@Override
	public Object assemble(Serializable cached, SessionImplementor implementor,
			Object obj) throws HibernateException {
		return deepCopy(cached);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#deepCopy(java.lang.Object)
	 */
	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if(value==null)
			return null;
		PhoneCh4_4 phoneValue = (PhoneCh4_4)value;
		PhoneCh4_4 phoneCopied = new PhoneCh4_4();
		phoneCopied.setAreaCode(phoneValue.getAreaCode());
		phoneCopied.setTelNo(phoneValue.getTelNo());
		return phoneCopied;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#disassemble(java.lang.Object, org.hibernate.engine.SessionImplementor)
	 */
	@Override
	public Serializable disassemble(Object value, SessionImplementor implementor)
			throws HibernateException {
		Object deepCopy = deepCopy(value);

        if (!(deepCopy instanceof Serializable)) {
            throw new SerializationException(value.getClass().getName() + " is not serializable ",null);
            
        }
        
        return (Serializable) deepCopy;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#equals(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if(x == y)
			return true;
		
		if(x ==null || y == null)
			return false;
		
		return x.equals(y);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyNames()
	 */
	@Override
	public String[] getPropertyNames() {
		return new String[]{"areaCode", "telNo"};
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyTypes()
	 */
	@Override
	public Type[] getPropertyTypes() {
		return new Type[] {Hibernate.STRING, Hibernate.STRING};
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#getPropertyValue(java.lang.Object, int)
	 */
	@Override
	public Object getPropertyValue(Object component, int property)
			throws HibernateException {
		PhoneCh4_4 phone = (PhoneCh4_4)component;
		if(property == 0)
			return phone.getAreaCode();
		else
			return phone.getTelNo();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode(Object phone) throws HibernateException {
		assert (phone != null);

		return phone.hashCode();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#isMutable()
	 */
	@Override
	public boolean isMutable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names,
			SessionImplementor session, Object owner) throws HibernateException,
			SQLException {
		String areaCode = resultSet.getString(names[0]);
		if(resultSet.wasNull()) {
			return null;
		}
		String telNo = resultSet.getString(names[1]);
		
		
		return new PhoneCh4_4(areaCode, telNo);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int, org.hibernate.engine.SessionImplementor)
	 */
	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if(value == null) {
			statement.setNull(index, Hibernate.STRING.sqlType());
			statement.setNull(index+1, Hibernate.STRING.sqlType());
		} else {
			PhoneCh4_4 phone = (PhoneCh4_4)value;
			statement.setString(index, phone.getAreaCode());
			statement.setString(index+1, phone.getTelNo());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#replace(java.lang.Object, java.lang.Object, org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	@Override
	public Object replace(Object original, Object target, SessionImplementor owner,
			Object arg3) throws HibernateException {
		
		return deepCopy(original);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#returnedClass()
	 */
	@Override
	public Class returnedClass() {
		return com.hibernaterecipes.chapter4.custommappings.PhoneCh4_4.class;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.CompositeUserType#setPropertyValue(java.lang.Object, int, java.lang.Object)
	 */
	@Override
	public void setPropertyValue(Object component, int index, Object value)
			throws HibernateException {
		String columnValue = (String) value;
		
		PhoneCh4_4 phone = (PhoneCh4_4)component;
		if(index == 0)
		{
			phone.setAreaCode(columnValue);
		}else if (index == 1)
		{
			phone.setTelNo(columnValue);
		}else
		{
			throw new IllegalArgumentException("Unknown Property - "+index);
		}
			 
		
	}
	
	

}
