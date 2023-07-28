#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "utenti.h"
#include "eventi.h"
#define MAX 100

void MenuR_A()
{
enum OP_UTENTE scelta_ut;
    do
    {
        printf("\n0-REGISTRA UN NUOVO UTENTE");
        printf("\n1-ACCEDI");
        printf("\n2-ESCI\n");
        printf("Inserisci una scelta: ");
        scanf("%d", &scelta_ut);

        switch (scelta_ut)
        {
        case REGISTRA:
            Aggiungi_utente();
            break;
        case ACCEDI:
		    Accesso_utente();
            break;
		}
    } while (scelta_ut!=ESCI3);

}

void Aggiungi_utente()
{
Utente utenti[MAX];
enum GENERE scelta_genere;
enum GENERE_MUSICALE scelta_gen_mus;
FILE* fP;
int a;
int f;
  /*CODICE REGISTRAZIONE UTENTE*/
	if ((fP = fopen("Dati_utente.csv", "a+")) == NULL)
    {
        printf ("\nImpossibile aprire in lettura il file.\n");
    }
  else
    {
       do
       {
           for(int i=0;i<1;i++)
           {
               fP=fopen("Dati_utente.csv","r+");
               Utente tmp[MAX];
               char linea[200];
               int cont=0;
               while((cont<MAX)&&(!feof(fP)))
               {
                   fscanf(fP, "%s",linea);
                   strcpy(tmp[cont].nickname,strtok(linea,";"));
                   cont++;
               }
            do
            {
                printf("\n%s","Inserisci un nickname: ");
                scanf("%s",utenti[i].nickname);
                for(int k=0;k<MAX;k++)
                {
                    f=strcmp(utenti[i].nickname,tmp[k].nickname);
                    if(f==0)
                    {
                        printf("\nNICKNAME ESISTENTE\n");
                        printf("\nInserisci nickname: ");
                        scanf("%s",utenti[i].nickname);
                        f=1;
                        k=0;
                    }
                }
            }while(f==0);
                printf("\n%s","Inserisci un e-mail: ");
                scanf("%s",utenti[i].email);
                printf("\n%s","Inserisci un nome: ");
                scanf("%s",utenti[i].nome);
                printf("\n%s","Inserisci un cognome: ");
                scanf("%s",utenti[i].cognome);
                printf("\n%s","Inserisci anno di nascita: ");
                scanf("%d",&utenti[i].anno);
                do
                {
                    printf("\n%s","Inserisci mese di nascita: ");
                    scanf("%d",&utenti[i].mese);
                } while(utenti[i].mese<1 || utenti[i].mese>12);
                do
                {
                    printf("\n%s","Inserisci giorno di nascita: ");
                    scanf("%d",&utenti[i].giorno);
                } while(utenti[i].giorno<1 || utenti[i].giorno>31);
                        if(utenti[i].mese==2)
                        {
                            if((utenti[i].anno%4)== 0)
                            {
                                if(utenti[i].giorno < 0 || utenti[i].giorno > 29)
                                {
                                    do
                                    {
                                    printf("Giorno inesistente\n");
                                    scanf("%d", &utenti[i].giorno);
                                    }while(utenti[i].giorno > 29);
                                }
                            }else
                                {
                                    while(utenti[i].giorno>28)
                                    {
                                        printf("Giorno inesistente\n");
                                        scanf("%d", &utenti[i].giorno);
                                    }
                                }
                        }


                        if(utenti[i].mese==4 || utenti[i].mese==6 || utenti[i].mese==9 || utenti[i].mese==11)
                        {
                            if(utenti[i].giorno < 0 || utenti[i].giorno >30)
                            {
                                do
                                {
                                    printf("Giorno inesistente\n");
                                    scanf("%d", &utenti[i].giorno);
                                }while(utenti[i].giorno > 30);
                            }
                        }
                  do
                  {
                        printf("\n0-MASCHIO\n");
                        printf("1-FEMMINA\n");
                        printf("2-ALTRI\n");
                        printf("Inserisci il genere: ");
                        scanf("%d",&scelta_genere);
                        switch(scelta_genere)
                        {
                            case MASCHIO:
                                strcpy(utenti[i].genere,"MASCHIO");
                                break;
                            case FEMMINA:
                                strcpy(utenti[i].genere,"FEMMINA");
                                break;
                            case ALTRI:
                                strcpy(utenti[i].genere,"ALTRI");
                                break;
                            default:
                                printf("SELEZIONE NON ACCETTATA\n");
                                break;
                        }
                    }while (scelta_genere<MASCHIO || scelta_genere>ALTRI);
                    do
                    {
                        printf("\n0-BLUES\n1-CLASSICA\n2-HEAVY-METAL\n3-HIP-HOP\n4-JAZZ\n5-POP\n6-PUNK\n7-ROCK\n8-ALTRO\n");
                        printf("Inserisci il tuo genere musicale preferito: ");
                        scanf("%d",&scelta_gen_mus);

                        switch(scelta_gen_mus)
                        {
                            case BLUES:
                                strcpy(utenti[i].genere_musicale,"BLUES");
                                break;
                            case CLASSICA:
                                strcpy(utenti[i].genere_musicale,"CLASSICA");
                                break;
                            case HEAVY_METAL:
                                strcpy(utenti[i].genere_musicale,"HEAVY_METAL");
                                break;
                            case HIP_HOP:
                                strcpy(utenti[i].genere_musicale,"HIP_HOP");
                                break;
                            case JAZZ:
                                strcpy(utenti[i].genere_musicale,"JAZZ");
                                break;
                            case POP:
                                strcpy(utenti[i].genere_musicale,"POP");
                                break;
                            case PUNK:
                                strcpy(utenti[i].genere_musicale,"PUNK");
                                break;
                            case ROCK:
                                strcpy(utenti[i].genere_musicale,"ROCK");
                                break;
                            case ALTRO:
                                strcpy(utenti[i].genere_musicale,"ALTRO");
                                break;
                            default:
                                printf("SELEZIONE NON ACCETTATA\n");
                                break;
                        }
                    } while(scelta_gen_mus<BLUES || scelta_gen_mus>ALTRO);
                    printf("\n%s","Inserisci un numero cellulare: ");
                    scanf("%lu",&utenti[i].n_cellulare);
                    printf("\nVuoi registrare un nuovo utente? \n1-SI\n0-NO\n");
                    printf("Inserisci la scelta: ");
                    scanf("%d",&a);
                    fprintf(fP,"%s;%s;%s;%s;%d;%d;%d;%s;%s;%lu;\n",utenti[i].nickname,utenti[i].email,utenti[i].nome,utenti[i].cognome,utenti[i].anno,utenti[i].mese,utenti[i].giorno,utenti[i].genere,utenti[i].genere_musicale,utenti[i].n_cellulare);
                    fclose(fP);
            }
        }while(a!=0);
		fclose(fP);
    }
}

