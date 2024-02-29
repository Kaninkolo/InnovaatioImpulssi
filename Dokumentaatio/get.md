# Tapahtuman hakeminen

Hakee luodun tapahtuman tietokannasta.

**Perus-URL** : `/api/events`

**Tietyn tapahtuman URL:** : `/api/events/123`

**Metodi** : `GET`

**Oikeuksien tarkistus** :

Käyttäjällä on ainakin joku näistä oikeuksista:

* Omistaja `OO`
* Admin `AA`
* Katselu `VV`


## Vastaukset

### Onnistunut tapahtuman haku

**Koodi:** : `200 OK`

**Esimerkki** 

```json
{
    "tapahtuma_id": 321,
    "pvm": "2024-02-22",
    "sijainti": "Pohjolankatu 10 00610 Helsinki",
    "kuvaus": "Salakapakka bileet",
}
```

### Virheilmoitukset


**Koodi** : `404 NOT FOUND`

**Esimerkki**

```json
{}
```
**Tai**

**Koodi** : `403 FORBIDDEN`

```json
{"Ohjeistus": "Sinulla ei ole oikeuksia tähän tietoon"}
```