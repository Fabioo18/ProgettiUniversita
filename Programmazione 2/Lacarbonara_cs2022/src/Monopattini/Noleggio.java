package Monopattini;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Noleggio implements Serializable
{
	private int codice_noleggio;
	private LocalDate data_inizio;
	private LocalDate data_fine;
	private double costo_noleggio;
	private double penale;
	private Dipendente dipendente;
	private Mono_base monopattino;
	private Cliente cliente;
	transient Scanner scanner = new Scanner(System.in);
	
		public Noleggio(Mono_base monopattino,Dipendente dipendente,Cliente cliente, LocalDate data_inizio, int i) 
		{	
			boolean flag = true;
			int anno;
			int mese;
			int giorno;
			LocalDate dataf;
			do
			{
				System.out.println("\nInserisci anno, mese, giorno di fine noleggio (uno alla volta): ");
				anno = scanner.nextInt();
				System.out.print(", ");
				mese = scanner.nextInt();
				System.out.print(", ");
				giorno = scanner.nextInt();
				dataf = LocalDate.of(anno, mese, giorno);
				if(dataf.compareTo(data_inizio) < 0)
				{
					System.out.println("Errore! Il giorno di fine noleggio non può essere più recente della data di inizio\n");
					flag = false;
				}
				else
					flag = true;
			}while(flag  == false);
			this.data_fine = dataf;
			System.out.println("\nInserisci il costo del noleggio: ");
			this.costo_noleggio = scanner.nextDouble();
			System.out.println("\nInserisci il costo della penale: ");
			double penale = scanner.nextDouble();
			this.monopattino = monopattino;
			this.dipendente=dipendente;
			this.cliente=cliente;
			this.data_inizio=data_inizio;
			this.codice_noleggio = i;
			this.penale = penale;
			System.out.println("Codice del noleggio: " + ++this.codice_noleggio);
		} 
		
		@Override
		public String toString() {
			return "Noleggio [codice_noleggio=" + codice_noleggio + ", data_inizio=" + data_inizio + ", data_fine="
					+ data_fine + ", costo_noleggio=" + costo_noleggio + ", penale=" + penale + ", dipendente="
					+ dipendente + ", monopattino=" + monopattino + ", cliente=" + cliente + "]";
		}

		public double getCosto_noleggio() 
		{
			return costo_noleggio;
		}

		public Dipendente getDipendente() 
		{
			return dipendente;
		}

		public Mono_base getMonopattino() 
		{
			return monopattino;
		}

		public Cliente getCliente() 
		{
			return cliente;
		}
		
		public int getCodice_noleggio() 
		{
			return codice_noleggio;
		}
		
		public void setCosto_noleggio(double costo_noleggio) 
		{
			this.costo_noleggio = costo_noleggio;
		}
		
		public void setPenale(double penale) 
		{
			this.penale = penale;
		}
		
		public void setDipendente(Dipendente dipendente) 
		{
			this.dipendente = dipendente;
		}
		
		public void setMonopattino(Mono_base monopattino) 
		{
			this.monopattino = monopattino;
		}
		
		public void setCliente(Cliente cliente) 
		{
			this.cliente = cliente;
		}
		
		public LocalDate getData_inizio() 
		{
			return data_inizio;
		}
	
		public boolean setData_inizio(LocalDate data_inizio) 
		{
			if(data_inizio.compareTo(data_fine) > 0)
			{
				System.out.println("Errore! Il giorno di inizio noleggio non può essere meno recente della data di fine\n");
				return false;
			}
			else
			{
				this.data_inizio = data_inizio;
				return true;
			}
		}
	
		public LocalDate getData_fine() 
		{
			return data_fine;
		}
	
		public boolean setData_fine(LocalDate data_fine) 
		{
			if(data_fine.compareTo(data_inizio) < 0)
			{
				System.out.println("Errore! Il giorno di fine noleggio non può essere più recente della data di inizio\n");
				return false;
			}
			else
			{
				this.data_fine = data_fine;
				return true;
			}
			
		}	
}

