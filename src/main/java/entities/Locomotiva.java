package entities;

import java.util.Objects;

public class Locomotiva{

    private int id;
    private Trem tremAlocado;
    private double pesoMaximo;
    private int limiteVagoes;

    protected Locomotiva(int id, double pesoMaximo) {
        this.id = id;
        this.pesoMaximo = pesoMaximo;
    }

    protected int getId() {
        return id;
    }

    protected Trem getTremAlocado() {
        return tremAlocado;
    }

    protected void setTremAlocado(Trem tremAlocado) {
        this.tremAlocado = tremAlocado;
    }

    @Override
    public String toString() {
        return "L" + Integer.toString(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotiva that = (Locomotiva) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
