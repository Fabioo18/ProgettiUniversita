package Monopattini;

import java.io.Serializable;
import java.util.*;

public class Cliente implements Serializable
{
	private String nome;
	private String cognome;
	private String codice_fiscale;
	private static final int m = 2; // limite massimo di noleggi in uno stesso giorno
	transient Scanner scanner = new Scanner(System.in);
	
	public Cliente()
	{	
		System.out.println("Inserisci il nome del cliente: ");
		this.nome= scanner.next();
		System.out.println("\nInserisci il cognome del cliente: ");
		this.cognome= scanner.next();
		String tmp;
		do
		{
			System.out.println("\nInserisci il codice fiscale del cliente(16 caratteri): ");
			tmp = scanner.next();
			if(tmp.length() != 16) 
			{
				System.out.println("Codice fiscale non accettabile.");
			}
		} while(tmp.length() != 16);
			this.codice_fiscale= tmp;
	}

	@Override
	public String toString() 
	{
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + "]";
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public String getCodice_fiscale() 
	{
		return codice_fiscale;
	}

	public static int getM() 
	{
		return m;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice_fiscale == null) ? 0 : codice_fiscale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (codice_fiscale == null) {
			if (other.codice_fiscale != null) {
				return false;
			}
		} else if (!codice_fiscale.equals(other.codice_fiscale)) {
			return false;
		}
		return true;
	}	
	
}
