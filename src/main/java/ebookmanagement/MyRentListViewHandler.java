package ebookmanagement;

import ebookmanagement.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyRentListViewHandler {

    @Autowired
    private MyRentListRepository myRentListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRented_then_CREATE_1 (@Payload Rented rented) {
        try {

            if (!rented.validate()) return;

            // view 객체 생성
            MyRentList myRentList = new MyRentList();
            // view 객체에 이벤트의 Value 를 set 함
            myRentList.setId(rented.getId());
            myRentList.setUserId(rented.getUserId());
            myRentList.setBookId(rented.getBookId());
            myRentList.setBookName(rented.getBookName());
            myRentList.setRentalFee(rented.getRentalFee());
            myRentList.setRentedDate(rented.getRentedDate());
            myRentList.setStatus(rented.getStatus());
            // view 레파지 토리에 save
            myRentListRepository.save(myRentList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_1(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
            // view 객체 조회
            Optional<MyRentList> myRentListOptional = myRentListRepository.findById(paid.getRentId());

            if( myRentListOptional.isPresent()) {
                MyRentList myRentList = myRentListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myRentList.setPaidDate(paid.getPaidDate());
                myRentList.setStatus(paid.getStatus());
                myRentList.setRentalFee(paid.getRentalFee());
                // view 레파지 토리에 save
                myRentListRepository.save(myRentList);
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
            Optional<MyRentList> myRentListOptional = myRentListRepository.findById(approved.getRentId());

            if( myRentListOptional.isPresent()) {
                MyRentList myRentList = myRentListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myRentList.setApprovedDate(approved.getApprovedDate());
                myRentList.setStatus(approved.getStatus());
                // view 레파지 토리에 save
                myRentListRepository.save(myRentList);
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
            Optional<MyRentList> myRentListOptional = myRentListRepository.findById(returned.getId());

            if( myRentListOptional.isPresent()) {
                MyRentList myRentList = myRentListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myRentList.setReturnedDate(returned.getReturnedDate());
                myRentList.setStatus(returned.getStatus());
                // view 레파지 토리에 save
                myRentListRepository.save(myRentList);
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
            Optional<MyRentList> myRentListOptional = myRentListRepository.findById(canceled.getId());

            if( myRentListOptional.isPresent()) {
                MyRentList myRentList = myRentListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myRentList.setStatus(canceled.getStatus());
                myRentList.setCanceledDate(canceled.getCanceledDate());
                // view 레파지 토리에 save
                myRentListRepository.save(myRentList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

