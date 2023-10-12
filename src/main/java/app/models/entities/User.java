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
    private double fondoSOL;
    private double fondoUSD;
    private String token;
    
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public double getFondoSOL() {
		return fondoSOL;
	}

	public void setFondoSOL(double fondoSOL) {
		this.fondoSOL = fondoSOL;
	}

	public double getFondoUSD() {
		return fondoUSD;
	}

	public void setFondoUSD(double fondoUSD) {
		this.fondoUSD = fondoUSD;
	}

	public User() {
    }

    public User(String email,String nombre, String password, double fondoSOL, double fondoUSD) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.fondoSOL = fondoSOL;
        this.fondoUSD = fondoUSD;
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
