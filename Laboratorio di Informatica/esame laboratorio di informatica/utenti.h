#ifndef utenti_H
#define utenti_H

/**
 * Questa funzione permette di salvare sul file "Dati_utente.csv"
 * le informazioni relative all utente:
 * NICKNAME, E-MAIL, ANNO DI NASCITA, MESE DI NASCITA,
 * GIORNO DI NASCITA, GENERE, GENERE MUSICALE E
 * NUMERO CELLULARE
 *
 */
void Aggiungi_utente();

/**
 * Questa funzione permette all utente di scegliere tra
 * R(egistra) e A(ccedi)
 */
void MenuR_A();

/**
 * Questa funzione permette all utente di modificare i
 * dati e di controllare la sua cronologia degli eventi
 */
void Accesso_utente();

/**
 * Questa funzione permette all utente di modificare
 * i suoi dati (senza cambiare il nickname):
 * E-MAIL, ANNO DI NASCITA, MESE DI NASCITA,
 * GIORNO DI NASCITA, GENERE, GENERE MUSICALE E
 * NUMERO CELLULARE
 */
void Modifica_utente();

/**
 * Questa funzione permette di stampare tutti gli eventi
 * a cui ha partecipato un utente, sia in ordine di
 * costo che in ordine di data
 */
void Cronologia_eventi();

/**
 * Questa funzione permette di ordinare gli eventi in base
 * al costo speso dall utente
 */
void Ordine_costo();

/**
 * Questa funzione permette di ordinare gli eventi in
 * ordine cronologico
 */
void Ordine_data();

/**
 * Questo tipo di dato tiene traccia delle
 * possibili operazioni dell utente
 */
enum OP_UTENTE{REGISTRA,ACCEDI,ESCI3};

/**
 * Questo tipo di dato è definito per
 * descrivere gli attributi dei generi musicali
 */
enum GENERE_MUSICALE{BLUES,CLASSICA,HEAVY_METAL,HIP_HOP,JAZZ,POP,PUNK,ROCK,ALTRO};

/**
 * Questo tipo di dato è definito per
 * descrivere gli attributi dell accesso utente
 */
enum ACCESSO{MODIFICA,CRONOLOGIA,ESCI2};

/**
 * Questa enumerazione tiene traccia dei parametri
 * dell utente che possono essere modificati
 */
enum MODIFICA_UTENTE{EMAIL,NOME,COGNOME,ANNO,MESE,GIORNO,GENERE,GENERE_MUSICALE,NUMERO_CELLULARE};

/**
 * Questo tipo di dato è definito per descrivere
 * i generi che può scegliere un utente nella funzione Aggiungi_utente()
 */
enum GENERE{MASCHIO,FEMMINA,ALTRI};

/**
 * Questo tipo di dato è definito per descrivere
 * in che modo possono essere ordinati gli eventi
 * nella funzione Cronologia_eventi()
 */
enum ORDINE{COSTO,DATA1};

/**
 * Questa struttura contiene i parametri che permettono
 * di registrare un nuovo utente
 */
typedef struct
{
  char nickname[15];
  char email[40];
  char nome[15];
  char cognome[15];
  int anno;
  int mese;
  int giorno;
  char genere[10];
  char genere_musicale[12];
  unsigned int n_cellulare;
}Utente;

/**
 * Questa struttura contiene i parametri che permettono
 * all utente di prenotarsi ad un determinato evento
 */
typedef struct
{
    char cod_Univoco[20];
    char Nickname_utente[15];
    int fila_poltrona;
    int numero_poltrona;
    float importo;
}Prenotazione;

#endif
