# Dependency Injection

In dit triviale voorbeeldje is wellicht niet direct
duidelijk dat Dependency Injection voordelen heeft.
Het is enkel om te demonstreren hoe Dependency Injection
werkt.

Er is een klasse `MyDatabaseImplementation` en 
`MyDatabase`. Het idee is dat je altijd
tegen interfaces praat. Ook hier heeft dat voordelen.
Stel, je wilt een alternatieve database implementatie
gebruiken, dan hoef je niet overal in de code waar
de database implementatie gebruikt wordt, een refactor
te doen. Zolang je een alternatieve implmentatie bouwt
die `MyDatabase` implementeert, voorkomt dat grote
refactors.

Een voordeel van Dependency Injection is dat je niet
meer hoeft te bedenken hoe je dependencies moet
instantieren. Dat wordt namelijk voor je gedaan met
dependency injection.