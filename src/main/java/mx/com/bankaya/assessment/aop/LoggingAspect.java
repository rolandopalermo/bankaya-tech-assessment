package mx.com.bankaya.assessment.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bankaya.assessment.service.AuditLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final AuditLogService auditLogService;


    @Before("execution(public * mx.com.bankaya.assessment.web.soap..*(..))")
    public void soapEndpoints(JoinPoint joinPoint) {
        auditLogService.save(joinPoint);
    }

}
