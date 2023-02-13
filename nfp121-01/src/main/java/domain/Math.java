package domain;

public class Math {
    public static float PI = 3.1415926f;
    public static float square(float x) {
        return x * x;
    }

    public float x, y;
    public Math(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
