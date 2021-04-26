package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    //Arrange
    private MenuRepository menuRepo= new MenuRepository();
    private PaymentRepository payRepo = new PaymentRepository();
    private Service service =new Service(menuRepo,payRepo);

    //valid
    @Test
            void testValid(){
    assert(service.getTotalAmount(PaymentType.Card)==292.25);

    }

    @Test
    void testInvalid(){
        payRepo.setPayments();
        assert(service.getTotalAmount(PaymentType.Card)==0);
    }

    @Test
    void testEmpty(){
        payRepo.setEmpty();
        assert(service.getTotalAmount(PaymentType.Card)==0);
    }

    @Test

    void testPaymentTypeInexistent(){
        payRepo.deleteCard();
        assert(service.getTotalAmount(PaymentType.Card)==0);
    }

}