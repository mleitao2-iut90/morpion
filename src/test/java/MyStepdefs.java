import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tictactoe.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {
    private Grille grille;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur ia;

    @Given("une grille vide")
    public void une_grille_vide() {
        grille = new Grille();
        joueur1 = new Human(new Scanner(System.in));
        joueur2 = new IA("X");
        ia = new IA("O");
    }

    @Given("une grille avec les positions {int} et {int} occupées par le joueur {int}")
    public void une_grille_avec_les_positions_occupees_par_le_joueur(int pos1, int pos2, int joueur) throws OccupiedCellException {
        grille = new Grille();
        joueur1 = new Human(new Scanner(System.in));
        joueur2 = new IA("X");
        ia = new IA("O");
        if (joueur == 1) {
            grille.joue(pos1, joueur1);
            grille.joue(pos2, joueur1);
        } else {
            grille.joue(pos1, joueur2);
            grille.joue(pos2, joueur2);
        }
    }

    @Given("une grille avec le centre occupé par le joueur {int}")
    public void une_grille_avec_le_centre_occupe_par_le_joueur(int joueur) throws OccupiedCellException {
        grille = new Grille();
        joueur1 = new Human(new Scanner(System.in));
        joueur2 = new IA("X");
        ia = new IA("O");
        if (joueur == 1) {
            grille.joue(4, joueur1);
        } else {
            grille.joue(4, joueur2);
        }
    }

    @When("le joueur {int} joue en position {int}")
    public void le_joueur_joue_en_position(int joueur, int position) throws OccupiedCellException {
        if (joueur == 1) {
            grille.joue(position, joueur1);
        } else {
            grille.joue(position, joueur2);
        }
    }

    @When("l'IA joue")
    public void l_IA_joue() {
        ia.joue(grille);
    }

    @Then("le joueur {int} gagne")
    public void le_joueur_gagne(int joueur) {
        assertEquals(joueur == 1 ? joueur1 : joueur2, grille.gagnant());
    }

    @Then("l'IA place un pion au centre")
    public void l_IA_place_un_pion_au_centre() {
        assertTrue(grille.casesJoueur(ia).contains(4));
    }

    @Then("l'IA place un pion en position {int}")
    public void l_IA_place_un_pion_en_position(int position) {
        assertTrue(grille.casesJoueur(ia).contains(position));
    }

    @Then("l'IA place un pion en coin")
    public void l_IA_place_un_pion_en_coin() {
        boolean pionEnCoin = false;
        for (int coin : new int[]{0, 2, 6, 8}) {
            if (grille.casesJoueur(ia).contains(coin)) {
                pionEnCoin = true;
                break;
            }
        }
        assertEquals(true, pionEnCoin);
    }
}
