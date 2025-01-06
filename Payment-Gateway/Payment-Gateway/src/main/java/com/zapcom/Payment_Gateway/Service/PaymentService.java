package com.zapcom.Payment_Gateway.Service;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private RazorpayClient client;

    @Value("${razorpay.key.id}")
    private String key;

    @Value("${razorpay.secret.key}")
    private String secret;

//    public PaymentService(@Value("${razorpay.key.id}") String keyId,
//                          @Value("${razorpay.key.secret}") String keySecret) throws RazorpayException {
//        this.client = new RazorpayClient(keyId, keySecret);
//    }

    public Order createOrder(double amount) throws RazorpayException {
        JSONObject options = new JSONObject();
        options.put("amount", amount * 100); // Amount in paise
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        client=new RazorpayClient(key,secret);
        return client.orders.create(options);
    }
}
