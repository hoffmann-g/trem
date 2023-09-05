package entities;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Garagem {

    private List<Locomotiva> garagemLocomotivas = new ArrayList<>();
    private List<Vagao> garagemVagoes = new ArrayList<>();
    private List<Trem> garagemTrens = new ArrayList<>();

    public Garagem(){}

    public void cadastrarLocomotiva(int id, double pesoMaximo){
        garagemLocomotivas.add(new Locomotiva(id, pesoMaximo));
    }

    public void cadastrarVagao(int id, double capacidadeCarga){
        garagemVagoes.add(new Vagao(id, capacidadeCarga));
    }

    public void cadastrarTrem(int id){
        garagemTrens.add(new Trem(id));
    }

    public void alocarLocomotiva(Locomotiva locomotiva, Trem trem) throws InvalidParameterException{
        if (!garagemLocomotivas.contains(locomotiva)) {
            throw new InvalidParameterException("Locomotiva nao encontrada.");
        }
        if (!trem.getListaVagoes().isEmpty()) {
            throw new InvalidParameterException("Nao e possivel alocar locomotivas a unidades com vagoes ja acoplados.");
        }
        locomotiva.setTremAlocado(trem);
        trem.addLocomotiva(locomotiva);
        garagemLocomotivas.remove(locomotiva);


    }

    public void alocarVagao(Vagao vagao, Trem trem) throws InvalidParameterException{
        if (!garagemVagoes.contains(vagao)) {
            throw new InvalidParameterException("Vagao nao encontrado.");
        }
        if (trem.getListaLocomotivas().isEmpty()){
            throw new InvalidParameterException("Nao e possivel alocar vagoes a unidades sem locomotivas acopladas.");
        }
        vagao.setTremAlocado(trem);
        trem.addVagao(vagao);
        garagemVagoes.remove(vagao);
    }

    public void desacoplarLocomotiva(Trem trem) throws InvalidParameterException{
        if (!garagemTrens.contains(trem)) {
            throw new InvalidParameterException("Trem nao encontrado.");
        }
        if (!trem.getListaVagoes().isEmpty()){
            throw new InvalidParameterException("Nao e possivel desacoplar locomotivas sem antes desacoplar todos os vagoes.");
        }
        garagemLocomotivas.add(trem.getListaLocomotivas().get(trem.getListaLocomotivas().size()-1));
        trem.getListaLocomotivas().remove(trem.getListaLocomotivas().size()-1);
    }

    public void desacoplarVagao(Trem trem){
        if (!garagemTrens.contains(trem)) {
            throw new InvalidParameterException("Trem nao encontrado.");
        }
        garagemVagoes.add(trem.getListaVagoes().get(trem.getListaVagoes().size()-1));
        trem.getListaVagoes().remove(trem.getListaVagoes().size()-1);
    }

    public Locomotiva getLocomotiva(int id) throws InvalidParameterException {
        for(Locomotiva l : garagemLocomotivas){
            if (l.getId() == id) return l;
        }
        throw new InvalidParameterException("Locomotiva nao encontrada.");
    }

    public Vagao getVagao(int id) throws InvalidParameterException {
        for(Vagao v : garagemVagoes){
            if (v.getId() == id) return v;
        }
        throw new InvalidParameterException("Vagao nao encontrado.");
    }

    public Trem getTrem(int id) throws InvalidParameterException {
        for(Trem t : garagemTrens){
            if (t.getId() == id) return t;
        }
        throw new InvalidParameterException("Trem nao encontrado.");
    }

    @Deprecated
    public List<String> inspecionarTrem(Trem trem){
        List<String> info = new ArrayList<>();
        for (Trem t : garagemTrens){
            if (t.equals(trem)){
                info.add(String.valueOf(t.getId()));
                info.add(String.valueOf(t.getListaVagoes()));
                info.add(String.valueOf(t.getListaLocomotivas()));
            }
        }
        return info;
    }

    public int inspecionarLocomotiva(int id) throws InvalidParameterException{
        for(Trem t : garagemTrens) {
            for(Locomotiva l : t.getListaLocomotivas()){
                if (l.getId() == id){
                    return l.getTremAlocado().getId();
                }
            }
        }
        for(Locomotiva l : garagemLocomotivas){
            if(l.getId() == id){
                throw new InvalidParameterException("Unidade nao alocada a nenhum trem");
            }
        }
        throw new InvalidParameterException("Unidade nao encontrada");
    }

    public int inspecionarVagao(int id) throws InvalidParameterException{
        for(Trem t : garagemTrens) {
            for(Vagao v : t.getListaVagoes()){
                if (v.getId() == id){
                    return v.getTremAlocado().getId();
                }
            }
        }
        for(Vagao v : garagemVagoes){
            if(v.getId() == id){
                throw new InvalidParameterException("Unidade nao alocada a nenhum trem");
            }
        }
        throw new InvalidParameterException("Unidade nao encontrada");
    }

    public void desfazerTrem(Trem trem) throws InvalidParameterException{
        if(garagemTrens.contains(trem)){
            garagemVagoes.addAll(trem.getListaVagoes());
            garagemLocomotivas.addAll(trem.getListaLocomotivas());
            trem.getListaVagoes().clear();
            trem.getListaLocomotivas().clear();
            garagemTrens.remove(trem);
        } else {
            throw new InvalidParameterException("Trem nao encontrado");
        }
    }

    @Override
    public String toString() {
        return  "GARAGENS:\n" +
                "Locomotivas:\n" +
                garagemLocomotivas +
                "\nGaragem de Vagoes:\n" +
                garagemVagoes +
                "\nGaragem de Trens:\n" +
                garagemTrens;
    }
}
