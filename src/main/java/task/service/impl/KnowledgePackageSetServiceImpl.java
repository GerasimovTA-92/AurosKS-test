package task.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import task.dao.KnowledgePackageSetDao;
import task.model.KnowledgePackage;
import task.model.KnowledgePackageSet;
import task.service.KnowledgePackageSetService;

@Service
public class KnowledgePackageSetServiceImpl implements KnowledgePackageSetService {
    private final KnowledgePackageSetDao dao;

    public KnowledgePackageSetServiceImpl(KnowledgePackageSetDao dao) {
        this.dao = dao;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet set) {
        return dao.add(set);
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<KnowledgePackage> getKnowledgePackages(Long id) {
        return dao.getKnowledgePackages(id);
    }

    @Override
    public void addKnowledgePackage(Long setId, Long pacId) {
        dao.addKnowledgePackage(setId, pacId);
    }
}
