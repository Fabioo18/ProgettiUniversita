#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "eventi.h"
#include "utenti.h"
#define MAX 100

void MenuG_E()
{
    enum OP_EVENTO scelta_ev;
    do
    {
        printf("\n0-AGGIUNGI EVENTO");
        printf("\n1-CERCA EVENTO");
        printf("\n2-PRENOTA");
        printf("\n3-INCASSO");
        printf("\n4-ESCI\n");
        printf("Inserisci una scelta: ");
        scanf("%d", &scelta_ev);

		switch (scelta_ev)
		{
            case AGGIUNGI:
                    Aggiungi_evento();
                    break;
            case CERCA:
                    Cerca_evento();
                    break;
            case PRENOTA:
                    Prenota_evento();
                    break;
            case INCASSO:
                    Stampa_Incassi();
                    break;
		}

	} while (scelta_ev != ESCI4);

}

void Aggiungi_evento()
{
Evento evento[MAX];
FILE* ptr_evento;
int a;
int e;


if ((ptr_evento = fopen ("Evento.csv", "a+")) == NULL)
{
    printf ("\nImpossibile aprire in lettura il file.\n");
}
  else
    {
        do{
            for(int i=0;i<1;i++)
            {
                  ptr_evento=fopen("Evento.csv","r+");
                  Evento temp[MAX];
                  char linea[200];
                  int cont=0;
                   while((cont<MAX)&&(!feof(ptr_evento)))
                  {
                      fscanf(ptr_evento,"%s",linea);
                      strcpy(temp[cont].codiceUnivoco,strtok(linea, ";"));
                     cont++;
                  }
                do
                {
                  printf("\n%s","Inserisci il codice univoco dell'evento:");
                  scanf("%s",evento[i].codiceUnivoco);
                  for(int k=0;k<MAX;k++)
                  {
                      e=strcmp(evento[i].codiceUnivoco,temp[k].codiceUnivoco);
                      if(e==0)
                      {
                        printf("\nCODICE UNIVOCO ESISTENTE\n");
                        puts("\nInserisci il codice univoco: ");
                        scanf("%s",evento[i].codiceUnivoco);
                        e=1;
                        k=0;

                      }
                  }
                }while(e==0);

                do
                {
                  printf("\n%s","Inserisci un anno:");
                  scanf("%d",&evento[i].anno);
                }while(evento[i].anno<2021);
                  do
                  {
                  printf("\n%s","Inserisci un mese:");
                  scanf("%d",&evento[i].mese);
                  }while(evento[i].mese<1 || evento[i].mese>12);
                   do
                  {
                    printf("\n%s","Inserisci un giorno: ");
                    scanf("%d",&evento[i].giorno);
                  } while(evento[i].giorno<1 || evento[i].giorno>31);
                    if(evento[i].mese==2)
                    {
                        if((evento[i].anno%4)== 0)
                        {
                            if(evento[i].giorno < 0 || evento[i].giorno > 29)
                            {
                                do
                                {
                                    printf("\nGiorno inesistente\n");
                                    scanf("%d", &evento[i].giorno);
                                }while(evento[i].giorno > 29);
                            }
                        }else
                         {
                                while(evento[i].giorno>28)
                                {
                                printf("\nGiorno inesistente\n");
                                scanf("%d", &evento[i].giorno);
                                }
                         }
                    }


                    if(evento[i].mese==4 || evento[i].mese==6 || evento[i].mese==9 || evento[i].mese==11)
                    {
                        if(evento[i].giorno < 0 || evento[i].giorno >30)
                        {
                            do
                            {
                                printf("\nGiorno inesistente\n");
                                scanf("%d", &evento[i].giorno);
                            }while(evento[i].giorno > 30);
                        }
                    }
                  do
                  {
                    printf("\n%s","Inserisci un orario di inizio:");
                    scanf("%d",&evento[i].or_Inizio);
                  }while(evento[i].or_Inizio<0 || evento[i].or_Inizio>24);
                  do
                  {
                    printf("\n%s","Inserisci un orario di fine:");
                    scanf("%d",&evento[i].or_Fine);
                  }while(evento[i].or_Fine<0 || evento[i].or_Fine>24);
                  printf("\n%s","Inserisci un artista: ");
                  scanf("%s",evento[i].artista);
                  printf("\n%s","Inserisci un locale: ");
                  scanf("%s",evento[i].locale);
                   printf("\n%s","Inserisci il costo prima fila: ");
                  scanf("%d",&evento[i].c_Primafila);
                   printf("\n%s","Inserisci il costo ultima fila: ");
                  scanf("%d",&evento[i].c_Ultimafila);
                  printf("\n%s","Inserisci i posti per fila: ");
                  scanf("%d",&evento[i].posti_Fila);
                  printf("\nInserisci il numero di file: ");
                  scanf("%d",&evento[i].numero_File);
                  printf("\nVuoi registrare nuovi eventi?\n1-SI\n0-NO\n");
                  printf("Inserisci una scelta: ");
                  scanf("%d",&a);
                  fprintf(ptr_evento,"%s;%d;%d;%d;%d;%d;%s;%s;%d;%d;%d;%d;\n",evento[i].codiceUnivoco,evento[i].anno,evento[i].mese,evento[i].giorno,evento[i].or_Inizio,evento[i].or_Fine,evento[i].artista,evento[i].locale,evento[i].c_Primafila,evento[i].c_Ultimafila,evento[i].posti_Fila,evento[i].numero_File);
                  fclose(ptr_evento);
            }
    }while(a!=0);
    fclose(ptr_evento);
  }
}

