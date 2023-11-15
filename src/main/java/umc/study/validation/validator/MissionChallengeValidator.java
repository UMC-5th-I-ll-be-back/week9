package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.validation.annotation.ExistMissionChallenge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ExistMissionChallenge, Long> {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistMissionChallenge constraintAnnotation) {
        // 초기화 로직
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 해당 미션을 도전 중인 멤버미션을 조회
        List<MemberMission> memberMissions = memberMissionRepository.findByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);

        // 도전 중인 멤버미션이 존재하면 유효하지 않음
        return memberMissions.isEmpty();
    }
}
