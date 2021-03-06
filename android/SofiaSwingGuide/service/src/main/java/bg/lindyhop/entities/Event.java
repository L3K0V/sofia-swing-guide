package bg.lindyhop.entities;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "EVENT".
 */
public class Event {

    private Long localId;
    private Long serverId;
    private java.util.Date createdAt;
    private java.util.Date updatedAt;
    private String name;
    private String description;
    private String country;
    private String city;
    private java.util.Date fromDate;
    private java.util.Date toDate;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Event() {
    }

    public Event(Long localId) {
        this.localId = localId;
    }

    public Event(Long localId, Long serverId, java.util.Date createdAt, java.util.Date updatedAt, String name, String description, String country, String city, java.util.Date fromDate, java.util.Date toDate) {
        this.localId = localId;
        this.serverId = serverId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.description = description;
        this.country = country;
        this.city = city;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public java.util.Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(java.util.Date fromDate) {
        this.fromDate = fromDate;
    }

    public java.util.Date getToDate() {
        return toDate;
    }

    public void setToDate(java.util.Date toDate) {
        this.toDate = toDate;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
