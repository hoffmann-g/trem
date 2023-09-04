package entities;

public class Locomotiva {

    private int id;
    private double pesoMaximo;
    private int limiteVagoes;
    private int tremAlocado;

    public Locomotiva(int id, double pesoMaximo) {
        this.id = id;
        this.pesoMaximo = pesoMaximo;
    }

    protected int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "L" + Integer.toString(id);

    }
}
