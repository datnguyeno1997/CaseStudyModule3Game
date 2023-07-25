package service;

import model.Bill;

import java.util.List;

public interface IBillServlet {
    List<Bill> findAll();
    void save(Bill bill);
}
