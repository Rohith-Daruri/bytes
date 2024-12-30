package FoodDelivery.com.BYTES.Transformers;

import FoodDelivery.com.BYTES.dto.request.Delivery_PartnerRequest;
import FoodDelivery.com.BYTES.dto.response.Delivery_Partner_Response;
import FoodDelivery.com.BYTES.model.Delivery_Partner;

public class DeliveryTransformer {
    public static Delivery_Partner RequestToModel(Delivery_PartnerRequest deliveryPartnerRequest){
        return Delivery_Partner.builder()
                .age(deliveryPartnerRequest.getAge())
                .name(deliveryPartnerRequest.getName())
                .gender(deliveryPartnerRequest.getGender())
                .vehicle_no(deliveryPartnerRequest.getVehicle_no())
                .phone_no(deliveryPartnerRequest.getPhone_no())
                .build();
    }
    public static Delivery_Partner_Response ModelToResponse(Delivery_Partner deliveryPartner){
        return Delivery_Partner_Response.builder()
                .name(deliveryPartner.getName())
                .vehicleNo(deliveryPartner.getVehicle_no())
                .build();
    }
}
