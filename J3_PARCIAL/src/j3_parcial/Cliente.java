import org.springframework.data.annotation.Id;

public class Cliente {
     
    @Id
    private String id;
    private String nombre;
    private Tarjeta tarjeta;

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

    public Cliente() {
    }
}