void Cerca_evento()
{
  int scelta_ric_ev;
  enum CERCA_EVENTO ricerca_evento;

    do
    {
        printf("\n0-RICERCA PER ARTISTA\n1-RICERCA PER DATA\n2-STAMPA PRENOTATI EVENTO\n3-MODIFICA EVENTO\n4-ESCI\n");
        printf("Inserisci una scelta: ");
        scanf("%d", &scelta_ric_ev);

        switch(scelta_ric_ev)
        {
            case ARTISTA:
                    Ricerca_artista();
                    break;
            case DATA:
                    Ricerca_data();
                    break;
            case STAMPA_PRENOTATI:
                    Stampa_prenotati();
                    break;
            case MODIFICA1:
                    Modifica_evento();
                    break;
        }
    }while(scelta_ric_ev!=ESCI5);
}

void Ricerca_artista()
{
  char c_e[20]; /*Chiave di ricerca per gli eventi*/
  Evento tmp[MAX];
  char linea[200];
  int conta=0;
  int e;
  int sent=0;
  FILE* cerca_art;

  if ((cerca_art = fopen ("Evento.csv", "r+")) == NULL)
  {
      printf("\nImpossibile aprire il file");
  } else
    {
        while(fgets(linea, sizeof(linea),cerca_art))
        {
            strcpy(tmp[conta].codiceUnivoco, strtok(linea, ";"));//per le stringhe
            tmp[conta].anno=atoi(strtok(NULL, ";"));//per gli interi
            tmp[conta].mese=atoi(strtok(NULL, ";"));
            tmp[conta].giorno=atoi(strtok(NULL, ";"));
            tmp[conta].or_Inizio=atoi(strtok(NULL, ";"));
            tmp[conta].or_Fine=atoi(strtok(NULL, ";"));
            strcpy(tmp[conta].artista, strtok(NULL, ";"));
            strcpy(tmp[conta].locale, strtok(NULL, ";"));
            tmp[conta].c_Primafila=atoi(strtok(NULL, ";"));
            tmp[conta].c_Ultimafila=atoi(strtok(NULL, ";"));
            tmp[conta].posti_Fila=atoi(strtok(NULL, ";"));
            tmp[conta].numero_File=atoi(strtok(NULL, ";"));
            conta++;
        }

         printf("\nInserisci evento(per artista) da ricercare: ");
         scanf("%s", c_e);
            for(int i=0;i<MAX;i++)
            {
                e=strcmp(c_e, tmp[i].artista);
                if(e==0)
                {
                    printf("\n\nEvento(per artista) trovato\n");
                    printf("\nCodice univoco evento: %s",tmp[i].codiceUnivoco);
                    printf("\nAnno: %d",tmp[i].anno);
                    printf("\nMese: %d",tmp[i].mese);
                    printf("\nGiorno: %d",tmp[i].giorno);
                    printf("\nOrario di inizio: %d",tmp[i].or_Inizio);
                    printf("\nOrario di fine: %d",tmp[i].or_Fine);
                    printf("\nArtista: %s",tmp[i].artista);
                    printf("\nLocale: %s",tmp[i].locale);
                    printf("\nCosto prima fila: %d",tmp[i].c_Primafila);
                    printf("\nCosto ultima fila: %d",tmp[i].c_Ultimafila);
                    printf("\nNumero posti per fila: %d",tmp[i].posti_Fila);
                    printf("\nNumero file: %d\n",tmp[i].numero_File);

                     sent=1;

                }

            }
            if(sent==0)
            {
            printf("\nEvento(per artista) non trovato\n");
            }

    }fclose(cerca_art);



}

