package by.antonov.shapes.entity;

public abstract class Shape {
    private long id;
    private Point point;

    public Shape(long id, Point point) {
        this.id = id;
        this.point = point;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;

        Cube cube = (Cube) o;
        return getId() == cube.getId()
                && getPoint() != null ? getPoint().equals(cube.getPoint()) : cube.getPoint() == null;
    }

    @Override
    public int hashCode() {
        int result;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getPoint() != null ? getPoint().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape{");
        sb.append("id=").append(id);
        sb.append(", point=").append(point.toString());
        sb.append('}');
        return sb.toString();
    }
}
