package task.dao;

import java.util.List;
import task.model.KnowledgePackage;

public interface KnowledgePackageDao {
    KnowledgePackage add(KnowledgePackage knowledgePackage);

    List<KnowledgePackage> getAll();

    boolean delete(Long id);
}
