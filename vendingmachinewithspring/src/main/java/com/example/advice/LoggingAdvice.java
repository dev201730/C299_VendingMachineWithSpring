package com.example.advice;

import com.example.dao.AuditDao;
import com.example.dao.PersistenceException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {

    AuditDao auditDao;

    public LoggingAdvice(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Throwable ex) {

        String auditEntry;
        auditEntry = ex.getClass().toString();
        auditEntry += ex.getMessage();
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (PersistenceException e) {
            System.err.println("ERROR: could not create audit entry in Logging Advice.");
        }
    }

}
