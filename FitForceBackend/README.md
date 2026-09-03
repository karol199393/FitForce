# FitForce Backend

Backend REST aplikacji FitForce. Wymaga Java 17 i PostgreSQL.

## Uruchomienie

```powershell
./mvnw spring-boot:run
```

Domyslny adres API: `http://localhost:8080/api/v1`.
Dokumentacja interaktywna: `http://localhost:8080/swagger-ui/index.html`.

Po rejestracji lub logowaniu frontend otrzymuje token JWT. Dla chronionych endpointow
nalezy wysylac naglowek `Authorization: Bearer <token>`.

Najwazniejsze zasoby:

- `/auth` - rejestracja i logowanie
- `/users/me` - profil zalogowanego uzytkownika
- `/exercises` - katalog cwiczen
- `/plans` - plany treningowe
- `/workout-sessions` - treningi, serie i historia
- `/measurements` - pomiary ciala
- `/goals` - cele i ich postep
- `/statistics` - podsumowanie tygodnia

Przed uruchomieniem trzeba ustawic `DB_USERNAME`, `DB_PASSWORD` i `JWT_SECRET`
(sekret JWT powinien miec co najmniej 48 losowych znakow). Opcjonalnie mozna
nadpisac `DB_URL` oraz `CORS_ALLOWED_ORIGINS`.
