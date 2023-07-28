package Monopattini;

public class Mono_avanzato extends AbstractMonopattino implements Acquistabili
{
	
	public Mono_avanzato()
	{
		super.conta_chilometri=true;
		super.freni_disco=true;
		this.marca=super.marca;
		this.numero_serie=super.numero_serie;
	}

	@Override
	public String toString() 
	{
		return "Mono_avanzato [numero_serie=" + numero_serie + ", marca=" + marca + ", freni_disco=" + freni_disco
				+ ", conta_chilometri=" + conta_chilometri + ", acquistato=" + acquistato + "]";
	}

	@Override
	public String getTipo() 
	{
		return "Avanzato";
	}
	
}
