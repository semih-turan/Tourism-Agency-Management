package entity;

public class Pansion {
    private int pansion_id;
    private String pansion_type;

    public Pansion(int pansion_id, int pansion_hotel_id, String pansion_type) {
        this.pansion_id = pansion_id;
        this.pansion_type = pansion_type;
    }

    public String getPansion_type() {
        return pansion_type;
    }

    public void setPansion_type(String pansion_type) {
        this.pansion_type = pansion_type;
    }

    public Pansion() {
    }

    public int getPansion_id() {
        return pansion_id;
    }

    public void setPansion_id(int pansion_id) {
        this.pansion_id = pansion_id;
    }

}
