Feature: Stratégie de placement de pion par l’IA

  Scenario: L'IA place un pion au centre
    Given une grille vide
    When l'IA joue
    Then l'IA place un pion au centre

  Scenario: L'IA bloque une victoire adverse
    Given une grille avec les positions 0 et 1 occupées par le joueur 1
    When l'IA joue
    Then l'IA place un pion en position 2
