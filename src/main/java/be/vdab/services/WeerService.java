package be.vdab.services;

import java.math.BigDecimal;

public interface WeerService {
	BigDecimal getTemperatuur(String plaats);
}