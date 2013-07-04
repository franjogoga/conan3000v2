package IngSoft.servicio.bean;
import java.util.Random;

public class SorteoRandom {


	private Random generator = new Random();
	private Integer n;
	private int[] socios = {1,2,3,4,5,6,7,8,9};
	private int[] bungalows = {1,2,3,4};
	
	 public int[]  GeneraRandomSocio() {
		
		int IndiceRandom; 
		int Indice;
		
		int[] Ramdomsocios = new int[this.n];
		
		for (int i =0; i < this.n; i++){
		
		IndiceRandom = generator.nextInt(socios.length);
		Indice = socios[IndiceRandom];
		Ramdomsocios[i] = Indice;
		
		}
		
		return Ramdomsocios;
	 }
	
		public int[]  GeneraRandomBungalows() {
			
			int IndiceRandom; 
			int Indice;
			
			int[] RamdomBungalows = new int[this.n];
			
			for (int i =0; i < this.n; i++){
			
			IndiceRandom = generator.nextInt(bungalows.length);
			Indice = bungalows[IndiceRandom];
			RamdomBungalows[i] = Indice;
			
			}
			return RamdomBungalows;
		}
		
}