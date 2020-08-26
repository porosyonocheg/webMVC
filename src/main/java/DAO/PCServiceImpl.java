package DAO;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Service("pcService")
@Transactional
public class PCServiceImpl implements PCService {
    private PCRepository pcRepository;

    @Autowired
    public void setPcRepository(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<PC> findAll() {
        return Lists.newArrayList(pcRepository.findAll());
    }

    @Transactional
    @Override
    public PC save(PC pc) {
        return pcRepository.save(pc);
    }

    @Transactional
    @Override
    public void delete(int code) {
        pcRepository.delete(code);
    }
}
