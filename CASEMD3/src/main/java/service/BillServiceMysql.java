package service;

import dao.DbContext;
import model.Bill;
import model.Product;
import model.ProductType;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BillServiceMysql extends DbContext implements IBillServlet {
    private static final String FIND_ALL_BILL = "SELECT p.*, pt.id as id_cate, pt.name as name_cate " + "FROM bills p = pt.id";
    @Override
    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BILL);

            System.out.println("findAll: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Bill bill = getBillFromResulSet(rs);
                bills.add(bill);
            }
            connection.close();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
        return bills;
    }

    private Bill getBillFromResulSet(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        Bill bill = new Bill(id, name, address, phone, email);

        return bill;
    }


    @Override
    public void save(Bill bill) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `bill` (`name`, `address`, `phone`, `email`) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, bill.getName());
            preparedStatement.setString(2, bill.getAddress());
            preparedStatement.setString(3, bill.getPhone());
            preparedStatement.setString(4, bill.getEmail());
            System.out.println("save: " + preparedStatement);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }





    }
