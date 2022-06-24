package task.service.mapper;

import org.springframework.stereotype.Service;
import task.dto.request.KnowledgePackageRequestDto;
import task.dto.response.KnowledgePackageResponseDto;
import task.model.KnowledgePackage;

@Service
public class KnowledgePackageDtoMapper {
    public KnowledgePackageResponseDto toDto(KnowledgePackage knowledgePackage) {
        KnowledgePackageResponseDto dto = new KnowledgePackageResponseDto();
        dto.setId(knowledgePackage.getId());
        dto.setDescription(knowledgePackage.getDescription());
        dto.setTitle(knowledgePackage.getTitle());
        dto.setCreationDate(knowledgePackage.getCreationDate());
        return dto;
    }

    public KnowledgePackage toModel(KnowledgePackageRequestDto dto) {
        KnowledgePackage model = new KnowledgePackage();
        model.setDescription(dto.getDescription());
        model.setTitle(dto.getTitle());
        return model;
    }
}
