package com.company;

public enum Planet {

    Mercury (3.303e+23, 2.4397e6),
    Venus   (4.869e+24, 6.0518e6),
    Earth  (5.976e+24, 6.37814e6),
    Mars    (6.421e+23, 3.3972e6),
    Jupiter (1.9e+27,   7.1492e7),
    Saturn  (5.688e+26, 6.0268e7),
    Uranus  (8.686e+25, 2.5559e7),
    Neptune (1.024e+26, 2.4746e7);

    private final double mass;
    private final double radius;
    public static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    public double gravForce() {
        return this.G * this.mass / Math.pow(this.radius,2);
    }

}