void Prenota_evento()
{
    char c_nickname[20];
    int f=0;
    int i=0;
    int sent=0;
    FILE* prenota_ut;
    FILE* prenota_ev;
    FILE* prenota2;
    int numero_Poltrona;
    int numero_Fila;

    if((prenota_ut=fopen("Dati_utente.csv","r+"))==NULL)
    {
        printf("\nImpossibile aprire il file");
    } else
        {
                for(i=0;i<1;i++)
                {
                    Utente tmp[MAX];
                    char linea[200];
                    int cont=0;
                    char c_univoco[20];
                    while(fgets(linea,sizeof(linea),prenota_ut))
                    {
                        strcpy(tmp[cont].nickname,strtok(linea,";"));
                        cont++;
                    }

                    printf("\nInserisci il nickname dell' utente per vedere se e' presente in lista: ");
                    scanf("%s",c_nickname);
                    for(int k=0;k<MAX;k++)
                    {
                        f=strcmp(c_nickname,tmp[k].nickname);
                        if(f==0)
                        {
                            printf("\nUtente trovato\n");
                            fclose(prenota_ut);
                            sent=1;

                            Evento temp[MAX];

                            if((prenota_ev=fopen("Evento.csv","r"))==NULL)
                            {
                                printf("\nImpossibile aprire il file");
                            } else
                                {
                                    cont=0;
                                    while(fgets(linea,sizeof(linea),prenota_ev))
                                    {
                                        strcpy(temp[cont].codiceUnivoco,strtok(linea,";"));
                                        temp[cont].anno=atoi(strtok(NULL, ";"));
                                        temp[cont].mese=atoi(strtok(NULL, ";"));
                                        temp[cont].giorno=atoi(strtok(NULL, ";"));
                                        temp[cont].or_Inizio=atoi(strtok(NULL, ";"));
                                        temp[cont].or_Fine=atoi(strtok(NULL, ";"));
                                        strcpy(temp[cont].artista, strtok(NULL, ";"));
                                        strcpy(temp[cont].locale, strtok(NULL, ";"));
                                        temp[cont].c_Primafila=atoi(strtok(NULL, ";"));
                                        temp[cont].c_Ultimafila=atoi(strtok(NULL, ";"));
                                        temp[cont].posti_Fila=atoi(strtok(NULL, ";"));
                                        temp[cont].numero_File=atoi(strtok(NULL, ";"));
                                        cont++;
                                    }
                                    int sent1=0;
                                    int sent2=0;
                                    int f1=0;
                                    do
                                    {
                                        printf("\nInserisci il codice univoco dell'evento a cui vuoi prenotarti: ");
                                        scanf("%s",c_univoco);
                                        for(int k=0;k<cont;k++)
                                        {
                                            f1=strcmp(temp[k].codiceUnivoco,c_univoco);
                                            if(f1==0)
                                            {
                                                printf("\nEvento trovato\n");
                                                sent1=1;

                                                do
                                                {
                                                    sent2=0;
                                                    printf("\nInserisci il numero di fila che desideri prenotare: ");
                                                    scanf("%d",&numero_Fila);
                                                    if((numero_Fila>temp[k].numero_File) || (numero_Fila<=0))
                                                    {
                                                        do
                                                        {
                                                            printf("\nFila non accettata\n");
                                                            printf("\nInserisci il numero di fila che desideri prenotare: ");
                                                            scanf("%d",&numero_Fila);
                                                        } while((numero_Fila>temp[k].numero_File) || (numero_Fila<=0));
                                                    }

                                                    printf("\nInserisci il numero di poltrona che desideri prenotare: ");
                                                    scanf("%d",&numero_Poltrona);
                                                    if((numero_Poltrona>temp[k].posti_Fila) || (numero_Poltrona<=0))
                                                    {
                                                        do
                                                        {
                                                            printf("\nPosto non accettato\n");
                                                            printf("\nInserisci il numero di poltrona che desideri prenotare: ");
                                                            scanf("%d",&numero_Poltrona);
                                                        }while((numero_Poltrona>temp[k].posti_Fila) || (numero_Poltrona<=0));
                                                    }
                                                    Prenotazione prenota[MAX];

                                                    if((prenota2=fopen("Prenotazione.csv","r+"))==NULL)
                                                    {
                                                        printf("\nImpossibile aprire il file in lettura");
                                                    } else
                                                       {
                                                            int cont2=0;
                                                            int f2;
                                                            char linea1[100];

                                                            while(fgets(linea1,sizeof(linea1),prenota2))
                                                                {
                                                                    strcpy(prenota[cont2].cod_Univoco,strtok(linea1,";"));
                                                                    strcpy(prenota[cont2].Nickname_utente,strtok(NULL,";"));
                                                                    prenota[cont2].fila_poltrona=atoi(strtok(NULL, ";"));
                                                                    prenota[cont2].numero_poltrona=atoi(strtok(NULL, ";"));
                                                                    prenota[cont2].importo=atof(strtok(NULL, ";"));
                                                                    cont2++;
                                                                }

                                                                for(int k=0;k<cont2;k++)
                                                                {
                                                                    f2=strcmp(c_univoco,prenota[k].cod_Univoco);
                                                                    if(f2==0)
                                                                    {
                                                                        if((prenota[k].fila_poltrona==numero_Fila) && (prenota[k].numero_poltrona==numero_Poltrona))
                                                                        {
                                                                            do
                                                                            {
                                                                                printf("\nPosto occupato\n");
                                                                                 printf("\nInserisci il numero di fila che desideri prenotare: ");
                                                                                scanf("%d",&numero_Fila);
                                                                                printf("\nInserisci il numero di poltrona che desideri prenotare: ");
                                                                                scanf("%d",&numero_Poltrona);
                                                                                sent2=1;
                                                                            }while((prenota[k].fila_poltrona==numero_Fila) &&(prenota[k].numero_poltrona==numero_Poltrona));
                                                                        }
                                                                    }
                                                                }



                                                                }
                                                       }while(sent2==1);

                                                float importo=0.0;
                                                float costoPrimafila=0.0;
                                                float costoUltimafila=0.0;
                                                int nFile=0;
                                                nFile=temp[k].numero_File;
                                                costoPrimafila=temp[k].c_Primafila;
                                                costoUltimafila=temp[k].c_Ultimafila;

                                                //Calcola Importo
                                                importo=costoPrimafila-(((float)(numero_Fila-1)/(float)(nFile-1))*(costoPrimafila-costoUltimafila));
                                                printf("\nL'importo totale e' %.2f euro\n",importo);
                                                fclose(prenota_ev);
                                                fclose(prenota2);

                                                if((prenota2=fopen("Prenotazione.csv","a+"))==NULL)
                                                {
                                                    printf("\nImpossibile aprire il file");
                                                } else
                                                    {
                                                        fprintf(prenota2,"%s;%s;%d;%d;%.2f;\n",c_univoco,c_nickname,numero_Fila,numero_Poltrona,importo);
                                                        printf("\nPrenotazione avvenuta con successo\n");
                                                        fclose(prenota2);
                                                    }
                                            }
                                        }
                                        if(sent1==0)
                                        {
                                            printf("\nCodice errato\n");
                                        } else
                                            {
                                                f1=0;
                                            }
                                    }while(f1!=0);

                                }
                        }
                    }
                }
                if(sent==0)
                {
                    printf("\nUtente non trovato\n");
                }
             //dovrebbe starci un while con la parantesi graffa chiusa }
        }
}

