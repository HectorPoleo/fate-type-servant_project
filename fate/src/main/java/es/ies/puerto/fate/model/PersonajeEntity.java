package es.ies.puerto.fate.model;
import java.util.Objects;

public class PersonajeEntity {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;

    public PersonajeEntity() {
    }

    public PersonajeEntity(Integer id) {
        this.id = id;
    }

    public PersonajeEntity(Integer id, String nombre, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public PersonajeEntity id(Integer id) {
        setId(id);
        return this;
    }

    public PersonajeEntity nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public PersonajeEntity descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    public PersonajeEntity imagen(String imagen) {
        setImagen(imagen);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonajeEntity)) {
            return false;
        }
        PersonajeEntity personajeEntity = (PersonajeEntity) o;
        return Objects.equals(id, personajeEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", imagen='" + getImagen() + "'" +
            "}";
    }


}
