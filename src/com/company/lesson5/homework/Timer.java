package com.company.lesson5.homework;

import javax.swing.*;
import java.awt.*;

public class Timer extends JFrame {

    private static int WIDTH = 300;
    private static int HEIGHT = 300;

    private Container container = getContentPane();
    private JLabel minutesLabel = new JLabel("Minutes");
    private JLabel secondsLabel = new JLabel("Seconds");
    private JTextField minutesTextField = new JTextField();
    private JTextField secondsTextField = new JTextField();
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");

    private JLabel minutesCounter = new JLabel("00m");
    private JLabel secondsCounter = new JLabel("00s");

    public Timer() throws HeadlessException {
        setFrameConfig();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();

        start();
    }

    private void setLocationAndSize() {
        minutesLabel.setBounds(10, (int) (HEIGHT - (HEIGHT * 0.95)), 80, 10);
        secondsLabel.setBounds(100, (int) (HEIGHT - (HEIGHT * 0.95)), 80, 10);
        minutesTextField.setBounds(10, (int) (HEIGHT - (HEIGHT * 0.85)), 50, 30);
        secondsTextField.setBounds(100, (int) (HEIGHT - (HEIGHT * 0.85)), 50, 30);
        startButton.setBounds(WIDTH - 120, (int) (HEIGHT - (HEIGHT * 0.90)), 100, 30);

        minutesCounter.setBounds(20, HEIGHT - 170, 300, 120);
        minutesCounter.setFont(new Font("Serif", Font.PLAIN, 64));

        secondsCounter.setBounds(WIDTH - 140, HEIGHT - 170, 120, 120);
        secondsCounter.setFont(new Font("Serif", Font.PLAIN, 64));

        stopButton.setBounds(100, HEIGHT - 70, 100, 30);
        stopButton.setVisible(false);
    }

    private void addComponentsToContainer() {
        container.add(minutesLabel);
        container.add(secondsLabel);
        container.add(minutesTextField);
        container.add(secondsTextField);
        container.add(startButton);
        container.add(stopButton);

        container.add(minutesCounter);
        container.add(secondsCounter);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    private void setFrameConfig() {
        this.setTitle("Timer");
        this.setVisible(true);
        this.setBounds(10, 10, WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void start() {
        startButton.addActionListener((e) -> {

            int minutes = Integer.parseInt(minutesTextField.getText());
            int seconds = Integer.parseInt(secondsTextField.getText());
            Counter counter = new Counter(minutes, seconds, minutesCounter, secondsCounter);
            TimerThread thread = new TimerThread(counter);

            thread.start();
            if (thread.isAlive()) {
                stopButton.setVisible(true);
            } else
                stopButton.setVisible(false);
        });
    }
}
