# Copilot + Clean Code démo

# Première Partie: l'Approche naïve

On a créé une application CustomerApplication en adoptant une méthode de bas en haut; c'est-à-dire qu'on est partie des classes de plus bas niveau, les classes les plus techniques (fichiers SQL, repository...) et on est remonté progressivement vers les classes les plus métiers (les services, les controllers...).

L'idée était de contraindre CoPilot le moins possible et de se laisser guider par ses propositions.

## Les points forts du code généré

On a réussi à créer une application CRUD complètement fonctionelle en très peu de temps, comportant:
- une base de données H2 (embarquée)
- une application d'une relative complexitée avec une couche d'abstraction entre la base de données et les services
- des tests unitaires
- un controller exposant une API REST

## Les points faibles du code généré

- le code généré n'utilise pas les meilleures pratiques ou les recommandations de Spring. Par exemple, on utilise encore @Autowired, @Mock et @InjeckMock, alors qu'il est recommandé d'utiliser de l'injection par constructeur
- le end-point GET /customers est dangereux car il retourne tous les clients de la base de données, sans pagination. Le comportement de cette méthode est donc imprévisible et pourrait causer des problèmes de performance, voire agenouiller l'application
- le end-point DELETE /customers/{id} procède à du hard-delete. Pour une vraie application il serait recommandé de procéder à du soft-delete. Ceci entraîne beaucoup de questions d'un point de vue métier
- on a eu malgré tout besoin de guider CoPilot pour lui faire comprendre certaines choses, en particulier la classe de test du controller
- les classes de test manquent de pertinence, testant des choses qui ne devraient pas être testées, n'utilisent pas toutes les possibilités que les librairies inclues dans le pom.xml offrent (AssertJ, Lombok...)

# Deuxième Partie: Utilisation de Clean Code et de l'IA gen en synergie

Développement d'un nouvel end-point

## Création d'une classe de test PurchaseControllerTest

```prompt
in class PurchaseControllerTest

generate one unit test to 
1. verify that PurchaseController invokes PurchaseService to find purchase by id
2. assertThat actualResponse body is equal to expectedPurchase
test method name should be should_invoke_purchase_service_to_find_purchase_by_id

use Mockito to mock method PurchaseService, do not use @Mock or @InjectMock
PurchaseService must be injected in PurchaseController by constructor
purchaseService and purchaseController variables must be final
test class and test method must be of scope package
```

## Création de la classe PurchaseController

Création de la classe PurchaseController en utilisant les suggestions de CoPilot

Amélioration de la classe en utilisant le prompt suivant:

```prompt
generate a class PurchaseController as a @RequestController 
to implement end-point GET /purchases/{id} as tested in PurchaseControllerTest in method should_invoke_purchase_service_to_find_purchase_by_id
use PurchaseService to find purchase by id
Purchase service must be final and injected by constructor
use Lombok to inject PurchaseService in PurchaseController
use @PathVariable to get id from request
use @GetMapping to map the end-point
```

## Création d'un nouvel end-point qui retourne toutes les commandes d'un client

```prompt
generate a new test in PurchaseControllerTest to verify that PurchaseController invokes PurchaseService to find all purchases for a customer
test method name should be should_invoke_purchase_service_to_find_all_customers_for_purchase
```