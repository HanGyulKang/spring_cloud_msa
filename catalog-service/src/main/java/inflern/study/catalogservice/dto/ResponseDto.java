package inflern.study.catalogservice.dto;

import inflern.study.catalogservice.dto.vo.CatalogVo;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CatalogResponseDto {
        private final CatalogVo.CatalogItem catalog;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CatalogsResponseDto {
        private final List<CatalogVo.CatalogItem> catalogs;
    }
}
