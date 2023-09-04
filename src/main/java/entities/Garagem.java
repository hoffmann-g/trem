package entities;

import java.util.ArrayList;
import java.util.List;

public class Garagem {

    private List<Locomotiva> garagemLocomotivas = new ArrayList<>();
    private List<Vagao> garagemVagoes = new ArrayList<>();
    private List<Trem> garagemTrens = new ArrayList<>();

    public Garagem(){}

    public void cadastrarLocomotiva(Locomotiva locomotiva){
        garagemLocomotivas.add(locomotiva);
    }

    public void cadastrarVagao(Vagao vagao){
        garagemVagoes.add(vagao);
    }

    public void cadastrarTrem(Trem trem){
        garagemTrens.add(trem);
    }

    public void alocarLocomotiva(Locomotiva locomotiva, Trem trem){
        boolean found = false;
        for(Trem t : garagemTrens){
            if(t.getId() == trem.getId()){
                t.addLocomotiva(locomotiva);
                garagemLocomotivas.remove(locomotiva);
                found = true;
            }
        }
        if (!found) throw new RuntimeException("locomotiva nao encontrada");
    }

    public void alocarVagao(Vagao vagao, Trem trem){
        boolean found = false;
        for(Trem t : garagemTrens){
            if(t.equals(trem)){
                t.addVagao(vagao);
                garagemVagoes.remove(vagao);
                found = true;
            }
        }
        if (!found) throw new RuntimeException("vagao nao encontrado");
    }

    public void desacoplarLocomotiva(Trem trem){
        boolean found = false;
        for(Trem t : garagemTrens){
            if(t.equals(trem) && t.getListaVagoes().isEmpty()){
                garagemLocomotivas.add(t.getListaLocomotivas().get(t.getListaLocomotivas().size()-1));
                t.getListaLocomotivas().remove(t.getListaLocomotivas().size()-1);
                found = true;
            }
        }
        if (!found) throw new RuntimeException("vagao nao encontrado");
    }

    public void desacoplarVagao(Trem trem){
        boolean found = false;
        for(Trem t : garagemTrens){
            if(t.equals(trem)){
                garagemVagoes.add(t.getListaVagoes().get(t.getListaVagoes().size()-1));
                t.getListaVagoes().remove(t.getListaVagoes().size()-1);
                found = true;
            }
        }
        if (!found) throw new RuntimeException("vagao nao encontrado");
    }

    public Locomotiva getLocomotiva(int id){
        for(Locomotiva l : garagemLocomotivas){
            if (l.getId() == id) return l;
        }
        throw new RuntimeException("locomotiva nao encontrada");
    }

    public Vagao getVagao(int id){
        for(Vagao v : garagemVagoes){
            if (v.getId() == id) return v;
        }
        throw new RuntimeException("vagao nao encontrada");
    }

    public Trem getTrem(int id){
        for(Trem t : garagemTrens){
            if (t.getId() == id) return t;
        }
        throw new RuntimeException("trem nao encontrada");
    }

    @Override
    public String toString() {
        return  "GARAGENS: " +
                "Locomotivas:\n" +
                garagemLocomotivas +
                "\ngaragemVagoes:\n" +
                garagemVagoes +
                "\ngaragemTrens:\n" +
                garagemTrens;
    }
}
