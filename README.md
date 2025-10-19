# CRM Bibliotekssystem för Fulköping
Detta system är ett CRM bibliotekssystem utvecklat för Fulköpings bibliotek.
Systemet är utvecklat i Java med Hibernate/MYSql som databas. Systemet låter användaren att skapa en profil och logga in. Innan man har loggat in är det möjligt att leta i "bokhyllan" och söka efter böcker. Efter man har loggat in kan man låna och lämna tillbaka böcker. Man kan även se sin lånehistorik (både aktiva och historik)

Systemet skyddar mot SQLinjection genom Hibernate och lösenord skyddas genom Hashing.

Jag har skapat en profil åt Elsbieta:
- Användarnamn: Elsbieta
- Lösenord: ElsbietaPassword


## Systemkrav
- **Java**: Version 17 eller senare
- **MySQL:** Version 8
- **Bibliotek**: BCrypt för hashing för lösenord

## Installation
1. Klona repository från GitHub:
    - git clone https://github.com/MH-GRIT/fulk-pings-bibliotek-webb-isaclarsen.git
2. Importera FulkopingCRM.sql till din databas som innehåller tabellstruktur och exempeldata.
3. Uppdatera anslutningen i hibernate.cfg.xml i resources mappen så att det fungerar med din databas.
4. Kör programmet
5. Anslut till hemsidan genom "localhost:8080" på valfri webbläsare (porten beror på vilken port du anger i din container)


## Användning
### Startsidan (ej inloggad):
- **Logga in:** Ange användarnamn och lösenord för att logga in
- **Registrera dig:** Ange ett användarnamn och ett lösenord för att skapa din profil
- **Sök böcker:** En sökruta som låter användaren att söka efter böcker från databasen
- **Se "Bokhyllan":** Vill man inte söka efter bok kan användaren trycka in sig till "Bokhyllan" där alla böcker listas i en listvy.
- **Se "böcker i detaljvy":** Från sökresultatet eller bokhyllan kan användaren trycka på titeln för att få en detaljvy av boken med mer information och även se lånestatus. Det går att låna bokk härifrån men som ej-inloggad anvädare nekas man.

### Startsidan (inloggad):
- **All användning som ej-inloggad:** Alla funktioner som man kan göra som ej-inloggad går även att göra som inloggad.
- **Låna bok:**: I detaljvyn av en bok kan man trycka "låna bok". Om lånestatus är "ej tillgänglig" så kan man inte låna.
- **Se aktivt lånehistorik:**: Från "profil" menyn i navbar kan man komma åt sin aktiva lånehistorik i listvy. En "lämna tillbaka" knapp finns här för att lämna tillbaka böcker. Även förväntat återlämningsdatum finns.
- **Se lånehistorik:** Visar tidigare lånade böcker från användaren. Ink. datum
- **Logga ut:** Från "profil" menyn i navbar kan man trycka på "logga ut", användaren loggas då ut.
