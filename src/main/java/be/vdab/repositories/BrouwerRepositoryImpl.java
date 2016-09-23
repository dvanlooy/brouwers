package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class BrouwerRepositoryImpl implements BrouwerRepository {
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();

	BrouwerRepositoryImpl() {
		brouwers.put(1L,
				new Brouwer(1, "Achouffe", new Adres("Route du Village", "32", 6666, "Achouffe-Wibrin"), 10000));
		brouwers.put(2L, new Brouwer(2, "Alken", new Adres("StationStraat", "2", 3570, "Alken"), 950000));
		brouwers.put(8L, new Brouwer(8, "Bavik", new Adres("Rijksweg", "33", 8531, "Bavikhove"), 11000));
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwer.setId(Collections.max(brouwers.keySet()) + 1);
		brouwers.put(brouwer.getId(), brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		beginNaam = beginNaam.toUpperCase();
		List<Brouwer> resultaat = new ArrayList<>();
		for (Brouwer brouwer : brouwers.values()) {
			if (brouwer.getNaam().toUpperCase().startsWith(beginNaam)) {
				resultaat.add(brouwer);
			}
		}
		return resultaat;
	}
}
