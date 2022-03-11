# Projet RentManager

## Comment lancer le projet 
- Executer `FillDatabase.java` afin de remplir la BDD (Clients, Resas et véhicules) 
- dans l'invite de commande Executer `mvn tomcat7:run` 
- Dans votre navigateur (OK avec EDGE et Chrome pour sûr) rendez vous [ici](http://localhost:8080/rentmanager) `http://localhost:8080/rentmanager`

## Fonctions de base réalisées
### Affichage
- Home : les 3 counts fonctionnent 
- Client : Create OK, Update OK, Delete OK, Details OK 
- Vehicules : Create OK, Update OK, Delete OK, Details OK 
- Reservatios : Create OK Delete OK (pas details parce que pas d'infos complémentaires à afficher, pas d'update parce qu'une mise a jour d'une resa n'a pas de sens, une nouvelle résa est plus sensée 

### DAO
- toutes les fonctionnalités sont faites 

## Vérifications 
- Nom et prénom +3 caractères (dans le JSP, HTML attribut Minlenght=3 Create et Update) 
- Resa pas plus de 7 jours de suite (JS en bas de la JSP Create et Update reservation) 
- Client de -18 ans ne peut être crée (JS en bas de la JSP Create et Update Client)
- Un vhicle a un Constructeur et entre 3 et 9 places (Required et min=3 max=9 dans le HTML) 
- Une adresse mail ne peut pas être utilisée deux fois (JS en bas de la JSP create client)
