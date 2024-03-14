public class Gato extends Animal {
    private String nombre;
    private String color;

    public Gato(String nombre, String tipo, String nombreGato, String color) {
        super(nombre, tipo);
        this.nombre = nombreGato;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Gato{" +
            "nombre='" + getNombre() + '\'' +
            ", tipo='" + getTipo() + '\'' +
            ", raza='" + nombre + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
