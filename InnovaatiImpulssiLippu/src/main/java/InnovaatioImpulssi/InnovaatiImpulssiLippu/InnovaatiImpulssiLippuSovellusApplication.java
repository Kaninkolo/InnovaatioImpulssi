package InnovaatioImpulssi.InnovaatiImpulssiLippu;

import InnovaatioImpulssi.InnovaatiImpulssiLippu.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.expression.Arrays;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class InnovaatiImpulssiLippuSovellusApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovaatiImpulssiLippuSovellusApplication.class, args);
	}

	@Bean
	public CommandLineRunner myyjanLuonti(MyyjaRepository myyjarepository,
			TapatumaRepository tapatumaRepository,
			LippuRepository lippuRepository,
			LippuTyyppiRepository lippuTyyppiRepository,
			OstoTapahtumaRepository ostoTapahtumaRepository,
			UserRepository userRepository) {
		return (args) -> {

			AppUser u1 = new AppUser("user", "$2a$10$Ii9qBD9ZCTukaRwIzX8zzu/7tEmtrozDOQ05SUEYc.07l3wV94.T2", "USER");
			AppUser u2 = new AppUser("admin", "$2a$10$GvrXyt.9U/JjTKhgbvCfC.p.1ULhYfIKwhxGBCCwFU.O3gIKawB4C", "ADMIN");
			userRepository.save(u1);
			userRepository.save(u2);

			myyjarepository.save(new Myyja("Pekka Puupää"));

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Tapahtuma tapahtuma1 = new Tapahtuma();
			tapahtuma1.setTapahtumaId(null);
			tapahtuma1.setPvm(sdf.parse("15-06-2022"));
			tapahtuma1.setSijainti("Forssa");
			tapahtuma1.setKuvaus("Konsertti");
			tapahtuma1.setLippumaara(100);
			tapahtuma1.setMaxLiput(100);
			tapahtuma1 = tapatumaRepository.save(tapahtuma1);

			LippuTyyppi lippuTyyppi = new LippuTyyppi();
			lippuTyyppi.setTapahtuma(tapahtuma1);
			lippuTyyppi.setHinta(new BigDecimal(99.99));
			lippuTyyppi.setKuvaus("Normaali hinta");
			lippuTyyppiRepository.save(lippuTyyppi);

			Tapahtuma tapahtuma2 = new Tapahtuma();
			tapahtuma2.setTapahtumaId(null);
			tapahtuma2.setPvm(sdf.parse("15-05-2022"));
			tapahtuma2.setSijainti("Imatra");
			tapahtuma2.setKuvaus("Nykytaiteen Tapahtuma");
			tapahtuma2.setLippumaara(150);
			tapahtuma2.setMaxLiput(150);
			tapahtuma2 = tapatumaRepository.save(tapahtuma2);

			LippuTyyppi lippuTyyppiImatra = new LippuTyyppi();
			lippuTyyppiImatra.setTapahtuma(tapahtuma2);
			lippuTyyppiImatra.setHinta(new BigDecimal(199.99));
			lippuTyyppiImatra.setKuvaus("Normaali hinta");
			lippuTyyppiRepository.save(lippuTyyppiImatra);

			LippuTyyppi lippuTyyppiImatra2 = new LippuTyyppi();
			lippuTyyppiImatra2.setTapahtuma(tapahtuma2);
			lippuTyyppiImatra2.setHinta(new BigDecimal(149.99));
			lippuTyyppiImatra2.setKuvaus("Alennettu hinta");
			lippuTyyppiRepository.save(lippuTyyppiImatra2);

			// OstoTapahtuma ostoTapahtuma = new OstoTapahtuma();
			// ostoTapahtuma.setLiput();
			// Lippu lippu = new Lippu();
			// lippu.setLipputyyppi(lippuTyyppi);
			// lippu.setLippujenMaara(100);
			// lippu = lippuRepository.save(lippu);
			//
			// lippuTyyppi.setLiput(Collections.singletonList(lippu));
			// lippuTyyppiRepository.save(lippuTyyppi);"

		};
	}

	// @Bean
	// public CommandLineRunner tapahtuma(TapatumaRepository tapahtumarepository) {
	// return (args) -> {
	// SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	//
	// Tapahtuma tapahtuma = new Tapahtuma(null, sdf.parse("15-03-2022"),
	// "Helsinki", "Kevätkonsertti",
	// new ArrayList<>());
	// tapahtumarepository.save(tapahtuma);
	//
	// };
	// }

}