void Accesso_utente()
{
  enum ACCESSO scelta_acc;
  do
  {
    printf("\n\n0-MODIFICA I DATI");
    printf("\n1-CRONOLOGIA EVENTI");
    printf("\n2-ESCI\n");
    printf("Inserisci una scelta: ");
    scanf("%d", &scelta_acc);
    switch (scelta_acc)
    {
        case MODIFICA:
                Modifica_utente();
                break;
        case CRONOLOGIA:
              Cronologia_eventi();
                break;
    }

   }while(scelta_acc != ESCI2);

}

void Modifica_utente()
{
  enum GENERE_MUSICALE scelta_gen_mus;
  enum GENERE scelta_genere;
  enum MODIFICA_UTENTE scelta_par;
  char c_n[20]; /*Chiave di ricerca per il nickname*/
  Utente temp[MAX];
  char linea[200];
  int cont=0;
  int f;
  int sent=0;
  FILE* modifica;
  if((modifica= fopen("Dati_utente.csv","r+"))==NULL)
  {
      printf ("\nImpossibile aprire in lettura il file.\n");
  } else
    {
        while(fgets(linea, sizeof(linea),modifica))
        {
            strcpy(temp[cont].nickname,strtok(linea,";"));
            strcpy(temp[cont].email, strtok(NULL, ";"));
            strcpy(temp[cont].nome, strtok(NULL, ";"));
            strcpy(temp[cont].cognome, strtok(NULL, ";"));
            temp[cont].anno=atoi(strtok(NULL, ";"));
            temp[cont].mese=atoi(strtok(NULL, ";"));
            temp[cont].giorno=atoi(strtok(NULL, ";"));
            strcpy(temp[cont].genere, strtok(NULL, ";"));
            strcpy(temp[cont].genere_musicale, strtok(NULL, ";"));
            temp[cont].n_cellulare=atoi(strtok(NULL, ";"));
            cont++;
        }

        printf("\nInserisci nickname da ricercare: ");
        scanf("%s", c_n);

          for(int i=0;i<MAX;i++)
            {
                f=strcmp(c_n, temp[i].nickname);
                if(f==0)
                {
                    printf("\nUtente trovato\n\n");

                    sent=1;
                    char temp_email[40];
                    char temp_nome[15];
                    char temp_cognome[15];
                    char temp_genere[6];
                    char temp_genere_musicale[12];
                    int temp_giorno;
                    int temp_mese;
                    int temp_anno;
                    unsigned int temp_n_cellulare;
                    int scelta_parametro;

                  do
                  {
                    printf("Quale parametro vuoi modificare?\n0-EMAIL\n1-NOME\n2-COGNOME\n3-ANNO\n4-MESE\n5-GIORNO\n6-GENERE\n7-GENERE MUSICALE\n8-NUMERO CELLULARE\n");
                    printf("Inserisci una scelta: ");
                    scanf("%d",&scelta_parametro);
                    switch(scelta_parametro)
                    {
                      case EMAIL:
                                printf("\nInserisci la nuova e-mail: ");
                                scanf("%s",temp_email);
                                strcpy(temp[i].email,temp_email);
                                break;
                      case NOME:
                                printf("\nInserisci il nuovo nome: ");
                                scanf("%s",temp_nome);
                                strcpy(temp[i].nome,temp_nome);
                                break;
                      case COGNOME:
                                printf("\nInserisci il nuovo cognome: ");
                                scanf("%s",&temp_cognome);
                                strcpy(temp[i].cognome,temp_cognome);
                                break;
                       case ANNO:
                                printf("\nInserisci il nuovo anno di nascita: ");
                                scanf("%d",&temp_anno);
                                temp[i].anno=temp_anno;
                                break;
                        case MESE:
                            do
                            {
                                printf("\nInserisci il nuovo mese di nascita: ");
                                scanf("%d",&temp_mese);
                            }while(temp_mese<1 || temp_mese>12);
                                temp[i].mese=temp_mese;
                                break;
                        case GIORNO:
                            do
                            {
                                printf("\nInserisci il nuovo giorno di nascita: ");
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
                            }else
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
                        int genere=0;/*Serve per il genere*/
                      case GENERE:
                      do
                      {
                        printf("\nInserisci il nuovo genere: ");
                        printf("\n0-MASCHIO");
                        printf("\n1-FEMMINA");
                        printf("\n2-ALTRI\n");
                        printf("Inserisci una scelta: ");
                        scanf("%d", &scelta_genere);

                        switch(scelta_genere)
                        {
                         case MASCHIO:
                            strcpy(temp_genere,"MASCHIO");
                            break;
                         case FEMMINA:
                            strcpy(temp_genere,"FEMMINA");
                            break;
                         case ALTRI:
                            strcpy(temp_genere,"ALTRI");
                            break;
                         default:
                            printf("SELEZIONE NON ACCETTATA");
                            break;
                        }
                        }while (genere<MASCHIO || genere>ALTRI);

                        strcpy(temp[i].genere,temp_genere);
                        break;
                      case GENERE_MUSICALE:
                        do
                        {
                         printf("\nInserisci il tuo genere musicale preferito:\n 0-BLUES\n1-CLASSICA\n2-HEAVY-METAL\n3-HIP-HOP\n4-JAZZ\n5-POP\n6-PUNK\n7-ROCK\n8-ALTRO\n");
                         printf("Inserisci una scelta: ");
                         scanf("%d",&scelta_gen_mus);

                         switch(scelta_gen_mus)
                            {
                              case BLUES:
                                  strcpy(temp_genere_musicale,"BLUES");
                                  break;
                              case CLASSICA:
                                   strcpy(temp_genere_musicale,"CLASSICA");
                                  break;
                              case HEAVY_METAL:
                                   strcpy(temp_genere_musicale,"HEAVY_METAL");
                                   break;
                              case HIP_HOP:
                                   strcpy(temp_genere_musicale,"HIP_HOP");
                                   break;
                              case JAZZ:
                                  strcpy(temp_genere_musicale,"JAZZ");
                                  break;
                              case POP:
                                  strcpy(temp_genere_musicale,"POP");
                                  break;
                              case PUNK:
                                  strcpy(temp_genere_musicale,"PUNK");
                                  break;
                                case ROCK:
                                  strcpy(temp_genere_musicale,"ROCK");
                                  break;
                                case ALTRO:
                                  strcpy(temp_genere_musicale,"ALTRO");
                                  break;
                                default:
                                  printf("SELEZIONE NON ACCETTATA");
                                  break;
                            }
                        }while(scelta_gen_mus<BLUES || scelta_gen_mus>ALTRO);
                          strcpy(temp[i].genere_musicale,temp_genere_musicale);
                                case NUMERO_CELLULARE:
                                    printf("\nInserisci il nuovo numero di cellulare (senza 39+): ");
                                    scanf("%lu",&temp_n_cellulare);
                                    temp[i].n_cellulare=temp_n_cellulare;
                                    break;
                    }

                  }while(scelta_parametro<EMAIL || scelta_parametro>NUMERO_CELLULARE);
                }


            }
            if(sent==0)
            {
                printf("\nUtente non trovato.\n");
            }




    }
    fclose(modifica);

    if((modifica=fopen("Dati_utente.csv","w"))==NULL)
    {
      printf("Impossibile aprire il file\n");
    }
    else
    {
      for(int i=0;i<cont;i++)
      {
          fprintf(modifica,"%s;%s;%s;%s;%d;%d;%d;%s;%s;%lu;\n",temp[i].nickname,temp[i].email,temp[i].nome,temp[i].cognome,temp[i].anno,temp[i].mese,temp[i].giorno,temp[i].genere,temp[i].genere_musicale,temp[i].n_cellulare);

      }
    }
    fclose(modifica);
}

