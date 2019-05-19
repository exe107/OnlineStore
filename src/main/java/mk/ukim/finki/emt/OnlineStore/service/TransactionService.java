package mk.ukim.finki.emt.OnlineStore.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import mk.ukim.finki.emt.OnlineStore.model.Transaction;

import java.util.List;

public interface TransactionService {

    Charge charge(Transaction transaction) throws StripeException;

    List<Transaction> getTransactions();
}
