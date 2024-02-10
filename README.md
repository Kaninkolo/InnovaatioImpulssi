# InnovaatioImpulssi
Tiimi Innovaatioimpulssi: Jetro Eräkangas, Niilo Virtamo, Emilia Friman, Jasmin Huttunen

# TicketGuru

## Johdanto

- TicketGuru lipunmyyntijärjestelmän kehitys, jonka tarkoituksena on palvella lipputoimiston tarpeita lippujen myynnissä.

- Järjestelmän tarkoitus: 
	- Päätavoitteena on helpottaa lipunmyyntiä ja tapahtumien hallintaa. Järjestelmä tulee mahdollistamaan lippujen myynnin myyntipisteessä. Järjestelmää tarkoitus laajentaa myöhemmin verkkokauppa toimintaan, mikä palvelee asiakkaita, jotka haluavat ostaa lippuja etänä.
	- Järjestelmän avulla lipputoimisto voi hallinnoida tapahtumia ja lipunmyyjät myydä lippuja myyntipisteissä.

- Toteutus:
	- Järjestelmä tehdään hyödyntäen Java Spring Bootia.

- Valmis työ:
	- Projektin päättyessä odotamme TicketGuru-järjestelmän olevan täydessä toiminnassa, mahdollistaen sujuvan lipunmyynnin ja tapahtumien hallinnan. 

## Järjestelmän määrittely

TicketGurulla on kolme eri käyttäjäryhmää: asiakas, lipunmyyjä ja lipputoimisto. 
- Asiakkaat ovat tapahtumiin osallistuvia henkilöitä, jotka ostavat lippuja
- Lipunmyyjät ovat palkattua henkilöstöä, jotka vastaavat lippujen myynnistä asiakkaalle
- Lipputoimisto on liiketoimintaa harjoittava taho, joka myy tapahtumiin lippuja

Alla on esitettynä käyttötapauskaaviona jokaisen
käyttäjäryhmän tärkeimmät toiminnot:

