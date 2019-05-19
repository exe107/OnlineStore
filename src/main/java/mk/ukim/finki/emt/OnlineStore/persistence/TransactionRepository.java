package mk.ukim.finki.emt.OnlineStore.persistence;

import mk.ukim.finki.emt.OnlineStore.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
