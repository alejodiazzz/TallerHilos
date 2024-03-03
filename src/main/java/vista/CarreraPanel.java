package vista;

import javax.swing.*;
import java.awt.*;

public class CarreraPanel extends JPanel {
    private JLabel carro, carretera;
    private ImageIcon car3;
    private ImageIcon car4;
    private ImageIcon car2;
    private ImageIcon car1;
    private ImageIcon car5;
    private ImageIcon street1, street2,street3,street4,street5;
    public CarreraPanel (){
        setPreferredSize(new Dimension(150, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.blue,1));

        this.carretera = new JLabel();
        this.carretera.setSize(350,80);
        this.carretera.setPreferredSize(getPreferredSize());


        this.street1 = new ImageIcon(getClass().getResource("/img/paisaje1.jpg"));
        Image image5 = street1.getImage();
        Image newImage5 = image5.getScaledInstance(carretera.getWidth(),carretera.getHeight(),Image.SCALE_SMOOTH);
        this.street2 = new ImageIcon(getClass().getResource("/img/paisaje2.jpg"));
        Image image6 = street2.getImage();
        Image newImage6 = image6.getScaledInstance(carretera.getWidth(),carretera.getHeight(),Image.SCALE_SMOOTH);
        this.street3 = new ImageIcon(getClass().getResource("/img/paisaje3.jpg"));
        Image image7 = street3.getImage();
        Image newImage7 = image7.getScaledInstance(carretera.getWidth(),carretera.getHeight(),Image.SCALE_SMOOTH);
        this.street4 = new ImageIcon(getClass().getResource("/img/paisaje4.jpg"));
        Image image8 = street4.getImage();
        Image newImage8 = image8.getScaledInstance(carretera.getWidth(),carretera.getHeight(),Image.SCALE_SMOOTH);
        this.street5 = new ImageIcon(getClass().getResource("/img/paisaje5.jpg"));
        Image image9 = street5.getImage();
        Image newImage9 = image9.getScaledInstance(carretera.getWidth(),carretera.getHeight(),Image.SCALE_SMOOTH);

        this.street1.setImage(newImage5);
        this.street2.setImage(newImage6);
        this.street3.setImage(newImage7);
        this.street4.setImage(newImage8);
        this.street5.setImage(newImage9);

        this.carretera.setIcon(street1);
        add(carretera);

        this.carro = new JLabel();
        this.carro.setSize(200,80);
        this.carro.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.car1 = new ImageIcon(getClass().getResource("/img/carro1.png"));
        Image image = car1.getImage();
        Image newImage = image.getScaledInstance(carro.getWidth(),carro.getHeight(),Image.SCALE_SMOOTH);
        this.car2 = new ImageIcon(getClass().getResource("/img/carro2.png"));
        Image image1 = car2.getImage();
        Image newImage1 = image1.getScaledInstance(carro.getWidth(),carro.getHeight(),Image.SCALE_SMOOTH);
        this.car3 = new ImageIcon(getClass().getResource("/img/carro3.png"));
        Image image2 = car3.getImage();
        Image newImage2 = image2.getScaledInstance(carro.getWidth(),carro.getHeight(),Image.SCALE_SMOOTH);
        this.car4 = new ImageIcon(getClass().getResource("/img/carro4.png"));
        Image image3 = car4.getImage();
        Image newImage3 = image3.getScaledInstance(carro.getWidth(),carro.getHeight(),Image.SCALE_SMOOTH);
        this.car5 = new ImageIcon(getClass().getResource("/img/carro5.png"));
        Image image4 = car5.getImage();
        Image newImage4 = image4.getScaledInstance(carro.getWidth(),carro.getHeight(),Image.SCALE_SMOOTH);


        this.car1.setImage(newImage);
        this.car2.setImage(newImage1);
        this.car3.setImage(newImage2);
        this.car4.setImage(newImage3);
        this.car5.setImage(newImage4);
        this.carro.setIcon(car3);

        this.carro.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        add(carro);
        add(Box.createVerticalGlue());



    }
    public JLabel getCarro() {

        return carro;
    }
    public void setIcons(int i){
        switch (i){
            case 0:
                this.carro.setIcon(this.car1);
                this.carretera.setIcon(this.street1);
                this.setBackground(new Color(56, 65, 60));
                break;
            case 1:
                this.carro.setIcon(this.car2);
                this.carretera.setIcon(this.street2);
                this.setBackground(new Color(56, 65, 60));
                break;
            case 2:
                this.carro.setIcon(this.car3);
                this.carretera.setIcon(this.street3);
                this.setBackground(new Color(56, 65, 60));

                break;
            case 3:
                this.carro.setIcon(this.car4);
                this.carretera.setIcon(this.street4);
                this.setBackground(new Color(56, 65, 60));
                break;
            case 4:
                this.carro.setIcon(this.car5);
                this.carretera.setIcon(this.street5);
                this.setBackground(new Color(56, 65, 60));
                break;
        }
    }
    public void visible(){
        this.carro.setVisible(false);

    }
    public void invisible(){
        this.carro.setVisible(true);
    }

    public void setCarro(JLabel carro) {
        this.carro = carro;
    }



    public ImageIcon getCar1() {
        return car1;
    }



    public ImageIcon getCar2() {
        return car2;
    }



    public ImageIcon getCar3() {
        return car3;
    }
    public ImageIcon getCar4() {
        return car4;
    }



    public ImageIcon getCar5() {
        return car5;
    }
}
