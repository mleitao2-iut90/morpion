Feature: Detection de victoire

  Scenario: Victoire en ligne horizontale
    Given une grille vide
    When le joueur 1 joue en position 0
    And le joueur 2 joue en position 1
    And le joueur 1 joue en position 3
    And le joueur 2 joue en position 4
    And le joueur 1 joue en position 6
    Then le joueur 1 gagne

  Scenario: Victoire en ligne verticale
    Given une grille vide
    When le joueur 1 joue en position 0
    And le joueur 2 joue en position 1
    And le joueur 1 joue en position 3
    And le joueur 2 joue en position 4
    And le joueur 1 joue en position 6
    Then le joueur 1 gagne

  Scenario: Victoire en diagonale
    Given une grille vide
    When le joueur 1 joue en position 0
    And le joueur 2 joue en position 1
    And le joueur 1 joue en position 4
    And le joueur 2 joue en position 2
    And le joueur 1 joue en position 8
    Then le joueur 1 gagne
