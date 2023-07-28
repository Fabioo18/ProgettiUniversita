package Monopattini;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RegistroDipendenti implements Serializable
{

private LinkedHashSet<Dipendente> Contenitore = new LinkedHashSet<Dipendente>();
	
	public RegistroDipendenti() 
	{
		
	}
	
	public void addDipendente(Dipendente d)
	{
		Contenitore.add(d);	
	}
	
	public void removeDipendente(Dipendente d)
	{
		Contenitore.remove(d);	
	}

	public Dipendente ricercaDipendente(String x)
	{
		for(Dipendente i:Contenitore)
		{
			if(i.getCodice_dipendente().compareTo(x) == 0)
			{
				return i;
			}
		}
		System.out.println("Dipendente non presente nel registro\n");
		return null;
	}
	
	public boolean Verifica(Dipendente d)
	{
		for(Dipendente i:Contenitore)
		{
			if(i.getCodice_dipendente().compareTo(d.getCodice_dipendente()) == 0)
			{
				System.out.println("Codice dipendente già esistente.\n");
				return false;
			}
			
		}
		return true;
	}

	public void Stampa()
	{
		Iterator<Dipendente> It = Contenitore.iterator();
		
		while(It.hasNext())
		{
			System.out.println("\n" +  It.next().toString() + "\n");
		}
	}
	
	public void Stampa(String s) // Overloading del metodo 
	{
		boolean flag = false;
		
		for(Dipendente i:Contenitore)
		{
			if(i.getCodice_dipendente().compareTo(s) == 0)
			{
				System.out.println("\n" + i.toString() + "\n");
				flag = true;
			}
		}
		
		if(flag == false)
		{
			System.out.println("Dipendente non trovato!\n");
		}
	}

	public boolean isEmpty() 
	{
		return Contenitore.isEmpty();
	}
	
}
