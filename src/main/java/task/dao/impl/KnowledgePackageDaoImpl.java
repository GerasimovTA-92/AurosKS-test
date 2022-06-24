package task.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import task.dao.KnowledgePackageDao;
import task.model.KnowledgePackage;

@Repository
public class KnowledgePackageDaoImpl implements KnowledgePackageDao {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final JdbcTemplate jdbcTemplate;

    public KnowledgePackageDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public KnowledgePackage add(KnowledgePackage knowledgePackage) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into k_pacs (title, description, creation_date) values(?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement insertStatement = connection.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, knowledgePackage.getTitle());
            insertStatement.setString(2, knowledgePackage.getDescription());
            insertStatement.setString(3, FORMATTER.format(LocalDate.now()));
            return insertStatement;
        }, keyHolder);
        knowledgePackage.setId(keyHolder.getKey().longValue());
        return knowledgePackage;
    }

    @Override
    public List<KnowledgePackage> getAll() {
        return jdbcTemplate.query("select * from k_pacs",
                new BeanPropertyRowMapper<>(KnowledgePackage.class));
    }

    @Override
    public boolean delete(Long id) {
        jdbcTemplate.update("delete from k_pacs_sets_k_pacs where k_pac_id = ?", id);
        return jdbcTemplate.update("delete from k_pacs where id=?", id) > 0;
    }
}
