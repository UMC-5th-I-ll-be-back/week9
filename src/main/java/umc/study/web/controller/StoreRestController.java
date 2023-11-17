package umc.study.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Store;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.RegionStoreResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.RegionStoreDTO request){
        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toRegionStoreResultDTO(store));
    }

    @GetMapping
    public ResponseEntity<?> getStoreList() {
        return new ResponseEntity<>(storeQueryService.getStoreList(), HttpStatus.FOUND);
    }

    @GetMapping("/{store_id}")
    public ResponseEntity<?> getStoreReviewList(@PathVariable Long store_id){
        return new ResponseEntity<>(storeQueryService.getStoreReviewList(store_id), HttpStatus.FOUND);
    }
}
