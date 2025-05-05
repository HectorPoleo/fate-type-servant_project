package es.ies.puerto.fate.model;
import java.util.Objects;

public class SugerenciaEntity {
    
    private String text;
    private Integer id;

    public SugerenciaEntity() {
    }

    public SugerenciaEntity(Integer id) {
        this.id = id;
    }
    

    public SugerenciaEntity(Integer id, String text) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SugerenciaEntity text(String text) {
        setText(text);
        return this;
    }

    public SugerenciaEntity id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SugerenciaEntity)) {
            return false;
        }
        SugerenciaEntity sugerenciaEntity = (SugerenciaEntity) o;
        return Objects.equals(id, sugerenciaEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " text='" + getText() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }
}
