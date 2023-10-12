package app.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String nombre;
    private String email;
    private String password;
    private double fondo;
    private String token;
    
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public double getFondo() {
		return fondo;
	}

	public void setFondo(double fondo) {
		this.fondo = fondo;
	}

	public User() {
    }

    public User(String email,String nombre, String password, double fondo) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.fondo = fondo;
    }
    
   
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
}
