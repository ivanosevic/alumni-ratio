package edu.pucmm.eict.accounts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.*;

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

    public static boolean isContraAccount(Integer accountType) {
        int firstDigit = Integer.parseInt(Integer.toString(accountType).substring(0, 1));
        return firstDigit == 2 || firstDigit == 4 || firstDigit == 3;
    }

    public static String getAccountName(Integer accountType) {
        Map<Integer, String> accountNameMap = new HashMap<>();
        accountNameMap.put(CASH, "Efectivo");
        accountNameMap.put(OFFICE_SUPPLIES, "Materiales de oficina");
        accountNameMap.put(OFFICE_EQUIPMENT, "Equipos de oficina");
        accountNameMap.put(LANDS, "Terrenos");
        accountNameMap.put(CUSTOMERS, "Clientes");
        accountNameMap.put(NOTES_PAYABLES, "Documentos por pagar");
        accountNameMap.put(ACCOUNTS_PAYABLES, "Cuentas por pagar");
        accountNameMap.put(COMPANY_CAPITAL, "Capital");
        accountNameMap.put(SERVICES_REVENUES, "Ingresos por servicio");
        accountNameMap.put(WAGES_EXPENSES, "Gastos sueldos");
        accountNameMap.put(RENT_EXPENSES, "Gastos renta");
        accountNameMap.put(PUBLIC_SERVICES_EXPENSES, "Gastos servicios públicos");
        return accountNameMap.get(accountType);
    }
}
