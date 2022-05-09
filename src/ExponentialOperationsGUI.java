import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ExponentialOperationsGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton powerOperation;
	private JButton squareRootOperation;
	private JButton logOperation;
	private JButton lnOperation;
	private JTextField firstUserExponentialInput;
	private JTextField secondUserExponentialInput;
	private JPanel mainExponentialPanel;
	private JPanel subExponentialPanel;
	private JLabel exponentialSolution;
	
	public ExponentialOperationsGUI() {
		setTitle("Exponential Operations Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExponentialComponents();
		pack();
	}
	
	public void setExponentialComponents() {
		mainExponentialPanel = new JPanel(new GridLayout(10, 5));
		subExponentialPanel = new JPanel();
		firstUserExponentialInput= new JTextField(4);
		secondUserExponentialInput= new JTextField(4);
		subExponentialPanel.add(new JLabel("Enter the two values on the text fields: "));
		subExponentialPanel.add(firstUserExponentialInput);
		subExponentialPanel.add(secondUserExponentialInput);
		mainExponentialPanel.add(subExponentialPanel);
		powerOperation = new JButton("Power");
		squareRootOperation = new JButton("Square Root");
		logOperation = new JButton("Logarithm");
		lnOperation = new JButton("Natural Logarithm");
		powerOperation.addActionListener(this);
		squareRootOperation.addActionListener(this);
		logOperation.addActionListener(this);
		lnOperation.addActionListener(this);
		mainExponentialPanel.add(powerOperation);
		mainExponentialPanel.add(squareRootOperation);
		mainExponentialPanel.add(logOperation);
		mainExponentialPanel.add(lnOperation);
		exponentialSolution = new JLabel("");
		mainExponentialPanel.add(exponentialSolution);
		firstUserExponentialInput.setText("0");
		secondUserExponentialInput.setText("0");
		this.add(mainExponentialPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double firstValue = Integer.parseInt(firstUserExponentialInput.getText());
		double secondValue = Integer.parseInt(secondUserExponentialInput.getText());
		double solution = 0.0;
		if (e.getSource() == powerOperation) {
			solution = Math.pow(firstValue, secondValue);
			exponentialSolution.setText("Power: " + solution);
		}
		else if (e.getSource() == squareRootOperation) {
			solution = Math.sqrt(firstValue);
			exponentialSolution.setText("Square Root: " + solution);
		}
		else if (e.getSource() == logOperation) {
			solution = Math.log(firstValue)/Math.log(secondValue);
			exponentialSolution.setText("Logarithm: " + solution);
		}
		else if (e.getSource() == lnOperation) {
			solution = Math.log(firstValue);
			exponentialSolution.setText("Natural Logarithm: " + solution);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new ExponentialOperationsGUI().setVisible(true);
			}
		});
	}

}
