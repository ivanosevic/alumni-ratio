package edu.pucmm.eict.accounts;

import java.util.List;

public class AccountBook {

    public static Integer CASH = 101;
    public static Integer OFFICE_SUPPLIES = 102;
    public static Integer OFFICE_EQUIPMENT = 103;
    public static Integer LANDS = 104;
    public static Integer CUSTOMERS = 105;
    public static Integer NOTES_PAYABLES = 201;
    public static Integer ACCOUNTS_PAYABLES = 202;
    public static Integer COMPANY_CAPITAL = 301;
    public static Integer SERVICES_REVENUES = 401;
    public static Integer WAGES_EXPENSES = 601;
    public static Integer RENT_EXPENSES = 602;
    public static Integer PUBLIC_SERVICES_EXPENSES = 603;

    public static List<Integer> ALL_ACCOUNTS = List.of(CASH, OFFICE_SUPPLIES, OFFICE_EQUIPMENT, LANDS, CUSTOMERS, NOTES_PAYABLES, ACCOUNTS_PAYABLES,
            COMPANY_CAPITAL, SERVICES_REVENUES, WAGES_EXPENSES, RENT_EXPENSES, PUBLIC_SERVICES_EXPENSES);
}
