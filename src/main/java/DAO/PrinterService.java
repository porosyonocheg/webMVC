package DAO;

import java.util.List;

public interface PrinterService {
    Printer findByCode(int code);
    List<Printer> findAll();
	Printer save(Printer printer);
	void delete(int code);
}
