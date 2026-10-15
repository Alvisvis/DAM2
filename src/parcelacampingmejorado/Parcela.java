package parcelacampingmejorado;

/**
 *
 * @author 2DAM
 */
public class Parcela {

//ATRIBUTOS
    private int id;
    private String nombre;
    private int capacidad;
    private boolean tieneEletricidad;
    private double precioNoche;
    private String descrip;
    private boolean disponible;

    //CONSTRUCTORES
    public Parcela() {
    }

    public Parcela(String nombre, int capacidad,
            boolean tieneEletricidad, double precioNoche,
            String descrip, boolean disponible) {

        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        } else {
            this.nombre = nombre;
        }
        if (capacidad < 0 || capacidad > 20) {
            throw new IllegalArgumentException("La capacidad debe estar entre 1 y 20");
        } else {
            this.capacidad = capacidad;
        }
        if (precioNoche < 0.0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        } else {
            this.precioNoche = precioNoche;
        }

        this.id = 1;
        this.tieneEletricidad = tieneEletricidad;
        this.descrip = descrip;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTieneEletricidad() {
        return tieneEletricidad;
    }

    public void setTieneEletricidad(boolean tieneEletricidad) {
        this.tieneEletricidad = tieneEletricidad;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
