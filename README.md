# uek295_project_Predolac_Ilija

# Dokumentation

## Beschreibung
Der Projektauftrag beinhaltet die Entwicklung eines Teils eines Backends für einen Online-Buchladen. Es gibt einen allgemeinen Teil, bei dem Aspekte wie Sicherheit, Architektur, Dokumentation, Coding Standard und Testing beachtet werden müssen. Darüber hinaus musste jeder einen individuellen Teil entwickeln, der mindestens ein Businessobjekt enthält und bestimmte Anforderungen erfüllt. Ich hatte das Businessobjekt Adresse erhalten und habe das implementiert.
## Vorbereitung

- Postman [Download Link](https://www.postman.com/downloads/)
- Docker [Download Link](https://docs.docker.com/get-docker/)
- Intellij [Download Link](https://www.jetbrains.com/idea/)

Diese drei Programme braucht man um mein Projekt zu benutzen.

## Installation

Um mein Programm laufen zu lassen kann man mein Repository clonen.

```bash
git clone https://github.com/Ilija44/uek295_project_Predolac_Ilija.git
```

Man startet das Programm Docker auf und benutzt diesen Befehl um ein Docker Container zu erstellen und laufen zu lassen.
```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres
```
- Name: uek295db
- POSTGRES_PASSWORD: postgres
- port: 5432

Diese Daten soll man benutzen wenn Docker einen auffordert etwas einzugeben.

Die Swagger Dokumentation kann man unter diesem Link anschauen wenn man alles eingerichtet hat.
http://localhost:8080/swagger-ui/index.html#/
