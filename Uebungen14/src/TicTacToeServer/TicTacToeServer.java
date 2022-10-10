package TicTacToeServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TicTacToeServer extends TicTacToe
{

	private java.net.Socket clientSocket;
	private static int PORT = 63000;
	private static int FELDGROESSE = 3;
	private java.net.ServerSocket server;

	public static void main(String[] args) {

		System.out.println("TicTacToe - Server");
		System.out.println("==================");
		TicTacToeServer server = null;
		try {
			server = new TicTacToeServer(FELDGROESSE, PORT);
			do {
				System.out.println(server.toString());
				System.out.println("Warten auf Zug des Gegners...");
				server.getGegnerZug();
				System.out.println(server.toString());
				if (server.getGewonnen() == 0) {
					int zug;
					do {
						zug = TestScannerErweitert.readInt("Server Zug: ");
						if (zug < 0 || zug > 8) {
							System.out.println("Zug liegt außerhalb des Spielbereichs");
						}
						
					} while (zug < 0 || zug > 8);
					server.setMeinZug(zug);
				}
			} while (server.getGewonnen() == 0 && server.getEinerKannGewinnen());
			int a = server.getGewonnen();
			
			if (server.getEinerKannGewinnen()) {
				if (a == -1) {
					System.out.println(server.toString());
					System.out.println("Sie haben gewonnen");
				} else {
					System.out.println(server.toString());
					System.out.println("Gegner hat gewonnen");
				}
			} else {
				System.out.println(server.toString());
				System.out.println("Keiner kann mehr gewinnen.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Konstruktor für TicTacToe server
	 * 
	 * @param feldgroesse
	 * @param port
	 * @throws java.io.IOException
	 */
	public TicTacToeServer(int feldgroesse, int port) throws java.io.IOException {
		super(feldgroesse);
		server = new java.net.ServerSocket(PORT);
	}

	/**
	 * schließt den Client Socket
	 */
	public void close() {
		try {
			clientSocket.close();
			clientSocket = null;
		} catch (IOException e) {
			System.out.println("Fehler beim Schließen!: " + e.getMessage());
		}
	}
	
	/**
	 * Der Client und der Server verbinden sich und Client schickt Zug
	 * 
	 * @return ausgangsstatus von Zug
	 */
	public int getGegnerZug() throws java.io.IOException {
		int ret = -1;
		if (clientSocket != null)
			return (-3);
		try {
			clientSocket = server.accept();
			InputStream in = clientSocket.getInputStream();
			int zug = (byte) in.read();
			ret = (setZugSpieler2(zug));
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * Der Server schickt seinen Zug an den Client
	 * 
	 * @param zug
	 * @return Ausgangstatus vom Zug
	 * @throws java.io.IOException
	 */
	public int setMeinZug(int zug) throws java.io.IOException {
		int ret = -1;
		if (clientSocket == null)
			return (-3);
		try {
			ret = (setZugSpieler1(zug));
			if (ret == 0) {
				OutputStream out = clientSocket.getOutputStream();
				out.write(zug);
			}
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		close();
		return ret;
	}

}