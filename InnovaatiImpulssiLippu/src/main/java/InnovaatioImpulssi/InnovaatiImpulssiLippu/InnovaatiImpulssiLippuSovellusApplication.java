package InnovaatioImpulssi.InnovaatiImpulssiLippu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.LippuRepository;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Myyja;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.MyyjaRepository;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.Tapahtuma;
import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.TapatumaRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

	@Bean
	public CommandLineRunner tapahtuma(TapatumaRepository tapahtumarepository) {
		return (args) -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Tapahtuma tapahtuma = new Tapahtuma(null, sdf.parse("15-03-2022"), "Helsinki", "Kevätkonsertti",
					new ArrayList<>());
			tapahtumarepository.save(tapahtuma);

		};
	}

}
