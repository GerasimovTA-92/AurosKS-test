package task.controller;

import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.dto.request.KPacKSetDto;
import task.dto.request.KnowledgePackageSetRequestDto;
import task.service.KnowledgePackageService;
import task.service.KnowledgePackageSetService;
import task.service.mapper.KnowledgePackageDtoMapper;
import task.service.mapper.KnowledgePackageSetDtoMapper;

@Controller
@RequestMapping("/sets")
public class KnowledgePackageSetController {
    private final KnowledgePackageSetService knowledgePackageSetService;
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageDtoMapper knowledgePackageMapper;
    private final KnowledgePackageSetDtoMapper knowledgePackageSetMapper;

    public KnowledgePackageSetController(KnowledgePackageSetService knowledgePackageSetService,
                                         KnowledgePackageService knowledgePackageService,
                                         KnowledgePackageDtoMapper knowledgePackageDtoMapper,
                                         KnowledgePackageSetDtoMapper knowledgePackageSetMapper) {
        this.knowledgePackageSetService = knowledgePackageSetService;
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageMapper = knowledgePackageDtoMapper;
        this.knowledgePackageSetMapper = knowledgePackageSetMapper;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("sets", knowledgePackageSetService.getAll().stream()
                .map(knowledgePackageSetMapper::toDto)
                .collect(Collectors.toList()));
        return "set";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageSetService.delete(id);
        return "redirect: /sets";
    }

    @GetMapping("/kpacs/add")
    public String addPacFrom() {
        return "addPacToSet";
    }

    @PostMapping("/kpacs/add")
    public void addPac(@Valid KPacKSetDto dto) {
        knowledgePackageSetService.addKnowledgePackage(dto.getSetId(), dto.getPacId());
    }

    @GetMapping("/add")
    public String addSetForm() {
        return "addSet";
    }

    @PostMapping("/add")
    public void addSet(@Valid KnowledgePackageSetRequestDto requestDto) {
        knowledgePackageSetService.add(knowledgePackageSetMapper.toModel(requestDto));
    }
}
