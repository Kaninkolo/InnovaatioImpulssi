URL: `/api/events/{event_id}`

Metodi: `DELETE`

Oikeudet: Vaatii tilin omistajaa tai adminia poistaakseen

## Onnistuneet pyynnöt 

Jos käyttäjä on olemassa voidaan se poistaa jos käyttäjällä on tarvittavat oikeudet poistamaan käyttäjä 

Koodi: `204 NO CONTENT`

Sisältö: `[]`

## Virheilmoitukset

Jos tiliä ei ole olemassa:

Koodi: `404 NOT FOUND`

Sisältö: `[]`

Jos ei ole oikeuksia poistaa tiliä:

Koodi: `403 FORBIDDEN`

Sisältö: `[]`
