/**
 * This is a singleton class which defines a plateau.
 *
 * Created with IntelliJ IDEA.
 * @author Mohamad Alsayedahmad
 * Date: 17/05/2013
 */
public enum Plateau {
    INSTANCE;

    private int length;
    private int width;

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean contains(int x, int y) {
        return (x>=0 && x<=this.width && y>=0 && y<=this.length);
    }

}
