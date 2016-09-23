package be.vdab.repositories;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerRepository {
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam(String beginNaam);
}
