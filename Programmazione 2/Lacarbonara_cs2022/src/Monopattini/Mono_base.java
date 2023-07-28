package Monopattini;

public class Mono_base extends AbstractMonopattino 
{
	public Mono_base()
	{
		this.numero_serie=super.numero_serie;
	}

	@Override
	public String toString() 
	{
		return "Mono_base [numero_serie=" + numero_serie + ", marca=" + marca + ", freni_disco=" + freni_disco
				+ ", conta_chilometri=" + conta_chilometri + "]";
	}
	
}
