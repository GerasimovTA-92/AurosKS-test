package task.controller;

import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import task.dto.request.KnowledgePackageRequestDto;
import task.service.KnowledgePackageService;
import task.service.mapper.KnowledgePackageDtoMapper;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageController {
    private final KnowledgePackageService knowledgePackageService;
    private final KnowledgePackageDtoMapper knowledgePackageDtoMapper;

    public KnowledgePackageController(KnowledgePackageService knowledgePackageService,
                                      KnowledgePackageDtoMapper knowledgePackageDtoMapper) {
        this.knowledgePackageService = knowledgePackageService;
        this.knowledgePackageDtoMapper = knowledgePackageDtoMapper;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("set", knowledgePackageService.getAll().stream()
                .map(knowledgePackageDtoMapper::toDto)
                .collect(Collectors.toList()));
        return "pack";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        knowledgePackageService.delete(id);
        return "redirect: /kpacs";
    }

    @GetMapping ("/add")
    public String add() {
        return "addPac";
    }

    @PostMapping("/add")
    public void addPac(@Valid KnowledgePackageRequestDto requestDto) {
        knowledgePackageService.add(knowledgePackageDtoMapper.toModel(requestDto));
    }
}
