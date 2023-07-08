package com.harshad.dto;

import com.harshad.model.Booking;

public class BookingDetailDao {
    private Booking booking;
    private String cancelUrl;

    BookingDetailDao() {}

    public BookingDetailDao(Booking booking, String cancelUrl) {
        this.booking = booking;
        this.cancelUrl = cancelUrl;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }
}