void Cronologia_eventi()
{
  int scelta_crono;

  printf("\nScegliere il criterio di ordine degli eventi: \n0-COSTO\n1-DATA\n");
  printf("Inserisci una scelta: ");
  scanf("%d", &scelta_crono);
  switch(scelta_crono)
  {
  case COSTO:
      Ordine_costo();
      break;
  case DATA1:
      Ordine_data();
      break;
  }
}

void Ordine_costo()
{
  Prenotazione tmp[MAX];
  char linea[200];
  int conta=0;
  int o=0;
  int i;
  int sent=0;
  FILE* ordine_co;

  if ((ordine_co = fopen ("Prenotazione.csv", "r+")) == NULL)
  {
      printf("\nImpossibile aprire il file");
  } else
    {

      while(fgets(linea, sizeof(linea),ordine_co))
      {
          strcpy(tmp[conta].cod_Univoco,strtok(linea,";"));
          strcpy(tmp[conta].Nickname_utente,strtok(NULL,";"));
          tmp[conta].fila_poltrona=atoi(strtok(NULL, ";"));
          tmp[conta].numero_poltrona=atoi(strtok(NULL, ";"));
          tmp[conta].importo=atof(strtok(NULL, ";"));
          conta++;
     }
     conta=conta-1;
       for(i=1;i<conta;i++)
        {
          for(int j=0;j<conta;j++)
          {
            if (tmp[j].importo>tmp[j+1].importo)
            {
              float hold_importo;
              char hold_nickname[15];
              int hold_filapoltrona;
              int hold_numeropoltrona;

              hold_importo=tmp[j].importo;
              strcpy(hold_nickname,tmp[j].Nickname_utente);
              hold_filapoltrona=tmp[j].fila_poltrona;
              hold_numeropoltrona=tmp[j].numero_poltrona;
              tmp[j].importo=tmp[j+1].importo;
              tmp[j+1].importo=hold_importo;
              strcpy(tmp[j].Nickname_utente,tmp[j+1].Nickname_utente);
              strcpy(tmp[j+1].Nickname_utente,hold_nickname);
              tmp[j].fila_poltrona=tmp[j+1].fila_poltrona;
              tmp[j+1].fila_poltrona=hold_filapoltrona;
              tmp[j].numero_poltrona=tmp[j+1].numero_poltrona;
              tmp[j+1].numero_poltrona=hold_numeropoltrona;
            }
          }
        }
        printf("\nGli eventi in ordine di costo sono:\n ");
        for(i=1;i<conta+1;i++)
        {
          printf("\nEvento n.%d ",i);
          printf("Codice univoco evento: %s\t ",tmp[i].cod_Univoco);
          printf("Nickname utente: %s\t ", tmp[i].Nickname_utente);
          printf("Fila poltrona: %d\t ", tmp[i].fila_poltrona);
          printf("Numero poltrona: %d\t", tmp[i].numero_poltrona);
          printf("Importo: %.2f euro\t",tmp[i].importo);
        }

    }
    fclose(ordine_co);
}

