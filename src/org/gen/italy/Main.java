package org.gen.italy;

import org.gen.italy.model.Televisore;

import java.util.Scanner;

public class Main {

	private static Televisore tv;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		String marca, modello;
		int scelta, nrCanale = 0;
		int nrPollici;

		do {
			
			System.out.println(
					"Menù: \n1. Crea TV \n2. Accendi TV \n3. Spegni TV \n4. Aumenta volume \n5. Diminuisci volume \n6. Cambia canale \n7. Mostra canale \n8. Visualizza elenco canali \n9. Esci");
			scelta = sc.nextInt();
			sc.nextLine();
			switch (scelta) {
			// Crea televisore
			case 1:
				try {
					creaTelevisore();
				} catch (Exception e) {
					System.err.println("Errore: " + e.getMessage());
				}
				break;
			// Accendi
			case 2:
				if (tv != null) {
				tv.accendi();
				System.out.println("Stato tv: " + tv.statoTV());
				} else
					System.out.println("La TV è inesistente!");
				break;
			// Spegni
			case 3:
				if (tv != null) {
				tv.spegni();
				System.out.println("Stato tv: " + tv.statoTV());
				} else 
					System.out.println("La TV è inesistente!");
				break;
			// Aumenta volume
			case 4:
				if (tv != null) {
				tv.aumentaVolume();
				System.out.println("Il volume è: " + tv.getVolume());
				} else
					System.out.println("La TV è inesistente");
				break;
			// Diminuisci volume
			case 5:
				if (tv != null) {
				tv.diminuisciVolume();
				System.out.println("Il volume è: " + tv.getVolume());
				} else 
					System.out.println("La TV è inesistente");
				break;
			// Cambia canale
			case 6:
				if (tv != null) {
				nrCanale = sc.nextInt();
				sc.nextLine();
				tv.cambiaCanale(nrCanale);
				} else
					System.out.println("La TV è inesistente");
				break;
			// Mostra canale
			case 7:
				if (tv != null) {
				System.out.println("Il canale corrente è: " + tv.getCanaleCorrente());
				} else
					System.out.println("La TV è inesistente");
				break;
			// Visualizza elenco canali
			case 8:
				if (tv != null) {
				tv.getElencoCanali();
				} else 
					System.out.println("La TV è inesistente");
				break;
			// Esci
			case 9:
				break;
			default:
				System.out.println("Scelta non valida");
			}
			
			if (tv != null)
			System.out.println(tv.toString());
			
		} while (scelta != 9);

	}

	// Metodo per creazione televisore
	private static void creaTelevisore() throws Exception {
		System.out.println("Inserisci la marca: ");
		String marca = sc.nextLine();
		System.out.println("Inserisci il modello: ");
		String modello = sc.nextLine();
		System.out.println("Inserisci il numero dei pollici");
		int nrPollici = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserire modalità hotel? true/false");
		boolean modalitaHotel = Boolean.parseBoolean(sc.nextLine());
		
		tv = new Televisore (marca, modello, nrPollici, modalitaHotel);
		
		
	}
}