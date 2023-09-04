package application;

import entities.Garagem;
import entities.Locomotiva;
import entities.Trem;
import entities.Vagao;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Program {

    private static final double PESO_MAXIMO  = 5;
    private static final int ENTIDADES_INICIAIS = 10;
    private static final int CAPACIDADE_CARGA = 6;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        Garagem garagem = new Garagem();

        //cria os bagulho inicial
        for(int i = 0; i < ENTIDADES_INICIAIS ; i++){
            garagem.cadastrarLocomotiva(new Locomotiva(i, PESO_MAXIMO));
            garagem.cadastrarVagao(new Vagao(i, CAPACIDADE_CARGA));
        }

        boolean repeat = true;
        while(repeat){
            printMenu();
            switch (sc.next()){
                case "1":
                    System.out.println("insira uma id para o seu trem: ");
                    int idTrem = sc.nextInt();
                    Trem trem = new Trem(idTrem);
                    garagem.cadastrarTrem(trem);
                    System.out.println(garagem);
                    break;
                case "2":
                    System.out.println("id do trem:");
                    int idTrem3 = sc.nextInt();
                    System.out.println("id locomotiva: ");
                    int idLocomotiva = sc.nextInt();
                    garagem.alocarLocomotiva(garagem.getLocomotiva(idLocomotiva), garagem.getTrem(idTrem3));
                    System.out.println(garagem);
                    break;
                case "3":
                    System.out.println("id do trem:");
                    int idTrem2 = sc.nextInt();
                    System.out.println("id vagao: ");
                    int idVagao = sc.nextInt();
                    garagem.alocarVagao(garagem.getVagao(idVagao), garagem.getTrem(idTrem2));
                    break;
                case "4":
                    System.out.println("id do trem:");
                    int idTrem1 = sc.nextInt();
                    garagem.desacoplarLocomotiva(garagem.getTrem(idTrem1));
                    System.out.println(garagem);
                    break;
                case "5":
                    System.out.println("id do trem:");
                    int idTrem4 = sc.nextInt();
                    garagem.desacoplarVagao(garagem.getTrem(idTrem4));
                    System.out.println(garagem);
                case "0":
                    repeat = false;
            }
        }
    }

    public static void printMenu(){
        System.out.println(" ");
        System.out.println("DIGITE");
        System.out.println("1 para criar trem");
        System.out.println("2 para adicionar locomotiva");
        System.out.println("3 para adicionar vagao");
        System.out.println("4 para remover locomotiva");
        System.out.println("5 para remover vagao");
        System.out.println("0 para sair");
        System.out.print("> ");
    }

}
