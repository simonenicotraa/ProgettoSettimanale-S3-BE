# ProgettoSettimanale-S3-BE
Creare le classi necessarie a gestire un catalogo bibliotecario. Il catalogo è formato da elementi che possono essere Libri o Riviste. Di seguito attributi delle classi. <br>
class Abstract Catalog :
- Codice ISBN (codice univoco)
- Titolo
- Anno pubblicazione
- Numero pagine


class Book extends Catalog:
- Autore
- Genere

class Magazine Catalog:
- Periodicità [SETTIMANALE, MENSILE, SEMESTRALE]

Creare inoltre le classi necessarie alla gestione del prestito:

L'utente è caratterizzato dai seguenti attributi:<br>
class User:
- Nome
- Cognome
- Data di nascita
- Numero di tessera

Il prestito è caratterizzato da:<br>
class Lending:
- Utente 
- Elemento prestato (può essere un libro o una rivista)
- Data inizio prestito
- Data restituzione prevista (calcolata automaticamente a 30 gg dalla data inizio prestito)
- Data restituzione effettiva


L'archivio deve permettere le seguenti operazioni:<br>
ArchiveService:
- Aggiunta di un elemento del catalogo
- Rimozione di un elemento del catalogo dato un codice ISBN
- Ricerca per ISBN
- Ricerca per anno pubblicazione
- Ricerca per autore
- Ricerca per titolo o parte di esso
- Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
- Ricerca di tutti i prestiti scaduti e non ancora restituiti
