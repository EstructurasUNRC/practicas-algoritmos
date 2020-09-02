package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerCadenas {
	
	public static void main(String [] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Ingrese una palabra: ");
				String input = reader.readLine();
				if (input.equals("q")) {
					System.out.println("Finalizado!");
					return;
				}
				System.out.println("Leido: " + input);
				System.out.println("-----------");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
