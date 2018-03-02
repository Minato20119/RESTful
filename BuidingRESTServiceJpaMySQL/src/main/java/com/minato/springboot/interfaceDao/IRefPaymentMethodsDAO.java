/**
 * 
 */
package com.minato.springboot.interfaceDao;

import java.util.List;

import com.minato.springboot.entityRef.RefPaymentMethods;

/**
 * @author Minato
 *
 */
public interface IRefPaymentMethodsDAO {

	List<RefPaymentMethods> getAllRefPaymentMethods();

	RefPaymentMethods getRefPaymentMethodsById(int id);

	void addRefPaymentMethods(RefPaymentMethods refPaymentMethods);

	void updateRefPaymentMethods(RefPaymentMethods refPaymentMethods);

	void deleteRefPaymentMethods(int id);

	void deleteAllRefPaymentMethods();

	boolean refPaymentMethodsExists(String name);
}
