package Monopattini;

import java.io.Serializable;
import java.util.*;

public class RegistroClienti implements Serializable
{
	private LinkedHashSet<Cliente> Contenitore = new LinkedHashSet<Cliente>();
	
	public RegistroClienti() 
	{
		
	}
	
	public void addCliente(Cliente c)
	{
		Contenitore.add(c);	
	}
	
	public void removeCliente(Cliente c)
	{
		Contenitore.remove(c);	
	}
	
	public Cliente ricercaCliente(String x)
	{
		for(Cliente i:Contenitore)
		{
			if(i.getCodice_fiscale().compareTo(x) == 0)
			{
				return i;
			}
		}
		System.out.println("Cliente non presente nel registro\n");
		return null;
	}
	
	public boolean Verifica(Cliente c)
	{
		for(Cliente i:Contenitore)
		{
			if(i.getCodice_fiscale().compareTo(c.getCodice_fiscale()) == 0)
			{
				System.out.println("Codice fiscale già esistente.\n");
				return false;
			}
			
		}
		return true;
	}
	
	public void Stampa()
	{
		Iterator<Cliente> It = Contenitore.iterator();
		
		while(It.hasNext())
		{
			System.out.println("\n" +  It.next().toString() + "\n");
		}
	}
	
	public void Stampa(String s) // Overloading del metodo 
	{
		boolean flag = false;
		
		for(Cliente i:Contenitore)
		{
			if(i.getCodice_fiscale().compareTo(s) == 0)
			{
				System.out.println("\n" + i.toString() + "\n");
				flag = true;
			}
			
		}
		if(flag == false)
		{
			System.out.println("Cliente non trovato!\n");
		}
	}

	public boolean isEmpty()
	{
		return Contenitore.isEmpty();
	}
	
}
