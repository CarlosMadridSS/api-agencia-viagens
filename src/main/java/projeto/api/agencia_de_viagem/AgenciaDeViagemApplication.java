package projeto.api.agencia_de_viagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("projeto.api.agencia_de_viagem.model")

@SpringBootApplication
public class AgenciaDeViagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaDeViagemApplication.class, args);
	}

}
