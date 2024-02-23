package com.project.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.project.project.model.Member;

@RepositoryRestResource(path="member")
public interface MemberRepository extends JpaRepository<Member, String> {

}
