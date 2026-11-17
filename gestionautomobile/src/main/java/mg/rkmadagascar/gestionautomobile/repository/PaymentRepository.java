package mg.rkmadagascar.gestionautomobile.repository;

import mg.rkmadagascar.gestionautomobile.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    List<Payment> findBySaleId(String saleId);
    List<Payment> findByPaymentStatusId(String paymentStatusId);
    List<Payment> findByPaymentCategoryId(String paymentCategoryId);
}
