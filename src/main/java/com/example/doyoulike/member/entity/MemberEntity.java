package com.example.doyoulike.member.entity;

import com.example.doyoulike.enums.Gender;
import com.example.doyoulike.enums.Major;
import com.example.doyoulike.member.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(nullable = false, unique = true)
    private Long memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private int birthYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Major major;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setGender(Gender.valueOf(memberDTO.getGender()));
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setBirthYear(memberDTO.getBirthYear());
        memberEntity.setMajor(Major.valueOf(memberDTO.getMajor()));
        return memberEntity;
    }
}