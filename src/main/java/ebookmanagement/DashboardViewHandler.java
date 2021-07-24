package ebookmanagement;

import ebookmanagement.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_CREATE_1 (@Payload Rented rented) {
        try {

            if (!rented.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setId(rented.getId());
            dashboard.setUserId(rented.getUserId());
            dashboard.setBookId(rented.getBookId());
            dashboard.setBookName(rented.getBookName());
            dashboard.setRentalFee(rented.getRentalFee());
            dashboard.setRentedDate(rented.getRentedDate());
            dashboard.setStatus(rented.getStatus());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(paid.getRentId());

            if( dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setPaidDate(paid.getPaidDate());
                dashboard.setStatus(paid.getStatus());
                dashboard.setRentalFee(paid.getRentalFee());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenApproved_then_UPDATE_2(@Payload Approved approved) {
        try {
            if (!approved.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(approved.getRentId());

            if( dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setApprovedDate(approved.getApprovedDate());
                dashboard.setRentedDate(approved.getApprovedDate());
                dashboard.setStatus(approved.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_3(@Payload Returned returned) {
        try {
            if (!returned.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(returned.getId());

            if( dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setReturnedDate(returned.getReturnedDate());
                dashboard.setStatus(returned.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_4(@Payload Canceled canceled) {
        try {
            if (!canceled.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findById(canceled.getId());

            if( dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(canceled.getStatus());
                dashboard.setCanceledDate(canceled.getCanceledDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

