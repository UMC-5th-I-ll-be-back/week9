package umc.study.service;

import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;

import java.util.List;

@Service
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    public MemberMissionService(MemberMissionRepository memberMissionRepository) {
        this.memberMissionRepository = memberMissionRepository;
    }

    public void addMemberMission(Member member, Mission mission) {
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .member(member)
                .mission(mission)
                .build();

        memberMissionRepository.save(memberMission);
    }

    public List<MemberMission> getMemberMissionsByMember(Member member) {
        return memberMissionRepository.findByMember(member);
    }

    public List<MemberMission> getMemberMissionsByMission(Mission mission) {
        return memberMissionRepository.findByMission(mission);
    }

    public void updateMemberMissionStatus(MemberMission memberMission, MissionStatus status) {
        memberMission.setStatus(status);
        memberMissionRepository.save(memberMission);
    }

    public void deleteMemberMission(MemberMission memberMission) {
        memberMissionRepository.delete(memberMission);
    }
}
