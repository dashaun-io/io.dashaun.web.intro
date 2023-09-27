package io.dashaun.web.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@RestController
class MyController {
	@GetMapping("/")
	public String timeSince() {
		ZonedDateTime startedWorking = ZonedDateTime.of(LocalDateTime.of(2021, Month.DECEMBER, 20, 9, 49), ZoneId.of("America/Chicago"));
		ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Chicago"));
		return String.format("%s days", ChronoUnit.DAYS.between(startedWorking, now));
	}
}
