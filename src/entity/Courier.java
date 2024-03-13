package entity;

public class Courier {
    private final Geo geo;

    public Courier(Geo geo) {
        this.geo = geo;
    }

    public Geo getGeo() {
        return geo;
    }
}
