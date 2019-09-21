package com.blade.ssm.utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public final class CaptchaUtil {

    private CaptchaUtil() {}

    private static Random random = new Random();

    private static final char[] CHARS = {
        '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    };

    private static String getRandomString() {
        StringBuilder buffer = new StringBuilder();
        // 随机压缩长度法
        for (int i = 0; i < 6; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    private static Color getRandomColor() {
        return new Color(
            random.nextInt(255),
            random.nextInt(255),
            random.nextInt(255));
    }

    private static Color getReverseColor(Color c) {
        return new Color(
            255-c.getRed(),
            255-c.getGreen(),
            255-c.getBlue()
        );
    }

    public static void outputCaptcha(HttpServletRequest request, HttpServletResponse response)
                                                        throws ServletException, IOException {
        response.setContentType("image/jpeg");
        String randomString = getRandomString();
        int width = 100;
        int height = 30;
        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        request.getSession().setAttribute("randomString", randomString);

        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
        for (int i = 0, n = random.nextInt(100); i < n; i++)
        {
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
        }

        // 转成JPEG格式
        ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(bi);
        out.flush();

    }
}