package inflern.study.catalogservice.controller;

import inflern.study.catalogservice.dto.ResponseDto;
import inflern.study.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<ResponseDto.ResponseCatalogsDto> getCatalogs() {
        ResponseDto.ResponseCatalogsDto response = this.catalogService.getAllCatalogs();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
