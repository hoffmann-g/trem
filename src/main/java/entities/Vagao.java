package entities;

import java.util.Objects;

public class Vagao{

    private int id;
    private Trem tremAlocado;
    private double capacidadeCarga; // necessita de implementação

    protected Vagao(int id, double capacidadeCarga){
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
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
        return "V" + Integer.toString(id);
    }

    /**
     * Metodos 'equals' e 'hashCode' sao necessarios para comparar um vagao com outro utilizando
     * seu ID, ao inves de seu pointer na memoria;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vagao vagao = (Vagao) o;
        return id == vagao.id;
    }

    /**
     * Metodos 'equals' e 'hashCode' sao necessarios para comparar um vagao com outro utilizando
     * seu ID, ao inves de seu pointer na memoria;
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
