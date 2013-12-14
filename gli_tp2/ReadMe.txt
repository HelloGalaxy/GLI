1. Le mode d'emploi :

cette application produit un jeu de solitaire donc pour jouer il faut juste lancer le Jar exécutable :
aprés le lancement de l'application une interface graphique s'affiche qui contient tous les composants puis l'utilisateur essaie de 
déplacer les cartes qui sont dans les colonnes ou bien il peut déplacer les cartes qui sont dans le sabot afin de vider les deux composants
(Sabot,7colonnes) et mettre toutes las cartes dans la zone qui est à droite à condition que les cartes déplacées sont ordonnée.

2. Le lancement de l'application :

on peut lancer l'application soit avec le fichier jar soit à partir de la classe « SolitaireTest ».
Jar : il faut taper cette commande dans le terminal  ==>     java -nomfichier,jar
SolitaireTest : il faut exécuter la classe « TestSolitaire » qui contient la méthode main qui crée l'objet Csolitaire puis elle appelle la méthode initialiser cette fin
crée tous les composants nécessaires pour jouer le solitaire « Jframe,Sabot,,, ».

3. Ce qui fonctionne bien :

tout fonctionne bien ==>
Colonnes : on a 7 colonnes, une colonne contient 2 tas de carte (cachées,visibles),
                  les tas de cartes cachées contiennent de 1 à 7 cartes
Sabot : contient le reste des cartes qui sont cachées dans le tas de cartes puis avec un seul  click sur le tas de cartes cachées on peut insérer les cartes.
Deplacement des cartes : on peut déplacer les cartes et les tas de cartes en fonction les tas de cartes alternées.

4. Ce qui ne fonctionne pas :

 drag'n drop est fonctionne bien mais quand on essaye de déplacer les cartes ou bien les tas de cartes il affiche pas les cartes déplacées.

5. Une brève description de nos choix d'implémentation :

_ Créer les classes et ses fonctions qu'on a noté dans le cours TD.
_ Créer les classes de test pour chaque composant : Sabot, Colonne, TasDeCartes, TasDeCartesAlternees, TasDeCartesColores.
_ Tester la classe Carte pour voir si la carte est affichée : ==> au début on peut pas afficher une carte car il faut créer un projet Maven
                                                                                                         puis mettre les imagers des cartes dans le fichier de resoources.
_ Tester ces méthodes (TasDeCartes, TasDeCartesAlternees, TasDeCartesColores, Sabot, Colonne)  puis résoudre les problémes rencontrés
    Par exemple: Redéfinir la classe usine,Modifier la taille des composants selon le nombre des cartes et ses positions.
_ Tester les fonctions de sabot puis implémenter le code nécessaire pour que ces fonctions fonctionnent bien.
_  verifier l'interface graphique de jeu de solitaire pour voir si tous les composants s'affichent bien.
_ Tester et compléter les fonctions de drag-and-drop pour le Sabot (TasDeCartesColores, Colonne) ainsi que verifier les changements des 
    carttes(cachées,visible).
   dans cette étape on a rencontré des problémes, chaque fois on ajoute ce code 'System.out.println("Drag tas!!!");' pour vois ce qu'il affiche 
    puis on essaye de trouver la solution et on reteste la fonction.
_ ajouter la fonction de signale qui permet de tester si on peut ajouter une carte ou bien in TasDeCarte.