package mx.com.bankaya.assessment.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final HttpServletRequest httpServletRequest;

    @Before("execution(public * mx.com.bankaya.assessment.web.soap..*(..))")
    public void soapEndpoints(JoinPoint joinPoint) {
        log.info("Executed method: {}", joinPoint.getSignature().getName());
        log.info("IP Address: {}", this.httpServletRequest.getRemoteAddr());
    }

}
