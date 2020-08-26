package controllers;

import DAO.Printer;
import DAO.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/printers")
public class PrinterApiController {
    private PrinterService printerService;

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Printer> list() {
        return printerService.findAll();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    @ResponseBody
    public Printer findByCode(@PathVariable int code) {
        return printerService.findByCode(code);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Printer create(@RequestBody Printer printer) {
        return printerService.save(printer);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.PUT)
    @ResponseBody
    public Printer update(@RequestBody Printer printer, @PathVariable int code) {
        printer.setCode(code);
        return printerService.save(printer);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int code) {
        printerService.delete(code);
    }
}
