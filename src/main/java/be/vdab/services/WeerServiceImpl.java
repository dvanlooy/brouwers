package be.vdab.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import be.vdab.restclients.WeerClient;

@Service
class WeerServiceImpl implements WeerService {
	private final WeerClient weerClient;

	WeerServiceImpl(WeerClient weerClient) {
		this.weerClient = weerClient;
	}

	@Override
	public BigDecimal getTemperatuur(String plaats) {
		return weerClient.getTemperatuur(plaats);
	}
}