package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trem implements Comparable<Trem>{

    private int id;
    private List<Locomotiva> listaLocomotivas = new ArrayList<>();
    private List<Vagao> listaVagoes = new ArrayList<>();

    protected Trem(int id) {
        this.id = id;
    }

    protected void addLocomotiva(Locomotiva locomotiva){
        listaLocomotivas.add(locomotiva);
    }

    protected void addVagao(Vagao vagao){
        listaVagoes.add(vagao);
    }

    protected Integer getId() {
        return id;
    }

    protected List<Locomotiva> getListaLocomotivas() {
        return listaLocomotivas;
    }

    protected List<Vagao> getListaVagoes() {
        return listaVagoes;
    }

    @Override
    public String toString() {
        return "[ID: T" + id + " Locomotivas: " + listaLocomotivas + " Vagoes:" + listaVagoes + "]";
    }

    /**
     * Metodos 'equals' e 'hashCode' sao necessarios para comparar um trem com outro utilizando
     * seu ID, ao inves de seu pointer na memoria;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trem trem = (Trem) o;
        return id == trem.id;
    }

    /**
     * Metodos 'equals' e 'hashCode' sao necessarios para comparar um trem com outro utilizando
     * seu ID, ao inves de seu pointer na memoria;
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Trem o) {
        return this.getId().compareTo(o.getId());
    }
}
