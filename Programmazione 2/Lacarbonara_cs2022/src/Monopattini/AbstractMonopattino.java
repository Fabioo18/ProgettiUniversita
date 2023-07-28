package Monopattini;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractMonopattino implements Serializable,IMonopattino
{
	protected String numero_serie;
	protected String marca= "Bit";
	protected boolean freni_disco=false;
	protected boolean conta_chilometri=false;
	transient Scanner scanner = new Scanner(System.in); 
	protected boolean acquistato = false;
	
	public AbstractMonopattino()
	{
		String tmp;
		boolean flag = false;
			do
			{
				System.out.println("Inserisci il numero di serie (composto da 8 numeri): ");
				tmp=scanner.next();
				if(tmp.length() == 8)
				{
					for(int i=0; i<8; i++)
					{
						if(tmp.codePointAt(i) >= 48 && tmp.codePointAt(i) <= 57) //Verifica che la stringa contenga solo numeri
						{
							flag = true;
						}
						else
						{
							flag = false;
						}
					}
				}
				else
				{
					System.out.println("Numero di serie non accettabile.\n");
				}
			} while(flag == false);
		this.numero_serie = tmp;
	} 

	@Override
	public String toString() 
	{
		return "AbstractMonopattino [numero_serie=" + numero_serie + ", marca=" + marca + ", freni_disco=" + freni_disco
				+ ", conta_chilometri=" + conta_chilometri + ", acquistato=" + acquistato + "]";
	}

	@Override
	public String getNumero_serie() 
	{
		return numero_serie;
	}

	public void setAcquistato(boolean acquistato) 
	{
		this.acquistato = acquistato;
	}

	public boolean isAcquistato() 
	{
		return acquistato;
	}
	
}
