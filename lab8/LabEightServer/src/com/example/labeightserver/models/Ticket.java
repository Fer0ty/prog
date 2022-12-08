package com.example.labeightserver.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Ticket implements Serializable {
    private Long id; // unique default
    private String name;
    private Float coordinateX;
    private Integer coordinateY;
    private Date creationDate;
    private Float price;// can null, >0
    private TicketType type; // can null
    private String venueName; // can null
    private Long venueCapacity; // can null
    private String author;

    public Ticket() {}

    public Ticket(Long id, String name, Float coordinateX, Integer coordinateY, Long creationDate, Float price,
                  String type, String author) {
        this(name, coordinateX, coordinateY, creationDate, price, type, author);
        this.id = id;
    }
    public Ticket(String name, Float coordinateX, Integer coordinateY, Long creationDate, Float price,
                  String type, String author) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.creationDate = new Date(creationDate);
        this.price = price;
        this.type = type == null ? null : TicketType.valueOf(type);
        this.author = author;
    }

    public Ticket(Long id, String name, Float coordinateX, Integer coordinateY, Long creationDate, Float price,
                  String type, String venueName, Long venueCapacity, String author) {
        this(name, coordinateX, coordinateY, creationDate, price, type, venueName, venueCapacity, author);
        this.id = id;
    }

    public Ticket(String name, Float coordinateX, Integer coordinateY, Long creationDate, Float price,
                  String type, String venueName, Long venueCapacity, String author) {
        this(name, coordinateX, coordinateY, creationDate, price, type, author);
        if (venueName != null && venueCapacity != null) {
            this.venueName = venueName;
            this.venueCapacity = venueCapacity;
        }
    }

    public Ticket(String name, String coordinateX, String coordinateY, String price,
                  TicketType type, String venueName, String venueCapacity, String author) {
        this.name = name;
        this.coordinateX = Float.parseFloat(coordinateX);
        this.coordinateY = Integer.parseInt(coordinateY);
        this.creationDate = new Date();
        this.price = Float.parseFloat(price);
        this.type = type;
        if (!venueName.isEmpty() && !venueCapacity.isEmpty()) {
            this.venueName = venueName;
            this.venueCapacity = Long.parseLong(venueCapacity);
        }
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getPrice() {
        return price;
    }

    public TicketType getType() {
        return type;
    }

    public String getVenueName() {
        return venueName;
    }

    public Long getVenueCapacity() {
        return venueCapacity;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venueName, Long venueCapacity) {
        this.venueName = venueName;
        this.venueCapacity = venueCapacity;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public void setCoordinates(Float coordinateX, Integer coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate == null) {
            creationDate = new Date();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
