package TicTacToeServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TicTacToeClient extends TicTacToe
{
	public TicTacToeClient(int feldgroesse) {
		super(feldgroesse);
	}

	private java.net.Socket clientSocket;
	private static int PORT = 63000;
	private static int FELDGROESSE = 3;
	private static String ipAdresse = "localhost";

	public static void main(String[] args) {
		TicTacToeClient client = null;
			try {
			System.out.println("TicTacToe - Client");
			System.out.println("==================");
			client = new TicTacToeClient(FELDGROESSE);
			do {
				
				System.out.println(client.toString());
				int zug;
				do {
					zug = TestScannerErweitert.readInt("Clients Zug: ");
					if (zug < 0 || zug > 8) {
						System.out.println("Zug liegt außerhalb des Spielbereichs");
					}
				} while (zug < 0 || zug > 8);
				client.setMeinZug(zug);
				System.out.println(client.toString());
				if (client.getGewonnen() != -1) {
					System.out.println("Warten auf Zug des Gegners...");
					client.getGegnerZug();
				}
				
			} while (client.getGewonnen() == 0 && client.getEinerKannGewinnen());
			
			int a = client.getGewonnen();
			// Es wird ausgegeben wer gewonnen hat
			
			if (client.getEinerKannGewinnen()) {
				if (a == -1) {
					System.out.println(client.toString());
					System.out.println("Sie haben gewonnen");
				} else {
					System.out.println(client.toString());
					System.out.println("Gegner hat gewonnen");
				}
			} else {
				System.out.println(client.toString());
				System.out.println("Keiner kann mehr gewinnen.");
			}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Der Server schickt seinen Zug
	 * 
	 * @return ausgangsstatus von Zug
	 */
	public int getGegnerZug() throws java.io.IOException {
		int ret = -1;
		if (clientSocket == null)
			return (-3);
		try {
			InputStream in = clientSocket.getInputStream();
			int zug = (byte) in.read();
			ret = setZugSpieler2(zug);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		close();
		return ret;
	}
	/**
	 * Der Client schickt seinen Zug an den Server
	 * 
	 * @return ausgangsstatus von Zug
	 */
	public int setMeinZug(int zug) throws java.io.IOException, java.net.UnknownHostException {
		int ret = 0;
		if (clientSocket != null)
			return (-3);
		if (ret != -3) {
			ret = (setZugSpieler1(zug));
			if (ret == 0) {
				try {
					clientSocket = new Socket(ipAdresse, PORT);
					OutputStream out = clientSocket.getOutputStream();
					out.write(zug);

				} catch (UnknownHostException e) {
					e.getStackTrace();
				}
			}
		}
		return ret;
	}

	/**
	 * Der Client Socket wird geschlossen
	 */
	public void close() {
		try {
			clientSocket.close();
			clientSocket = null;
		} catch (IOException e) {
			System.out.println("Fehler beim Schließen!: " + e.getMessage());
		}
	}

}