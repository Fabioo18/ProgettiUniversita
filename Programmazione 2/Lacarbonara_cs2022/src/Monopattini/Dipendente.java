package Monopattini;

import java.io.Serializable;
import java.util.*;

public class Dipendente implements Serializable
{
	private String nome;
	private String cognome;
	private String codice_dipendente;
	private static final int n = 4; // numero massimo di noleggi al giorno;
	transient Scanner scanner = new Scanner(System.in);
	
	public Dipendente()
	{
		System.out.println("Inserisci il nome del dipendente: ");
		this.nome= scanner.next();
		System.out.println("\nInserisci il cognome del dipendente: ");
		this.cognome= scanner.next();
		String tmp;
		do
		{
			System.out.println("\nInserisci il codice dipendente(8 caratteri alfanumerici): ");
			tmp = scanner.next();
			if(tmp.length() != 8) 
			{
				System.out.println("Codice dipendente non accettabile.");
			}
		} while(tmp.length() != 8);
			this.codice_dipendente= tmp;
	}

	@Override
	public String toString() 
	{
		return "Dipendente" + codice_dipendente + " [nome=" + nome + ", cognome=" + cognome + ", codice_dipendente=" + codice_dipendente + "]";
	}

	public String getNome() 
	{
		return nome;
	}


	public String getCognome() 
	{
		return cognome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getCodice_dipendente() 
	{
		return codice_dipendente;
	}

	public static int getN() 
	{
		return n;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice_dipendente == null) ? 0 : codice_dipendente.hashCode());
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
		Dipendente other = (Dipendente) obj;
		if (codice_dipendente == null) {
			if (other.codice_dipendente != null) {
				return false;
			}
		} else if (!codice_dipendente.equals(other.codice_dipendente)) {
			return false;
		}
		return true;
	}
	
}
