package cl.button.panic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoAlert {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	private String messageEmail;
	private String messageSMS;
	private String coordante;
	private long latitud; 
	private long longitud;
	private long idUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessageEmail() {
		return messageEmail;
	}
	public void setMessageEmail(String messageEmail) {
		this.messageEmail = messageEmail;
	}
	public String getMessageSMS() {
		return messageSMS;
	}
	public void setMessageSMS(String messageSMS) {
		this.messageSMS = messageSMS;
	}
	public String getCoordante() {
		return coordante;
	}
	public void setCoordante(String coordante) {
		this.coordante = coordante;
	}
	public long getLatitud() {
		return latitud;
	}
	public void setLatitud(long latitud) {
		this.latitud = latitud;
	}
	public long getLongitud() {
		return longitud;
	}
	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	
	
	
}
