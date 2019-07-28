package com.hepexta.lessons.hibernatelessons.data.entities;

import com.hepexta.lessons.hibernatelessons.EntityChecker;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class JoinTableTest extends EntityChecker {

    @Test
    public void test_saveBudget() {
        org.hibernate.Transaction transaction = session.beginTransaction();

        /** Create an account and use that account to create two transactions and we are putting those transactions
         *  within the transactions composed within the BudgetJoinTable entity. All this should persist. */
        Account account = createNewAccount();

        Budget budget = new Budget();
        budget.setGoalAmount(new BigDecimal("10000.00"));
        budget.setName("Emergency Fund");
        budget.setPeriod("Yearly");

        budget.getTransactions().add(createNewBeltPurchase(account));
        budget.getTransactions().add(createShoePurchase(account));

        session.save(account);
        session.save(budget);
        transaction.commit();
    }

    private static Transaction createNewBeltPurchase(Account account) {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Transaction createShoePurchase(Account account) {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings AccountHibernateAPI");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }

}
