package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trem {

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

    protected int getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trem trem = (Trem) o;
        return id == trem.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