void Stampa_prenotati()
{
  char c_u[20]; /*Chiave di ricerca per gli eventi*/
  Prenotazione tmp[MAX];
  char linea[200];
  int conta=0;
  int e=0;
  int sent=0;
  FILE* stampa_p;

  if ((stampa_p = fopen ("Prenotazione.csv", "r+")) == NULL)
  {
      printf("\nImpossibile aprire il file");
  } else
    {
        while(fgets(linea, sizeof(linea),stampa_p))

        {
            strcpy(tmp[conta].cod_Univoco,strtok(linea,";"));
            strcpy(tmp[conta].Nickname_utente,strtok(NULL,";"));
            tmp[conta].fila_poltrona=atoi(strtok(NULL, ";"));
            tmp[conta].numero_poltrona=atoi(strtok(NULL, ";"));
            tmp[conta].importo=atof(strtok(NULL, ";"));
            conta++;
        }

         printf("\nInserisci codice univoco da ricercare: ");
         scanf("%s", c_u);
            for(int i=0;i<MAX;i++)
            {
                e=strcmp(c_u, tmp[i].cod_Univoco);
                if(e==0)
                {
                    printf("\nPrenotato n.%d",i);
                    printf("\n\nCodice univoco evento: %s",tmp[i].cod_Univoco);
                    printf("\nNickname utente: %s\n", tmp[i].Nickname_utente);
                    sent=1;

                }

            }
            if(sent==0)
            {
            printf("\nEvento non trovato\n");
            }

    }fclose(stampa_p);
}

