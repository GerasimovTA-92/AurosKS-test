package task.dao;

import java.util.List;
import task.model.KnowledgePackage;
import task.model.KnowledgePackageSet;

public interface KnowledgePackageSetDao {
    KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet);

    List<KnowledgePackageSet> getAll();

    boolean delete(Long id);

    List<KnowledgePackage> getKnowledgePackages(Long id);

    void addKnowledgePackage(Long setId, Long packageId);
}
