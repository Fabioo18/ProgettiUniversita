package Monopattini;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Vendita<T extends Acquistabili> implements Serializable
{
	private int codice_vendita;
	private LocalDate data_vendita;
	private double prezzo_vendita;
	private Dipendente dipendente;
	private Cliente cliente;
	private T monopattino;
	transient Scanner scanner = new Scanner(System.in);
	
	public Vendita(T monopattino, Dipendente dipendente, Cliente cliente, int i) 
	{
		System.out.println("\nInserisci anno, mese, giorno della vendita (uno alla volta): ");
		int anno = scanner.nextInt();
		System.out.print(", ");
		int mese = scanner.nextInt();
		System.out.print(", ");
		int giorno = scanner.nextInt();
		this.data_vendita = LocalDate.of(anno, mese, giorno);
		System.out.println("\nInserisci il prezzo di vendita: ");
		this.prezzo_vendita = scanner.nextDouble();
		this.dipendente = dipendente;
		this.cliente = cliente;
		this.monopattino = monopattino;
		this.monopattino.setAcquistato(true);
		this.codice_vendita = i;
		System.out.println("\nCodice della vendita: " + ++this.codice_vendita );
	}

	@Override
	public String toString() 
	{
		return "Vendita [codice_vendita=" + codice_vendita + ", data_vendita=" + data_vendita + ", prezzo_vendita="
				+ prezzo_vendita + ", dipendente=" + dipendente + ", cliente=" + cliente + ", monopattino="
				+ monopattino + "]";
	}

	public LocalDate getData_vendita() 
	{
		return data_vendita;
	}

	public void setData_vendita(LocalDate data_vendita) 
	{
		this.data_vendita = data_vendita;
	}

	public double getPrezzo_vendita() 
	{
		return prezzo_vendita;
	}

	public Dipendente getDipendente() 
	{
		return dipendente;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public T getMonopattino() 
	{
		return monopattino;
	}

	public int getCodice_vendita() 
	{
		return codice_vendita;
	}

	public void setPrezzo_vendita(double prezzo_vendita) 
	{
		this.prezzo_vendita = prezzo_vendita;
	}

	public void setDipendente(Dipendente dipendente) 
	{
		this.dipendente = dipendente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}

	public void setMonopattino(T monopattino) 
	{
		this.monopattino = monopattino;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monopattino == null) ? 0 : monopattino.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo_vendita);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendita other = (Vendita) obj;
		if (monopattino == null) {
			if (other.monopattino != null)
				return false;
		} else if (!monopattino.equals(other.monopattino))
			return false;
		if (Double.doubleToLongBits(prezzo_vendita) != Double.doubleToLongBits(other.prezzo_vendita))
			return false;
		return true;
	}
		
}
