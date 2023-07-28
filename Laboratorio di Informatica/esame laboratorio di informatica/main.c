#include <stdio.h>
#include <stdlib.h>
#include "utenti.h"
#include "eventi.h"
#define MAX 100

void Menu();

void Traccia();

/**
 * Questa enumerazione tiene traccia
 * delle scelte nel menu iniziale
 */
enum MENU{GESTIONE_UTENTE,GESTIONE_EVENTO,ESCI};

/**
 * La funzione main() stampa un menu con la possibilita' di scegliere tra
 * GESTIONE UTENTE, GESTIONE EVENTO ed ESCI
 *
 * @return zero.
 */

int main()
{

  enum MENU scelta;

  Traccia();
  do {

        Menu();
        scanf("%d", &scelta);

        switch (scelta) {

        case GESTIONE_UTENTE : MenuR_A();
            break;

        case GESTIONE_EVENTO: MenuG_E();
            break;

    case ESCI:
      printf("\nGrazie per aver usufruito del nostro servizio.\n");
      break;
        }

    } while (scelta!=ESCI);



    return 0;
}

/**
 * Stampa un menu con le possibili scelte iniziali:
 * GESTIONE UTENTE, GESTIONE EVENTO ed ESCI
 */
void Menu()
{
  printf("\n0-GESTIONE UTENTE\n");
  printf("1-GESTIONE EVENTO\n");
  printf("2-ESCI\n");
  printf("Inserisci una scelta: ");
}

/**
 * Stampa le prime righe della traccia del progetto
 * cosi' da rendere chiaro l'utilizzo di questo programma
 */
void Traccia()
{
  printf("**********************************************************************************************************\n\n");
  printf("Questo programma gestiste la vendita di biglietti per eventi musicali in locali o teatri di Bari,\ntenendo traccia dell artista che si esibisce, del locale in cui si tiene l'evento, della fila,\ndel numero e del costo della poltrona prenotata.\n\n");
  printf("**********************************************************************************************************\n\n");

}
