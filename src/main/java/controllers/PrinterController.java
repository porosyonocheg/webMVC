package controllers;

import DAO.Printer;
import DAO.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/printers/")
public class PrinterController {
    private PrinterService printerService;

    @Autowired
    public void setPrinterService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Printer> printers = printerService.findAll();
        uiModel.addAttribute("printers", printers);
        return "printers/list";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "delete/{code}", method = RequestMethod.GET)
    public String delete (@PathVariable("code") int code, Model uiModel) {
        printerService.delete(code);
        return "redirect:/printers/";
    }

    @RequestMapping(value = "update/{code}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("code") int code, Model uiModel) {
        uiModel.addAttribute("printer", printerService.findByCode(code));
        return "printers/edit";
    }

    @RequestMapping(value = "update/0", method = RequestMethod.GET)
    public String newForm(Model uiModel) {
        return "printers/edit";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "update/{code}", method = RequestMethod.POST)
    public String update(Printer printer, BindingResult bindingResult, Model uiModel) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("printer", printer);
            return "printers/update";
        }
        printerService.save(printer);
        return "redirect:/printers/";
    }
}
