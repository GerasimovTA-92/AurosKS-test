package task.service;

import java.util.List;
import task.model.KnowledgePackage;

public interface KnowledgePackageService {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> getAll();

    boolean delete(Long id);
}
