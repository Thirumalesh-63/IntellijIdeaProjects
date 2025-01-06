package com.zapcom.Payment_Gateway.Controller;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.zapcom.Payment_Gateway.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment")
    public ModelAndView showPaymentPage() throws RazorpayException {
        ModelAndView modelAndView = new ModelAndView("payment");
        return modelAndView;
    }
    @GetMapping("/payment/{amount}/{email}")
    public String showPaymentPage(@PathVariable double amount, @PathVariable String email) throws RazorpayException {
        Order order = paymentService.createOrder(amount);
        return order.get("id");
    }

}
