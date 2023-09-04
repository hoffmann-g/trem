package entities;

public class Vagao {

    private int id;
    private double capacidadeCarga;
    private int tremAlocado;

    public Vagao(int id, double capacidadeCarga){
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "V" + Integer.toString(id);
    }
}
