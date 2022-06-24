package task.service;

import java.util.List;
import task.model.KnowledgePackage;
import task.model.KnowledgePackageSet;

public interface KnowledgePackageSetService {
    KnowledgePackageSet add(KnowledgePackageSet set);

    List<KnowledgePackageSet> getAll();

    boolean delete(Long id);

    List<KnowledgePackage> getKnowledgePackages(Long id);

    void addKnowledgePackage(Long setId, Long pacId);
}
