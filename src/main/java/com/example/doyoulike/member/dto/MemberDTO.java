package com.example.doyoulike.member.dto;

import com.example.doyoulike.member.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long memberId;
    private String password;
    private String confirmPassword;
    private String name;
    private String gender;
    private String email;
    private int birthYear;
    private String major;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setGender(memberEntity.getGender().toString());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setName(memberEntity.getName());
        memberDTO.setBirthYear(memberEntity.getBirthYear());
        memberDTO.setMajor(memberEntity.getMajor().toString());
        return memberDTO;
    }
}