package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Main {
    private JPanel panelMain;
    private JPanel panelTitle;
    private JPanel panelCenter;
    private JLabel labelTime;
    private JLabel labelLives;
    private JLabel labelPoints;
    private JLabel labelCharacter;
    private JLabel labelTurnip;
    private JButton buttonPause;
    private int seconds = 0;
    private int points = 0;
    private int lives = 3;

    public Main() {

        panelMain.setPreferredSize(new Dimension(700, 500));
        panelMain.setSize(new Dimension(700, 500));
        panelMain.setLayout(null); //no le ponemos ningún layout al panel main para que podamos poner lo que queramos en él
        panelMain.setFocusable(true); //esto hace que se detecten los eventos del teclado

        showPanelTitle();
        showPanelCenter();

        Timer timer = new Timer(1000, new TimerActionListener()); //timer de los segundos
        timer.start();

        Timer turnipMovimiento = new Timer(100, new turnipMovimientoActionListener()); //timer que lleva el movimiento del papel/turnip
        turnipMovimiento.start();

        buttonPause.addMouseListener(new ButtonPauseListener(timer, turnipMovimiento)); //añadimos el action listener al botón de pausa y le masamos el timer y el movimiento del turnip como parámetros
        panelMain.addKeyListener(new PanelMainListener()); //añadimos el key listener al panelMain para poder mover al personaje con las flechas

    }

        //Si la clase de la ventana es static, esta también tiene que serlo:
    private static class FrameWindowListener extends WindowAdapter {

        //paso de parámetros:
        //creamos un frame temporal para poder usarlo en el constructor:
        JFrame frame;
        //hacemos un constructor para pasarle el frame de la clase mainFrame como parámetro y con el constructor lo convertimos al frame declarado en esta clase:
        public FrameWindowListener(JFrame frame) {
            this.frame = frame;
        }

        //método de acción para cuando cerramos la ventana:
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);

            int confirmado = JOptionPane.showConfirmDialog(null,
                    "¿Seguro que quieres cerrar la ventana?",
                    "Mensaje",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (confirmado == JOptionPane.YES_OPTION) { //si se da a la opción Yes, se cierra la ventana:
                //lo que va a hacer por defecto al decirle a Yes:
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            } else { //si se da al No, que no haga nada:
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        }
        //JOptionPane.YES_NO_OPTION es las opciones que queremos que nos salga, en este caso Yes y No
        //JOptionPane.QUESTION_MESSAGE es el icono de interrogante que se mostrará en la ventanita

    }

    private class PanelMainListener extends KeyAdapter {

        //método para mover al personaje con las teclas de flecha:
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            int x = labelCharacter.getX(); //tomamos como variable la posición 'x' (horizontal)

            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT -> x += 5; //se suman 5 pixeles horizontalmente, moviendo el personaje hacia la derecha
                case KeyEvent.VK_LEFT -> x -= 5; //se restan 5 pixeles horizontalmente, moviendo el personaje hacia la izquierda
            }

            //el siguiente if evita que el personaje se mueva fuera de la pantalla:
            if (x>0 && x<= panelMain.getWidth() - labelCharacter.getWidth()) { //si la posición x (horizontal) es más grande que 0 y más pequeña que el ancho total de la pantalla menos el ancho del personaje (para que el personaje se pare en su extremo derecho en el límite de la pantalla, colocamos al personaje):
                labelCharacter.setLocation(x, labelCharacter.getY());
            }

        }
    }

    private class ButtonPauseListener extends MouseAdapter {

        //paso de parámetros:
        Timer timer;
        Timer turnipMovimiento;
        public ButtonPauseListener(Timer timer, Timer turnipMovimiento) {
            this.timer = timer;
            this.turnipMovimiento = turnipMovimiento;
        }

        //método para pausar y reanudar el juego:
        @Override
        public void mouseClicked(MouseEvent e) {

            //super.mouseClicked(e);

            if (buttonPause.getText().equals("Pausa")) {
                timer.stop();
                turnipMovimiento.stop();
                buttonPause.setText("Reanudar");

            } else {
                timer.start();
                turnipMovimiento.start();
                panelMain.requestFocus(); //esto hace que el pause se actualice para que el personaje se mueva otra vez al darle a reanudar
                buttonPause.setText("Pausa");
            }

        }
    }

    public class TimerActionListener implements ActionListener {

        //método para sumar segundos con el timer:
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds++;
            labelTime.setText(seconds + " segundos");
        }
    }

    public class turnipMovimientoActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Random random = new Random(); //variable random para luego utilizarla al voler a posicionar el turnip en una posición 'x' random

            int y = labelTurnip.getY(); //guardamos en una variable la posición 'y' (vertical) del turnip
            y+=10; //Sumamos 10 píxeles para que se mueva hacia abajo por el eje 'y' (vertical)

            if (y + labelTurnip.getHeight() >= panelCenter.getHeight()) { //Si el turnip llega al final de la pantalla verticalmente se resta una vida (si la medida vertical del turnip + su recorrido llega a ser la misma distancia vertical de la pantalla significa que ha tocado el suelo)

                lives--;
                labelLives.setText(lives + " vidas");
                labelTurnip.setLocation(random.nextInt(panelCenter.getWidth() - labelTurnip.getWidth()), 0); //recolocamos el turnip en una nueva posición random del eje 'x' (horizontal)

                //si las vidas llegan a 0, termina el juego:
                if (lives == 0) {
                    JOptionPane.showMessageDialog(null, "GAME OVER\n¡Prueba otra vez!");
                    replayGame();
                }

            } else {
                labelTurnip.setLocation(labelTurnip.getX(), y); //movimiento contínuo del turnip hacia abajo manteniendo la misma posición en 'x' (horizontal) y actualizando el eje 'y' (vertical) continuamente al usar un timer

                //si los bordes del labelTurnip colisionan con los bordes del labelCharacter:
                if (labelTurnip.getBounds().intersects(labelCharacter.getBounds())) {
                    points += 10;
                    labelPoints.setText(points + " puntos");

                    labelTurnip.setLocation(random.nextInt(panelCenter.getWidth() - labelTurnip.getWidth()), 0); //recolocamos el turnip en una nueva posición random del eje 'x' (horizontal)

                    if (points == 50) {
                        JOptionPane.showMessageDialog(null, "¡¡GANASTE!!\n¡Juguemos otra vez!");
                        replayGame();
                    }
                }
            }
        }
    }

    private void showPanelTitle() {
        panelTitle = new JPanel();
        panelTitle.setLocation(0, 0);
        panelTitle.setSize(panelMain.getWidth(), 50);
        panelTitle.setBackground(Color.decode("#1A925E"));

        labelPoints = new JLabel();
        labelPoints.setText(points + " puntos");
        panelTitle.add(labelPoints);

        labelLives = new JLabel();
        labelLives.setText(lives + " vidas");
        panelTitle.add(labelLives);

        labelTime = new JLabel();
        labelTime.setText(seconds + " segundos");
        panelTitle.add(labelTime);

        buttonPause = new JButton();
        buttonPause.setText("Pausa");
        buttonPause.setFocusPainted(false);
        buttonPause.setForeground(Color.white);
        buttonPause.setBackground(new Color(25, 18, 50));
        panelTitle.add(buttonPause);

        panelMain.add(panelTitle);
    }


    private void showPanelCenter() {
        panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setLocation(0, panelTitle.getHeight()); //posición
        panelCenter.setSize(panelMain.getWidth(), panelMain.getHeight() - panelTitle.getHeight()); //tamaño
        panelCenter.setBackground(Color.decode("#2EAC82"));

        panelMain.add(panelCenter);

        showCharacter();
        showTurnip();

    }

    private void showTurnip() {
        labelTurnip = new JLabel();
        labelTurnip.setSize(50, 60);
        ImageIcon imageIcon = new ImageIcon("src/images/turnip.png");
        Icon icon = new ImageIcon(
                imageIcon.getImage().getScaledInstance(labelTurnip.getWidth(), labelTurnip.getHeight(), Image.SCALE_DEFAULT)
        );
        labelTurnip.setIcon(icon);

        Random random = new Random();
        labelTurnip.setLocation(random.nextInt(panelCenter.getWidth() - labelTurnip.getWidth()), 0); //colocamos el turnip en una posición random horizontalmente y arriba

        panelCenter.add(labelTurnip);
    }

    private void showCharacter() {
        labelCharacter = new JLabel();
        labelCharacter.setSize(90, 120);
        ImageIcon imageIcon = new ImageIcon("src/images/daisy_mae.png");
        Icon icon = new ImageIcon(
                imageIcon.getImage().getScaledInstance(labelCharacter.getWidth(), labelCharacter.getHeight(), Image.SCALE_DEFAULT)
        );

        labelCharacter.setIcon(icon);
        labelCharacter.setLocation(panelCenter.getWidth()/2 - labelCharacter.getWidth()/2, panelCenter.getHeight() - labelCharacter.getHeight());

        panelCenter.add(labelCharacter);
    }

    private void replayGame() {
        //para volver a jugar el juego después de terminarlo reseteamos las variables:
        points = 0;
        lives = 3;
        seconds = 0;
        labelPoints.setText(points + " puntos");
        labelLives.setText(lives + " vidas");
        labelTime.setText(seconds + " segundos");
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Main"); //nombre en la ventana del juego
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); //no le ponemos ningún layout a la ventana para que podamos poner lo que queramos en ella

        //cambio del icono del juego:
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/images/politecnics.png");
        frame.setIconImage(icono);

        //añadimos un windowListener al frame para hacer que salga una ventanita de confirmación al querer cerrar la ventana y le pasamos el frame como parámetro:
        frame.addWindowListener(new FrameWindowListener(frame));

    }

}
