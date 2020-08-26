package controllers;

import DAO.PC;
import DAO.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/pc")
public class PcApiController {
    private PCService pcService;

    @Autowired
    public void setPcService(PCService pcService) {
        this.pcService = pcService;
    }
    @RequestMapping (method = RequestMethod.GET)
    @ResponseBody
    public List<PC> list() {
        return pcService.findAll();
    }

    @RequestMapping (value = "/newPC", method = RequestMethod.POST)
    @ResponseBody
    public PC create(@RequestBody PC pc) {
        return pcService.save(pc);
    }

    @RequestMapping (value = "/{code}", method = RequestMethod.PUT)
    @ResponseBody
    public PC update(@RequestBody PC pc, @PathVariable int code) {
        pc.setCode(code);
        return pcService.save(pc);
    }

    @RequestMapping (value = "/{code}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int code) {
        pcService.delete(code);
    }

}
