import javax.swing.*;
import java.awt.event.*;
public class AmazingRace {
    public static void main(String[] args) {

        Graphics window = new Graphics();
        window.createWindow();

        
        
        
    }
    
}

class Graphics{

    Thread deloreanThread;
    Thread ectomobileThread;

    JFrame frame;
    JPanel panel;
    JLabel delorean;
    JLabel ectomobile;
    JLabel goal;
    JButton startButton;
    JButton stopButton;
    JButton restartButton;
    JButton sleepButton;


    public void createWindow() {
        frame = new JFrame("AmazingRace");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        JButton startButton = new JButton("Iniciar");
        startButton.setBounds(5, 10, 100, 30);
        startButton.addActionListener(new JButtonListener());

        JButton stopButton = new JButton("Destruir");
        stopButton.setBounds(130, 10, 100, 30);
        stopButton.addActionListener(new StopListener());

        JButton restartButton = new JButton("Reiniciar");
        restartButton.setBounds(255, 10, 100, 30);
        restartButton.addActionListener(new RestartListener());

        JButton sleepButton = new JButton("Suspender");
        sleepButton.setBounds(380, 10, 100, 30);
        sleepButton.addActionListener(new SleepListener());


        ImageIcon deloreanIcon = new ImageIcon("car.png");
        ImageIcon ectomobileIcon = new ImageIcon("car2.png");
        ImageIcon goalIcon = new ImageIcon("goal.png");


        delorean = new JLabel();
        delorean.setIcon(deloreanIcon);
        delorean.setText("Delorean");
        delorean.setBounds(5, 100, 200, 100);

        ectomobile = new JLabel();
        ectomobile.setText("Ectomobile");
        ectomobile.setIcon(ectomobileIcon);
        ectomobile.setBounds(5, 400, 200, 100);

        goal = new JLabel();
        goal.setIcon(goalIcon);
        goal.setBounds(820, 0, 80, 600);

        frame.setVisible(true);
        frame.setSize(900, 600);
        frame.add(panel);

        panel.setLayout(null);
        panel.add(delorean);
        panel.add(ectomobile);
        panel.add(goal);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(restartButton);
        panel.add(sleepButton);
        

    }

    class Motion implements Runnable{
        JLabel car;
        Motion(JLabel car){
            this.car = car;
        }

        public void run(){
            move();
        }

    public void move(){
        int x = car.getX();
        int xGoal = goal.getX() + 10;
        int speed = (int) (Math.random() + 1) * 15;
        
        car.setLocation(x + speed, car.getY());
        panel.revalidate();
        panel.repaint();
        if(x > xGoal){
            deloreanThread.stop();
            ectomobileThread.stop();
            System.out.println("Gana: "+car.getText());
            return;
        } 

        try {
            Thread.sleep(50);
        }catch(Exception e){
            e.printStackTrace();
        }
        move();
    }

    }


    class JButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Motion deloreanMotion = new Motion(delorean);
            Motion ectomobileMotion = new Motion(ectomobile);

            deloreanThread = new Thread(deloreanMotion);
            ectomobileThread = new Thread(ectomobileMotion);
            deloreanThread.start();
            ectomobileThread.start();
            

        }
    }

    class StopListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            try{
                deloreanThread.stop();
                ectomobileThread.stop();
                
            }catch (Exception ex){}
            
        }
    }

    class RestartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                deloreanThread.stop();
                ectomobileThread.stop();
                
            }catch (Exception ex){}

            delorean.setLocation(5, delorean.getY());
            ectomobile.setLocation(5, ectomobile.getY());
            panel.revalidate();
            panel.repaint();
        }
    }

    class SleepListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                deloreanThread.sleep(5000);
                ectomobileThread.sleep(5000);
            }catch (Exception ex){}
        }
    }
}





