package com.project.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.project.model.AppUser;
// import com.project.project.model.AppUser;
import com.project.project.model.Member;
import com.project.project.repository.AppUserRepository;
import com.project.project.repository.MemberRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	private final MemberRepository memberRepository;
	private final AppUserRepository userRepository;

	public ProjectApplication(MemberRepository memberRepository, AppUserRepository userRepository) {
		this.memberRepository = memberRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// Username: user, password: user
		memberRepository.save(new Member("member03", "สมยอส กินเป็ด", "abc3333","0833333333","ADMIN"));
		// Username: admin, password: admin
		memberRepository.save(new Member("member04", "สมยอส กินเป็ด", "abc4444","0844444444","USER"));
		memberRepository.save(new Member("member05", "สมยอส กินเป็ด", "","0844444444","ADMIN"));


		// // // Username: user, password: user
		// userRepository.save(new AppUser("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
		// // Username: admin, password: admin
		// userRepository.save(new AppUser("admin","$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
	}

	
}
