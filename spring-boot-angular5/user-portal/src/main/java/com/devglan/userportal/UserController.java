package com.devglan.userportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){
        return userService.findById(id);
    }
    
    @PostMapping
    public void create(@RequestBody User user) throws IOException{
        this.userService.create(user);
    }
    
    @PutMapping
    public void update( @RequestBody User user) throws IOException{
        userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") int id) {
        this.userService.delete(id);
    }
    
    
}
