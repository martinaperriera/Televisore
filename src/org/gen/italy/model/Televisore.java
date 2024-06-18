package org.gen.italy.model;

public class Televisore {

	// Dichiarazione variabili
	private String marca;
	private String modello;
	private int nrPollici;
	private boolean stato;
	private int volume;
	private boolean modalitaHotel;
	private String[] elencoCanali;
	private String canaleCorrente;
	private boolean cambiaCanale;

	public Televisore(String marca, String modello, int nrPollici, boolean modalitaHotel) throws Exception {
		// Inizializzazione attributi
		if (!marca.isEmpty())
			this.marca = marca;
		else
			throw new Exception("marca non valida");
		if (!modello.isEmpty())
			this.modello = modello;
		else
			throw new Exception("modello non valido");
		if (nrPollici > 0)
			this.nrPollici = nrPollici;
		else
			throw new Exception("numero pollici non validi");
		this.stato = false;
		this.volume = 0;
		this.modalitaHotel = modalitaHotel;
		this.canaleCorrente = "";
		this.elencoCanali = new String[] { "Rai 1", "Rai 2", "Rai 3", "Rai 4", "Canale 5", "Italia 1", "La7", "TV8",
				"NOVE", "Italia 2" };
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getNrPollici() {
		return nrPollici;
	}

	public boolean isStato() {
		return stato;
	}

	public boolean isModalitaHotel() {
		return modalitaHotel;
	}

	public void setModalitaHotel(boolean modalitaHotel) {
		this.modalitaHotel = modalitaHotel;
	}

	public boolean isCambiaCanale() {
		return cambiaCanale;
	}

	// Metodi per l'accensione e lo spegnimento
	public boolean statoTV() {
		return stato;
	}

	public void accendi() {
		this.stato = true;
		this.canaleCorrente = "";
	}

	public void spegni() {
		this.stato = false;
	}

	// Metodi per volume
	public int getVolume() {
		return volume;
	}

	public void aumentaVolume() {
		if (modalitaHotel && volume >= 5) {
			System.out.println("Volume massimo per la modalità hotel");
			this.volume = 5;
		} else if (volume < 10 && stato) {
			this.volume++;
		} else if (!stato) {
			System.out.println("La TV è spenta");
		}
		if (volume == 10) {
			System.out.println("Hai raggiunto il volume massimo!");
		}

	}

	public void diminuisciVolume() {
		if (volume > 0 && stato) {
			this.volume--;
		} else if (!stato) {
			System.out.println("La TV è spenta");
		}
		if (volume == 0) {
			System.out.println("Volume muto");
		}
	}

	// Metodi per i canali
	public void getElencoCanali() {
		if (stato) {
		System.out.println("Elenco canali: ");
		for (String canale : elencoCanali) {
			System.out.print(canale + " | ");
		}
		System.out.println();
		} else
			System.out.println("La TV è spenta");
	}

	public void cambiaCanale(int canale) {
		if (stato) {
			if (canale >= 0 && canale <= this.elencoCanali.length) {
				System.out.println("Cambiando il canale: " + this.elencoCanali[canale]);
				this.canaleCorrente = this.elencoCanali[canale];
			} else {
				System.out.println("Il canale non esiste.");
			}
		} else
			System.out.println("La TV è spenta");
	}

	public String getCanaleCorrente() {
		return canaleCorrente;
	}

	// Stampa TV
	@Override
	public String toString() {
		return "Televisore [marca=" + marca + ", modello=" + modello + ", nrPollici=" + nrPollici + ", stato=" + stato
				+ ", volume=" + volume + ", modalitaHotel=" + modalitaHotel + "]";
	}

}