import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StaffDisplay extends JFrame {

	private Staff staff;
	private StaffQueries staffQueries;
	private List<Staff> staffList;
	private int numberOfEntries = 0;
	private int currentEntryIndex;

	private JButton backButton;
	private JTextField minIndexTextField;
	private JLabel ofLabel;
	private JTextField maxIndexTextField;
	private JButton nextButton;
	private JLabel staffIDLabel;
	private JTextField staffIDTextField;
	private JLabel firstNameLabel;
	private JTextField firstNameTextField;
	private JLabel lastNameLabel;
	private JTextField lastNameTextField;
	private JLabel dateOfBirthLabel;
	private JTextField dateOfBirthTextField;
	private JLabel departmentLabel;
	private JTextField departmentTextField;
	private JLabel salaryLabel;
	private JTextField salaryTextField;
	private JLabel startDateLabel;
	private JTextField startDateTextField;
	private JLabel fullTimeLabel;
	private JTextField fullTimeTextField;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JPanel searchByNamePanel;
	private JLabel fnLabelPanel;
	private JTextField fnTextFieldPanel;
	private JLabel lastNamePanel;
	private JTextField lnTextFieldPanel;
	private JButton searchNameButton;
	private JPanel searchByDepartment;
	private JLabel departInThePanel;
	private JTextField depTextFieldInThePanel;
	private JButton searchDepartmentButton;
	private JButton viewAllButton;
	private JButton insertNewButton;
	private JButton saveButton;

	public StaffDisplay() {
		super("Staff search and Entry");

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		setSize(550, 700);
		setResizable(false);

		staffQueries = new StaffQueries();

		navigatePanel = new JPanel();
		backButton = new JButton("<<BACK");
		backButton.setToolTipText("Go Back");
		minIndexTextField = new JTextField(2);
		ofLabel = new JLabel("OF");
		maxIndexTextField = new JTextField(2);
		nextButton = new JButton("NEXT>>");
		nextButton.setToolTipText("Go Next");

		backButton.setEnabled(true);
		minIndexTextField.setHorizontalAlignment(JTextField.CENTER);
		maxIndexTextField.setHorizontalAlignment(JTextField.CENTER);
		maxIndexTextField.setEnabled(false);

		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

		navigatePanel.add(backButton);
		navigatePanel.add(Box.createHorizontalStrut(10));
		navigatePanel.add(minIndexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		navigatePanel.add(ofLabel);
		navigatePanel.add(Box.createHorizontalStrut(10));
		navigatePanel.add(maxIndexTextField);
		navigatePanel.add(Box.createHorizontalStrut(10));
		navigatePanel.add(nextButton);

		add(navigatePanel);

		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(8, 2, 4, 4));

		staffIDLabel = new JLabel("Staff ID:");
		staffIDTextField = new JTextField(10);
		displayPanel.add(staffIDLabel);
		displayPanel.add(staffIDTextField);

		firstNameLabel = new JLabel("First Name:");
		firstNameTextField = new JTextField(10);
		displayPanel.add(firstNameLabel);
		displayPanel.add(firstNameTextField);

		lastNameLabel = new JLabel("Last Name:");
		lastNameTextField = new JTextField(10);
		displayPanel.add(lastNameLabel);
		displayPanel.add(lastNameTextField);

		dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthTextField = new JTextField(10);
		displayPanel.add(dateOfBirthLabel);
		displayPanel.add(dateOfBirthTextField);

		departmentLabel = new JLabel("Department:");
		departmentTextField = new JTextField(10);
		displayPanel.add(departmentLabel);
		displayPanel.add(departmentTextField);

		salaryLabel = new JLabel("Salary:");
		salaryTextField = new JTextField(10);
		displayPanel.add(salaryLabel);
		displayPanel.add(salaryTextField);

		startDateLabel = new JLabel("Start Date:");
		startDateTextField = new JTextField(10);
		displayPanel.add(startDateLabel);
		displayPanel.add(startDateTextField);

		fullTimeLabel = new JLabel("Full Time:");
		fullTimeTextField = new JTextField(10);
		displayPanel.add(fullTimeLabel);
		displayPanel.add(fullTimeTextField);

		add(displayPanel);
		searchByNamePanel = new JPanel();

		searchByNamePanel.setLayout(new BoxLayout(searchByNamePanel, BoxLayout.X_AXIS));
		searchByNamePanel.setBorder(BorderFactory.createTitledBorder("Search by Name"));

		fnLabelPanel = new JLabel("First Name:");
		fnTextFieldPanel = new JTextField(10);
		lastNamePanel = new JLabel("Last Name:");
		lnTextFieldPanel = new JTextField(10);
		searchNameButton = new JButton("SEARCH");
		searchNameButton.setToolTipText("Search by Name/LastName");

		searchByNamePanel.add(Box.createHorizontalStrut(6));
		searchByNamePanel.add(fnLabelPanel);
		searchByNamePanel.add(Box.createHorizontalStrut(9));
		searchByNamePanel.add(fnTextFieldPanel);
		searchByNamePanel.add(Box.createHorizontalStrut(9));
		searchByNamePanel.add(lastNamePanel);
		searchByNamePanel.add(Box.createHorizontalStrut(9));
		searchByNamePanel.add(lnTextFieldPanel);
		searchByNamePanel.add(Box.createHorizontalStrut(9));
		searchByNamePanel.add(searchNameButton);

		searchByDepartment = new JPanel();

		searchByDepartment.setLayout(new BoxLayout(searchByDepartment, BoxLayout.X_AXIS));
		searchByDepartment.setBorder(BorderFactory.createTitledBorder("Search by Department"));

		departInThePanel = new JLabel("Department:");
		depTextFieldInThePanel = new JTextField(15);
		searchDepartmentButton = new JButton("SEARCH");
		searchDepartmentButton.setToolTipText("Search by department");

		searchByDepartment.add(Box.createHorizontalStrut(20));
		searchByDepartment.add(departInThePanel);
		searchByDepartment.add(Box.createHorizontalStrut(20));
		searchByDepartment.add(depTextFieldInThePanel);
		searchByDepartment.add(Box.createHorizontalStrut(20));
		searchByDepartment.add(searchDepartmentButton);

		add(searchByNamePanel);
		add(searchByDepartment);

		viewAllButton = new JButton("VIEW ALL");
		viewAllButton.setToolTipText("View All ");
		insertNewButton = new JButton("INSERT NEW ");
		insertNewButton.setToolTipText("clear");
		saveButton = new JButton("SAVE");
		saveButton.setToolTipText("Save");

		add(viewAllButton);
		add(insertNewButton);
		add(saveButton);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				backButtonPressed(e);

			}

		});
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nextButtonPressed(e);

			}

		});
		minIndexTextField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				minIndexTextFieldChanged(e);

			}

		});
		searchNameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchNameButtonPressed(e);

			}

		});

		searchDepartmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchDepartmentButtonPressed(e);

			}

		});

		viewAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAllButtonPressed(e);

			}

		});
		insertNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insertNewButtonPressed(e);

			}

		});
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (staffIDTextField.getText().equalsIgnoreCase("")) {
					saveButtonPressed(e);
				} else {
					upDateRecordsButtonPressed(e);
				}

			}

		});
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				staffQueries.close();
				System.exit(0);
			}
		});

		showRecordByDefault();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void backButtonPressed(ActionEvent e) {
		currentEntryIndex--;

		if (currentEntryIndex <= 0) {

			currentEntryIndex = 0;

		}
		minIndexTextField.setText("" + (currentEntryIndex + 1));
		minIndexTextFieldChanged(e);

	}

	private void nextButtonPressed(ActionEvent e) {
		currentEntryIndex++;
		if (currentEntryIndex >= numberOfEntries) {
			currentEntryIndex = numberOfEntries - 1;

		}
		minIndexTextField.setText("" + (currentEntryIndex + 1));
		minIndexTextFieldChanged(e);
	}

	private void minIndexTextFieldChanged(ActionEvent e) {
		try {
			currentEntryIndex = (Integer.parseInt(minIndexTextField.getText()) - 1);

			if (numberOfEntries != 0 && currentEntryIndex <= numberOfEntries) {

				staff = staffList.get(currentEntryIndex);
				staffIDTextField.setText(staff.getStaffId() + "");
				firstNameTextField.setText(staff.getFirstName());
				lastNameTextField.setText(staff.getLastName());
				dateOfBirthTextField.setText(staff.getDateOfBirth());
				departmentTextField.setText(staff.getDepartment());
				salaryTextField.setText(staff.getSalary() + "");
				startDateTextField.setText(staff.getStartDate());
				fullTimeTextField.setText(staff.hasFullTime());
				minIndexTextField.setText("" + (currentEntryIndex + 1));
				maxIndexTextField.setText("" + numberOfEntries);

				backButton.setEnabled(true);
				nextButton.setEnabled(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void searchNameButtonPressed(ActionEvent e) {
		staffList = staffQueries.getFirstNLastN(fnTextFieldPanel.getText(), lnTextFieldPanel.getText());
		numberOfEntries = staffList.size();

		if (numberOfEntries != 0) {

			currentEntryIndex = 0;
			staff = staffList.get(currentEntryIndex);
			staffIDTextField.setText(staff.getStaffId() + "");
			firstNameTextField.setText(staff.getFirstName());
			lastNameTextField.setText(staff.getLastName());
			dateOfBirthTextField.setText(staff.getDateOfBirth());
			departmentTextField.setText(staff.getDepartment());
			salaryTextField.setText(staff.getSalary() + "");
			startDateTextField.setText(staff.getStartDate());
			fullTimeTextField.setText(staff.hasFullTime());
			minIndexTextField.setText("" + (currentEntryIndex) + 1);
			maxIndexTextField.setText(numberOfEntries + "");
			backButton.setEnabled(true);
			nextButton.setEnabled(true);
		} else
			viewAllButtonPressed(e);

	}

	private void searchDepartmentButtonPressed(ActionEvent e) {

		staffList = staffQueries.getDepartment(depTextFieldInThePanel.getText());
		numberOfEntries = staffList.size();

		if (numberOfEntries != 0) {
			currentEntryIndex = 0;
			staff = staffList.get(currentEntryIndex);
			staffIDTextField.setText(staff.getStaffId() + "");
			firstNameTextField.setText(staff.getFirstName());
			lastNameTextField.setText(staff.getLastName());
			dateOfBirthTextField.setText(staff.getDateOfBirth());
			departmentTextField.setText(staff.getDepartment());
			salaryTextField.setText(staff.getSalary() + "");
			startDateTextField.setText(staff.getStartDate());
			fullTimeTextField.setText(staff.hasFullTime());
			minIndexTextField.setText("" + (currentEntryIndex) + 1);
			maxIndexTextField.setText("" + numberOfEntries);
			nextButton.setEnabled(true);
			backButton.setEnabled(true);

		} else
			viewAllButtonPressed(e);

	}

	private void viewAllButtonPressed(ActionEvent e) {

		staffList = staffQueries.getAllStaff();
		numberOfEntries = staffList.size();

		if (numberOfEntries != 0) {

			currentEntryIndex = 0;

			staff = staffList.get(currentEntryIndex);
			staffIDTextField.setText(staff.getStaffId() + "");
			firstNameTextField.setText(staff.getFirstName());
			lastNameTextField.setText(staff.getLastName());
			dateOfBirthTextField.setText(staff.getDateOfBirth());
			departmentTextField.setText(staff.getDepartment());
			salaryTextField.setText(staff.getSalary() + "");
			startDateTextField.setText(staff.getStartDate());
			fullTimeTextField.setText(staff.hasFullTime());
			minIndexTextField.setText("" + (currentEntryIndex + 1));
			maxIndexTextField.setText(numberOfEntries + "");
			backButton.setEnabled(true);
			nextButton.setEnabled(true);
			staffIDTextField.setEditable(false);

		} else

			viewAllButtonPressed(e);

	}

	private void insertNewButtonPressed(ActionEvent e) {

		staffList = staffQueries.clearRecords();
		numberOfEntries = staffList.size();

		if (numberOfEntries != 0) {

			currentEntryIndex = 0;

			staff = staffList.get(currentEntryIndex);
			staffIDTextField.setText("");
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			dateOfBirthTextField.setText("");
			departmentTextField.setText("");
			salaryTextField.setText("");
			startDateTextField.setText("");
			fullTimeTextField.setText("");
			backButton.setEnabled(true);
			nextButton.setEnabled(true);

		} else
			JOptionPane.showMessageDialog(this, "New record can't be created", "Error", JOptionPane.ERROR_MESSAGE);

	}

	private void upDateRecordsButtonPressed(ActionEvent e) {

		int result = staffQueries.updateStaffDetail(firstNameTextField.getText(), lastNameTextField.getText(),
				dateOfBirthTextField.getText(), departmentTextField.getText(),
				Double.parseDouble(salaryTextField.getText()), startDateTextField.getText(),
				fullTimeTextField.getText(), Integer.parseInt(staffIDTextField.getText()));

		if (result == 1) {
			JOptionPane.showMessageDialog(this, "updated successfully!!!");
		} else {
			JOptionPane.showMessageDialog(this, "Staff detail are not updated!!!");
		}
   viewAllButtonPressed(e);
	}

	private void saveButtonPressed(ActionEvent e) {

		int result = staffQueries.addStaffDetail(firstNameTextField.getText(), lastNameTextField.getText(),
				dateOfBirthTextField.getText(), departmentTextField.getText(),
				Double.parseDouble(salaryTextField.getText()), startDateTextField.getText(),
				(fullTimeTextField.getText()));

		if (result == 1) {

			JOptionPane.showMessageDialog(this, "Saved successfully!", "added!!!", JOptionPane.PLAIN_MESSAGE);

		} else {

			JOptionPane.showMessageDialog(this, "Staff detail are not added try again!", "Erro!!!",
					JOptionPane.PLAIN_MESSAGE);

		}

		viewAllButtonPressed(e);

	}

	public void showRecordByDefault() {
		staffList = staffQueries.getAllStaff();
		numberOfEntries = staffList.size();

		if (numberOfEntries != 0) {

			currentEntryIndex = 0;
			staff = staffList.get(currentEntryIndex);
			staffIDTextField.setText(staff.getStaffId() + "");
			staffIDTextField.setEditable(false);
			firstNameTextField.setText(staff.getFirstName());
			lastNameTextField.setText(staff.getLastName());
			dateOfBirthTextField.setText(staff.getDateOfBirth());
			departmentTextField.setText(staff.getDepartment());
			salaryTextField.setText(staff.getSalary() + "");
			startDateTextField.setText(staff.getStartDate());
			fullTimeTextField.setText(staff.hasFullTime());
			minIndexTextField.setText("" + (currentEntryIndex + 1));
			maxIndexTextField.setText(numberOfEntries + "");
			backButton.setEnabled(true);
			nextButton.setEnabled(true);

		}

	}

	public static void main(String[] args) {
		new StaffDisplay();
	}
}
