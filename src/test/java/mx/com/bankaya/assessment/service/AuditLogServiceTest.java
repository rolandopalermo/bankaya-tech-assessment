package mx.com.bankaya.assessment.service;

import lombok.val;
import mx.com.bankaya.assessment.reposity.sql.AuditLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuditLogServiceTest {

    @Mock
    HttpServletRequest httpServletRequest;

    @Mock
    AuditLogRepository auditLogRepository;

    @InjectMocks
    AuditLogService auditLogService;

    @Test
    void contextLoads() {
        assertNotNull(auditLogService);
    }

    @Test
    void given_ValidMethodName_whenSave_thenSuccess() {
        val result = auditLogService.save("auditLogServiceTest");
        verify(auditLogRepository).save(any());
        assertNotNull(result);
    }

}
