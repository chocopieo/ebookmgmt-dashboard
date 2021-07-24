package ebookmanagement;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Dashboard_table")
public class Dashboard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long userId;
        private Long bookId;
        private String bookName;
        private Long rentalFee;
        private Date rentedDate;
        private Date paidDate;
        private Date returnedDate;
        private Date approvedDate;
        private String status;
        private Date canceledDate;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
        public Long getBookId() {
            return bookId;
        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }
        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public Long getRentalFee() {
            return rentalFee;
        }

        public void setRentalFee(Long rentalFee) {
            this.rentalFee = rentalFee;
        }
        public Date getRentedDate() {
            return rentedDate;
        }

        public void setRentedDate(Date rentedDate) {
            this.rentedDate = rentedDate;
        }
        public Date getPaidDate() {
            return paidDate;
        }

        public void setPaidDate(Date paidDate) {
            this.paidDate = paidDate;
        }
        public Date getReturnedDate() {
            return returnedDate;
        }

        public void setReturnedDate(Date returnedDate) {
            this.returnedDate = returnedDate;
        }
        public Date getApprovedDate() {
            return approvedDate;
        }

        public void setApprovedDate(Date approvedDate) {
            this.approvedDate = approvedDate;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public Date getCanceledDate() {
            return canceledDate;
        }

        public void setCanceledDate(Date canceledDate) {
            this.canceledDate = canceledDate;
        }

}
