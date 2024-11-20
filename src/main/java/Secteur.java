import Exceptions.AnimalDansMauvaisSecteurException;

import java.util.ArrayList;
import java.util.List;

public class Secteur {
    private TypeAnimal typeAnimauxDansSecteur;
    private List<Animal> animauxDansSecteur;

    public Secteur(TypeAnimal typeAnimauxDansSecteur) {
        this.typeAnimauxDansSecteur = typeAnimauxDansSecteur;
        this.animauxDansSecteur = new ArrayList<>();
    }

    public void ajouterAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        if (animal.getTypeAnimal() != typeAnimauxDansSecteur) {
            throw new AnimalDansMauvaisSecteurException("Animal dans le mauvais secteur !");
        }
        animauxDansSecteur.add(animal);
    }

    public int getNombreAnimaux() {
        return animauxDansSecteur.size();
    }

    public TypeAnimal obtenirType() {
        return typeAnimauxDansSecteur;
    }
}
