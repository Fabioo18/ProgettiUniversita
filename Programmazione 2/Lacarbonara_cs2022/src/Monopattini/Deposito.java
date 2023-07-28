package Monopattini;

import java.io.Serializable;
import java.util.*;


public class Deposito implements Serializable
{
	private ArrayList<AbstractMonopattino> Contenitore = new ArrayList<AbstractMonopattino>();
	
	public Deposito() 
	{

	}
	
	public void addMono(AbstractMonopattino m)
	{
		Contenitore.add(m);	
	}
	
	public void removeMono(AbstractMonopattino m)
	{
		Contenitore.remove(m);	
	}
	
	public AbstractMonopattino ricercaMono(String x)
	{
		for(AbstractMonopattino i:Contenitore)
		{
			if(i.getNumero_serie().compareTo(x) == 0)
			{
				return i;
			}	
			
		}
		System.out.println("Monopattino non presente nel deposito\n");
		return null;
	}
	
	public boolean Verifica(AbstractMonopattino o)
	{
		for(AbstractMonopattino i:Contenitore)
		{
			if(i.getNumero_serie().compareTo(o.getNumero_serie()) == 0)
			{
				System.out.println("Numero di serie già esistente. Reinserire il codice.\n");
				return false;
			}
			
		}
		return true;
	}

	public void Stampa()
	{
		Iterator<AbstractMonopattino> It = Contenitore.iterator();
		
		while(It.hasNext())
		{
			System.out.println("\n" +  It.next().toString() + "\n");
		}
	}
	
	public void Stampa(String s) // Overloading del metodo 
	{
		boolean flag = false;
		
		for(AbstractMonopattino i:Contenitore)
		{
			if(i.getNumero_serie().compareTo(s)== 0)
			{
				System.out.println("\n" + i.toString() + "\n");
				flag = true;
			}
		}
		if(flag == false)
		{
			System.out.println("Monopattino non trovato!\n");
		}
	}

	public boolean isEmpty() {
		return Contenitore.isEmpty();
	}
	
}
