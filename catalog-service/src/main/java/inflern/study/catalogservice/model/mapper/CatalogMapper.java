package inflern.study.catalogservice.model.mapper;

import inflern.study.catalogservice.dto.vo.CatalogVo;
import inflern.study.catalogservice.model.entity.Catalog;
import org.springframework.stereotype.Component;

@Component
public class CatalogMapper {

    public CatalogVo.CatalogItem CatalogEntityToMap(Catalog catalog) {
        return CatalogVo.CatalogItem.builder()
                .productId(catalog.getProductId())
                .productName(catalog.getProductName())
                .unitPrice(catalog.getUnitPrice())
                .stock(catalog.getStock())
                .createdAt(catalog.getCreatedAt())
                .build();
    }
}
