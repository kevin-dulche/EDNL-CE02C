public class Perro extends Animal {
    private String raza;
    private String color;

    public Perro(String nombre, String tipo, String raza, String color) {
        super(nombre, tipo);
        this.raza = raza;
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Perro{" +
            "nombre='" + getNombre() + '\'' +
            ", tipo='" + getTipo() + '\'' +
            ", raza='" + raza + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
    
}
