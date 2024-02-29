package InnovaatioImpulssi.InnovaatiImpulssiLippu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuRepository;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Myyja;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.MyyjaRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class InnovaatiImpulssiLippuSovellusApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovaatiImpulssiLippuSovellusApplication.class, args);
	}

	@Bean
	public CommandLineRunner myyjanLuonti(MyyjaRepository myyjarepository) {
		return (args) -> {

			myyjarepository.save(new Myyja("Pekka Puupää"));
		};
	}

}
