# Voorbeelden colleges

In deze repository staan allerlei voorbeelden die gebruikt worden in colleges.

## Projecten

### Testing

- [Java en Selenium](java-en-selenium).
Dit project is een triviaal voorbeeld waarbij met Jetty een eenvoudige
webapplicatie opgestart kan worden. Het voorbeeld laat zien hoe je met
Selenium de webapplicatie kunt testen.

- [Zoeken naar overlappende elementen](selenium-overlappende-elementen).
Dit is een vervolg op [een eerder project](java-en-selenium). Met een
ChromeDriver kan op de applicatie in worden gezoomd. Als je te ver met
de webapplicatie inzoomt, verdwijnt de 'about us' knop.
Daardoor faalt een test waarbij wordt gezoomd, maar gaat de test waarbij niet
wordt gezoomd wel goed.

- [Dependency Injection](dependency-injection).
Een triviaal voorbeeldje van hoe je Dependency Injection in Java gebruikt.

- [Mocken bij tests](mocking).
Een voorbeeld waarbij een MYSQL database wordt gemockt tijdens tests.
Op die manier hoef je geen verbinding te maken met een database en kan je
toch allerlei tests uitvoeren waarbij het ophalen van een database nodig is.
Stel je voor hoe je dit kunt combineren met Dependency Injection.

### Software Engineering 2

- [De RPG voor overerving](overerving).
Dit project is een eenvoudige implementatie waarmee je middels overerving
de `Player` meer aanvallen te geven, bijvoorbeeld door een `Wizard` te maken.

- [Sockets in C#](sockets).
Dit is een C sharp solution bestaande uit meerdere projecten. `Client` is
een MAUI applicatie die gebruikt kan worden om TCP berichten naar een server
te sturen. `TextServer` is een TCP server die alles wat ie ontvangt terugstuurt
en er `"Hallo, "` voor plakt. Het `KwadraatServer` project geeft het kwadraat
terug van elk getal dat je stuurt. Je draait dus altijd `Client` en daarnaast
nog `TextServer` of `KwadraatServer`. Let wel op dat `Client` specifiek is
gemaakt voor `OS X`.
