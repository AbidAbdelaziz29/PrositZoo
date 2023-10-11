package tn.esprit.gestionzoo.entities;
public class Zoo {

    static final int NUMBER_OF_CAGES = 25;
    private Animal[] animals;
    private String name;
    private String  city;
    private int nbrAnimals;



    public Animal[] getAnimals() {
        return animals;
    }


    public void setFamily(Animal[] animals) {
        this.animals = animals;
    }
    public String getCity() {
        return city;
    }


    public void setFamily(String city) {
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public void setTName(String nouveauName) {
        if (!nouveauName.isBlank()) {
            this.name = nouveauName;
        } else {
            // Vous pouvez gérer l'erreur de différentes manières, par exemple, lever une exception
            throw new IllegalArgumentException("Le nom ne peut pas être vide.");
        }
    }


    public int getNbrAnimals() {
        return nbrAnimals;
    }


    public void setNbrAnimals(int nbrAnimals) {
        this.nbrAnimals = nbrAnimals;
    }
    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[NUMBER_OF_CAGES];
        this.name = name;
        this.city = city;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals > z2.nbrAnimals)
            return z1;
        return z2;
    }

    public void displayZoo() {
        System.out.println("Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals);
    }

    public boolean addAnimal(Animal animal) {
        if (searchAnimal(animal) != -1)
            return false;
        if (isZooFull())
            return false;
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        int indexAnimal = searchAnimal(animal);
        if (indexAnimal == -1)
            return false;
        for (int i = indexAnimal; i < nbrAnimals; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals] = null;
        this.nbrAnimals--;
        return true;
    }

    public void displayAnimals() {
        System.out.println("List of animals of " + name + ":");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        int index = -1;
        for (int i = 0; i < nbrAnimals; i++) {
            if (animal.getName() == animals[i].getName())
                return i;
        }
        return index;
    }

    public boolean isZooFull() {
        return nbrAnimals == NUMBER_OF_CAGES;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", City: " + city + ", N° Cages: " + NUMBER_OF_CAGES + " N° animals: " + nbrAnimals;
    }

    public void DisplayAnimals() {
    }


}