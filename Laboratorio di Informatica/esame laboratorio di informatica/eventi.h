#ifndef eventi_H
#define eventi_H

/**
 * Questa funzione permette di cercare
 * un evento (in base all artista e la data),
 * stampare e modificare i dati di un evento
 */
void Cerca_evento();

/**
 * Questa funzione permette di
 * salvare sul file "Evento.csv" i dati relativi
 * ad un evento:
 * CODICE UNIVOCO, ANNO, MESE, GIORNO,
 * ORARIO DI INIZIO, ORARIO DI FINE,
 * ARTISTA, LOCALE, COSTO PRIMAFILA,
 * COSTO ULTIMA FILA, NUMERO PER FILA
 * E NUMERO FILE
 */
void Aggiungi_evento();

/**
 * Questa funzione permette di cercare
 * un evento in base al nome di un artista
 */
void Ricerca_artista();

/**
 * Questa funzione permette di cercare un
 * evento in base alla data
 *
 */
void Ricerca_data();

/**
 * Questa funzione permette all utente di
 * modificare i dati dell evento:
 * CODICE UNIVOCO, ANNO, MESE, GIORNO,
 * ORARIO DI INIZIO, ORARIO DI FINE,
 * ARTISTA, LOCALE, COSTO PRIMAFILA,
 * COSTO ULTIMA FILA, NUMERO PER FILA
 * E NUMERO FILE
 */
void Modifica_evento();


/**
 * Questa funzione permette all utente
 * di scegliere tra aggiungere, cercare, prenotarsi
 * e vedere l incasso di un evento
 */
void MenuG_E();

/**
 * Questa funzione permette all utente di
 * effettuare la prenotazione ad un determinato evento salvando
 * le informazioni sul file "Prenotazione.csv"
 */
void Prenota_evento();

/**
 * Questa funzione permette di stampare gli incassi
 * totali dell evento
 */
void Stampa_Incassi();

/**
 * Questa funzione permette di stampare gli
 * utenti che si sono prenotati ad un determinato
 * evento
 */
void Stampa_prenotati();

/**
 * Questa enumerazione tiene traccia delle
 * possibili operazioni dell evento
 */
enum OP_EVENTO{AGGIUNGI,CERCA,PRENOTA,INCASSO,ESCI4};

/**
 * Questa enumerazione tiene traccia delle
 * scelte del menu cerca evento
 */
enum CERCA_EVENTO{ARTISTA,DATA,STAMPA_PRENOTATI,MODIFICA1,ESCI5};

/**
 * Questa enumerazione tiene traccia dei parametri
 * dell'evento che possono essere modificati dall utente
 */
enum MODIFICA_EVENTO{ANNO1,MESE1,GIORNO1,OR_INIZIO,OR_FINE,ARTISTA1,LOCALE,C_PRIMAFILA,C_ULTIMAFILA,POSTI_FILA,NUMERO_FILA};

/**
 * Questa struttura contiene i parametri che permettono
 * di registrare un nuovo evento
 */
typedef struct
{
char codiceUnivoco[20];
int anno;
int mese;
int giorno;
int or_Inizio;
int or_Fine;
char artista[20];
char locale[20];
int c_Primafila;
int c_Ultimafila;
int posti_Fila;
int numero_File;
}Evento;

#endif
