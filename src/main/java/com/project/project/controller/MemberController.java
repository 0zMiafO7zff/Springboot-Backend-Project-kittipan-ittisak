package com.project.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.model.Member;
import com.project.project.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("")
    public Iterable<Member> getAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/{m_user}")
    public Optional<Member> getMemberById(@PathVariable String m_user) {
        return memberRepository.findById(m_user);
    }

    @PostMapping("/addMember")
    public Member addMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @PutMapping("updateMember/{m_user}")
    public Member updatMember(@PathVariable String m_user, @RequestBody Member updatMember){
        return memberRepository.findById(m_user).map(member -> {
            member.setM_name(updatMember.getM_name());
            member.setM_pass(updatMember.getM_pass());
            member.setM_phone(updatMember.getM_phone());
            return memberRepository.save(member);
        })
        .orElseThrow(()->new RuntimeException("Member not found with id "+ m_user));
    }

    @DeleteMapping("/deleteMember/{m_user}")
    public void deleteMember(@PathVariable String m_user){
        memberRepository.deleteById(m_user);
    }
}
