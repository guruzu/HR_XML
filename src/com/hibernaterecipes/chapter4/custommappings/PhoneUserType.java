/**
 * 
 */
package com.hibernaterecipes.chapter4.custommappings;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.UserType;

import com.hibernaterecipes.chapter4.custommappings.PhoneCh4_4;

/**
 * @author Guruzu
 *
 */
public class PhoneUserType implements UserType {

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
	 */
	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return deepCopy(cached);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
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
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		Object deepCopy = deepCopy(value);

        if (!(deepCopy instanceof Serializable)) {
            throw new SerializationException(value.getClass().getName() + " is not serializable ",null);
            
        }
        
        return (Serializable) deepCopy;

	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
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
	 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode(Object PhoneCh4_4) throws HibernateException {
		assert (PhoneCh4_4 != null);

		return PhoneCh4_4.hashCode();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#isMutable()
	 */
	@Override
	public boolean isMutable() {
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
			throws HibernateException, SQLException {
		String completeTelNo = resultSet.getString(names[0]);
				
		if(resultSet.wasNull()) {
			return null;
		}
		String areaCode = null;
		String telNo = null;
		StringTokenizer st = new StringTokenizer(completeTelNo,"-");
		 while (st.hasMoreTokens()) {
			 if(areaCode == null)
			 {
				 areaCode = st.nextToken();
			 }else
			 {
				 telNo = st.nextToken();
			 }
		 }
		PhoneCh4_4 phn = new PhoneCh4_4();
		phn.setAreaCode(areaCode);
		phn.setTelNo(telNo);
		return phn;
		
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
	 */
	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index)
			throws HibernateException, SQLException {
		
		if(value == null) {
			statement.setNull(index, Hibernate.STRING.sqlType());
		} else {
			PhoneCh4_4 phone = (PhoneCh4_4)value;
			
			statement.setString(index, phone.convertToCompleteTelNum());
		}

	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		
		return deepCopy(original);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@Override
	public Class returnedClass() {
		
		return com.hibernaterecipes.chapter4.custommappings.PhoneCh4_4.class;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	@Override
	public int[] sqlTypes() {
		
		return new int [] {java.sql.Types.VARCHAR};
	}

}
