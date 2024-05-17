import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class giocatoreSingolo {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> mazzo = new ArrayList<Integer>();
		int manoGiocatore, cartaPescata, manoBanco, puntata, portafoglio = 100;
		double valoreMano = 0, valoreBanco = 0;
		String risposta, nuovaPartita;
		boolean sbancato = false;

		do {  //ciclo partita
			System.out.println("Montepremi: " + portafoglio); //puntata giocatore 1
			
			System.out.println("inserire la puntata");
			puntata = sc.nextInt();
			while(puntata>portafoglio) {
				System.out.println("somma:" + portafoglio);
				System.out.println("diminuire la puntata");
				puntata = sc.nextInt();				
			}
			System.out.println();
			System.out.println("Inizio Partita");
			System.out.println();

			for (int i = 0; i < 40; i++) {   //creazione mazzo
				mazzo.add(i + 1);
				// System.out.println(mazzo.get(i));
			}

			do { // ciclo giocatore
				cartaPescata = r.nextInt(mazzo.size());  //carta random
				// System.out.println();
				// System.out.println(mazzo.get(cartaPescata));
				mazzo.remove(cartaPescata);
				manoGiocatore = (mazzo.get(cartaPescata));

				if (manoGiocatore >= 1 && manoGiocatore <= 7) { // stampa carta e aggiunta valore numerico
					System.out.println(manoGiocatore + " di Bastoni");
					valoreMano = valoreMano + manoGiocatore;
				} else if (manoGiocatore >= 11 && manoGiocatore <= 17) {
					System.out.println((manoGiocatore - 10) + " di Denari");
					valoreMano = valoreMano + (manoGiocatore - 10);
				} else if (manoGiocatore >= 21 && manoGiocatore <= 27) {
					System.out.println((manoGiocatore - 20) + " di Spade");
					valoreMano = valoreMano + (manoGiocatore - 20);
				} else if (manoGiocatore >= 31 && manoGiocatore <= 37) {
					System.out.println((manoGiocatore - 30) + " di Coppe");
					valoreMano = valoreMano + (manoGiocatore - 30);
				} else {
					System.out.println("Figura");
					valoreMano = valoreMano + 0.50;
				}

				if (valoreMano > 7.50) {  //check sbancato
					System.out.println("punteggio: " + valoreMano);
					sbancato = true;
					break;
				} else {
					System.out.println("punteggio: " + valoreMano);
					System.out.println("peschi o stai");
					risposta = sc.next();
					sc.nextLine();
					while (!(risposta.equals("peschi") || risposta.equals("stai"))) {
						System.out.println("inserire peschi o stai");
						risposta = sc.next();
						sc.nextLine();
					}
				}
			} while (risposta.equals("peschi"));

			System.out.println();
			System.out.println("Turno Banco");
			System.out.println();

			do { // ciclo banco
				if (sbancato) {
					break;
				} else {
					cartaPescata = r.nextInt(mazzo.size()); //carta random
					// System.out.println();
					// System.out.println(mazzo.get(cartaPescata));
					mazzo.remove(cartaPescata);
					manoBanco = (mazzo.get(cartaPescata));

					if (manoBanco >= 1 && manoBanco <= 7) { // stampa carta e aggiunta valore numerico
						System.out.println(manoBanco + " di Bastoni");
						valoreBanco = valoreBanco + manoBanco;
					} else if (manoBanco >= 11 && manoBanco <= 17) {
						System.out.println((manoBanco - 10) + " di Denari");
						valoreBanco = valoreBanco + (manoBanco - 10);
					} else if (manoBanco >= 21 && manoBanco <= 27) {
						System.out.println((manoBanco - 20) + " di Spade");
						valoreBanco = valoreBanco + (manoBanco - 20);
					} else if (manoBanco >= 31 && manoBanco <= 37) {
						System.out.println((manoBanco - 30) + " di Coppe");
						valoreBanco = valoreBanco + (manoBanco - 30);
					} else {
						System.out.println("Figura");
						valoreBanco = valoreBanco + 0.50;
					}
					System.out.println("punteggio: " + valoreBanco);
				}

			} while (valoreBanco <= valoreMano && valoreBanco <= 7.5 && valoreMano <= 7.5);

			System.out.println();

			if (sbancato == true) { //controllo condizioni e aggiornamento portafoglio
				System.out.println("Banco vince");
				portafoglio = portafoglio - puntata;
			} else if (valoreBanco > 7.50) { 
				System.out.println("Giocatore Vince");
				portafoglio = portafoglio + puntata;
			} else if (valoreBanco == 7.50 || valoreBanco >= valoreMano) {
				System.out.println("Banco Vince");
				portafoglio = portafoglio - puntata;
			} else {
				System.out.println("Giocatore Vince");
				portafoglio = portafoglio + puntata;
			}

			valoreMano = 0;       //reset mano 
			valoreBanco = 0;
			if(portafoglio<=0)  //check se giocatore è senza fondi
				break;
			System.out.println();
			System.out.println("vuoi fare un altra partita? si/no"); //check nuova partita
			nuovaPartita = sc.next();
			sc.nextLine();
			while (!(nuovaPartita.equals("si") || nuovaPartita.equals("no"))) {
				System.out.println("inserire si o no");
				nuovaPartita = sc.next();
				sc.nextLine();
			}

		} while (nuovaPartita.equals("si"));
		System.out.println();
		System.out.println("Montepremi finale: "+portafoglio);
		System.out.println("Grazie per aver giocato");

	}
}