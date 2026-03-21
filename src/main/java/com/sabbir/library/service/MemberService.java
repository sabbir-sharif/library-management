package com.sabbir.library.service;

import com.sabbir.library.models.Book;
import com.sabbir.library.models.Member;
import com.sabbir.library.repository.MemberRepository;

import java.util.List;

public class MemberService {

    private MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public void addMember(Member member){
        repo.save(member.getId(), member);
    }

    public Member findById(int id){
        return repo.findById(id);
    }

    public List<Member> findAll(){
        return repo.findAll();
    }

    public void delete(int id){
        repo.remove(id);
    }
}
