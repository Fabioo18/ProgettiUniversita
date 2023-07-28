package Monopattini;

import java.io.Serializable;
import java.util.Comparator;

public class VenditeByTipoPrezzo implements Comparator<Vendita>,Serializable 
{
	@Override
	public int compare(Vendita o1, Vendita o2) 
	{
		int risultato = 0;
		risultato = o1.getMonopattino().getTipo().compareTo(o2.getMonopattino().getTipo());
		if(risultato == 0)
		{
			return risultato=(int)(o1.getPrezzo_vendita()-o2.getPrezzo_vendita());
		}
		else
		{
			if(o1.getMonopattino().getTipo() == "Medio")
			{
				risultato = -1;
				return risultato;
			}
			else
			{
				risultato = 1;
				return risultato;
			}
		}
	}
}


