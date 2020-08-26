package DAO;

import java.util.List;

public interface PCService {
    List<PC> findAll();
    PC save(PC pc);
    void delete(int code);
}
