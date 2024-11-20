import com.google.gson.Gson;
import model.Client;
import model.Compte;
import service.BanqueService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Compte> comptes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Client client = new Client("lName"+i+1,"fName"+i+1);
            Compte compte = new Compte(rand.nextFloat() * 100000,i+1,client);
            comptes.add(compte);
        }

        System.out.println("Création d'un nouveau compte ");
        System.out.print("Entrez le numéro de compte : ");
        int numeroCompte = scanner.nextInt();
        System.out.print("Entrez le solde : ");
        int solde = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();

        comptes.add(new Compte( solde,numeroCompte, new Client(nom, prenom)));



        // Afficher les comptes avec l'API Stream
        System.out.println("\nListe des comptes (utilisant l'API Stream) :");
        comptes.stream().forEach(System.out::println);


        Gson gson = new Gson();
        String json = gson.toJson(comptes);
        System.out.println("\nListe des comptes en format JSON :");
        System.out.println(json);


        /* affichage normal
        for (Compte compte : comptes) {
            compte.afficher();
        }


        BanqueService banqueService = new BanqueService();
        ArrayList<Compte> comptesTries = banqueService.sortBySolde(comptes);

        System.out.println("\nListe des comptes triés par solde croissant :");
        for (Compte compte : comptesTries) {
            compte.afficher();
        }*/
    }
    }

