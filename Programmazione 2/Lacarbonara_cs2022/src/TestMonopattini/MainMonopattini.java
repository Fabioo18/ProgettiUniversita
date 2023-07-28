package TestMonopattini;
import Monopattini.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class MainMonopattini 
{
	public static void main(String[] args) throws IOException
	{
		File FileMonos = new File("Monopattini.txt");
		Deposito DepositoMono= new Deposito();
		DepositoMono = Controllo(FileMonos,DepositoMono,"Monopattini.txt");
		      
		File FileClienti = new File("Clienti.txt");
		RegistroClienti ContenitoreClienti= new RegistroClienti();
		ContenitoreClienti = Controllo(FileClienti, ContenitoreClienti,"Clienti.txt");
		
		File FileDipendenti = new File("Dipendenti.txt");
		RegistroDipendenti ContenitoreDipendenti= new RegistroDipendenti();
		ContenitoreDipendenti = Controllo(FileDipendenti,ContenitoreDipendenti,"Dipendenti.txt");
		      
		File FileVendite = new File("Vendite.txt");
		RegistroVendite ContenitoreVendite= new RegistroVendite();
		ContenitoreVendite = Controllo(FileVendite,ContenitoreVendite ,"Vendite.txt");
		     
		File FileNoleggi = new File("Noleggi.txt");
		RegistroNoleggi ContenitoreNoleggi = new RegistroNoleggi();
		ContenitoreNoleggi = Controllo(FileNoleggi,ContenitoreNoleggi ,"Noleggi.txt");
		
		System.out.println("Benvenuti nella monopattino System\n");
		int scelta=0;
		do 
		{
			System.out.println("0)Esci\n1)Inserimento oggetti\n2)Modifica\n3)Cancellazione\n4)Visualizzazione\n5)Visualizzazione acquisti in base alla data\n6)Stampa noleggi su file\n");
			System.out.println("Inserire una scelta:");
			Scanner scanner= new Scanner(System.in);
			scelta=scanner.nextInt();
			switch(scelta)
			{
				case 0://ESCI
					System.out.println("Grazie di aver usufruito del nostro servizio. Arrivederci!");
					break;
				case 1://INSERIMENTO
					System.out.println("\n0)Non voglio inserire nulla\n1)Monopattino\n2)Cliente\n3)Dipendente\n4)Acquisto\n5)Noleggio\n");
					System.out.println("Scegliere il tipo di oggetto da inserire:");
					int scelta2 = 0;
					scelta2 = scanner.nextInt();	
					switch(scelta2)
					{
						case 0:
							break;
						case 1://Monopattino
						int tmp;
						do
						{
							System.out.println("Che tipo di monopattino si vuole inserire?\n1)BASE\n2)MEDIO\n3)AVANZATO\n");
							tmp = scanner.nextInt();
						
							if(tmp == 1)
							{
								boolean flag = false;
								AbstractMonopattino Base;
								do
								{
									Base= new Mono_base();
									flag = DepositoMono.Verifica(Base);
									
								}while(flag == false);
							
								System.out.println("\nMonopattino aggiunto al deposito\n");
								DepositoMono.addMono(Base);
							}
							else if(tmp == 2)
							{
								boolean flag = false;
								AbstractMonopattino Medio;
								do
								{
									
									Medio= new Mono_medio();
									flag = DepositoMono.Verifica(Medio);
									
								}while(flag == false);
							
								System.out.println("\nMonopattino aggiunto al deposito\n");
								DepositoMono.addMono(Medio);
							}
							else if(tmp == 3)
							{
								boolean flag = false;
								AbstractMonopattino Avanzato;
								do
								{
									Avanzato= new Mono_avanzato();
									flag = DepositoMono.Verifica(Avanzato);
									
								}while(flag == false);
								
								System.out.println("\nMonopattino aggiunto al deposito\n");
								DepositoMono.addMono(Avanzato);
							}
						}while(tmp <= 0 || tmp >3);
						break;
						case 2: //Cliente
							boolean flag = false;
							Cliente cliente;;
							do
							{
								
								cliente = new Cliente();
								flag = ContenitoreClienti.Verifica(cliente);
								
							}while(flag == false);
							 
							System.out.println("\nCliente aggiunto al registro\n");
							ContenitoreClienti.addCliente(cliente);
							break;
						case 3: //Dipendente
							boolean flag2 = false;
							Dipendente dipendente;
							do
							{
								
								dipendente = new Dipendente();
								flag2 = ContenitoreDipendenti.Verifica(dipendente);
								
							}while(flag2 == false);
							
							System.out.println("\nDipendente aggiunto al registro\n");
							ContenitoreDipendenti.addDipendente(dipendente);
							break;
						case 4: //Acquisto
							System.out.println("\nInserisci il numero di serie del monopattino che vuoi acquistare: ");
							String numero = scanner.next();
							Acquistabili MonoVenduto;
							try
							{
								MonoVenduto = (Acquistabili) DepositoMono.ricercaMono(numero);
							}
							catch(ClassCastException e)
							{
								System.out.println("\nNon è possibile acquistare un monopattino base\n");
								break;
							}
							if(MonoVenduto == null)
								break;
							
							if(MonoVenduto.isAcquistato() == true)
							{
								System.out.println("Monopattino già acquistato. Impossibile effettuare la vendita.\n");
								break;
							}
							
							System.out.println("\nInserisci il codice del dipendente che effettua la vendita: ");
							String codice_dipendente = scanner.next();
							Dipendente DipVendita=ContenitoreDipendenti.ricercaDipendente(codice_dipendente);
							if (DipVendita == null)
								break;
							
							System.out.println("\nInserisci il codice del cliente che effettua l'acquisto: ");
							String codice_cliente = scanner.next();
							Cliente CliVendita=ContenitoreClienti.ricercaCliente(codice_cliente);
							if (CliVendita == null)
								break;
							
							int codice = ContenitoreVendite.getI();
							Vendita vendita = new Vendita(MonoVenduto,DipVendita,CliVendita,codice);
							System.out.println("\nVendita effettuata con successo\n");
							ContenitoreVendite.addVendita(vendita);
							break;
						case 5: //Noleggio
							System.out.println("\nInserisci il numero di serie del monopattino che vuoi noleggiare: ");
							String numero2 = scanner.next();
							Mono_base MonoNoleggiato;
							try
							{
								MonoNoleggiato = (Mono_base) DepositoMono.ricercaMono(numero2);
							}
							catch(ClassCastException e)
							{
								System.out.println("\nNon è possibile noleggiare un monopattino che non sia base\n");
								break;
							}
							
							if(MonoNoleggiato == null)
								break;
							
							if(MonoNoleggiato.isAcquistato() == true)
							{
								System.out.println("Monopattino già acquistato. Impossibile effettuare il noleggio.\n");
								break;
							}
							System.out.println("\nInserisci il codice del dipendente che concede il noleggio: ");
							String codice_dipendente2 = scanner.next();
							Dipendente DipNoleggio=ContenitoreDipendenti.ricercaDipendente(codice_dipendente2);
							if (DipNoleggio == null)
								break;
							
							System.out.println("\nInserisci il codice del cliente che usufruisce del noleggio: ");
							String codice_cliente2 = scanner.next();
							Cliente CliNoleggio = ContenitoreClienti.ricercaCliente(codice_cliente2);
							if(CliNoleggio == null)
								break;
							
							System.out.println("\nInserisci anno, mese, giorno di inizio noleggio (uno alla volta): ");
							int anno2 = scanner.nextInt();
							System.out.print(", ");
							int mese2 = scanner.nextInt();
							System.out.print(", ");
							int giorno2 = scanner.nextInt();
							LocalDate tmp2 = LocalDate.of(anno2, mese2, giorno2);
							if(ContenitoreNoleggi.Controllo(CliNoleggio, DipNoleggio, tmp2) == false)
							{
								break;
							}
							else
							{
								int codice2 = ContenitoreNoleggi.getI();
								Noleggio noleggio = new Noleggio(MonoNoleggiato,DipNoleggio,CliNoleggio, tmp2, codice2);
								System.out.println("\nNoleggio effettuato con successo\n");
								ContenitoreNoleggi.addNoleggio(noleggio);
							}
							break;
						default:
							System.out.println("Inserimento errato\n");
							break;
					}
					break;
				case 2: //MODIFICA
					System.out.println("0)Non voglio modificare nulla\n1)Monopattino\n2)Cliente\n3)Dipendente\n4)Acquisto\n5)Noleggio\n");
					System.out.println("Scegliere il tipo di oggetto da modificare:");
					int scelta3 = 0;
					scelta3 = scanner.nextInt();	
					switch(scelta3)
					{
						case 0: //ESCI
							break;
						case 1: //Monopattino
							int scelta4;
							do
							{
								System.out.println("0)Ho cambiato idea\n1)Vogliono fare il reso\n"); //Del monopattino non possiamo modificare il numero di serie.
								System.out.println("Cosa vuoi modificare ?");
								scelta4 = scanner.nextInt();
								if(scelta4 == 0)
								{
									break;
								}
								else if(scelta4 == 1)
								{
									System.out.println("Inserire il numero di serie del monopattino di cui vogliono fare il reso.\n");
									String numero = scanner.next();
									Acquistabili Reso;
									try
									{
										Reso = (Acquistabili) DepositoMono.ricercaMono(numero);
										if(Reso == null)
											break;
								
										Reso.setAcquistato(false);
										System.out.println("Reso effettuato con successo\n");
									}
									catch(ClassCastException e)
									{
										System.out.println("\nNon è possibile fare il reso di un monopattino base\n");
									}
								}
							}while(scelta4 < 0 || scelta4 >1);
							break;
						case 2://Cliente
							int scelta5;
							do
							{
								System.out.println("0)Tutti i dati\n1)Nome\n2)Cognome\n");
								System.out.println("Cosa vuoi modificare ?");
								scelta5 = scanner.nextInt();
							}while(scelta5 < 0 || scelta5 > 2);
								System.out.println("Inserisci il tuo codice fiscale: ");
								String codice_fiscale = scanner.next();
								Cliente cambio;
								cambio = ContenitoreClienti.ricercaCliente(codice_fiscale);
								if(cambio == null)
									break;
								
								if(scelta5 == 0)
								{
									System.out.println("\nInserisci il nuovo nome: ");
									String nome = scanner.next();
									System.out.println("\nInserisci il nuovo cognome: ");
									String cognome = scanner.next();
									cambio.setNome(nome);
									cambio.setCognome(cognome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else if (scelta5 == 1)
								{
									System.out.println("\nInserisci il nuovo nome: ");
									String nome = scanner.next();
									cambio.setNome(nome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else if(scelta5 == 2)
								{
									System.out.println("\nInserisci il nuovo cognome: ");
									String cognome = scanner.next();
									cambio.setCognome(cognome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else
								{
									System.out.println("Inserimento errato\n");
								}
							
							break;
						case 3://Dipendente
							int scelta6;
							do
							{
								System.out.println("0)Tutti i dati\n1)Nome\n2)Cognome\n");
								System.out.println("Cosa vuoi modificare ?");
								scelta6 = scanner.nextInt();
							}while(scelta6 < 0 || scelta6 > 2);
								System.out.println("Inserisci il tuo codice dipendente: ");
								String codice_dipendente = scanner.next();
								Dipendente cambiodip;
								cambiodip = ContenitoreDipendenti.ricercaDipendente(codice_dipendente);
								if(cambiodip == null)
									break;
								
								if(scelta6 == 0)
								{
									System.out.println("\nInserisci il nuovo nome: ");
									String nome = scanner.next();
									System.out.println("\nInserisci il nuovo cognome: ");
									String cognome = scanner.next();
									cambiodip.setNome(nome);
									cambiodip.setCognome(cognome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else if (scelta6 == 1)
								{
									System.out.println("\nInserisci il nuovo nome: ");
									String nome = scanner.next();
									cambiodip.setNome(nome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else if(scelta6 == 2)
								{
									System.out.println("\nInserisci il nuovo cognome: ");
									String cognome = scanner.next();
									cambiodip.setCognome(cognome);
									System.out.println("Modifica effettuato con successo\n");
								}
								else
									System.out.println("Inserimento errato\n");
							
							break;
						case 4://Acquisto
							int scelta7;
							do
							{
								System.out.println("0)Tutti i dati\n1)Monopattino\n2)Dipendente\n3)Cliente\n4)Data\n5)Prezzo vendita\n");
								System.out.println("Cosa vuoi modificare?");
								scelta7 = scanner.nextInt();
							}while(scelta7 < 0 || scelta7 > 5);
								System.out.println("Inserisci il codice della vendita: ");
								int codice = scanner.nextInt();
								Vendita modVendita;
								modVendita = ContenitoreVendite.ricercaVendita(codice);
								if(modVendita == null)
									break;
								
								switch(scelta7)
								{
									case 0:
										System.out.println("\nInserisci il nuovo numero di serie del monopattino che vuoi acquistare: ");
										String numero = scanner.next();
										Acquistabili MonoVenduto;
										try
										{
											MonoVenduto = (Acquistabili) DepositoMono.ricercaMono(numero);
										}
										catch(ClassCastException e)
										{
											System.out.println("\nNon è possibile acquistare un monopattino base\n");
											break;
										}
										if(MonoVenduto == null)
											break;
										
										if(MonoVenduto.isAcquistato() == true)
										{
											System.out.println("Monopattino già acquistato. Impossibile effettuare la vendita.\n");
											break;
										}
										modVendita.setMonopattino(MonoVenduto);
										System.out.println("\nInserisci il nuovo codice del dipendente che effettua la vendita: ");
										String codice_dipendente2= scanner.next();
										Dipendente DipVendita=ContenitoreDipendenti.ricercaDipendente(codice_dipendente2);
										if (DipVendita == null)
											break;
										
										modVendita.setDipendente(DipVendita);
										
										System.out.println("\nInserisci il nuovo codice del cliente che effettua l'acquisto: ");
										String codice_cliente = scanner.next();
										Cliente CliVendita=ContenitoreClienti.ricercaCliente(codice_cliente);
										if (CliVendita == null)
											break;
										
										modVendita.setCliente(CliVendita);
										
										System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno della vendita (uno alla volta)\n: ");
										int anno = scanner.nextInt();
										System.out.println(" , ");
										int mese = scanner.nextInt();
										System.out.println(" , ");
										int giorno = scanner.nextInt();
										LocalDate tmp = LocalDate.of(anno, mese, giorno);
										modVendita.setData_vendita(tmp);
										
										System.out.println("Inserisci il nuovo prezzo di vendita: ");
										double prezzo = scanner.nextDouble();
										modVendita.setPrezzo_vendita(prezzo);
										
										System.out.println("\nVendita modificata con successo\n");
										break;
								case 1:
									System.out.println("\nInserisci il nuovo numero di serie del monopattino che vuoi acquistare: ");
									String numero2 = scanner.next();
									Acquistabili MonoVenduto2;
									try
									{
										MonoVenduto2 = (Acquistabili) DepositoMono.ricercaMono(numero2);
									}
									catch(ClassCastException e)
									{
										System.out.println("\nNon è possibile acquistare un monopattino base\n");
										break;
									}
									if(MonoVenduto2 == null)
										break;
									
									if(MonoVenduto2.isAcquistato() == true)
									{
										System.out.println("Monopattino già acquistato. Impossibile effettuare la vendita.\n");
										break;
									}
									modVendita.setMonopattino(MonoVenduto2);
									System.out.println("Modifica effettuato con successo\n");
									break;
								case 2:
									System.out.println("\nInserisci il nuovo codice del dipendente che effettua la vendita: ");
									String codice_dipendente3= scanner.next();
									Dipendente DipVendita2=ContenitoreDipendenti.ricercaDipendente(codice_dipendente3);
									if (DipVendita2 == null)
										break;
									
									modVendita.setDipendente(DipVendita2);
									System.out.println("Modifica effettuato con successo\n");
									break;
								case 3:
									System.out.println("\nInserisci il nuovo codice del cliente che effettua l'acquisto: ");
									String codice_cliente2 = scanner.next();
									Cliente CliVendita2=ContenitoreClienti.ricercaCliente(codice_cliente2);
									if (CliVendita2 == null)
										break;
									
									modVendita.setCliente(CliVendita2);
									System.out.println("Modifica effettuato con successo\n");
									break;
								case 4:
									System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno della vendita (uno alla volta): ");
									int anno2 = scanner.nextInt();
									System.out.print(", ");
									int mese2 = scanner.nextInt();
									System.out.print(", ");
									int giorno2 = scanner.nextInt();
									LocalDate tmp2 = LocalDate.of(anno2, mese2, giorno2);
									modVendita.setData_vendita(tmp2);
									System.out.println("Modifica effettuato con successo\n");
									break;
								case 5:
									System.out.println("\nInserisci il nuovo prezzo di vendita: ");
									double prezzo2 = scanner.nextDouble();
									modVendita.setPrezzo_vendita(prezzo2);
									System.out.println("Modifica effettuato con successo\n");
									break;
								default:
									System.out.println("\nInserimento errato\n");
									break;
							}
							break;
						case 5://Noleggio
							int scelta8;
							do
							{
								System.out.println("0)Tutti i dati\n1)Monopattino\n2)Dipendente\n3)Cliente\n4)Data inizio\n5)Data fine\n6)Prezzo noleggio\n7)Penale");
								System.out.println("Cosa vuoi modificare ?");
								scelta8 = scanner.nextInt();
							}while(scelta8 < 0 | scelta8 > 7);
								System.out.println("Inserisci il codice del noleggio: ");
								int codice2 = scanner.nextInt();
								Noleggio modNoleggio;
								modNoleggio = ContenitoreNoleggi.ricercaNoleggi(codice2);
								if(modNoleggio == null)
									break;
								
								switch(scelta8)
								{
									case 0:
										System.out.println("\nInserisci il nuovo codice del dipendente che concede il noleggio: ");
										String codice_dipendente2 = scanner.next();
										Dipendente DipNoleggio=ContenitoreDipendenti.ricercaDipendente(codice_dipendente2);
										if (DipNoleggio == null)
											break;
										
										System.out.println("\nInserisci il nuovo codice del cliente che usufruisce del noleggio: ");
										String codice_cliente2 = scanner.next();
										Cliente CliNoleggio=ContenitoreClienti.ricercaCliente(codice_cliente2);
										if (CliNoleggio == null)
											break;
										
										System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno di inizio noleggio (uno alla volta): ");
										int anno2 = scanner.nextInt();
										System.out.print(", ");
										int mese2 = scanner.nextInt();
										System.out.print(", ");
										int giorno2 = scanner.nextInt();
										LocalDate tmp2 = LocalDate.of(anno2, mese2, giorno2);
										if(ContenitoreNoleggi.Controllo(CliNoleggio, DipNoleggio, tmp2) == false)
										{
											break;
										}
						
										System.out.println("\nInserisci il nuovo numero di serie del monopattino che vuoi noleggiare: ");
										String numero2 = scanner.next();
										Mono_base MonoNoleggiato;
										try
										{
											MonoNoleggiato = (Mono_base) DepositoMono.ricercaMono(numero2);
										}
										catch(ClassCastException e)
										{
											System.out.println("\nNon è possibile noleggiare un monopattino che non sia base\n");
											break;
										}
										if(MonoNoleggiato == null)
											break;
										
										if(MonoNoleggiato.isAcquistato() == true)
										{
											System.out.println("Monopattino già acquistato. Impossibile effettuare il noleggio.\n");
											break;
										}
										
										System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno di fine noleggio (uno alla volta): ");
										int anno3 = scanner.nextInt();
										System.out.print(", ");
										int mese3 = scanner.nextInt();
										System.out.print(", ");
										int giorno3 = scanner.nextInt();
										LocalDate tmp3 = LocalDate.of(anno3, mese3, giorno3);	
										if(modNoleggio.setData_fine(tmp3) == false)
										{
											System.out.println("Modifica non concessa\n");
											break;
										}
										else
										{
											modNoleggio.setData_fine(tmp3);
											System.out.println("Modifica effettuata con successo\n");
										}
										
										System.out.println("\nInserisci il costo del noleggio: ");
										double costo_noleggio = scanner.nextDouble();
										
										System.out.println("\nInserisci il costo della penale: ");
										double penale = scanner.nextDouble();
										
										modNoleggio.setDipendente(DipNoleggio);
										modNoleggio.setCliente(CliNoleggio);
										modNoleggio.setData_inizio(tmp2);
										modNoleggio.setMonopattino(MonoNoleggiato);
										modNoleggio.setCosto_noleggio(costo_noleggio);
										modNoleggio.setPenale(penale);
										
										System.out.println("Noleggio modificato con successo\n");
										break;
									case 1:
										System.out.println("\nInserisci il nuovo numero di serie del monopattino che vuoi noleggiare: ");
										String numero3 = scanner.next();
										Mono_base MonoNoleggiato2 = null;
										try
										{
											MonoNoleggiato2 = (Mono_base) DepositoMono.ricercaMono(numero3);
										}
										catch(ClassCastException e)
										{
											System.out.println("\nNon è possibile noleggiare un monopattino che non sia base\n");
											break;
										}
										if(MonoNoleggiato2 == null)
											break;
										
										if(MonoNoleggiato2.isAcquistato() == true)
										{
											System.out.println("Monopattino già acquistato. Impossibile effettuare il noleggio.\n");
											break;
										}
										modNoleggio.setMonopattino(MonoNoleggiato2);
										System.out.println("Modifica effettuato con successo\n");
										break;
									case 2:
										System.out.println("\nInserisci il nuovo codice del dipendente che concede il noleggio: ");
										String codice_dipendente3 = scanner.next();
										Dipendente DipNoleggio2=ContenitoreDipendenti.ricercaDipendente(codice_dipendente3);
										if (DipNoleggio2 == null)
											break;
										
										if(ContenitoreNoleggi.Controllo(modNoleggio.getCliente(), DipNoleggio2, modNoleggio.getData_inizio()) == false)
										{
											break;
										}
										modNoleggio.setDipendente(DipNoleggio2);
										System.out.println("Modifica effettuato con successo\n");
										break;
									case 3:
										System.out.println("\nInserisci il nuovo codice del cliente che usufruisce del noleggio: ");
										String codice_cliente3 = scanner.next();
										Cliente CliNoleggio2=ContenitoreClienti.ricercaCliente(codice_cliente3);
										if (CliNoleggio2 == null)
											break;
										
										if(ContenitoreNoleggi.Controllo(CliNoleggio2, modNoleggio.getDipendente(), modNoleggio.getData_inizio()) == false)
										{
											break;
										}
										modNoleggio.setCliente(CliNoleggio2);
										System.out.println("Modifica effettuato con successo\n");
										break;
									case 4:
										System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno di inizio noleggio (uno alla volta): ");
										int anno = scanner.nextInt();
										System.out.print(", ");
										int mese = scanner.nextInt();
										System.out.print(", ");
										int giorno = scanner.nextInt();
										LocalDate tmp = LocalDate.of(anno, mese, giorno);
										if(ContenitoreNoleggi.Controllo(modNoleggio.getCliente(), modNoleggio.getDipendente(), tmp) == false)
										{
											break;
										}
										if(modNoleggio.setData_inizio(tmp) == false)
										{
											System.out.println("Modifica non concessa\n");
										}
										else
										{
											modNoleggio.setData_inizio(tmp);
											System.out.println("Modifica effettuata con successo\n");
										}
										break;
									case 5:
										System.out.println("\nInserisci il nuovo anno, il nuovo mese, il nuovo giorno di fine noleggio (uno alla volta): ");
										int anno4 = scanner.nextInt();
										System.out.print(", ");
										int mese4 = scanner.nextInt();
										System.out.print(", ");
										int giorno4 = scanner.nextInt();
										LocalDate tmp4 = LocalDate.of(anno4, mese4, giorno4);
										if(modNoleggio.setData_fine(tmp4) == false)
										{
											System.out.println("Modifica non concessa\n");
										}
										else
										{
											modNoleggio.setData_fine(tmp4);
											System.out.println("Modifica effettuata con successo\n");
										}
										break;
									case 6:
										System.out.println("\nInserisci il costo del noleggio: ");
										double costo_noleggio2 = scanner.nextDouble();
										modNoleggio.setCosto_noleggio(costo_noleggio2);
										System.out.println("Modifica effettuato con successo\n");
										break;
									case 7:
										System.out.println("\nInserisci il costo della penale: ");
										double penale2 = scanner.nextDouble();
										modNoleggio.setPenale(penale2);
										System.out.println("Modifica effettuato con successo\n");
										break;
									default:
										System.out.println("Inserimento errato\n");
										break;
								}
							break;
						default:
							System.out.println("Inserimento errato\n");
							break;
					}
					break;
				case 3: // Cancellazione
					System.out.println("0)Non voglio cancellare nulla\n1)Monopattino\n2)Cliente\n3)Dipendente\n4)Acquisto\n5)Noleggio\n");
					System.out.println("Scegliere il tipo di oggetto da cancellare:");
					int scelta4 = 0;
					scelta4 = scanner.nextInt();	
					switch(scelta4)
					{
						case 0:
							break;
						case 1:
							System.out.println("Inserisci il numero di serie del monopattino che vuoi cancellare: ");
							String numero_serie  = scanner.next();
							AbstractMonopattino MonoCanc;
							MonoCanc = DepositoMono.ricercaMono(numero_serie);
							if(MonoCanc == null)
								break;
							
							DepositoMono.removeMono(MonoCanc);
							System.out.println("Monopattino eliminato correttamente\n");
							break;
						case 2:
							System.out.println("Inserisci il codice fiscale del cliente che vuoi cancellare: ");
							String codice_fiscale  = scanner.next();
							Cliente ClienteCanc;
							ClienteCanc = ContenitoreClienti.ricercaCliente(codice_fiscale);
							if(ClienteCanc == null)
								break;
							
							ContenitoreClienti.removeCliente(ClienteCanc);
							System.out.println("Cliente eliminato correttamente\n");
							break;
						case 3:
							System.out.println("Inserisci il codice dipendente del dipendente che vuoi cancellare: ");
							String codice_dipendente  = scanner.next();
							Dipendente DipendenteCanc;
							DipendenteCanc = ContenitoreDipendenti.ricercaDipendente(codice_dipendente);
							if(DipendenteCanc == null)
								break;
							
							ContenitoreDipendenti.removeDipendente(DipendenteCanc);
							System.out.println("Dipendente eliminato correttamente\n");
							break;
						case 4:
							System.out.println("Inserisci il codice della vendita che vuoi cancellare: ");
							int codice_vendita  = scanner.nextInt();
							Vendita VenditaCanc;
							VenditaCanc = ContenitoreVendite.ricercaVendita(codice_vendita);
							if(VenditaCanc == null)
								break;
							
							ContenitoreVendite.removeVendita(VenditaCanc);
							System.out.println("Vendita eliminata correttamente\n");
							break;
						case 5:
							System.out.println("Inserisci il codice del noleggio che vuoi cancellare: ");
							int codice_noleggio  = scanner.nextInt();
							Noleggio NoleggioCanc;
							NoleggioCanc = ContenitoreNoleggi.ricercaNoleggi(codice_noleggio);
							if(NoleggioCanc == null)
								break;
							
							ContenitoreNoleggi.removeNoleggio(NoleggioCanc);
							System.out.println("Noleggio eliminata correttamente\n");
							break;
						default:
							System.out.println("Inserimento errato\n");
							break;
					}
					break;
				case 4://Visualizzazione oggetti
					System.out.println("0)Non voglio visualizzare nulla\n1)Monopattino\n2)Cliente\n3)Dipendente\n4)Acquisto\n5)Noleggio\n");
					System.out.println("Scegliere il tipo di oggetto da visualizzare:");
					int scelta5 = 0;
					scelta5 = scanner.nextInt();	
					switch(scelta5)
					{
						case 0:
							break;
						case 1:
							int scelta6 = 0;
							do
							{
								System.out.println("0)Visualizzare l'elenco di tutti i monopattini\n1)Visualizzare uno specifico monopattino");
								scelta6 = scanner.nextInt();
							}while(scelta6 < 0 || scelta6 > 1);
							
							if(scelta6 == 0)
							{
								DepositoMono.Stampa();
								if(DepositoMono.isEmpty() == true)
								{
									System.out.println("Nessun monopattino presente\n");
								}
							}
							else if (scelta6 == 1)
							{
								System.out.println("Inserisci il numero di serie del monopattino che vuoi visualizzare");
								String numero_serie = scanner.next();
								DepositoMono.Stampa(numero_serie);
							}
							break;
						case 2:
							int scelta7;
							do
							{
								System.out.println("0)Visualizzare l'elenco di tutti i clienti\n1)Visualizzare uno specifico cliente");
								scelta7 = scanner.nextInt();
							}while(scelta7 < 0 || scelta7 > 1);
								
							if(scelta7 == 0)
							{
								ContenitoreClienti.Stampa();
								if(ContenitoreClienti.isEmpty() == true)
								{
									System.out.println("Nessun cliente presente\n");
								}
							}
							else if (scelta7 == 1)
							{
								System.out.println("Inserisci il codice fiscale del cliente che vuoi visualizzare");
								String codice_fiscale = scanner.next();
								ContenitoreClienti.Stampa(codice_fiscale);
							}
							break;
						case 3:
							int scelta8;
							do
							{
								System.out.println("0)Visualizzare l'elenco di tutti i dipendenti\n1)Visualizzare uno specifico dipendente");
								scelta8 = scanner.nextInt();
							}while(scelta8 < 0 || scelta8 > 1);
							if(scelta8 == 0)
							{
								ContenitoreDipendenti.Stampa();
								if(ContenitoreDipendenti.isEmpty() == true)
								{
									System.out.println("Nessun dipendente presente\n");
								}
							}
							else if (scelta8 == 1)
							{
								System.out.println("Inserisci il codice del dipendente che vuoi visualizzare");
								String codice_dipendente = scanner.next();
								ContenitoreDipendenti.Stampa(codice_dipendente);
							}
							break;
						case 4:
							int scelta9;
							do
							{
								System.out.println("0)Visualizzare l'elenco di tutti gli acquisti\n1)Visualizzare uno specifico acquisto");
								scelta9 = scanner.nextInt();
							}while(scelta9 < 0 || scelta9 > 1);
							
							if(scelta9 == 0)
							{
								ContenitoreVendite.Stampa();
								if(ContenitoreVendite.isEmpty() == true)
								{
									System.out.println("Nessuna vendita presente\n");
								}
							}
							else if (scelta9 == 1)
							{
								System.out.println("Inserisci il codice della vendita che vuoi visualizzare");
								int codice_vendite = scanner.nextInt();
								ContenitoreVendite.Stampa(codice_vendite);
							}
							break;
						case 5:
							int scelta10;
							do
							{
								System.out.println("0)Visualizzare l'elenco di tutti i noleggi\n1)Visualizzare uno specifico noleggio");
								scelta10 = scanner.nextInt();
							}while(scelta10 < 0 || scelta10 > 1);
								
							if(scelta10 == 0)
							{
								ContenitoreNoleggi.Stampa();
								if(ContenitoreNoleggi.isEmpty() == true)
								{
									System.out.println("Nessun noleggio presente\n");
								}
							}
							else if (scelta10 == 1)
							{
								System.out.println("Inserisci il codice del noleggio che vuoi visualizzare");
								int codice_noleggi = scanner.nextInt();
								ContenitoreNoleggi.Stampa(codice_noleggi);
							}
							break;
						default:
							System.out.println("Inserimento errato\n");
							break;
					}
					break;
				case 5: // Visualizzazione acquisti in un intervallo di tempo
					boolean flag  = true;
					LocalDate data;
					LocalDate data2;
					do
					{
						System.out.println("Inserire data a partire da quella meno recente\n");
						System.out.println("Inserire anno, mese, giorno della prima data dell'intervallo (uno alla volta): ");
						int anno = scanner.nextInt();
						System.out.print(", ");
						int mese = scanner.nextInt();
						System.out.print(" , ");
						int giorno = scanner.nextInt();
						data = LocalDate.of(anno, mese, giorno);
						System.out.println("Inserire anno, mese, giorno della seconda data dell'intervallo (uno alla volta): ");
						int anno2 = scanner.nextInt();
						System.out.print(", ");
						int mese2 = scanner.nextInt();
						System.out.print(", ");
						int giorno2 = scanner.nextInt();
						data2 = LocalDate.of(anno2, mese2, giorno2);
						if(data2.compareTo(data) < 0)
						{
							System.out.println("Errore! La prima data inserita è più recente della seconda\n");
							flag = false;
						}
						else
							flag = true;
						
					} while(flag == false);
						ContenitoreVendite.Stampa(data,data2);
					break;
				case 6: //Stampa noleggi su file
					String g = "ElencoNoleggi.txt";
					File dir= new File(g);	
					ContenitoreNoleggi.Stampa(dir,g);
					System.out.println("\nFile correttamente stampato\n");
					break;
				default:
					System.out.println("\nInserimento errato\n");
					break;
			}
		}while(scelta != 0);
		
		Serializza(DepositoMono,"Monopattini.txt");
		Serializza(ContenitoreClienti,"Clienti.txt");
		Serializza(ContenitoreDipendenti,"Dipendenti.txt");
		Serializza(ContenitoreVendite,"Vendite.txt");
		Serializza(ContenitoreNoleggi,"Noleggi.txt");
		
	}
	

	public static <T> T Controllo(File f,T o,String g)
	{
		if(f.length() == 0)
	    {
			return o;
	    }
		else 
	    {
	    	 try
	         {
	              FileInputStream fis = new FileInputStream(g);
	              ObjectInputStream ois = new ObjectInputStream(fis);
	              o = (T) ois.readObject();
	              ois.close();
	              fis.close();
	              return o;
	         } 
	         catch (Exception e) 
	         {
	            return o;
	         }
	    } 	
	}
	
	public static <T> void Serializza(T o, String s)
	{
		try
        {
            FileOutputStream fos = new FileOutputStream(s);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}		
}