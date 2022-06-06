package mx.com.bankaya.assessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bankaya.assessment.reposity.sql.AuditLogRepository;
import mx.com.bankaya.assessment.reposity.sql.entities.AuditLog;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final HttpServletRequest httpServletRequest;
    private final AuditLogRepository auditLogRepository;

    public AuditLog save(JoinPoint joinPoint) {
        AuditLog auditLog = new AuditLog();
        auditLog.setMethod(joinPoint.getSignature().getName());
        auditLog.setRemoteIpAddress(this.httpServletRequest.getRemoteAddr());
        auditLog.setCreationDate(LocalDateTime.now());
        auditLogRepository.save(auditLog);
        log.info("New audit log record has been created with data: {}", auditLog);
        return auditLog;
    }

}
