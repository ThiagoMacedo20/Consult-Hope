package br.com.ConsultHope.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.ConsultHope.model.enitty.Hope;
import br.com.ConsultHope.service.ConsultService;

@Controller
@RequestMapping("")
public class ConsultContoller {
	
	@Autowired
    private ConsultService consultService;
	
	
    @GetMapping("/exams")
    public ResponseEntity<List<Hope>> getAll(){
    	List<Hope> listhope=consultService.getAllExams();
    	return ResponseEntity.ok(listhope);
    }

    @PostMapping("/create")
    public ResponseEntity<Hope> createPacient( @RequestBody Hope hope) throws ParseException {
    	
    	String dateHope = hope.getDateExam();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = LocalDate.now().toString();
		Date dateCurret = dateFormat.parse(currentDate);		
		Date hopeDate = dateFormat.parse(dateHope);
		
		if(dateCurret.before(hopeDate)) {
			 consultService.creatPacient(hope);
	
			 
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
       
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Hope>deleteExam(@PathVariable ("id") int id) {
    	consultService.deletePacient(id);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).build();
 	}
    	
    	
    
    @GetMapping("/pacient/{id}")
    public ResponseEntity <Hope> getPacient(@PathVariable ("id") int id) {
    	Hope exams = consultService.findExams(id);
    	return ResponseEntity.ok(exams);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity <Hope> updatPacient(@PathVariable ("id") int id, @RequestBody Hope hope)
    {
    	 consultService.updatePacient(hope, id);
   	 
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    	
    }
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("list", consultService.getAllExams());
         
        return "index";
    }
    

}
