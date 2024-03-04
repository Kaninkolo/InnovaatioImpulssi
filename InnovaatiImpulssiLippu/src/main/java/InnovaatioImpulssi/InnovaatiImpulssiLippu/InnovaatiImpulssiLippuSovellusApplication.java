package InnovaatioImpulssi.InnovaatiImpulssiLippu;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@SpringBootApplication
public class InnovaatiImpulssiLippuSovellusApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovaatiImpulssiLippuSovellusApplication.class, args);
	}

	@Bean
	public CommandLineRunner myyjanLuonti(MyyjaRepository myyjarepository,
										  TapatumaRepository tapatumaRepository,
										  LippuRepository lippuRepository,
										  LippuTyyppiRepository lippuTyyppiRepository) {
		return (args) -> {

			myyjarepository.save(new Myyja("Pekka Puupää"));


			Tapahtuma tapahtuma = new Tapahtuma();
			tapahtuma.setTapahtuma_id(Long.valueOf(2));
			tapahtuma.setPvm(new Date());
			tapahtuma.setSijainti("Forssa");
			tapahtuma.setKuvaus("Konsertti");
			tapahtuma = tapatumaRepository.save(tapahtuma);

			LippuTyyppi lippuTyyppi = new LippuTyyppi();
			lippuTyyppi.setTapahtuma(tapahtuma);
			lippuTyyppi.setHinta(new BigDecimal(99.99));
			lippuTyyppi.setKuvaus("Normaali hinta");
			lippuTyyppi = lippuTyyppiRepository.save(lippuTyyppi);

			Lippu lippu = new Lippu();
			lippu.setLipputyyppi(lippuTyyppi);
			lippu.setLippujenMaara(100);
			lippu = lippuRepository.save(lippu);

			lippuTyyppi.setLiput(Collections.singletonList(lippu));
			lippuTyyppiRepository.save(lippuTyyppi);

		};
	}

}
