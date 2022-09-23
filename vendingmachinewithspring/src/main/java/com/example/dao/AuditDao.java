package com.example.dao;

public interface AuditDao {

    public void writeAuditEntry(String entry) throws PersistenceException;

}
