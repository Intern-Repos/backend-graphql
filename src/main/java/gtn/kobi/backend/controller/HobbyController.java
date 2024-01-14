package gtn.kobi.backend.controller;

import gtn.kobi.backend.model.Hobby;
import gtn.kobi.backend.model.Users;
import gtn.kobi.backend.service.HobbyService;
import gtn.kobi.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Controller
public class HobbyController {
    @Autowired
    private HobbyService hobbyService;
    @Autowired
    private UserService userService;
    @MutationMapping
    public Hobby addHobby(@Argument Hobby hobbyInput) {
        System.out.println(hobbyInput);
        return hobbyService.addHobby(hobbyInput);
    }
    @MutationMapping
    public Boolean deleteHobby(@Argument Integer id) {
        hobbyService.deleteHobby(id);
        return true;
    }

    @QueryMapping
    public List<Hobby> getHobbiesByUserId(@Argument Integer userId) {
        ;
        return hobbyService.getHobbiesByUserId(userId);
    }

//    @SchemaMapping
//    public Users user(Hobby hobby){
//        return hobbyService.findHobbyById(hobby.getId()).getUser();
//    }


}
