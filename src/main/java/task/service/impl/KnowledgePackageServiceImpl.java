package task.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import task.dao.KnowledgePackageDao;
import task.model.KnowledgePackage;
import task.service.KnowledgePackageService;

@Service
public class KnowledgePackageServiceImpl implements KnowledgePackageService {
    private final KnowledgePackageDao dao;

    public KnowledgePackageServiceImpl(KnowledgePackageDao dao) {
        this.dao = dao;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        return dao.add(knowledgePackage);
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
