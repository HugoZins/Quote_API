# Projet Full-Stack : API de Citations et Application de Messagerie

## 📝 Table des matières
1. [Présentation du projet](#présentation-du-projet)  
2. [Structure du repo](#structure-du-repo)  
3. [Prérequis](#prérequis)  
4. [Installation et Lancement](#installation-et-lancement)  
5. [Utilisation](#utilisation)  
6. [Dépannage](#dépannage)  
7. [Crédits](#crédits)  

---

## Présentation du projet
Ce projet full-stack se compose de deux applications développées avec **Spring Boot** :  

- **API de Citations** : Fournit des citations aléatoires via une API REST.  
- **Application de Messagerie** : Permet l'envoi et la réception de messages, en s'intégrant à l'API de citations pour enrichir les messages.  

L’objectif est de démontrer l'intégration de deux projets Maven distincts au sein d’un même repo GitHub, tout en respectant les bonnes pratiques de développement.

---

## Structure du repo
```plaintext
fullstack-project
├── quote-api                     # Projet 1 : API de Citations
│   ├── src
│   └── pom.xml
└── chat-app                      # Projet 2 : Application de Messagerie
    ├── src
    └── pom.xml
```
- Chaque projet dispose de son propre fichier `pom.xml`.  
- Le fichier README principal explique le fonctionnement global des deux projets.  

---

## Prérequis
Avant de commencer, assurez-vous d’avoir installé :  
- [Java 17](https://www.oracle.com/java/technologies/downloads/) (ou version compatible avec Spring Boot 3.x)  
- [Maven](https://maven.apache.org/download.cgi)  
- [MySQL](https://dev.mysql.com/downloads/)  
- [Git](https://git-scm.com/downloads)  

---

## Installation et Lancement

### 1. Cloner le repo
```bash
git clone https://github.com/VOTRE-NOM/fullstack-project.git
cd fullstack-project
```

### 2. Configuration de la base de données MySQL
1. Créez une base de données nommée **quotes** pour l'API de citations :  
```sql
CREATE DATABASE quotes CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
2. Configurez le fichier `application.properties` de l'API avec vos identifiants MySQL :  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quotes?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=VOTRE_MOT_DE_PASSE
```
Note : Spring Boot se charge de créer la base de données quotes automatiquement si elle n'existe pas déjà via l'option createDatabaseIfNotExist=true.

### 3. Lancer l’API de Citations
```bash
cd quote-api
mvn clean install
mvn spring-boot:run
```
L’API sera accessible à l’adresse : [http://localhost:8080/api/quotes/getQuote](http://localhost:8080/api/quotes/getQuote).

### 4. Lancer l’Application de Messagerie
Ouvrez un autre terminal :  
```bash
cd ../messaging-app
mvn clean install
mvn spring-boot:run
```
L’application de messagerie sera accessible à l’adresse : [http://localhost:8081](http://localhost:8081).

---

## Utilisation

### API de Citations  
- **Endpoint principal** : `/api/quotes/getQuote`  
- Méthode HTTP : `GET`  
- Réponse :  
```json
{
    "id": 1,
    "text": "La vie, c’est comme une bicyclette, il faut avancer pour ne pas perdre l’équilibre.",
    "author": "Albert Einstein"
}
```

### Application de Messagerie  
- Interface utilisateur pour envoyer et recevoir des messages.  
- Intégration avec l’API de Citations pour afficher une citation aléatoire lors de l'envoi d'un message.  

---

## Dépannage

### Problème : Erreur de connexion MySQL  
- Vérifiez que MySQL est démarré et que la base de données **quotes** existe.  
- Assurez-vous que les identifiants MySQL dans `application.properties` sont corrects.  

### Problème : Port déjà utilisé  
- Modifiez le port dans `application.properties` :  
```properties
server.port=8082
```

---

## Crédits
Projet développé par Hugo Zins dans le cadre de l'évaluation sur le framework Java Spring.  
Merci aux communautés **Spring Boot** et **MySQL** pour leurs ressources et tutoriels.  

---
