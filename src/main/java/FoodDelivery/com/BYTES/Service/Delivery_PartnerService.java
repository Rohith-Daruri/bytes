package FoodDelivery.com.BYTES.Service;

import FoodDelivery.com.BYTES.Repository.Delivery_PartnerRepository;
import FoodDelivery.com.BYTES.Transformers.DeliveryTransformer;
import FoodDelivery.com.BYTES.dto.request.Delivery_PartnerRequest;
import FoodDelivery.com.BYTES.dto.response.Delivery_Partner_Response;
import FoodDelivery.com.BYTES.model.Delivery_Partner;
import FoodDelivery.com.BYTES.model.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Delivery_PartnerService {
    @Autowired
    Delivery_PartnerRepository deliveryPartnerRepository;
    public Delivery_Partner_Response add_delivery_partner(Delivery_PartnerRequest deliveryPartnerRequest) {
        Delivery_Partner deliveryPartner = DeliveryTransformer.RequestToModel(deliveryPartnerRequest);
        List<OrderEntity> orderEntityList =new ArrayList<>();
        deliveryPartner.setOrderEntityList(orderEntityList);
        Delivery_Partner saved_delivery_partner = deliveryPartnerRepository.save(deliveryPartner);
        return DeliveryTransformer.ModelToResponse(saved_delivery_partner);
    }
}
