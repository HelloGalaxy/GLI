1. Le mode d'emploi :

cette application produit un jeu de solitaire donc pour jouer il faut juste lancer le Jar ex�cutable :
apr�s le lancement de l'application une interface graphique s'affiche qui contient tous les composants puis l'utilisateur essaie de 
d�placer les cartes qui sont dans les colonnes ou bien il peut d�placer les cartes qui sont dans le sabot afin de vider les deux composants
(Sabot,7colonnes) et mettre toutes las cartes dans la zone qui est � droite � condition que les cartes d�plac�es sont ordonn�e.

2. Le lancement de l'application :

on peut lancer l'application soit avec le fichier jar soit � partir de la classe � SolitaireTest �.
Jar : il faut taper cette commande dans le terminal  ==>     java -nomfichier,jar
SolitaireTest : il faut ex�cuter la classe � TestSolitaire � qui contient la m�thode main qui cr�e l'objet Csolitaire puis elle appelle la m�thode initialiser cette fin
cr�e tous les composants n�cessaires pour jouer le solitaire � Jframe,Sabot,,, �.

3. Ce qui fonctionne bien :

tout fonctionne bien ==>
Colonnes : on a 7 colonnes, une colonne contient 2 tas de carte (cach�es,visibles),
                  les tas de cartes cach�es contiennent de 1 � 7 cartes
Sabot : contient le reste des cartes qui sont cach�es dans le tas de cartes puis avec un seul  click sur le tas de cartes cach�es on peut ins�rer les cartes.
Deplacement des cartes : on peut d�placer les cartes et les tas de cartes en fonction les tas de cartes altern�es.

4. Ce qui ne fonctionne pas :

 drag'n drop est fonctionne bien mais quand on essaye de d�placer les cartes ou bien les tas de cartes il affiche pas les cartes d�plac�es.

5. Une br�ve description de nos choix d'impl�mentation :

_ Cr�er les classes et ses fonctions qu'on a not� dans le cours TD.
_ Cr�er les classes de test pour chaque composant : Sabot, Colonne, TasDeCartes, TasDeCartesAlternees, TasDeCartesColores.
_ Tester la classe Carte pour voir si la carte est affich�e : ==> au d�but on peut pas afficher une carte car il faut cr�er un projet Maven
                                                                                                         puis mettre les imagers des cartes dans le fichier de resoources.
_ Tester ces m�thodes (TasDeCartes, TasDeCartesAlternees, TasDeCartesColores, Sabot, Colonne)  puis r�soudre les probl�mes rencontr�s
    Par exemple: Red�finir la classe usine,Modifier la taille des composants selon le nombre des cartes et ses positions.
_ Tester les fonctions de sabot puis impl�menter le code n�cessaire pour que ces fonctions fonctionnent bien.
_  verifier l'interface graphique de jeu de solitaire pour voir si tous les composants s'affichent bien.
_ Tester et compl�ter les fonctions de drag-and-drop pour le Sabot (TasDeCartesColores, Colonne) ainsi que verifier les changements des 
    carttes(cach�es,visible).
   dans cette �tape on a rencontr� des probl�mes, chaque fois on ajoute ce code 'System.out.println("Drag tas!!!");' pour vois ce qu'il affiche 
    puis on essaye de trouver la solution et on reteste la fonction.
_ ajouter la fonction de signale qui permet de tester si on peut ajouter une carte ou bien in TasDeCarte.