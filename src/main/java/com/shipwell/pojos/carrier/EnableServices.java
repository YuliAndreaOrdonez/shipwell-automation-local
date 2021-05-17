package com.shipwell.pojos.carrier;

public class EnableServices {
    private boolean rating;
    private boolean booking;
    private boolean tracking;
    private boolean imaging;

    public boolean isRating() {
        return rating;
    }

    public EnableServices setRating(boolean rating) {
        this.rating = rating;
        return this;
    }

    public boolean isBooking() {
        return booking;
    }

    public EnableServices setBooking(boolean booking) {
        this.booking = booking;
        return this;
    }

    public boolean isTracking() {
        return tracking;

    }

    public EnableServices setTracking(boolean tracking) {
        this.tracking = tracking;
        return this;
    }

    public boolean isImaging() {
        return imaging;
    }

    public EnableServices setImaging(boolean imaging) {
        this.imaging = imaging;
        return this;
    }
}
