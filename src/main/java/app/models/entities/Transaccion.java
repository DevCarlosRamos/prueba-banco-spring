package app.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transacciones")
public class Transaccion {
    @Id
    private String id;
    private String emisorId; // ID del usuario que envía el dinero
    private String receptorId; // ID del usuario que recibe el dinero
    private String tipoCambio;
    private double monto;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmisorId() {
		return emisorId;
	}
	public void setEmisorId(String emisorId) {
		this.emisorId = emisorId;
	}
	public String getReceptorId() {
		return receptorId;
	}
	public void setReceptorId(String receptorId) {
		this.receptorId = receptorId;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

    
}