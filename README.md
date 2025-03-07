# Quote_API et Chat_App - Application Web

Ce projet est constitué de deux parties :

1. **quote-api** : Une API backend qui gère les citations (et communique avec la base de données).
2. **chat-app** : Une application frontend qui communique avec l'API pour afficher les citations et permettre des interactions.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants sur votre machine :

- [Java 17+](https://adoptopenjdk.net/) (ou version appropriée pour le projet)
- [Maven](https://maven.apache.org/) pour gérer les dépendances (si Maven est utilisé)
- [IDE (comme Eclipse ou IntelliJ)](https://www.jetbrains.com/idea/) pour gérer le code, ou utilisez un terminal pour les commandes.
- Un **serveur local** tel que [WAMP](https://www.wampserver.com/) (pour Windows) ou [XAMPP](https://www.apachefriends.org/) pour gérer une base de données **MySQL**.
<br>

## Instructions pour récupérer et exécuter les projets

### 1. Cloner le dépôt distant

Vous pouvez cloner ce dépôt en utilisant la commande suivante :
```bash
git clone https://github.com/ton-utilisateur/Quote_API.git
```

Ce dépôt contient directement deux dossiers à la racine :

chat-app : Frontend de l'application  
quote-api : API backend

<br>

### 2. Configurer la base de données

Avant de lancer l'API et le frontend, vous devez configurer la base de données MySQL sur votre serveur local (comme WAMP ou XAMPP).
Créer la base de données quotes sur votre serveur MySQL local :

Ouvrez phpMyAdmin (ou tout autre outil pour gérer MySQL) et créez une nouvelle base de données nommée quotes.
Configurer les fichiers application.properties
Chaque projet (backend et frontend) contient un fichier application.properties pour configurer la connexion à la base de données.
Dans le dossier quote-api, ouvrez le fichier src/main/resources/application.properties et configurez la connexion à la base de données comme suit :
```bash
spring.application.name=quote-api

spring.datasource.url=jdbc:mysql://localhost:3306/quotes?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

# JPA & Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.transaction.default-timeout=30
```
Ce fichier configure la connexion à la base de données quotes et permet à Spring Boot de gérer automatiquement les entités avec Hibernate et JPA. La base de données sera automatiquement créée si elle n'existe pas et sera mise à jour selon les entités du projet.
Dans le dossier chat-app, le fichier application.properties doit également être configuré de la même manière, afin que le frontend puisse se connecter à l'API backend.

```bash
spring.application.name=chat-app
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/quotes?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver

# JPA & Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true
spring.transaction.default-timeout=30

# Identifiants admin
spring.security.user.name=${ADMIN_USERNAME}
spring.security.user.password=${ADMIN_PASSWORD}
```
<br>

### 3. Lancer le Backend (quote-api)
Allez dans le dossier quote-api :
```bash
cd quote-api

```
Exécuter l'API : Comme c'est un projet Spring Boot, utilisez la commande suivante pour démarrer l'API :
```bash
./mvnw spring-boot:run
```
L'API sera maintenant disponible sur http://localhost:8080.

<br>

### 4. Lancer le Frontend (chat-app)
Allez dans le dossier chat-app :
```bash
cd chat-app
```
Exécuter le frontend : Comme c'est également un projet Spring Boot, utilisez la commande suivante pour démarrer l'application :
```bash
./mvnw spring-boot:run
```
Le frontend sera maintenant disponible sur http://localhost:8081 (ou un autre port si vous l'avez modifié dans application.properties).

<br>

### 5. Vérification du fonctionnement
Une fois les deux projets démarrés (backend sur http://localhost:8080 et frontend sur http://localhost:8081), ouvrez un navigateur et accédez à l'adresse suivante :
```bash
http://localhost:8081
```
Et vous pourrez interagir avec l'application, qui proposera une fenêtre de connexion et une option pour s'inscrire afin de protéger les conversations
des utilisateurs et éviter qu'une personne qui n'est pas à l'origine d'une conversation puisse y avoir accès, à moins d'être un administrateur.  

En s'inscrivant
et se connectant on obtient par défaut un rôle USER qui permet d'accéder aux pages de connexion et de sa conversation tandis que si on paramètre un administrateur
via les variables d'environnement ou en spécifiant le rôle "ADMIN" en base de données sur un utilisateur dans la colonne role de la table user, on aura alors accès
à la page présente à l'adresse http://localhost:8081/users qui permet de consulter les conversations des utilisateurs et les réponses envoyées par l'API.  

<br>

PS : n'oubliez pas de lancer la commande Maven pour installer les dépendances :
```bash
mvn install
```
dans chacun des deux projets chat-app et quote-api afin d'installer les dépendances relatives à chacun de ces 2 projets.






















