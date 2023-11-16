package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreService;
import umc.study.web.dto.store.StoreRequestDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> addMission(@RequestBody StoreRequestDto storeRequestDto){
        Store savedStore = storeService.addStore(storeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedStore);
    }
}
