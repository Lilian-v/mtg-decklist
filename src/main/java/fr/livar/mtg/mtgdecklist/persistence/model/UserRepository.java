package fr.livar.mtg.mtgdecklist.persistence.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByUserName(String userName);

}
