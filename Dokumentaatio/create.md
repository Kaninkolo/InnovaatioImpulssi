# Tapahtuman lisääminen

Luo uuden tapahtuman tietokantaan. Tapahtumia voi olla useita.

**Perus-URL** : `/api/events`

**Tietyn tapahtuman URL:** : `/api/events/123`

**Metodi** : `POST`


## Vastaukset

### Onnistunut tapahtuman lisääminen

**Koodi:** : `201 CREATED`

**Esimerkki** 

```json
{
    "tapahtuma_id": 123,
    "pvm": "2024-02-21",
    "sijainti": "Ratapihantie 13 00520 Helsinki",
    "kuvaus": "Opiskelijabileet",
}
```

### Virheilmoitukset


**Koodi** : `400 BAD REQUEST`

**Esimerkki**

```json
{
    "tapahtuma_id": [
        "This field is required."
    ],
    "pvm": [
        "This field is required."
    ],
    "sijainti": [
        "This field is required."
    ],
    "kuvaus": [
        "This field is required."
    ]
}
```