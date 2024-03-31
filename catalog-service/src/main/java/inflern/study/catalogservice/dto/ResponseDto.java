package inflern.study.catalogservice.dto;

import inflern.study.catalogservice.dto.vo.CatalogVo;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class ResponseCatalogDto {
        private final CatalogVo.CatalogItem catalog;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class ResponseCatalogsDto {
        private final List<CatalogVo.CatalogItem> catalogs;
    }
}
