package umc.study.web.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreService;
import umc.study.web.dto.store.StoreRequestDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Object> addStore(@RequestBody StoreRequestDto storeRequestDto){
        storeService.addStore(storeRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getStoreList() {
        return new ResponseEntity<>(storeService.getStoreList(),HttpStatus.FOUND);
    }

    @GetMapping("/{store_id}")
    public ResponseEntity<?> getStoreReviewList(@PathVariable Long store_id){
        return new ResponseEntity<>(storeService.getStoreReviewList(store_id), HttpStatus.FOUND);
    }
}
