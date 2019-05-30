import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Window implements Runnable{

    JFrame frame;
    Box[][] boxes;
    Random rand = new Random();

    public Window(int seed){
        rand.setSeed(seed);
    }

    @Override
    public void run(){
        initFrame();
        initBoxes();
        initTimer();
    }

    void initFrame(){
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH + 25, Config.SIZE * Config.HEIGHT + 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }

    void initBoxes(){
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++){
                boxes [x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }

        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++)
                for (int sx = -1; sx <= +1; sx++)
                    for (int sy = -1; sy <= +1; sy++)
                        if (!(sx == 0 && sy == 0))
                            boxes[x][y].cell.addNear(boxes
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);

        for (int x = 0; x < Config.WIDTH; x++)
            for (int y = 0; y < Config.HEIGHT; y++){
                if (rand.nextBoolean())
                    boxes[x][y].cell.status = Status.LIVE;
                else
                    boxes[x][y].cell.status = Status.NONE;
                boxes[x][y].setColor();
            }
    }

    private void initTimer(){
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener{
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e){
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++)
                for (int y = 0; y < Config.HEIGHT; y++){
                    if (flop)
                        boxes[x][y].prepare();
                    else
                        boxes[x][y].replace();
                }
        }
    }
}
