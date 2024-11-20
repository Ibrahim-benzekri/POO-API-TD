package service;

import model.Compte;

import java.util.ArrayList;
import java.util.Comparator;

public class BanqueService {
    public ArrayList<Compte> sortBySolde(ArrayList<Compte> comptes) {
        comptes.sort(Comparator.comparingDouble(Compte::getSolde));
        return comptes;
    }
}
