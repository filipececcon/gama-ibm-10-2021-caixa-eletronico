package br.com.caixaeletronico.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

public class AbstractEntity {

	private UUID id;
	private LocalDateTime dateCreated;
	private LocalDateTime dateUpdated;
	private boolean active;
	
	public AbstractEntity() {
		id = UUID.randomUUID();
		var now = LocalDateTime.now();
		dateCreated = now;
		dateUpdated = now;
		active = true;
	}
	
	public UUID getId() {
		return id;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	
	
	
}
