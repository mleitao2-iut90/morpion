Feature: Coup d’ouverture par l’IA

  Scenario: L'IA place un pion au centre
    Given une grille vide
    When l'IA joue
    Then l'IA place un pion au centre

  Scenario: L'IA place un pion en coin si le centre est occupé
    Given une grille avec le centre occupé par le joueur 1
    When l'IA joue
    Then l'IA place un pion en coin
