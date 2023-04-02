import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main implements ActionListener{
    private JFrame frame;
    private JTextArea area;
    private JTextField fieldName, fieldAge, fieldWeight, fieldHeight, fieldSex;
    private JButton button;

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        main.go();
    }

    public void go(){
        frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel labelName = new JLabel("Имя:   ");
        JLabel labelSex = new JLabel("Пол: ");
        JLabel labelAge = new JLabel("Возраст: ");
        JLabel labelWeight = new JLabel("Вес:   ");
        JLabel labelHeight = new JLabel("Рост:  ");
        fieldName = new JTextField(10);
        fieldAge = new JTextField(10);
        fieldWeight = new JTextField(10);
        fieldHeight = new JTextField(10);
        fieldSex = new JTextField(10);
        area = new JTextArea(6, 73);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);

        button = new JButton("Расчитать");
        button.addActionListener(this);

        JScrollPane scroller = new JScrollPane(area);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(labelName);
        panel.add(fieldName);
        panel.add(labelSex);
        panel.add(fieldSex);
        panel.add(labelAge);
        panel.add(fieldAge);
        panel.add(labelWeight);
        panel.add(fieldWeight);
        panel.add(labelHeight);
        panel.add(fieldHeight);
        panel.add(area);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 200);
        frame.setTitle("Расход калорий");
        frame.setVisible(true);
    }

    public double bmrM(){
        return 88.362 + (13.397 * Integer.parseInt(fieldWeight.getText())) + (6.25 * Integer.parseInt(fieldHeight.getText())) - (5 * Integer.parseInt(fieldAge.getText())) + 5;
    }

    public double bmrW(){
        return 88.362 + (13.397 * Integer.parseInt(fieldWeight.getText())) + (6.25 * Integer.parseInt(fieldHeight.getText())) - (5 * Integer.parseInt(fieldAge.getText())) - 161;
    }

    public void actionPerformed(ActionEvent event){
        if (fieldSex.getText().equals("Мужской") || fieldSex.getText().equals("мужской")){
            area.setText(fieldName.getText() + ", ваш расход в спокойном режиме(без тренировочного процесса) составляет - " + bmrM() + " калорий.");
        }else{
            area.setText(fieldName.getText() + ", ваш расход в спокойном режиме(без тренировочного процесса) составляет - " + bmrW() + " калорий.");
        }
    }
}