![alt text](https://github.com/JetiTheS/InnovaatioImpulssiLippu/blob/master/ticketguruusecase.png?raw=true "TicketGuru use case diagram")

- Lipputoimisto lisää järjestelmäänsä tapahtumia, joihin myydään lippuja lipunmyyjän kautta.   
- Lipunmyyjä toimii asiakaspalveluhenkilönä sekä vastaa lippujen tulostuksesta ja myynnistä asiakkaalle.   
- Asiakas osallistuu tapahtumiin ostamalla lipun lipunmyyjältä. Tulevaisuudessa asiakkaan tulisi voida ostaa 
lippuja itse verkkokaupan kautta.

Käyttäjätarinoita:
- "Asiakas haluaa ostaa liput tapahtumiin helposti ja mukavasti"
- "Asiakas haluaa mahdollisuuden hankkia liput tapahtumiin omalta älylaitteelta kotisohvalta välttääkseen jonottamisen"
- "Lipunmyyjä haluaa lipunmyyntijärjestelmään parannuksia lippupisteen ruuhkien helpottamiseksi"
- "Lipputoimisto haluaa helpottaa lippujen ostoa parantaakseen asiakaskokemusta"
- "Lipputoimisto haluaa parantaa lippujen myynnin järjestelmää saavuttaakseen paremmat myyntiluvut"



## Käyttöliittymä

1. Etusivu
	- Ensimmäinen sivu jonka käyttäjä näkee
	- Siirtymät: 
		- Tapahtumat listaussivu
		- Kirjautuminen / Rekisteröinti 
		- Sovelluksen tiedot
		
2. Tapahtuma listaukset
	- Näyttää kaikki saatavilla olevat tapahtumat 
	- Siirtymät: 
		- Etusivulle
		- Tapahtumien yksityiskohtiin ja lippujen lisääminen ostoskoriin
		- Ostoskori 

3. Tapahtumien yksityiskohdat
	- Näyttää valitun tapahtuman yksityiskohdat ja lippujen lisäämien ostoskoriin
	- Siirtymät: 
		- Takaisin etusivulle ja Tapahtumien listaukseen
		- Ostoskori

4. Kirjautuminen / Rekisteröinti 
	- Kirjautuminen olemassa olevalle tilille tai tilin luominen
	- Siirtymät: 
		- Etusivu
		- Tapahtumalistaan

5. Ostoskori ja maksaminen
	- Näyttää ostoskoriin lisätyt liput ja lippujen hinnat sekä yhteissumman lipuille. Lippujen maksaminen.
	- Siirtymät: 
		- Takaisin tapahtumalistaan
		- Maksun jälkeeinen vahvistus

6. Maksuvahvistus
	- Näyttää yhteenvedon ostostapahtumasta 
	- Siirtymät: 
		- Takaisin etusivulle

7. Sovelluksen tiedot
	- Tiedot sovelluksesta, yhteystiedot ja maksuväline mahdollisuudet 
	- Siirtymät: 
		- Etusivu 

## Tietokanta

### Relaatiokaavio

![alt text](https://raw.githubusercontent.com/Kaninkolo/InnovaatioImpulssi/development/ticketguru_uml.png "TicketGuru UML")

### Tietohakemistokuvaukset

> ### Tapahtuma
> Tapahtuma-taulu sisältää tapahtumatiedot. Lipputyypillä on yksi siihen tapahtuma, tapahtumalla voi olla monta lipputyyppiä.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtuma_id | int PK | Tapahtuman id
> pvm | datetime |  Tapahtuman päivämäärä
> sijainti | varchar(40) | Tapahtuman osoitetiedot
> kuvaus | varchar(150) | Tapahtuman kuvaus
>
> ### Lipputyyppi
> Lipputyyppi-taulu sisältää tapahtuma- ja hintaryhmäkohtaiset hintatiedot. Lipputyyppi liittyy vain yhteen tapahtumaan ja lippuun kerrallaan.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tyyppi_id | int PK | Lipputyypin id
> tapahtuma_id | int FK |  Tapahtuman id, johon kyseinen lipputyyppi liittyy
> hinta | integer | Lipputyypin tapahtuma- ja hintaryhmäkohtainen hinta
> kuvaus | char(30) | Lipputyypin kuvaus
>
> ### Lippu
> Lippu-taulu sisältää lipun tunnistetiedot. Lippu liittyy vain yhteen lipputyyppiin ja ostotapahtumaan kerrallaan.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | int PK | Lipun id
> tilausnumero | int FK |  Ostotapahtuman id, johon kyseinen lippu liittyy
> tyyppi_id | int FK | Lipputyypin id, johon kyseinen lippu liittyy
>
> ### OstoTapahtuma
> Ostotapahtuma-taulu sisältää ostotapahtuman tunnistetiedot. Ostotapahtuma voi sisältää monta lippua, mutta vain yhden myyjän.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tilausnumero | int PK | Ostotapahtuman id
> myyjä | int FK |  Myyjän id, joka myi lipun
> myynti_pvm | datetime | Ostotapahtuman päivämäärä
>
> ### Myyjä
> Myyjä-taulu sisältää myyjän tiedot. Myyjään voi liittyä monta ostotapahtumaa.
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> myyjä_id | int PK | Myyjän id
> nimi | char(30) |  Myyjän nimi


## Tekninen kuvaus

Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset
ratkaisut, esim.

-   Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma)
    ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin:
    https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)
-   Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms.
-   Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää
    UML-sekvenssikaavioilla.
-   Toteutuksen yleisiä ratkaisuja, esim. turvallisuus.

Tämän lisäksi

-   ohjelmakoodin tulee olla kommentoitua
-   luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa
    johdonmukaisia nimeämiskäytäntöjä
-   ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta
    vältytään

## Testaus

Tässä kohdin selvitetään, miten ohjelmiston oikea toiminta varmistetaan
testaamalla projektin aikana: millaisia testauksia tehdään ja missä vaiheessa.
Testauksen tarkemmat sisällöt ja testisuoritusten tulosten raportit kirjataan
erillisiin dokumentteihin.

Tänne kirjataan myös lopuksi järjestelmän tunnetut ongelmat, joita ei ole korjattu.

## Asennustiedot

Järjestelmän asennus on syytä dokumentoida kahdesta näkökulmasta:

-   järjestelmän kehitysympäristö: miten järjestelmän kehitysympäristön saisi
    rakennettua johonkin toiseen koneeseen

-   järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi
    asennettua johonkin uuteen ympäristöön.

Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja
käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta,
käyttäjätunnus, salasana, tietokannan luonti yms.).

## Käynnistys- ja käyttöohje

Tyypillisesti tässä riittää kertoa ohjelman käynnistykseen tarvittava URL sekä
mahdolliset kirjautumiseen tarvittavat tunnukset. Jos järjestelmän
käynnistämiseen tai käyttöön liittyy joitain muita toimenpiteitä tai toimintajärjestykseen liittyviä asioita, nekin kerrotaan tässä yhteydessä.

Usko tai älä, tulet tarvitsemaan tätä itsekin, kun tauon jälkeen palaat
järjestelmän pariin !
