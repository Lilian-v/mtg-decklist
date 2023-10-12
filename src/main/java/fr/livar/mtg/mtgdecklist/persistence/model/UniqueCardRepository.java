package fr.livar.mtg.mtgdecklist.persistence.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniqueCardRepository extends JpaRepository<UniqueCard, String> {

}
