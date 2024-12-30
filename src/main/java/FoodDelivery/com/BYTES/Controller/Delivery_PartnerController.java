package FoodDelivery.com.BYTES.Controller;

import FoodDelivery.com.BYTES.Service.Delivery_PartnerService;
import FoodDelivery.com.BYTES.dto.request.Delivery_PartnerRequest;
import FoodDelivery.com.BYTES.dto.response.Delivery_Partner_Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery_partner")
public class Delivery_PartnerController {
    @Autowired
    final Delivery_PartnerService deliveryPartnerService;

    public Delivery_PartnerController(Delivery_PartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }

    @PostMapping("/add/partner")
    public ResponseEntity add_delivery_partner(@RequestBody Delivery_PartnerRequest deliveryPartnerRequest){
        Delivery_Partner_Response delivery_partnerResponse = deliveryPartnerService.add_delivery_partner(deliveryPartnerRequest);
        return new ResponseEntity(delivery_partnerResponse, HttpStatus.CREATED);
    }
}
