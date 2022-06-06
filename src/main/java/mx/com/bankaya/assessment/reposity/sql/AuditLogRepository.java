package mx.com.bankaya.assessment.reposity.sql;

import mx.com.bankaya.assessment.reposity.sql.entities.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