void Modifica_evento()
{
  enum MODIFICA_EVENTO scelta_parametro;
  char codice_univoco[20]; /*Chiave di ricerca per il codice univoco*/
  Evento temp[MAX];
  char linea[200];
  int cont=0;
  int e;
  int sent=0;
  FILE* modifica_ev;
  if((modifica_ev = fopen("Evento.csv","r+"))==NULL)
  {
      printf ("\nImpossibile aprire in lettura il file.\n");
  } else
    {
        while(fgets(linea, sizeof(linea),modifica_ev))

        {

            strcpy(temp[cont].codiceUnivoco,(strtok(linea, ";")));
            temp[cont].anno=atoi(strtok(NULL, ";"));
            temp[cont].mese=atoi(strtok(NULL, ";"));
            temp[cont].giorno=atoi(strtok(NULL, ";"));
            temp[cont].or_Inizio=atoi(strtok(NULL, ";"));
            temp[cont].or_Fine=atoi(strtok(NULL, ";"));
            strcpy(temp[cont].artista, strtok(NULL, ";"));
            strcpy(temp[cont].locale, strtok(NULL, ";"));
            temp[cont].c_Primafila=atoi(strtok(NULL, ";"));
            temp[cont].c_Ultimafila=atoi(strtok(NULL, ";"));
            temp[cont].posti_Fila=atoi(strtok(NULL, ";"));
            temp[cont].numero_File=atoi(strtok(NULL, ";"));
            cont++;
        }

        printf("\nInserisci codice univoco da ricercare: ");
        scanf("%s",codice_univoco);

            for(int i=0;i<MAX;i++)
            {
                e=strcmp(codice_univoco,temp[i].codiceUnivoco);
                if(e==0)
                {
                    printf("\nEvento trovato\n\n");

                    sent=1;
                    int temp_anno;
                    int temp_mese;
                    int temp_giorno;
                    int temp_or_Inizio;
                    int temp_or_Fine;
                    char temp_artista[20];
                    char temp_locale[20];
                    int temp_c_Primafila;
                    int temp_c_Ultimafila;
                    int temp_posti_Fila;
                    int temp_numero_File;
                    int scelta_pa;


                  do
                  {
                    printf("Quale parametro vuoi modificare?");
                    printf("\n0-ANNO\n1-MESE\n2-GIORNO\n3-ORARIO DI INIZIO \n4-ORARIO DI FINE\n5-ARTISTA\n6-LOCALE\n7-COSTO PRIMA FILA\n8-COSTO ULTIMA FILA\n9-POSTI PER FILA\n10-NUMERO FILE\n");
                    printf("Inserisci una scelta: ");
                    scanf("%d",&scelta_pa);
                    switch(scelta_pa)
                    {
                      case ANNO1:
                        printf("\nInserisci il nuovo anno dell'evento: ");
                        scanf("%d",&temp_anno);
                        temp[i].anno=temp_anno;
                        break;
                      case MESE1:
                        do
                        {
                        printf("\nInserisci il nuovo mese dell'evento: ");
                        scanf("%d",&temp_mese);
                        }while(temp_mese<1 || temp_mese>12);
                        temp[i].mese=temp_mese;
                        break;
                      case GIORNO1:
                      do
                        {
                        printf("\nInserisci il nuovo giorno dell'evento: ");
                        scanf("%d",&temp_giorno);
                        }while(temp_giorno<1 || temp_giorno>31);

                        if(temp[i].mese==2)
                        {
                          if((temp[i].anno%4)== 0)
                          {
                            if(temp_giorno < 0 || temp_giorno > 29)
                            {
                              do
                              {
                                printf("\nGiorno inesistente");
                                scanf("%d", &temp_giorno);
                              }while(temp_giorno > 29);
                            }
                          }
                        }
                        else
                        {
                          while(temp_giorno>28)
                          {
                            printf("\nGiorno inesistente");
                            scanf("%d", &temp_giorno);
                          }
                        }

                        if(temp[i].mese==4 || temp[i].mese==6 || temp[i].mese==9 || temp[i].mese==11)
                          {
                            if(temp_giorno < 0 || temp_giorno > 30)
                            {
                              do
                              {
                                printf("\nGiorno inesistente");
                                scanf("%d", &temp_giorno);
                              }while(temp_giorno > 30);
                            }
                          }
                        temp[i].giorno=temp_giorno;

                        break;

                      case OR_INIZIO:
                      do
                      {
                        printf("\n%s","Inserisci un orario di inizio:");
                        scanf("%d",&temp_or_Inizio);
                      }while(temp_or_Inizio<0 || temp_or_Inizio>24);
                      temp[i].or_Inizio=temp_or_Inizio;
                            break;
                      case OR_FINE:
                      do
                      {
                        printf("\n%s","Inserisci un orario di fine:");
                        scanf("%d",&temp_or_Fine);
                      }while(temp_or_Fine<0 || temp_or_Fine>24);
                      temp[i].or_Fine=temp_or_Fine;
                            break;
                      case ARTISTA1:
                            printf("\nInserisci il nuovo artista dell'evento: ");
                            scanf("%s",temp_artista);
                            strcpy(temp[i].artista,temp_artista);
                            break;
                      case LOCALE:
                            printf("\nInserisci il nuovo locale dell'evento: ");
                             scanf("%s",temp_locale);
                            strcpy(temp[i].locale,temp_locale);
                            break;
                      case C_PRIMAFILA:
                            printf("\nInserisci il nuovo costo della prima fila: ");
                             scanf("%d",&temp_c_Primafila);
                            temp[i].c_Primafila=temp_c_Primafila;
                            break;
                      case C_ULTIMAFILA:
                            printf("\nInserisci il nuovo costo dell'ultima fila: ");
                            scanf("%d", &temp_c_Ultimafila);
                            temp[i].c_Ultimafila=temp_c_Ultimafila;
                            break;
                      case POSTI_FILA:
                            printf("\nInserisci il nuovo numero di posti per fila: ");
                            scanf("%d", &temp_posti_Fila);
                            temp[i].posti_Fila=temp_posti_Fila;
                            break;
                      case NUMERO_FILA:
                            printf("\nInserisci il nuovo numero di file: ");
                            scanf("%d",&temp_numero_File);
                            temp[i].numero_File=temp_numero_File;
                    }

                  }while(scelta_pa<ANNO1 || scelta_pa>POSTI_FILA);
                }


            }
            if(sent==0)
            {
                printf("\nEvento non trovato.\n");
            }

    }
    fclose(modifica_ev);

    if((modifica_ev=fopen("Evento.csv","w"))==NULL)
    {
      printf("\nImpossibile aprire il file\n");
    }
    else
    {
      for(int i=0;i<cont;i++)
      {
          fprintf(modifica_ev,"%s;%d;%d;%d;%d;%d;%s;%s;%d;%d;%d;%d;\n",temp[i].codiceUnivoco,temp[i].anno,temp[i].mese,temp[i].giorno,temp[i].or_Inizio,temp[i].or_Fine,temp[i].artista,temp[i].locale,temp[i].c_Primafila,temp[i].c_Ultimafila,temp[i].posti_Fila,temp[i].numero_File);
      }
    }fclose(modifica_ev);
}

