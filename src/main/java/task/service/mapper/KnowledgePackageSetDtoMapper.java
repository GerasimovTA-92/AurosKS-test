package task.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import task.dto.request.KnowledgePackageSetRequestDto;
import task.dto.response.KnowledgePackageSetResponseDto;
import task.model.KnowledgePackageSet;

@Service
public class KnowledgePackageSetDtoMapper {
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageSetDtoMapper(KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    public KnowledgePackageSetResponseDto toDto(KnowledgePackageSet knowledgePackageSet) {
        KnowledgePackageSetResponseDto dto = new KnowledgePackageSetResponseDto();
        dto.setId(knowledgePackageSet.getId());
        dto.setPacs(knowledgePackageSet.getPacs().stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList()));
        dto.setTitle(knowledgePackageSet.getTitle());
        return dto;
    }

    public KnowledgePackageSet toModel(KnowledgePackageSetRequestDto dto) {
        KnowledgePackageSet set = new KnowledgePackageSet();
        set.setTitle(dto.getTitle());
        return set;
    }
}
