package Monopattini;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class RegistroNoleggi implements Serializable 
{
	private ArrayList<Noleggio> Contenitore= new ArrayList<Noleggio>();
	private int i;
	
	public RegistroNoleggi() 
	{
		
	}
	
	public void addNoleggio(Noleggio n)
	{
		++i;
		Contenitore.add(n);	
	}
	
	public void removeNoleggio(Noleggio n)
	{
		Contenitore.remove(n);
	}
	
	public boolean Controllo(Cliente c, Dipendente d, LocalDate data)
	{
		int j = 0;
		
		for(Noleggio i:Contenitore)
		{
			if(i.getData_inizio().compareTo(data) == 0 && i.getCliente().getCodice_fiscale().compareTo(c.getCodice_fiscale()) == 0)
			{
				j++;
			}
			
			if(j >= c.getM()) // PER NON CONTARE SE STESSO
			{
				System.out.println("\nRaggiunto il numero massimo di noleggi al giorno da parte del cliente " + c.getCognome() + " " + c.getNome() + "\n");
				return false;
			}
		}
		
		j = 0;
		
		for(Noleggio i:Contenitore)
		{
			if(i.getData_inizio().compareTo(data) == 0 && i.getDipendente().getCodice_dipendente().compareTo(d.getCodice_dipendente()) == 0)
			{
				j++;
			}
			
			if(j >= d.getN()) // PER NON CONTARE SE STESSO
			{
				System.out.println("\nRaggiunto il numero massimo di noleggi al giorno da parte del dipendente " + d.getCognome() + " " + d.getNome() + "\n");
				return false;
			}
		}
		
		return true;
	}
	
	public Noleggio ricercaNoleggi(int codice)
	{
		for(Noleggio i:Contenitore)
		{
			if(i.getCodice_noleggio() == codice)
			{
				return i;
			}
		}
		System.out.println("Noleggio non trovato\n");
		return null;
	}
	
	public void Stampa()
	{
		Iterator<Noleggio> It = Contenitore.iterator();
		
		while(It.hasNext())
		{
			System.out.println("\n" +  It.next().toString() + "\n");
		}
	}
	
	public void Stampa(int c) // Overloading del metodo 
	{
		boolean flag = false;
		
		for(Noleggio i:Contenitore)
		{
			if(i.getCodice_noleggio() == c)
			{
				System.out.println("\n" + i.toString() + "\n");
				flag = true;
			}
		}
		
		if(flag == false)
		{
			System.out.println("Noleggio non trovato!\n");
		}
	}

	public void Stampa(File f, String g) throws IOException // Overloading del metodo 
	{
		Contenitore.sort(new DipendenteByCognome()); // Stampa in ordine del cognome del dipendente
		BufferedWriter writer;
		writer=new BufferedWriter(new FileWriter(g,false));
		
		for(Noleggio i:Contenitore)
		{
			writer.write(i.getDipendente().getCognome());
			writer.write("\n");
			writer.write(i.getMonopattino().toString());
			writer.write("\n\n");
		}
		writer.close();
	}

	public boolean isEmpty() {
		return Contenitore.isEmpty();
	}

	public int getI() {
		return i;
	}	
	
}
	

