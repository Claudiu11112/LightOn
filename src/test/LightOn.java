package test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class LightOn {
    private JFrame f;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LightOn window = new LightOn();
                window.f.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private LightOn() {
        initialize();
    }

    private void initialize() {
        f = new JFrame();
        f.getContentPane().setBackground(Color.WHITE);
        f.getContentPane().setFont(new Font("DejaVu Serif", Font.PLAIN, 12));
        f.setResizable(false);
        f.setBounds(100, 100, 556, 270);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);

        URL url = getClass().getResource("images.png");
        ImageIcon i = new ImageIcon(url);
        f.setIconImage(i.getImage());

        JLabel lbl1 = new JLabel("Default");
        lbl1.setFont(new Font("Bitstream Charter", Font.PLAIN, 16));
        lbl1.setBounds(153, 25, 70, 19);
        f.getContentPane().add(lbl1);

        JLabel lbl2 = new JLabel("Light switch");
        lbl2.setFont(new Font("Dialog", Font.BOLD, 16));
        lbl2.setBounds(153, 45, 138, 19);
        f.getContentPane().add(lbl2);

        JLabel lbl3 = new JLabel("OFF");
        lbl3.setFont(new Font("Dialog", Font.PLAIN, 24));
        lbl3.setBounds(176, 74, 70, 42);
        f.getContentPane().add(lbl3);

        JButton btnOn = new JButton("ON");
        btnOn.addActionListener(e -> {
            lbl3.setText("ON");
            lbl3.setForeground(Color.GREEN);

            Thread t = new Thread(() -> {
                URL url1;
                try {
                    String a = "http://192.168.1.111?pin=ON";
                    url1 = new URL(a);
                    URLConnection conn = url1.openConnection();
                    InputStream in = conn.getInputStream();
//                BufferedReader br = new BufferedReader(
//                        new InputStreamReader(conn.getInputStream()));
                    in.close();
                } catch (IOException e1) {
                    //joie1.printStackTrace();
                }
            });
            t.start();
        });
        btnOn.setBackground(new Color(230, 230, 250));
        btnOn.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnOn.setBounds(209, 117, 79, 34);
        f.getContentPane().add(btnOn);

        JButton btnOff = new JButton("OFF");
        btnOff.addActionListener(e -> {
            lbl3.setText("OFF");
            lbl3.setForeground(Color.MAGENTA);
            Thread t = new Thread(() -> {
                URL url1;
                try {
                    String a = "http://192.168.1.111?pin=OFF";
                    url1 = new URL(a);
                    URLConnection conn = url1.openConnection();
                    InputStream in = conn.getInputStream();
//                BufferedReader br = new BufferedReader(
//                        new InputStreamReader(conn.getInputStream()));
                    in.close();
                } catch (IOException e1) {
                   // e1.printStackTrace();
                }
            });
            t.start();
        });
        btnOff.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnOff.setBackground(new Color(230, 230, 250));
        btnOff.setBounds(129, 117, 79, 34);
        f.getContentPane().add(btnOff);

        JLabel lbl4 = new JLabel("OFF");
        lbl4.setFont(new Font("Dialog", Font.PLAIN, 24));
        lbl4.setBounds(383, 74, 70, 42);
        f.getContentPane().add(lbl4);

        JButton btnOff1 = new JButton("OFF");
        btnOff1.addActionListener(e -> {
            lbl4.setText("OFF");
            lbl4.setForeground(Color.MAGENTA);
            Thread t = new Thread(() -> {
                URL url1;
                try {
                    String a = "http://192.168.1.111?pin1=OFF";
                    url1 = new URL(a);
                    URLConnection conn = url1.openConnection();
                    InputStream in = conn.getInputStream();
//                BufferedReader br = new BufferedReader(
//                        new InputStreamReader(conn.getInputStream()));
                    in.close();
                } catch (IOException e1) {
                  //  e1.printStackTrace();
                }
            });
            t.start();
        });
        btnOff1.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnOff1.setBackground(new Color(230, 230, 250));
        btnOff1.setBounds(336, 117, 79, 34);
        f.getContentPane().add(btnOff1);

        JButton btnOn1 = new JButton("ON");
        btnOn1.addActionListener(e -> {
            lbl4.setText("ON");
            lbl4.setForeground(Color.GREEN);
            Thread t = new Thread(() -> {
                URL url12;
                try {
                    String a = "http://192.168.1.111?pin1=ON";
                    url12 = new URL(a);
                    URLConnection conn = url12.openConnection();
                    InputStream in = conn.getInputStream();
//                BufferedReader br = new BufferedReader(
//                        new InputStreamReader(conn.getInputStream()));
                    in.close();
                } catch (IOException e1) {
                   // e1.printStackTrace();
                }
            });
            t.start();
        });
        btnOn1.setFont(new Font("Dialog", Font.PLAIN, 20));
        btnOn1.setBackground(new Color(230, 230, 250));
        btnOn1.setBounds(416, 117, 79, 34);
        f.getContentPane().add(btnOn1);

        JLabel lbl5 = new JLabel("Light switch");
        lbl5.setFont(new Font("Dialog", Font.BOLD, 16));
        lbl5.setBounds(360, 45, 138, 19);
        f.getContentPane().add(lbl5);

        JLabel lbl6 = new JLabel();
        lbl6.setBounds(12, 12, 107, 104);
        f.getContentPane().add(lbl6);
        lbl6.setIcon(i);
    }
}
