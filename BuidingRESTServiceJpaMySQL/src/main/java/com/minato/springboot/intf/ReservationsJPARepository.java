/**
 * 
 */
package com.minato.springboot.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minato.springboot.entity.Reservations;

/**
 * @author Minato
 *
 */
@Repository
public interface ReservationsJPARepository extends JpaRepository<Reservations, Integer>{

}
