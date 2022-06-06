package mx.com.bankaya.assessment.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bankaya.assessment.reposity.sql.AuditLogRepository;
import mx.com.bankaya.assessment.reposity.sql.entities.AuditLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final HttpServletRequest httpServletRequest;
    private final AuditLogRepository auditLogRepository;

    @Before("execution(public * mx.com.bankaya.assessment.web.soap..*(..))")
    public void soapEndpoints(JoinPoint joinPoint) {
        saveAuditLog(joinPoint);
    }

    private void saveAuditLog(JoinPoint joinPoint) {
        AuditLog auditLog = new AuditLog();
        auditLog.setMethod(joinPoint.getSignature().getName());
        auditLog.setRemoteIpAddress(this.httpServletRequest.getRemoteAddr());
        auditLog.setCreationDate(LocalDateTime.now());
        auditLogRepository.save(auditLog);
    }

}
