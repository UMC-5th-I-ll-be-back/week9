package umc.study.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.service.MemberMissionService.MemberMissionService;
import umc.study.validation.annotation.ExistMissionChallenge;

@RestController
@RequestMapping("/member-mission")
public class MemberMissionController {
    private final MemberMissionService memberMissionService;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public MemberMissionController(MemberMissionService memberMissionService, MemberRepository memberRepository, MissionRepository missionRepository){
        this.memberMissionService = memberMissionService;
        this.memberRepository = memberRepository;
        this.missionRepository = missionRepository;
    }

    // 가게의 미션을 도전 중인 미션에 추가(미션도전하기) API
    @PostMapping("/add")
    public ResponseEntity<String> addMemberMission(@RequestParam Long memberId, @RequestParam @ExistMissionChallenge Long missionId) {
            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid member id"));
            Mission mission = missionRepository.findById(missionId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid mission id"));

            memberMissionService.addMemberMission(member, mission);

            return ResponseEntity.ok("미션 도전하기!");
    }
}
