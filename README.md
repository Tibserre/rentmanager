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
