package Monopattini;

import java.io.Serializable;
import java.util.Comparator;

public class DipendenteByCognome implements Comparator<Noleggio>, Serializable 
{
	@Override
	public int compare(Noleggio o1, Noleggio o2) 
	{
		int risultato = 0;
		return risultato = o1.getDipendente().getCognome().compareTo(o2.getDipendente().getCognome());
	}
}
