package application;

import entities.Garagem;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    private static final double PESO_MAXIMO  = 5;
    private static final int ENTIDADES_INICIAIS = 15;
    private static final int CAPACIDADE_CARGA = 6;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        Garagem garagem = new Garagem();

        for(int i = 1; i <= ENTIDADES_INICIAIS ; i++){
            garagem.cadastrarLocomotiva(i, PESO_MAXIMO);
            garagem.cadastrarVagao(i, CAPACIDADE_CARGA);
        }

        boolean repeat = true;
        while(repeat){
            printMenu();
            switch (sc.next()) {
                case "1" -> {
                    try {
                        System.out.println("Insira um ID (int) para o trem:");
                        int idTrem = sc.nextInt();

                        garagem.cadastrarTrem(idTrem);
                        System.out.println(garagem);
                    } catch (InvalidParameterException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "2" -> {
                    try {
                        System.out.println("Insira o ID do trem:");
                        int idTrem = sc.nextInt();

                        System.out.println("Insira o ID da locomotiva");
                        int idLocomotiva = sc.nextInt();

                        garagem.alocarLocomotiva(garagem.getLocomotiva(idLocomotiva), garagem.getTrem(idTrem));
                        System.out.println(garagem);
                    } catch (InvalidParameterException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "3" -> {
                    try {
                        System.out.println("Insira o ID do trem:");
                        int idTrem = sc.nextInt();

                        System.out.println("Insira o ID do vagao:");
                        int idVagao = sc.nextInt();

                        garagem.alocarVagao(garagem.getVagao(idVagao), garagem.getTrem(idTrem));
                        System.out.println(garagem);
                    } catch (InvalidParameterException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "4" -> {
                    try {
                        System.out.println("Insira o ID do trem:");
                        int idTrem = sc.nextInt();

                        garagem.desacoplarLocomotiva(garagem.getTrem(idTrem));
                        System.out.println(garagem);
                    } catch (InvalidParameterException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "5" -> {
                    try {
                        System.out.println("Insira o ID do trem:");
                        int idTrem = sc.nextInt();

                        garagem.desacoplarVagao(garagem.getTrem(idTrem));
                        System.out.println(garagem);
                    } catch (InvalidParameterException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "6" -> {
                    System.out.println(garagem);
                }
                case "7" -> {
                    try {
                        System.out.println("Insira o ID do trem:");
                        int idTrem = sc.nextInt();

                        garagem.desfazerTrem(garagem.getTrem(idTrem));
                        System.out.println(garagem);
                    } catch (InvalidParameterException e){
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e){
                        System.out.println("Input invalido");
                        sc.nextLine();
                    }
                }
                case "8" -> {
                    try {
                        System.out.println("Insira o tipo da unidade ('L'/'V') + ID (int): (eg: 'L1', 'V2')");
                        String input = sc.next().toUpperCase();
                        if(input.startsWith("L")){
                            String idChar = input.replace("L", "");
                            int id = Integer.parseInt(idChar);

                            System.out.println("Unidade alocada ao: T" + garagem.inspecionarLocomotiva(id));
                        } else if(input.startsWith("V")){
                            String idChar = input.replace("V", "");
                            int id = Integer.parseInt(idChar);

                            System.out.println("Unidade alocada ao: T" + garagem.inspecionarVagao(id));
                        } else {
                            System.out.println("O ID inserido nao e valido");
                        }
                    } catch (InvalidParameterException e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("O ID inserido nao e invalido");
                        sc.nextLine();
                    }
                }
                default -> {
                    System.out.println("Input invalido");
                }
                case "0" -> repeat = false;
            }
        }
        sc.close();
        System.out.println("#terminated");
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("DIGITE");
        System.out.println("1 para criar trem");
        System.out.println("2 para adicionar locomotiva");
        System.out.println("3 para adicionar vagao");
        System.out.println("4 para remover locomotiva");
        System.out.println("5 para remover vagao");
        System.out.println("6 para visualizar as garagens");
        System.out.println("7 para desmembrar um trem");
        System.out.println("8 para inspecionar unidade");
        System.out.println("0 para sair");
        System.out.print("> ");
    }
}
