package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private String compania;
    private String provincia;
    private String telefono;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

    public Proveedor(String nombre, String compania, String provincia, String telefono) {
        this.nombre = nombre;
        this.compania = compania;
        this.provincia = provincia;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
