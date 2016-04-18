import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffQueries {

	private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "33862543";

	private Connection conn;

	private PreparedStatement viewAll;
	private PreparedStatement searchFnLn;
	private PreparedStatement searchDepartment;
	private PreparedStatement save;
	private PreparedStatement insertNew;
	private PreparedStatement upDateRecords;

	public StaffQueries() {

		try {

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql1 = "SELECT * FROM Project.staff ";
			viewAll = conn.prepareStatement(sql1);

			String sql2 = "SELECT * FROM Project.staff WHERE firstName LIKE ? OR lastName LIKE ?";
			searchFnLn = conn.prepareStatement(sql2);

			String sql3 = "SELECT * FROM Project.staff WHERE department LIKE ?";
			searchDepartment = conn.prepareStatement(sql3);

			String sql4 = "INSERT INTO Project.staff"
					+ "(firstName,lastName,dateOfBirth,department,salary,startDate,fullTime)"
					+ "VALUES (?,?,?,?,?,?,?)";
			save = conn.prepareStatement(sql4);

			String sql5 = "SELECT * FROM Project.staff";
			insertNew = conn.prepareStatement(sql5);

			String sql6 = "UPDATE Project.staff SET firstName=?,lastName=?, dateOfBirth=?, department=?, salary=?, startDate=?,"
					+ " fullTime=? WHERE StaffID=?";
			upDateRecords = conn.prepareStatement(sql6);

		} catch (SQLException e) {
			System.out.println("Not connected to the DB");
			e.printStackTrace();
			System.exit(1);

		}

	}

	public List<Staff> getAllStaff() {
		List<Staff> staffList = null;
		ResultSet rs = null;

		try {
			rs = viewAll.executeQuery();
			staffList = new ArrayList<Staff>();

			while (rs.next()) {

				staffList.add(new Staff(rs.getInt("StaffID"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("dateOfBirth"), rs.getString("department"), rs.getDouble("salary"),
						rs.getString("startDate"), rs.getBoolean("fullTime")));
			}
		} catch (SQLException ex) {
			System.out.println("Lost connection to DB");
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				close();
			}
			return staffList;
		}

	}

	public List<Staff> getFirstNLastN(String fn, String ln) {
		ResultSet rs = null;
		List<Staff> staffList = null;

		try {
			searchFnLn.setString(1, fn);
			searchFnLn.setString(2, ln);
			rs = searchFnLn.executeQuery();
			staffList = new ArrayList<Staff>();

			while (rs.next()) {

				staffList.add(new Staff(rs.getInt("StaffID"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("dateOfBirth"), rs.getString("department"), rs.getDouble("salary"),
						rs.getString("startDate"), rs.getBoolean("FullTime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				close();
			}
		}
		return staffList;

	}

	public List<Staff> getDepartment(String dep) {
		List<Staff> staffList = null;
		ResultSet rs = null;

		try {
			searchDepartment.setString(1, dep);
			rs = searchDepartment.executeQuery();
			staffList = new ArrayList<Staff>();

			while (rs.next()) {

				staffList.add(new Staff(rs.getInt("StaffID"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("dateOfBirth"), rs.getString("department"), rs.getDouble("salary"),
						rs.getString("startDate"), rs.getBoolean("fullTime")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				close();
			}
		}
		return staffList;

	}

	public int addStaffDetail(String fn, String ln, String dateB, String dep, double salary, String startd,
			String fullTime) {

		int result = 0;

		try {

			save.setString(1, fn);
			save.setString(2, ln);
			save.setString(3, dateB);
			save.setString(4, dep);
			save.setDouble(5, salary);
			save.setString(6, startd);
			save.setString(7, fullTime);

			result = save.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			close();
		}
		return result;

	}
	public int updateStaffDetail(String fn, String ln, String dateB, String dep, double salary, String startd,
			String fullTime,int staffid) {	

		int result = 0;

		try {

			upDateRecords.setString(1, fn);
			upDateRecords.setString(2, ln);
			upDateRecords.setString(3, dateB);
			upDateRecords.setString(4, dep);
			upDateRecords.setDouble(5, salary);
			upDateRecords.setString(6, startd);
			upDateRecords.setString(7, fullTime);
			upDateRecords.setInt(8, staffid);

			result = upDateRecords.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

			close();
		}
		return result;
	}


	public List<Staff> clearRecords() {
		ResultSet rs = null;
		List<Staff> staffList = null;

		try {
			staffList = new ArrayList<Staff>();
			rs = insertNew.executeQuery();

			while (rs.next()) {
				staffList.add(new Staff(rs.getInt("StaffID"), rs.getString("FirstName"), rs.getString("lastName"),
						rs.getString("dateOfBirth"), rs.getString("department"), rs.getDouble("salary"),
						rs.getString("startDate"), rs.getBoolean("fullTime")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			close();
		}
		return staffList;

	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
