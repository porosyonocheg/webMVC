package DAO;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service("printerService")
@Transactional
public class PrinterServiceImpl implements PrinterService {

    private PrinterRepository printerRepository;

   @Autowired
    public void setPrinterRepository(PrinterRepository printerRepository) {
        this.printerRepository = printerRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Printer findByCode(int code) {
        return printerRepository.findOne(code);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Printer> findAll() {
        return Lists.newArrayList(printerRepository.findAll());
    }

    @Override
    public Printer save(Printer printer) {
        return printerRepository.save(printer);
    }

    @Override
    public void delete(int code) {
        printerRepository.delete(code);
    }
}
