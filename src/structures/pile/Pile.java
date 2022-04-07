package structures.pile;

import exceptions.PileException;

public class Pile {
    private NoeudPile sommet;
    private int nbrNoeud;

    /**
     * Construit une pile vide
     */
    public Pile() {
        construirePile();
    }

    private void construirePile() {
        this.sommet = null;
        this.nbrNoeud = 0;
        System.gc();
    }

    /**
     * Vérifie si la pile est vide
     *
     * @return vrai si la pile vide
     */
    public boolean estVide() {
        return sommet == null;
    }

    /**
     * Vide la pile
     */
    public void vider() {
        construirePile();
    }

    /**
     * Empile un objet dans la pile.
     */
    public void empiler(Object pElement) {
        sommet = new NoeudPile(pElement, this.sommet);
        this.nbrNoeud++;
    }

    /**
     * Retourne l'objet dépilé.
     */
    public Object depiler() throws PileException {
        Object retour = null;

        if (!estVide()) {
            retour = sommet.getElement();
            this.sommet = this.sommet.getPrecedent();
            this.nbrNoeud--;
        } else {
            throw new PileException("Pile vide");
        }

        return retour;
    }

    public Object getPremier() throws PileException {
        Object retour = null;

        if (!estVide()) {
            retour = sommet.getElement();
        } else {
            throw new PileException("La pile est vide");
        }

        return retour;
    }

    public String toString() {
        NoeudPile temp = this.sommet;
        // if raccourci
        String s = estVide() ? "vide!\n" : "";

        while (temp != null) {
            s += temp.getElement() + "\n";
            temp = temp.precedent;
        }

        return s;
    }

    /**
     * retourne la taille courante de la pile
     */
    public int getTaille() {
        return this.nbrNoeud;
    }

    /**
     * retourne la capacité de la pile
     */
    public String getCapacite() {
        return Integer.MAX_VALUE + " et plus";

    }
}