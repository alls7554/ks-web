package com.cheoloh.app;

import com.cheoloh.app.entity.*;
import com.cheoloh.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	private final PersonRepository personRepository;
	private final SocialMediaRepository socialMediaRepository;
	private final InterestsRepository interestsRepository;
	private final SkillRepository skillRepository;
	private final WorkRepository workRepository;

	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterestsRepository interestsRepository, SkillRepository skillRepository, WorkRepository workRepository){
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
		this.interestsRepository = interestsRepository;
		this.skillRepository = skillRepository;
		this.workRepository = workRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.save(new Person("박철오", "풀스택", "hello@test.com", "010-1234-5678"));
		socialMediaRepository.save(new SocialMedia("anonymous", "anonymous"));
		interestsRepository.save(new Interests("웨이트 트레이닝")); interestsRepository.save(new Interests("게임"));
		skillRepository.save(new Skill("Front-End", 65)); skillRepository.save(new Skill("Java", 80));
		workRepository.save(new Work("Boss", "CS-Lab","10months", "연구실장"));
	}
}
