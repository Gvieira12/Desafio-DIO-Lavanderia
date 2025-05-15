package edu.exercicios.petshop;

public class PetMachine {
    private int water = 30;

    private int shampoo = 10;
    
    private Pet pet;

    private boolean clean = true;

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("insira o pet na maquina para começar a lavar!");
            return;
        }

        if (water < 10 || shampoo < 2) {
            System.out.println("Recursos insuficientes, abasteça a máquina para continuar com as lavagens!");
            return;
        }
        water -= 10;
        shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo! ");

    }

    public void addWater() {
        if (water == 30) {
            System.out.println(("O limite de agua foi excedido"));
            return;
        }

        water += 2;
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println(("O limite de agua foi excedido"));
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public void setPet (Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja, é preciso limpa-lá para usar.");
            return;
        }

        if (hasPet()) {
            System.out.println("O pet " + pet.getName() + "está na máquina nesse momento.");
            return;
        } 

        this.pet = pet;
    }

    public boolean hasPet() {
        return pet != null;
    }
    
    

    public void removerPet() {
        this.clean = pet.isClean();
        System.out.println("O pet " + pet.getName() + " foi removido da maquina");

        this.pet = null;
    }

    public void wash() {
        this.clean = true;
        water -= 10;
        shampoo -= 2;
        System.out.println("A maquina foi limpa.");
    }
}
