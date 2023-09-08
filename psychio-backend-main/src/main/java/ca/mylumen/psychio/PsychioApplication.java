package ca.mylumen.psychio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsychioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsychioApplication.class, args);

		System.out.println("Connexion à la base de données établie avec succès !");
	}
}