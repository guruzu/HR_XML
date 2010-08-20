/**
 * 
 */
package com.hibernaterecipes.chapter10;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * @author Guruzu
 *
 */
public class BookShopInterceptor extends EmptyInterceptor {
	
	/* (non-Javadoc)
	 * @see org.hibernate.EmptyInterceptor#onSave(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if ( entity instanceof Auditable ) {
            for ( int i=0; i<propertyNames.length; i++ ) {
                if ( "createDate".equals( propertyNames[i] ) ) {
                    state[i] = new Date();
                    return true;
                }else if( "modDate".equals( propertyNames[i] ) ) {
                    state[i] = new Date();
                    return true;
                }
            }
        }
        return false;

	}

}
