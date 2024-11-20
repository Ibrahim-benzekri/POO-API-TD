package model;

public class Compte {
    @Override
    public String toString() {
        return "Compte{" +
                "numCompte=" + numCompte +
                ", solde=" + solde +
                ", client=" + client.fName + client.lName+
                '}';
    }

    int numCompte;
    float solde;
    Client client;

    public Compte(float solde, int numCompte,Client client) {
        this.solde = solde;
        this.numCompte = numCompte;
        this.client = client;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public float getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public void afficher(){
        System.out.println("Num compte: " + numCompte+ "\n Solde: " + solde + "\n Client: " + client.fName+" "+client.lName);
    }
}
