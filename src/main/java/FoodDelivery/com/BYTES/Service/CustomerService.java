package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Enum.Gender;
import FoodDelivery.com.BYTES.Exception.GenderException;
import FoodDelivery.com.BYTES.Repository.CustomerRepository;
import FoodDelivery.com.BYTES.Transformers.CustomerTransformer;
import FoodDelivery.com.BYTES.dto.request.CustomerRequest;
import FoodDelivery.com.BYTES.dto.response.CustomerResponse;
import FoodDelivery.com.BYTES.model.Cart;
import FoodDelivery.com.BYTES.model.Customer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) throws MessagingException {
            Customer customer  = CustomerTransformer.RequestToModel(customerRequest);
            Cart cart = Cart.builder()
                    .cart_total(0)
                    .customer(customer)
                    .build();
            customer.setCart(cart);
            Customer savedcustomer = customerRepository.save(customer);
            String text = "Dear "+savedcustomer.getName()+", "+"\n"+"\n"+"Your Account has been Created Successfully.\n"+"\n"+"Thanks for choosing  BYTES.We would love to serving you."+"\n"+"\n"+"Please find your Details below.\n"+"\n"+"Email: "+savedcustomer.getEmail()+"\n"+"Location: "+savedcustomer.getCountry()+"\n"+"\n"+"Have a great day ahead!!!"+"\n"+"\n"+"Regards,\n"+"Bytes, India.\n"+"Phone:- 8296431478\n"+"\n"+"www.bytes.com";
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("acciospringtest@gmail.com");
        mimeMessageHelper.setTo(savedcustomer.getEmail());
        mimeMessageHelper.setSubject("Congratulations!!!! Registration Done");
        mimeMessageHelper.setText(text);
        String attachment = "C:\\Users\\RD\\Desktop\\RD-Aster.pdf";
        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
        javaMailSender.send(mimeMessage);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("acciospringtest@gmail.com");
        simpleMailMessage.setTo(savedcustomer.getEmail());
        simpleMailMessage.setSubject("Account Created!!! TAKE a BYTE Break!!!");
        simpleMailMessage.setText(text);
            CustomerResponse customerResponse = CustomerTransformer.ModelToResponse(savedcustomer);
            return customerResponse;

    }

    public List<CustomerResponse> getByGender(Gender gender) {
        List<Customer> customer = customerRepository.findByGender(gender);
        if(customer.equals(null)){
            throw new GenderException("Gender Not Found");
        }
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer c:customer){
            CustomerResponse customerResponse = CustomerTransformer.ModelToResponse(c);
            customerResponses.add(customerResponse);
        }
        return customerResponses;
    }
    public final int print(int a ,int b) {
        return  a+b;
    }
}