void Ricerca_data()
{
int cerca_anno;
int cerca_mese;
int cerca_giorno;
Evento evento[MAX];
char linea[200];
int conta=0;
int e;
int sent=0;
FILE* ricerca_da;

  if ((ricerca_da = fopen ("Evento.csv", "r+")) == NULL)
  {
      printf("\nImpossibile aprire il file");
  } else
    {
        while(fgets(linea, sizeof(linea),ricerca_da))

        {
            strcpy(evento[conta].codiceUnivoco, strtok(linea, ";"));
            evento[conta].anno=atoi(strtok(NULL, ";"));
            evento[conta].mese=atoi(strtok(NULL, ";"));
            evento[conta].giorno=atoi(strtok(NULL, ";"));
            evento[conta].or_Inizio=atoi(strtok(NULL, ";"));
            evento[conta].or_Fine=atoi(strtok(NULL, ";"));
            strcpy(evento[conta].artista, strtok(NULL, ";"));
            strcpy(evento[conta].locale, strtok(NULL, ";"));
            evento[conta].c_Primafila=atoi(strtok(NULL, ";"));
            evento[conta].c_Ultimafila=atoi(strtok(NULL, ";"));
            evento[conta].posti_Fila=atoi(strtok(NULL, ";"));
            evento[conta].numero_File=atoi(strtok(NULL, ";"));
            conta++;
        }
        printf("\nInserisci un anno per l'evento da ricercare: ");
        scanf("%d",&cerca_anno);
        printf("\nInserisci un mese per l'evento da ricercare: ");
        scanf("%d", &cerca_mese);
        printf("\nInserisci un giorno per l'evento da ricercare: ");
        scanf("%d", &cerca_giorno);
        for(int i=0; i<MAX; i++)
        {
            if(cerca_anno==evento[i].anno && cerca_mese==evento[i].mese && cerca_giorno==evento[i].giorno)
            {
                printf("\nEvento(per data) trovato\n");
                printf("\nCodice univoco evento: %s",evento[i].codiceUnivoco);
                printf("\nAnno: %d",evento[i].anno);
                printf("\nMese: %d",evento[i].mese);
                printf("\nGiorno: %d",evento[i].giorno);
                printf("\nOrario di inizio: %d",evento[i].or_Inizio);
                printf("\nOrario di fine: %d",evento[i].or_Fine);
                printf("\nArtista: %s",evento[i].artista);
                printf("\nLocale: %s",evento[i].locale);
                printf("\nCosto prima fila: %d",evento[i].c_Primafila);
                printf("\nCosto ultima fila: %d",evento[i].c_Ultimafila);
                printf("\nNumero posti per fila: %d",evento[i].posti_Fila);
                printf("\nNumero file: %d\n",evento[i].numero_File);
                sent=1;


            }
        }
        if(sent==0)
        {
            printf("\nEvento(per data) non trovato\n");
        }
    } fclose(ricerca_da);

}

