import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class dueGiocatori {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> mazzo = new ArrayList<Integer>();
		int manoGiocatore, cartaPescata, manoGiocatore2, puntata, puntata2, portafoglio = 100, portafoglio2 = 100;
		int totalePuntata;
		double valoreMano = 0, valoreMano2 = 0;
		String risposta, nuovaPartita;
		boolean sbancato = false, sbancato2 = false;

		do {
			System.out.println("Montepremi giocatore 1: " + portafoglio);
			System.out.println("inserire la puntata");
			puntata = sc.nextInt();
			while (puntata > portafoglio) {
				System.out.println("somma:" + portafoglio);
				System.out.println("diminuire la puntata");
				puntata = sc.nextInt();
			}

			System.out.println("Montepremi giocatore 2: " + portafoglio2);
			System.out.println("inserire la puntata");
			puntata2 = sc.nextInt();
			while (puntata2 > portafoglio2) {
				System.out.println("somma:" + portafoglio2);
				System.out.println("diminuire la puntata");
				puntata2 = sc.nextInt();
			}

			totalePuntata = puntata + puntata2;
			System.out.println();
			System.out.println("Inizio Partita");
			System.out.println();
			System.out.println("Turno Giocatore 1");
			System.out.println();

			for (int i = 0; i < 40; i++) {
				mazzo.add(i + 1);
				// System.out.println(mazzo.get(i));
			}

			do { // ciclo giocatore
				cartaPescata = r.nextInt(mazzo.size());
				// System.out.println();
				// System.out.println(mazzo.get(cartaPescata));
				mazzo.remove(cartaPescata);
				manoGiocatore = (mazzo.get(cartaPescata));

				if (manoGiocatore >= 1 && manoGiocatore <= 7) {
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

				if (valoreMano > 7.50) {
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
			System.out.println("Turno Giocatore 2");
			System.out.println();

			do {
				cartaPescata = r.nextInt(mazzo.size());
				// System.out.println();
				// System.out.println(mazzo.get(cartaPescata));
				mazzo.remove(cartaPescata);
				manoGiocatore2 = (mazzo.get(cartaPescata));

				if (manoGiocatore2 >= 1 && manoGiocatore2 <= 7) {
					System.out.println(manoGiocatore2 + " di Bastoni");
					valoreMano2 = valoreMano2 + manoGiocatore2;

				} else if (manoGiocatore2 >= 11 && manoGiocatore2 <= 17) {
					System.out.println((manoGiocatore2 - 10) + " di Denari");
					valoreMano2 = valoreMano2 + (manoGiocatore2 - 10);
				} else if (manoGiocatore2 >= 21 && manoGiocatore2 <= 27) {
					System.out.println((manoGiocatore2 - 20) + " di Spade");
					valoreMano2 = valoreMano2 + (manoGiocatore2 - 20);
				} else if (manoGiocatore2 >= 31 && manoGiocatore2 <= 37) {
					System.out.println((manoGiocatore2 - 30) + " di Coppe");
					valoreMano2 = valoreMano2 + (manoGiocatore2 - 30);
				} else {
					System.out.println("Figura");
					valoreMano2 = valoreMano2 + 0.50;
				}

				if (valoreMano2 > 7.50) {
					System.out.println("punteggio: " + valoreMano2);
					sbancato2 = true;
					break;
				} else {
					System.out.println("punteggio: " + valoreMano2);
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
			if (sbancato == true) {
				System.out.println("Giocatore 2 Vince");
				portafoglio = portafoglio - puntata;
				portafoglio2 = portafoglio2 + totalePuntata;
			} else if (sbancato2 == true) {
				System.out.println("Giocatore 1 Vince");
				portafoglio2 = portafoglio2 - puntata2;
				portafoglio = portafoglio + totalePuntata;
			} else {

				if (valoreMano > valoreMano2) {
					System.out.println("Giocatore 1 Vince");
					portafoglio2 = portafoglio2 - puntata2;
					portafoglio = portafoglio + totalePuntata;
				} else if (valoreMano2 > valoreMano) {
					System.out.println("Giocatore 2 Vince");
					portafoglio = portafoglio - puntata;
					portafoglio2 = portafoglio2 + totalePuntata;
				} else
					System.out.println("Pareggio");
			}

			valoreMano = 0;
			valoreMano2 = 0;
			if (portafoglio <= 0 || portafoglio2 <= 0)
				break;
			System.out.println();
			System.out.println("vuoi fare un altra partita? si/no");
			nuovaPartita = sc.next();
			sc.nextLine();
			while (!(nuovaPartita.equals("si") || nuovaPartita.equals("no"))) {
				System.out.println("inserire si o no");
				nuovaPartita = sc.next();
				sc.nextLine();
			}

		} while (nuovaPartita.equals("si"));
		System.out.println();
		System.out.println("Montepremi Giocatore 1: " + portafoglio);
		System.out.println("Montepremi Giocatore 2: " + portafoglio2);
		System.out.println("Grazie per aver giocato");

	}
}