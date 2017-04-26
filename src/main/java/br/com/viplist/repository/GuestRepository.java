package br.com.viplist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.viplist.model.Guest;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long>{
	
}
