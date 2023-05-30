package com.financy.FinancyAPI.model;

import java.sql.Timestamp;

public interface Finances {
    Long id = null;
    Long finances_type_id = null;
    Long user_id = null;
    Timestamp timestamp = null;
    String name = null;
    Double exchange = null;
    String comment = null;
}
