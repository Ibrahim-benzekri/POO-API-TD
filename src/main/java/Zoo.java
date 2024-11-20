import Exceptions.AnimalDansMauvaisSecteurException;
import Exceptions.LimiteVisiteurException;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int visiteurs;
    private List<Secteur> secteursAnimaux;
    private int nbVisiteurMaxParSecteur;

    public Zoo(int nbVisiteurMaxParSecteur) {
        this.visiteurs = 0;
        this.nbVisiteurMaxParSecteur = nbVisiteurMaxParSecteur;
        this.secteursAnimaux = new ArrayList<>();
    }

    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {
        if (visiteurs + 1 > getLimiteVisiteur()) {
            throw new LimiteVisiteurException("Limite de visiteurs atteinte !");
        }
        visiteurs++;
    }

    public int getLimiteVisiteur() {
        return nbVisiteurMaxParSecteur * secteursAnimaux.size();
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        for (Secteur secteur : secteursAnimaux) {
            if (secteur.obtenirType() == animal.getTypeAnimal()) {
                secteur.ajouterAnimal(animal);
                return;
            }
        }
        throw new AnimalDansMauvaisSecteurException("Aucun secteur pour ce type d'animal !");
    }

    public int nombreAnimaux() {
        return secteursAnimaux.stream().mapToInt(Secteur::getNombreAnimaux).sum();
    }
}
