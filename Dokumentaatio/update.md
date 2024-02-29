URL: `/api/events/{tapahtuma_id}/`
Metodi: `PUT`


```
{
	"Pvm": "2024-01-01"
	"Sijainti":"Uusi sijainti"
	"Kuvaus":"Uusi kuvaus"
}
```

Vastauksen palautus:
- Onnistunut päivitys:
    - Paluukoodi: 200 OK
    - Palautettava sisältö: Päivitetyn tapahtuman tiedot JSON-muodossa.
- Tunnistamaton tapahtuma_id:
    - Paluukoodi: 404 Not Found
    - Palautettava sisältö: Virheilmoitus, kuten "Tapahtumaa ei löytynyt."
- Virheellinen tai puutteellinen pyyntö:
    - Paluukoodi: 400 Bad Request
    - Palautettava sisältö: Virheilmoitus, joka osoittaa pyynnön virheelliset osat.