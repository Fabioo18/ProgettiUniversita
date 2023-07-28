package Monopattini;

import java.io.Serializable;
import java.time.*;
import java.util.*;

public class RegistroVendite implements Serializable 
{
	private ArrayList<Vendita> Contenitore=new ArrayList<Vendita>();
	private int i;
	
	public RegistroVendite() 
	{

	}
	
	public void addVendita(Vendita v)
	{
		Contenitore.add(v);
		i++;
	}
	
	public void removeVendita(Vendita v)
	{
		Contenitore.remove(v);
	}
	
	public Vendita ricercaVendita(int codice)
	{
		for(Vendita i:Contenitore)
		{
			if(i.getCodice_vendita() == codice)
			{
				return i;
			}
		}
		System.out.println("Vendita non trovata\n");
		
		return null;
	}
	
	public void Stampa()
	{
		Iterator<Vendita> It = Contenitore.iterator();
		
		while(It.hasNext())
		{
			System.out.println("\n" +  It.next().toString() + "\n");
		}
	}
	
	public void Stampa(int c) // Overloading del metodo Stampa()
	{
		boolean flag = false;
		for(Vendita i:Contenitore)
		{
			if(i.getCodice_vendita() == c)
			{
				System.out.println("\n" + i.toString() + "\n");
				flag = true;
			}
		}
		
		if(flag == false)
		{
			System.out.println("Vendita non trovata!\n");
		}
	}
	
	public void Stampa(LocalDate data, LocalDate data2) // Overloading del metodo Stampa()
	{
		Contenitore.sort(new VenditeByTipoPrezzo()); //Ordina per tipo e prezzo
		
		boolean flag = false;
		System.out.println("Elenco dei monopattini acquistati dal " + data + " fino al " + data2);
		
		for(Vendita i:Contenitore)
		{
			if(i.getData_vendita().compareTo(data) >= 0 && i.getData_vendita().compareTo(data2) <= 0)
			{
				System.out.println("\n" + i.getMonopattino().toString()  + " Prezzo di vendita:" + i.getPrezzo_vendita() +  "\n");
				flag = true;
			}
		}
		
		if(flag == false)
		{
			System.out.println("Vendita non trovata!\n");
		}
	}

	public boolean isEmpty() {
		return Contenitore.isEmpty();
	}

	public int getI() {
		return i;
	}
	
}
