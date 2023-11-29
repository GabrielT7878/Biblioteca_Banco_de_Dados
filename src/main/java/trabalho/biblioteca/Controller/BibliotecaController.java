package trabalho.biblioteca.Controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
@AllArgsConstructor
public class BibliotecaController {

        @GetMapping("/")
        public String getHome(){
            return "home";
        }
}
