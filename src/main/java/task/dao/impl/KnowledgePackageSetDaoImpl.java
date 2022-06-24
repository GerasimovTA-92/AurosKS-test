package task.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import task.dao.KnowledgePackageSetDao;
import task.model.KnowledgePackage;
import task.model.KnowledgePackageSet;

@Repository
public class KnowledgePackageSetDaoImpl implements KnowledgePackageSetDao {
    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageSetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KnowledgePackageSet add(KnowledgePackageSet knowledgePackageSet) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into k_pacs_sets (title) values(?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement insertStatement = connection.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, knowledgePackageSet.getTitle());
            return insertStatement;
        }, keyHolder);
        knowledgePackageSet.setId(keyHolder.getKey().longValue());
        if (knowledgePackageSet.getPacs() != null) {
            insertAllKPacs(knowledgePackageSet);
        }
        return knowledgePackageSet;
    }

    @Override
    public List<KnowledgePackageSet> getAll() {
        List<KnowledgePackageSet> list = jdbcTemplate.query("select * from k_pacs_sets",
                new BeanPropertyRowMapper<>(KnowledgePackageSet.class));
        list.forEach(e -> e.setPacs(getKPacs(e.getId())));
        return list;
    }

    @Override
    public boolean delete(Long id) {
        jdbcTemplate.update("delete from k_pacs_sets_k_pacs where k_pacs_set_id = ?", id);
        return jdbcTemplate.update("delete from k_pacs_sets where id = ?", id) > 0;
    }

    @Override
    public List<KnowledgePackage> getKnowledgePackages(Long id) {
        return getKPacs(id);
    }

    @Override
    public void addKnowledgePackage(Long setId, Long packageId) {
        jdbcTemplate.update("insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(?, ?)",
                setId, packageId);
    }

    private List<KnowledgePackage> getKPacs(Long setId) {
        String query = "select * from k_pacs kp "
                + "right join k_pacs_sets_k_pacs kps on kp.id = kps.k_pac_id "
                + "where kps.k_pacs_set_id = ?";
        return jdbcTemplate.query(query, new Object[] {setId},
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    private void insertAllKPacs(KnowledgePackageSet set) {
        String query = "insert into k_pacs_sets_k_pacs (k_pacs_set_id, k_pac_id) values(?, ?)";
        for (var knowledgePackage : set.getPacs()) {
            jdbcTemplate.update(query, set.getId(), knowledgePackage.getId());
        }
    }
}