void Stampa_Incassi()
{
  char c_u[20]; /*Chiave di ricerca per gli eventi*/
  Prenotazione tmp[MAX];
  char linea[200];
  int conta=0;
  int e=0;
  int sent=0;
  FILE* stampa_i;
  float importo=0.0;

  if ((stampa_i = fopen ("Prenotazione.csv", "r+")) == NULL)
  {
      printf("\nImpossibile aprire il file");
  } else
    {
        while(fgets(linea, sizeof(linea),stampa_i))

        {
            strcpy(tmp[conta].cod_Univoco,strtok(linea,";"));
            strcpy(tmp[conta].Nickname_utente,strtok(NULL,";"));
            tmp[conta].fila_poltrona=atoi(strtok(NULL, ";"));
            tmp[conta].numero_poltrona=atoi(strtok(NULL, ";"));
            tmp[conta].importo=atof(strtok(NULL, ";"));
            conta++;
        }

         printf("\nInserisci codice univoco da ricercare: ");
         scanf("%s", c_u);
            for(int i=0;i<MAX;i++)
            {
                e=strcmp(c_u, tmp[i].cod_Univoco);
                if(e==0)
                {
                    importo+=tmp[i].importo;
                    sent=1;

                }

            }
            printf("\nL'incasso totale dell'evento e': %.2f euro\n",importo);
            if(sent==0)
            {
            printf("\nEvento non trovato\n");
            }

    }fclose(stampa_i);
}
