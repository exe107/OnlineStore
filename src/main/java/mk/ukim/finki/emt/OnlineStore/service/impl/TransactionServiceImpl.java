package mk.ukim.finki.emt.OnlineStore.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import mk.ukim.finki.emt.OnlineStore.model.Transaction;
import mk.ukim.finki.emt.OnlineStore.persistence.TransactionRepository;
import mk.ukim.finki.emt.OnlineStore.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    @Override
    public Charge charge(Transaction transaction) throws StripeException {

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("source", transaction.getStripeToken());
        chargeParams.put("amount", transaction.getAmount());
        chargeParams.put("currency", "USD");
        Charge charge = Charge.create(chargeParams);

        transactionRepository.save(transaction);

        return charge;
    }

    @Override
    public List<Transaction> getTransactions() {

        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);

        return transactions;
    }
}
