package Monopattini;

public class Mono_medio extends AbstractMonopattino implements Acquistabili{
		
	public Mono_medio()
	{
		super.freni_disco=true;
		this.marca=super.marca;
		this.numero_serie=super.numero_serie;
	}

	@Override
	public String toString() 
	{
		return "Mono_medio [numero_serie=" + numero_serie + ", marca=" + marca + ", freni_disco=" + freni_disco
				+ ", conta_chilometri=" + conta_chilometri + ", acquistato=" + acquistato + "]";
	}

	@Override
	public String getTipo() 
	{
		return "Medio";
	}

}
