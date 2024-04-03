package inflern.study.catalogservice.service.impl;

import inflern.study.catalogservice.dto.ResponseDto;
import inflern.study.catalogservice.dto.vo.CatalogVo;
import inflern.study.catalogservice.model.mapper.CatalogMapper;
import inflern.study.catalogservice.repository.CatalogRepository;
import inflern.study.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseCatalogsDto getAllCatalogs() {
        List<CatalogVo.CatalogItem> catalogItems = this.catalogRepository.findAll()
                .stream()
                .map(this.catalogMapper::CatalogEntityToMap)
                .toList();

        return ResponseDto.ResponseCatalogsDto.builder()
                .catalogs(catalogItems)
                .build();
    }
}