void Ordine_data()
{
Prenotazione tmp[MAX];
char linea[200];
int conta=0;
int i;
int n;
Evento temp[MAX];
FILE* ordine_da;
FILE* ordine_da2;
char c_n[20];
int sent=0;
char hold_cod_univoco[10];
int hold_anno;
int hold_mese;
int hold_giorno;
int hold_inizio;
int hold_fine;
char hold_artista[10];
char hold_locale[10];
int hold_costoPrimafila;
int hold_costoUltimafila;
int hold_postifila;
int hold_numerofile;

        if ((ordine_da = fopen ("Evento.csv", "r+")) == NULL)
        {
            printf("\nImpossibile aprire il file");
        } else
            {
                while(fgets(linea,sizeof(linea),ordine_da))
                    {
                        strcpy(temp[conta].codiceUnivoco,strtok(linea,";"));
                        temp[conta].anno=atoi(strtok(NULL, ";"));
                        temp[conta].mese=atoi(strtok(NULL, ";"));
                        temp[conta].giorno=atoi(strtok(NULL, ";"));
                        temp[conta].or_Inizio=atoi(strtok(NULL, ";"));
                        temp[conta].or_Fine=atoi(strtok(NULL, ";"));
                        strcpy(temp[conta].artista, strtok(NULL, ";"));
                        strcpy(temp[conta].locale, strtok(NULL, ";"));
                        temp[conta].c_Primafila=atoi(strtok(NULL, ";"));
                        temp[conta].c_Ultimafila=atoi(strtok(NULL, ";"));
                        temp[conta].posti_Fila=atoi(strtok(NULL, ";"));
                        temp[conta].numero_File=atoi(strtok(NULL, ";"));
                        conta++;
                    }
                        conta=conta-1;
                            for(i=1;i<conta;i++)
                            {
                                for(int j=0;j<conta;j++)
                                {
                                    if (temp[j].anno>temp[j+1].anno)
                                    {

                                              strcpy(hold_cod_univoco,temp[j].codiceUnivoco);
                                              hold_anno=temp[j].anno;
                                              hold_mese=temp[j].mese;
                                              hold_giorno=temp[j].giorno;
                                              hold_inizio=temp[j].or_Inizio;
                                              hold_fine=temp[j].or_Fine;
                                              strcpy(hold_artista,temp[j].artista);
                                              strcpy(hold_locale,temp[j].locale);
                                              hold_costoPrimafila=temp[j].c_Primafila;
                                              hold_costoUltimafila=temp[j].c_Ultimafila;
                                              hold_postifila=temp[j].posti_Fila;
                                              hold_numerofile=temp[j].numero_File;
                                              strcpy(temp[j].codiceUnivoco,temp[j+1].codiceUnivoco);
                                              strcpy(temp[j+1].codiceUnivoco,hold_cod_univoco);
                                              temp[j].anno=temp[j+1].anno;
                                              temp[j+1].anno=hold_anno;
                                              temp[j].mese=temp[j+1].mese;
                                              temp[j+1].mese=hold_mese;
                                              temp[j].giorno=temp[j+1].giorno;
                                              temp[j+1].giorno=hold_giorno;
                                              temp[j].or_Inizio=temp[j+1].or_Inizio;
                                              temp[j+1].or_Inizio=hold_inizio;
                                              temp[j].or_Fine=temp[j+1].or_Fine;
                                              temp[j+1].or_Fine=hold_fine;
                                              strcpy(temp[j].artista,temp[j+1].artista);
                                              strcpy(temp[j+1].artista,hold_artista);
                                              strcpy(temp[j].locale,temp[j+1].locale);
                                              strcpy(temp[j+1].locale,hold_locale);
                                              temp[j].c_Primafila=temp[j+1].c_Primafila;
                                              temp[j+1].c_Primafila=hold_costoPrimafila;
                                              temp[j].c_Ultimafila=temp[j+1].c_Ultimafila;
                                              temp[j+1].c_Ultimafila=hold_costoUltimafila;
                                              temp[j].posti_Fila=temp[j+1].posti_Fila;
                                              temp[j+1].posti_Fila=hold_postifila;
                                              temp[j].numero_File=temp[j+1].numero_File;
                                              temp[j+1].numero_File=hold_numerofile;

                                    } else if ((temp[j].anno==temp[j+1].anno ) && (temp[j].mese>temp[j+1].mese))
                                        {

                                              strcpy(hold_cod_univoco,temp[j].codiceUnivoco);
                                              hold_anno=temp[j].anno;
                                              hold_mese=temp[j].mese;
                                              hold_giorno=temp[j].giorno;
                                              hold_inizio=temp[j].or_Inizio;
                                              hold_fine=temp[j].or_Fine;
                                              strcpy(hold_artista,temp[j].artista);
                                              strcpy(hold_locale,temp[j].locale);
                                              hold_costoPrimafila=temp[j].c_Primafila;
                                              hold_costoUltimafila=temp[j].c_Ultimafila;
                                              hold_postifila=temp[j].posti_Fila;
                                              hold_numerofile=temp[j].numero_File;
                                              strcpy(temp[j].codiceUnivoco,temp[j+1].codiceUnivoco);
                                              strcpy(temp[j+1].codiceUnivoco,hold_cod_univoco);
                                              temp[j].anno=temp[j+1].anno;
                                              temp[j+1].anno=hold_anno;
                                              temp[j].mese=temp[j+1].mese;
                                              temp[j+1].mese=hold_mese;
                                              temp[j].giorno=temp[j+1].giorno;
                                              temp[j+1].giorno=hold_giorno;
                                              temp[j].or_Inizio=temp[j+1].or_Inizio;
                                              temp[j+1].or_Inizio=hold_inizio;
                                              temp[j].or_Fine=temp[j+1].or_Fine;
                                              temp[j+1].or_Fine=hold_fine;
                                              strcpy(temp[j].artista,temp[j+1].artista);
                                              strcpy(temp[j+1].artista,hold_artista);
                                              strcpy(temp[j].locale,temp[j+1].locale);
                                              strcpy(temp[j+1].locale,hold_locale);
                                              temp[j].c_Primafila=temp[j+1].c_Primafila;
                                              temp[j+1].c_Primafila=hold_costoPrimafila;
                                              temp[j].c_Ultimafila=temp[j+1].c_Ultimafila;
                                              temp[j+1].c_Ultimafila=hold_costoUltimafila;
                                              temp[j].posti_Fila=temp[j+1].posti_Fila;
                                              temp[j+1].posti_Fila=hold_postifila;
                                              temp[j].numero_File=temp[j+1].numero_File;
                                              temp[j+1].numero_File=hold_numerofile;
                                            } else if ((temp[j].anno==temp[j+1].anno ) && (temp[j].mese==temp[j+1].mese) && (temp[j].giorno>temp[j+1].giorno))
                                                {
                                              strcpy(hold_cod_univoco,temp[j].codiceUnivoco);
                                              hold_anno=temp[j].anno;
                                              hold_mese=temp[j].mese;
                                              hold_giorno=temp[j].giorno;
                                              hold_inizio=temp[j].or_Inizio;
                                              hold_fine=temp[j].or_Fine;
                                              strcpy(hold_artista,temp[j].artista);
                                              strcpy(hold_locale,temp[j].locale);
                                              hold_costoPrimafila=temp[j].c_Primafila;
                                              hold_costoUltimafila=temp[j].c_Ultimafila;
                                              hold_postifila=temp[j].posti_Fila;
                                              hold_numerofile=temp[j].numero_File;
                                              strcpy(temp[j].codiceUnivoco,temp[j+1].codiceUnivoco);
                                              strcpy(temp[j+1].codiceUnivoco,hold_cod_univoco);
                                              temp[j].anno=temp[j+1].anno;
                                              temp[j+1].anno=hold_anno;
                                              temp[j].mese=temp[j+1].mese;
                                              temp[j+1].mese=hold_mese;
                                              temp[j].giorno=temp[j+1].giorno;
                                              temp[j+1].giorno=hold_giorno;
                                              temp[j].or_Inizio=temp[j+1].or_Inizio;
                                              temp[j+1].or_Inizio=hold_inizio;
                                              temp[j].or_Fine=temp[j+1].or_Fine;
                                              temp[j+1].or_Fine=hold_fine;
                                              strcpy(temp[j].artista,temp[j+1].artista);
                                              strcpy(temp[j+1].artista,hold_artista);
                                              strcpy(temp[j].locale,temp[j+1].locale);
                                              strcpy(temp[j+1].locale,hold_locale);
                                              temp[j].c_Primafila=temp[j+1].c_Primafila;
                                              temp[j+1].c_Primafila=hold_costoPrimafila;
                                              temp[j].c_Ultimafila=temp[j+1].c_Ultimafila;
                                              temp[j+1].c_Ultimafila=hold_costoUltimafila;
                                              temp[j].posti_Fila=temp[j+1].posti_Fila;
                                              temp[j+1].posti_Fila=hold_postifila;
                                              temp[j].numero_File=temp[j+1].numero_File;
                                              temp[j+1].numero_File=hold_numerofile;

                                            }
                                          }
                                       }




                            printf("\nGli eventi in ordine di data sono:\n ");
                            for(i=1;i<conta+1;i++)
                            {
                              printf("\n\nEvento n.%d\n\n",i);
                              printf("Codice univoco evento:%s\t",temp[i].codiceUnivoco);
                              printf("Anno evento:%d\t", temp[i].anno);
                              printf("Mese evento:%d\t", temp[i].mese);
                              printf("Giorno evento:%d\t", temp[i].giorno);
                              printf("Orario di inizio:%d\t", temp[i].or_Inizio);
                              printf("Orario di fine:%d\t", temp[i].or_Fine);
                              printf("Artista:%s\t",temp[i].artista);
                              printf("Locale:%s\t",temp[i].locale);
                              printf("Costo prima fila:%d\t", temp[i].c_Primafila);
                              printf("Costo ultima fila:%d\t", temp[i].c_Ultimafila);
                              printf("Posti per fila:%d\t", temp[i].posti_Fila);
                              printf("Numero di file:%d\t", temp[i].numero_File);
                            }

              }
            fclose(ordine_da);
   }
