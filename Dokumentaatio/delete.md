URL: `/api/events/{event_id}`

Metodi: `DELETE`

Oikeudet: Vaatii adminia poistaakseen

## Onnistuneet pyynnöt 

Jos tapahtuma on olemassa voidaan se poistaa jos käyttäjällä on tarvittavat oikeudet poistamaan tapahtuma 

Koodi: `204 NO CONTENT`

Sisältö: `[]`

## Virheilmoitukset

Jos tapahtumaa ei ole olemassa:

Koodi: `404 NOT FOUND`

Sisältö: `[]`

Jos ei ole oikeuksia poistaa tapahtumaa:

Koodi: `403 FORBIDDEN`

Sisältö: `[]`
