package edu.exercicios.petshop;

import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    public final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {

        int option = -1;
        do {
            System.out.println("===Escolha uma opção===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");

            option = sc.nextInt();

            switch(option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> hasPetInMachine();
                case 7 -> setPetInMachine();
                case 8 -> petMachine.removerPet();
                case 9 -> petMachine.wash();
            }
        } while (option != 0);
    }

    public static void setPetInMachine() {
        System.out.println("Informe o nome do pet:");
        var name = sc.next();
        while (name.isEmpty() || name == null) {
            System.out.println("Erro, por favor informe o nome do pet:");
            name = sc.next();
        }
        var pet = new Pet(name);
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina.");
        petMachine.setPet(pet);

    }

    private static void hasPetInMachine() {
        var hasPet = petMachine.hasPet();
        if (hasPet) {
            System.out.println("A máquina está ocupada");
        } else {
            System.out.println("A máquina está vazia");
        }

    }

    private static void verifyWater() {
        var amount = petMachine.getWater();
        System.out.println("A máquina está no momento com " + amount + " litros da água");
    }

    private static void verifyShampoo() {
        var amount = petMachine.getShampoo();
        System.out.println("A máquina está no momento com " + amount + " litros de shampoo");
    }

    private static void setWater() {
        System.out.println("Tentando colocar água na máquina:");
        petMachine.addWater();
    } 
    
    private static void setShampoo() {
        System.out.println("Tentando colocar água na máquina:");
        petMachine.addShampoo();
    }    
}

