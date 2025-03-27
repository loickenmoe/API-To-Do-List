# API Todo

Cette API permet de gérer des tâches (création, lecture, mise à jour, suppression) avec une base de données PostgreSQL.

## Prérequis

- **Java 17, 21, 22** (ou supérieur)
- **Maven** (pour la gestion des dépendances)
- **PostgreSQL** (installé et configuré localement)

## Installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/loickenmoe/API-To-Do-List
   cd API-To-Do-List

2. **Configurer la base de données PostgreSQL :**    
    -Créez une base de données nommée todo_db :
        CREATE DATABASE todo_db;

    -Vérifiez les identifiants dans application.properties :
        "spring.datasource.username=postgres
        spring.datasource.password=Lucas1998*

## Lancer l'application :
    mvn spring-boot:run
    L'API sera disponible sur http://localhost:9005.

## Utilisation de l'application :
Endpoints

    Méthode	         Endpoint	                   Description
     GET	          /tasks	                    Lister toutes les tâches
     POST	          /tasks/create	                Créer une nouvelle tâche
     DELETE	          /tasks/delete?taskId=1	    Supprimer une tâche par ID
     PUT	          /tasks/update/{taskId}	    Mettre à jour une tâche par ID
     GET	          /tasks/by-status	            Filtrer les tâches par statut

## Lien Swagger :
    http://localhost:9005/swagger-ui/index.html

## Exemples de requêtes :
    -Créer une tâche :
     POST http://localhost:9005/tasks/create
       {
         "title":"exercice",
         "description":"Doing my homework",
         "status":"to do"
       }
     Reponse attendue:
     {
       "message": "Task created successfully",
        "data": {
        "id": 4,
        "title": "exercice",
        "description": "Doing my homework",
        "status": "to do"
        }
      }

     -Lister toutes les tâches :
     GET http://localhost:9005/tasks
       {
         "message": "Task fetch successfully",
         "data": [
                   {
                     "id": 1,
                     "title": "All new Exercice",
                     "description": "A new description",
                     "status": "IN_PROGRESS"
                   },
                   {
                     "id": 3,
                     "title": "exercice",
                     "description": "Doing my homework",
                     "status": "to do"
                   },
                   {
                     "id": 5,
                     "title": "Last homework",
                     "description": "Doing my last homework",
                     "status": "IN_PROGRESS"
                   }
                  ]
       }

      -Supprimer une tâche (ID=4) :
      DELETE http://localhost:9005/tasks/delete?taskId=4
        {
            "message":"Task delete successfully",
            "data":null
        }