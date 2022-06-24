package task.controller;

import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import task.service.KnowledgePackageSetService;
import task.service.mapper.KnowledgePackageDtoMapper;

@Controller
public class KnowledgePackageBySetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageBySetController(KnowledgePackageSetService knowledgePackageSetService,
                                           KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @GetMapping("/set/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("set", knowledgePackageSetService.getKnowledgePackages(id).stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList()));
        return "pack";
    }
}
