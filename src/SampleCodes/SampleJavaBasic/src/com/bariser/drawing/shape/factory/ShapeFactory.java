package com.bariser.drawing.shape.factory;

import com.bariser.drawing.Color;
import com.bariser.drawing.shape.Ellipse;
import com.bariser.drawing.shape.Line;
import com.bariser.drawing.shape.Rectangle;
import com.bariser.drawing.shape.Shape;
import org.csystem.util.math.geometry.Point;

import java.util.Random;
import java.util.random.RandomGenerator;

public class ShapeFactory {
    private final RandomGenerator m_randomGenerator = new Random();

    public Shape createShape()
    {
        return switch (m_randomGenerator.nextInt(3)) {
            case 0 -> {
                Color fgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Color bgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Point point = Point.createCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));

                yield new Rectangle(fgColor, bgColor, point, m_randomGenerator.nextInt(100),  m_randomGenerator.nextInt(100));
            }
            case 1 -> {
                Color fgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Color bgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Point point = Point.createCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));

                yield new Ellipse(fgColor, bgColor, point, m_randomGenerator.nextInt(100),  m_randomGenerator.nextInt(100));
            }
            default -> {
                Color color = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Point point1 = Point.createCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));
                Point point2 = Point.createCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));
                yield new Line(color, point1, point2);
            }
        };
    }
}
