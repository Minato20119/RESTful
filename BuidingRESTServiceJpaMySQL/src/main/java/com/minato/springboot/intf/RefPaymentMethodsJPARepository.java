/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entityRef.RefPaymentMethods;

/**
 * @author Minato
 *
 */
@Repository
public interface RefPaymentMethodsJPARepository extends JpaRepository<RefPaymentMethods, Integer>{

}
