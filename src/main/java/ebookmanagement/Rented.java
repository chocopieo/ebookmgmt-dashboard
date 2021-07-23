package ebookmanagement;

import java.util.Date;

public class Rented extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long bookId;
    private String bookName;
    private Long rentalFee;
    private String status;
    private Date rentedDate;

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(Date rentedDate) {
        this.rentedDate = rentedDate;
    }
}